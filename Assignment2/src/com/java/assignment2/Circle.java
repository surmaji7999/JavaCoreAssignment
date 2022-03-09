package com.java.assignment2;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Circle extends Shape{

	double radius,area,parimeter;
	@Override
	public void getInput() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter radius:");
			radius=sc.nextDouble();
		
			if(radius<=0) {
			System.out.println("Please Enter only positive value");
			getInput();
			}	
			}
		catch(InputMismatchException ex) {
			System.out.println("Input must be integer type or double  "+ex);
			
			}
	
		
	}
	@Override
	public void area() {
		area=Math.PI*radius;
		System.out.println("Area of circle with radius "+radius+" = "+area);
	}
	public void parimeter() {
		parimeter=2*(Math.PI)*radius;
		System.out.println("parimeter of circle with radius "+radius+" = "+parimeter);

	}
}
