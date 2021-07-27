package com.thevarungupta.Day2;

class Calculation{
    public void test(){
        System.out.println("1st method");
    }

    public void test(int a){
        System.out.println("2nd method");
    }

    public void test(String a){
        System.out.println("3rd method");
    }

    public void test(int a, String b){
        System.out.println("4th method");
    }

    public void test(String a, int b){
        System.out.println("5th method");
    }

//    public int test(){
//        return 10;
//    }
}

public class Demo8 {
    public static void main(String[] args) {
        Calculation cal = new Calculation();
        cal.test();
        cal.test(10);
        cal.test("A");
        cal.test(10, "A");
        cal.test("A", 10);
    }
}
