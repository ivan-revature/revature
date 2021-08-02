package com.javatrain.Calculator;
import java.util.Scanner;

public class TwoNumberCalculator {
	double num1;
	double num2;
	
	public TwoNumberCalculator(Scanner scanner) {
		System.out.print("Enter 1st number: ");
		this.num1 = scanner.nextDouble();
		System.out.print("Enter 2nd number: ");
		this.num2 = scanner.nextDouble();
	}
	
	public void operationOptions(Scanner scanner) {
		System.out.println("\nSelect option: ");
		System.out.println("1. Arithmetic");
		System.out.println("2. Subtraction");
		System.out.println("3. Multiplication");
		System.out.println("4. Division");
		System.out.print("\nChoice: ");
		System.out.println(performOp(scanner.nextInt()));
	}
	
	private double performOp(int choice) {
		double result = 0.0;
		switch(choice) {
		case 1:
			result = this.num1 + this.num2;
			break;
		case 2:
			result = this.num1 - this.num2;
			break;
		case 3:
			result = this.num1 * this.num2;
			break;
		case 4:
			result = this.num1 / this.num2;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		TwoNumberCalculator twocalc = new TwoNumberCalculator(scanner);
		twocalc.operationOptions(scanner);
	}}
