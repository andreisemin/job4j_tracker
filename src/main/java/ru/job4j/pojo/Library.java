package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Clean code", 460);
        Book book2 = new Book("Book of book", 104);
        Book book3 = new Book("Books books", 55);
        Book book4 = new Book("Book of sings", 250);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (Book book : books) {
            System.out.println(book.getBookTitle() + " - " + book.getPagesNumber());
        }
        System.out.println();
        System.out.println("Replace book 1 to 4.");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (Book book : books) {
            System.out.println(book.getBookTitle() + " - " + book.getPagesNumber());
        }
        System.out.println();
        System.out.println("Shown only \"Clean code\"");
        for (Book book : books) {
            if ("Clean code".equals(book.getBookTitle())) {
                System.out.println(book.getBookTitle() + " - " + book.getPagesNumber());
            }
        }
    }
}
