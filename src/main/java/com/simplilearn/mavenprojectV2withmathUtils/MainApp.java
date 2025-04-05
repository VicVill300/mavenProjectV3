package com.simplilearn.mavenprojectV2withmathUtils;

public class MainApp {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("✅ Hello from MainApp!");

        // Keeps the app alive so Kubernetes thinks it's healthy
        Thread.sleep(Long.MAX_VALUE);
    }
}
