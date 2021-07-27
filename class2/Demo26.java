package com.thevarungupta.Day2;

interface ICustomer{

}
class User{

}

class Customer implements ICustomer{

}

public class Demo26 {
    public static void main(String[] args) {
        Customer customer = new Customer();
        //ICustomer iCustomer = new ICustomer();
        ICustomer iCustomer = new Customer();
        //ICustomer iCustomer = new User();
    }
}
