package com.thevarungupta;

// simple inheritance
//class A{
//
//}
//
//class B extends  A{
//
//}

// multilevel inheritance
class A{
    public void test1(){
        System.out.println("A");
    }
}

class B extends  A{
    public void test2(){
        System.out.println("B");
    }
}

class C extends B{
    public void test3(){
        System.out.println("C");
    }
}

public class Demo25 {
    public static void main(String[] args) {
        C c1 = new C();
        c1.test1();
        c1.test2();
        c1.test3();

        B b1 = new B();
        b1.test1();
        b1.test2();

        A a1 = new A();
        a1.test1();
    }
}
