package library.service;

import library.entity.Book;
import library.entity.Ebook;

import java.io.IOException;
import java.util.Scanner;

public interface RunableMyService extends Displayable,Manageable{



      default void menu() throws IOException {
          {

              Scanner sc = new Scanner(System.in);
              while(true){
                  System.out.println("welcome to the library");
                  System.out.println("please choose action");
                  System.out.println("1 - add a book");
                  System.out.println("2 - remove a book");
                  System.out.println("3 - display all books");
                  int action = sc .nextInt();

                  if (action == 1) {
                     try{
                         addInformBook(); //
                     }catch (InvalidValueException e){
                         System.out.println(e.getMessage());
                     }

                  }else if(action == 2){
                      System.out.println("enter index of book which you want to remove");
                      int isbnToRemove = sc .nextInt();
                      removeBook(isbnToRemove);
                  }else if(action == 3){
                      displayInfo();
                  }else if(action ==4){
                      System.out.println("exiting program....");return;
                  }
              }

          }
      };





    }

