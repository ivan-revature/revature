package com.thevarungupta.Day2;

abstract class Shape{
    public double width;
    public double height;
    public double radius;
    public float pie = 3.14f;

    public abstract void getArea();
}

class Rectangle extends Shape{
    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    public  void draw(){
        System.out.println("rectangle drawing...");
    }


    @Override
    public void getArea() {
        System.out.println(width * height);
    }
}

class Circle extends Shape{
    public Circle(double radius){
        this.radius = radius;
    }

    public void draw(){
        System.out.println("circle drawing...");
    }

    @Override
    public void getArea() {
        System.out.println(pie * radius * radius);
    }
}

public class Demo16 {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(12.34, 56.78);
        Circle circle = new Circle(55.55);

        rectangle.draw();
        circle.draw();

        rectangle.getArea();
        circle.getArea();

    }
}
