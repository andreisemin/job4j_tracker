package ru.job4j.pojo;

public class Book {
    private String bookTitle;
    private int pagesNumber;

    public Book(String bookTitle, int pagesNumber) {
        this.bookTitle = bookTitle;
        this.pagesNumber = pagesNumber;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getPagesNumber() {
        return pagesNumber;
    }

    public void setPagesNumber(int pagesNumber) {
        this.pagesNumber = pagesNumber;
    }
}
