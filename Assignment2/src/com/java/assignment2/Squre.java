package com.java.assignment2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Squre extends Shape {


	double  side1,area,parimeter;
	
	@Override
	public void getInput() {
		try {
		Scanner sc = new Scanner(System.in);
			System.out.println("Enter side1:");
			side1= sc.nextDouble();
		
		if(side1<=0) {
			System.out.println("Please Enter Radius");
			getInput();
		}	
		}
		catch(InputMismatchException ex) {
			System.out.println("Input must be integer type or double  "+ex);
			
			}
	}
	@Override
	public void area() {
		area=side1*side1;
		System.out.println("Area of squre is = "+area);
		
	}
	public void parimeter() {
		parimeter=4*side1;
		System.out.println("Parimeter of squre is = "+parimeter);
	}
}
