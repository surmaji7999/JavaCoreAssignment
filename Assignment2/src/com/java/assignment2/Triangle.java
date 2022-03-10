package com.java.assignment2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Triangle extends Shape {

	double  side1,side2,side3,area,parimeter;
	
	@Override
	public void getInput() {
		try {
		Scanner sc = new Scanner(System.in); 
			System.out.println("Enter side1:");
			side1= sc.nextDouble();
			System.out.println("Enter side2:");
			side2= sc.nextDouble();
			System.out.println("Enter side3:");
			side3= sc.nextDouble();
		
		if(side1<=0&&side2<=0&&side3<=0) {
			System.out.println("Please Enter Radius");
			getInput();
		}
		}
		catch(InputMismatchException ex) {
			ex.printStackTrace();
			}
	
	}
	@Override
	public void area() {
		double s= (side1 +side2+ side3)/2; 
		area= Math.sqrt((s*(s-side1)*(s-side2)*(s-side3)));
		System.out.println("Area of triangle is = "+area);
		
	}
	public void parimeter() {
		parimeter= (side1+ side2 + side3);
		System.out.println("Parimeter of triangle is = "+parimeter);
	}
}
