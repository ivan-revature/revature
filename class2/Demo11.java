package com.thevarungupta.Day2;

class Car{

    public final int speedLimit = 60;

    public void drive(){
        //speedLimit = 80;
        System.out.println("car is driving at speed of "+ speedLimit);
    }
}

public class Demo11 {
    public static void main(String[] args) {

        Car car = new Car();
        //car.speedLimit = 80;
        car.drive();

    }
}
