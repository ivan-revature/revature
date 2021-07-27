package com.thevarungupta.Day2;

class Calculator{

    // non static method
    public void addNumber(int num1, int num2){
        System.out.println(num1 + num2);
    }

    // static method
    public static void subNumber(int num1, int num2){
        System.out.println(num1 - num2);
    }

}

public class Demo3 {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        cal.addNumber(20,10);

        Calculator.subNumber(20,10);

    }
}
