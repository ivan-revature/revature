package com.thevarungupta.Day2;


abstract class Calculator2 {

    // not abstract method
    public void addNumber(int num1, int num2) {
        System.out.println("Sum: " + (num1 + num2));
    }

    public void subNumber(int num1, int num2) {
        System.out.println("Sub: " + (num1 - num2));
    }

    // abstract methods
    public abstract void mulNumber(int num1, int num2);

    public abstract void divNumber(int num1, int num2);
}

class Test2 extends Calculator2 {

    @Override
    public void mulNumber(int num1, int num2) {
        System.out.println("Mul: " + (num1 * num2));
    }

    @Override
    public void divNumber(int num1, int num2) {
        System.out.println("Div: " + (num1 / num2));
    }
}

public class Demo15 {
    public static void main(String[] args) {
        Test2 t1 = new Test2();
        t1.addNumber(20,10);
        t1.subNumber(20,10);
        t1.mulNumber(20,10);
        t1.divNumber(20,10);

    }
}
