package com.thevarungupta.Day2;

abstract class Test10{
    public abstract void display1();
}

abstract class Test20 extends Test10{
    public abstract void display2();
}

abstract class Test30 extends Test20{
    public abstract void display30();
}

class Output extends Test30{

    @Override
    public void display1() {

    }

    @Override
    public void display2() {

    }

    @Override
    public void display30() {

    }
}

public class Demo17 {
    public static void main(String[] args) {

    }
}
