package com.thevarungupta;

class Parent{
    public Parent(){
        System.out.println("Parent constructor called");
    }
}

class Child extends Parent{
    public Child(){
        System.out.println("Child constructor called");
    }
}

public class Demo24 {
    public static void main(String[] args) {
        //Parent p = new Parent();
        Child c = new Child();

    }
}
