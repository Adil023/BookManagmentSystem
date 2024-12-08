package library.service;

import library.entity.Book;
import library.entity.Ebook;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;


public class Library implements RunableMyService {
    private Book[] books= new Book[0];
    private  final  Path filePath = Paths.get("myBook.txt");





    @Override
    public void addBook(Book book) throws IOException {

        Book[] newBooks = new Book[books.length+1];
        for(int i = 0;i<books.length;i++){
            newBooks[i]=books[i];
        }
        newBooks[books.length]=book;
        books = newBooks;
        saveBookToFile(book);
        displayInfo();

    }

    private void saveBookToFile(Book book) throws IOException {
        String info = book.getTitle()+","+book.getAuthor()+","+book.getBookType()+","+book.getISBN()+"\n";
        Files.write(filePath,info.getBytes(StandardCharsets.UTF_8),StandardOpenOption.CREATE,StandardOpenOption.APPEND);
    }


    public void addInformBook() throws InvalidValueException {
        try{
        Scanner sc = new Scanner(System.in);
        System.out.println("Write details of book which you want to add");
        System.out.println("Title of the book:");
        String title = sc.nextLine();

        System.out.println("Author of the book:");
        String author = sc.nextLine();

        System.out.println("ISBN of the book:");
        int ISBN = sc.nextInt();sc.nextLine();
        // library.entity.Ebook olub-olmamağını yoxlayırıq
        System.out.println("Is this phsical or ebook");

        String b = new Scanner(System.in).nextLine();

           BookType bookType = BookType.valueOf(b.toUpperCase());
           Book book = new Book(title, author, ISBN,bookType);
           addBook(book);
       }catch(IllegalArgumentException ex){
           throw new InvalidValueException("you have entered wrong value");
       } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void  removeBook(int  isbn) throws IOException {

        boolean found = false;
        Book[] newBooks = new Book[books.length-1];
        int j=0;

        for(Book book:books){
            if(book.getISBN() == isbn){
                found = true;
                continue;
            }

            if(j<newBooks.length){
                newBooks[j++]=book;
            }
        }

        if(found){
            books = newBooks;
            System.out.println("book removed");
            displayInfo();
            removeBookFromFile(isbn);

        }else{
            System.out.println("book not found");
        }


    }

    private void removeBookFromFile(int isbn) throws IOException {
        if (!Files.exists(filePath)) {
            return;
        }

        String content = new String(Files.readAllBytes(filePath), StandardCharsets.UTF_8);
        StringBuilder updatedContent = new StringBuilder();
        String[] lines = content.split("\n");

        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length >= 4 && Integer.parseInt(parts[3]) != isbn) {
                updatedContent.append(line).append("\n");
            }
        }

        // Fayla yenilənmiş məzmunu yazırıq
        Files.write(filePath, updatedContent.toString().getBytes(StandardCharsets.UTF_8), StandardOpenOption.TRUNCATE_EXISTING);
    }



    public void displayInfo(){
        if(books.length ==0){
            System.out.println("there are no anything to show");
        }


        for(Book book:books){
            if(book instanceof Digital){
                Ebook ebook = (Ebook) book;
                System.out.println(book+"file size: "+ebook.getFileSize());
            }else{
                System.out.println(book);
            }
        }
    }
}
