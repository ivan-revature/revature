package com.thevarungupta;

class Student{
    private int id;
    private String name;
    private int passMark = 40;

    public Student(int id) throws Exception {
        if(id < 0)
            throw new Exception("id cannot ve -ve");
        this.id = id;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) throws Exception {
//        if(id < 0)
//            throw new Exception("id cannot ve -ve");
//        this.id = id;
//    }
}

public class Demo18 {

    public static void main(String[] args) throws Exception {
        Student student = new Student(-1);


//        Student student = new Student();
//        student.setId(-1);
//
//        System.out.println(student.getId());


        //student.id = -10;
//        student.name = null;
//        student.passMark = 20;

//        System.out.println("ID: "+ student.id);
//        System.out.println("Name: "+ student.name);
//        System.out.println("Passmark: "+ student.passMark);
    }
}
