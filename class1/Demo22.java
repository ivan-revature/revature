package com.thevarungupta;

class Employee{
    public int empId;
    public String firstName;
    public String lastName;
    public String email;

    public void getFullName(){
        System.out.println(this.firstName + " "+ this.lastName);
    }
}

class FullTimeEmployee extends Employee{
    public int annualSalary;
}

class PartTimeEmployee extends Employee{
    public int hourSalary;
}

public class Demo22 {
    public static void main(String[] args) {
        FullTimeEmployee fte = new FullTimeEmployee();
        fte.firstName = "Mark";
        fte.lastName  ="Smith";


        PartTimeEmployee pte = new PartTimeEmployee();
        pte.firstName = "Paul";
        pte.lastName  ="Watson";

        fte.getFullName();
        pte.getFullName();

        Employee emp = new Employee();

    }
}
