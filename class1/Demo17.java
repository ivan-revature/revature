package com.thevarungupta;

class Book3 {
    private String title;
    private String author;
    private int price;

    public Book3(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void printInfo() {
        System.out.println("Book: Title=" + title + ", Author=" + author + ", Price=" + price);
    }
}

public class Demo17 {
    public static void main(String[] args) {
        Book3 obj = new Book3("Title 1", "Author 1", 100);
        obj.printInfo();
    }
}
