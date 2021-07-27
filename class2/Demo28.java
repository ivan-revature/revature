package com.thevarungupta.Day2;

class Student2{
    private int id;
    private String name;
    private int passMark = 40;

    public int getId() {
        return id;
    }

    public void setId(int id) throws Exception {
        if(id < 0)
            throw new Exception("id cannot be -ve");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if(name.isBlank())
            throw new Exception("name cannot be blank");
        this.name = name;
    }

    public int getPassMark() {
        return passMark;
    }

}

public class Demo28 {
    public static void main(String[] args) throws Exception {
        Student2 student = new Student2();
//        student.id = -1;
//        student.name = null;
//        student.passMark = 20;
//
//        System.out.println("Id = "+ student.id+ ", Name = "+ student.name+", Passmark = "+ student.passMark);

        student.setId(1);
        student.setName("");
        System.out.println("Id = "+ student.getId()+ ", Name = "+ student.getName()+", Passmark = "+ student.getPassMark());
    }
}
