package com.example.demo;

public class exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int result = 10/0;
		} catch (ArithmeticException e) {
			System.out.println("Exception caught: " + e.getMessage());
		} finally {
			System.out.println("This block executes no matter what.");
		}

	}

}
