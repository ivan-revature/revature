package com.thevarungupta.Day2;

abstract class Test100{
    public abstract void display();
}

abstract class Test200 extends Test100{
    public abstract void display();
}

abstract class Test300 extends Test200{
    public abstract void display();
}

class Output2 extends Test300{

    @Override
    public void display() {

    }
}

public class Demo18 {
    public static void main(String[] args) {

        Output2 obj = new Output2();
        obj.display();

    }
}
