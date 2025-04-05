pipeline {
    agent any

    environment {
        SONARQUBE_SERVER = 'http://sonar:9000'
        DOCKER_IMAGE = 'villegas7155/mavenprojectv3:latest'
        SONAR_TOKEN = credentials('sonar_for_jenkins')
        KUBE_CONFIG_PATH = 'kube/config'
    }

    stages {
        stage('Clean Workspace') {
            steps {
                cleanWs()
            }
        }

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build (Java 17)') {
            steps {
                script {
                    docker.image('maven:3.9.6-eclipse-temurin-17').inside('--network ci_network') {
                        sh 'mvn clean compile'
                    }
                }
            }
        }

        stage('Test (Java 11)') {
            steps {
                script {
                    docker.image('maven:3.9.6-eclipse-temurin-11').inside('--network ci_network') {
                        sh 'mvn test'
                    }
                }
            }
        }

        stage('SonarQube Analysis (Java 14)') {
            steps {
                script {
                    docker.image('maven:3.9.6-eclipse-temurin-14').inside('--network ci_network') {
                        sh """
                            mvn sonar:sonar \
                              -Dsonar.projectKey=mavenprojectv3 \
                              -Dsonar.host.url=$SONARQUBE_SERVER \
                              -Dsonar.login=$SONAR_TOKEN
                        """
                    }
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE .'
            }
        }

        stage('Push to Docker Hub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'docker_for_jenkins', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASSWORD')]) {
                    sh '''
                        echo $DOCKER_PASSWORD | docker login -u $DOCKER_USER --password-stdin
                        docker push $DOCKER_IMAGE
                    '''
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                withCredentials([file(credentialsId: 'kubeconfig_for_
