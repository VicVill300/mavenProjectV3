package com.simplilearn.mavenprojectV2withmathUtils;




//this is a change
public class mathUtils 
{
	//Add two numbers
	public int add(int a, int b)
	{
		return a + b;
	}
	
	// Subtract two numbers
	public int subtract(int a, int b) 
	{
		return a - b;
	}
	
	// multiply two numbers
	public int multiply(int a, int b)
	{
		return a * b;
	}
	
	//divide two numbers
	public double divide(int a, int b) 
	{
	    if (b == 0) 
	    {
	        return -1.0; // Handle division by zero gracefully
	    }
	    return (double) a / b; // Perform the division if b is not zero
	}

}
