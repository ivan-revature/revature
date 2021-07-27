package com.thevarungupta;

class Book2{
    private String title;
    private String author;
    private int price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void printInfo(){
        System.out.println("Book: Title=" + title + ", Author=" + author + ", Price=" + price);
    }

}

public class Demo16 {
    public static void main(String[] args) {
        Book2 bookObj = new Book2();
        bookObj.setTitle("Title 1");
        bookObj.setAuthor("Author 1");
        bookObj.setPrice(100);

        bookObj.printInfo();
    }
}
