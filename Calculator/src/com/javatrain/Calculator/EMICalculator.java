package com.javatrain.Calculator;
import java.util.Scanner;
import java.text.NumberFormat;

public class EMICalculator {
	double loanPrincipal;
	double rateOfInterest; // rate of interest divided by 100
	int loanTenure; // tenure for loan repayment in months
	double emi; // Equated Monthly Installment
	
	public EMICalculator(Scanner scanner) {
		System.out.println("\nEMI Calculator");
		System.out.print("Loan principal: ");
		this.loanPrincipal = scanner.nextDouble();
		System.out.print("Rate of interest (%): ");
		this.rateOfInterest = scanner.nextDouble() / 100.0;
		System.out.print("Tenure for loan repayment (in months): ");
		this.loanTenure = scanner.nextInt();
		//  [P x R x (1+R) ^N] / [(1+R) ^N-1]
		double emiDividend = this.loanPrincipal * this.rateOfInterest * (Math.pow(1.0 + this.rateOfInterest,this.loanTenure));
		double emiDivider = Math.pow(1.0 + this.rateOfInterest,this.loanTenure)-1;
		this.emi = emiDividend / emiDivider;
	}
	
	public String getEMI() {
		return NumberFormat.getInstance().format(this.emi);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		EMICalculator emiCalc = new EMICalculator(scanner);
		System.out.print("\nYour EMI is: " + emiCalc.getEMI());
	}
	
}
