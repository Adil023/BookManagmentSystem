package library.entity;

import library.service.BookType;

public class Book {
    private String title;
    private String author;
    private int ISBN;
    private BookType bookType;
    public Book(String title, String author, int ISBN, BookType bookType) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.bookType = bookType;
    }

    public BookType getBookType() {
        return bookType;
    }

    public Book setBookType(BookType bookType) {
        this.bookType = bookType;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public int getISBN() {
        return ISBN;
    }

    public Book setISBN(int ISBN) {
        this.ISBN = ISBN;
        return this;
    }

    public String toString() {
        return title + " " + author + " " + ISBN+" "+bookType;
    }


}
