package library.service;

import library.entity.Book;

import java.io.IOException;

public interface Manageable {
    void addBook(Book book) throws IOException;
   void addInformBook() throws InvalidValueException;
    void  removeBook(int isbn) throws IOException;
}
