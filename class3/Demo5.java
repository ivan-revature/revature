package com.thevarungupta.Day3;

public class Demo5 {
    public static void main(String[] args) {
        String s1 = "Mark";
        String s2 = "Mark";
        String s3 = "Paul";

        System.out.println(s1.compareTo(s2)); // 0
        System.out.println(s1.compareTo(s3));  // -
        System.out.println(s3.compareTo(s1));  // +
    }
}
