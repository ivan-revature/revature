package com.thevarungupta.Day3;

public class Demo2 {
    public static void main(String[] args) {

        String str = "Hello";
        str.concat("World"); // we are using concat() method to append the string at the end
        System.out.println(str);  // will print Hello only bcoz strings are immutable object

        String str1 = "Hello";
        str1 = str1.concat("World");
        System.out.println(str1);

    }
}
