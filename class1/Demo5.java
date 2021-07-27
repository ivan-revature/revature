package com.thevarungupta;

public class Demo5 {
    public static void main(String[] args) {

        int score = 91;

        if(score >= 90)
            System.out.println("A Grade");
        else if(score < 90 && score > 75)
            System.out.println("B Grade");
        else if(score < 75 && score > 50)
            System.out.println("C grade");
        else
            System.out.println("D grade");

    }
}
