package library.entity;

import library.service.BookType;
import library.service.Digital;

public class Ebook extends Book implements Digital {
    private double fileSize;

   public Ebook(String title, String author, int ISBN, double fileSize, BookType type) {
       super(title, author, ISBN,type);
       this.fileSize = fileSize;
   }

    public double getFileSize() {
        return fileSize;
    }

    public Ebook setFileSize(double fileSize) {
        this.fileSize = fileSize;
        return this;
    }
}
