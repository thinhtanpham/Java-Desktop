/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.html.parser.DTDConstants;
import ws1.Book;
import ws1.BookDB;

/**
 *
 * @author Rog
 */
public class MyModel {
    private String bookID;
    private String bookTitle;
    private String bookAuthor;
    private boolean bookStatus;
    private String bookKeyword;
    private String bookCategory;
    private List<MyModelListener> listeners = new ArrayList<MyModelListener>();
    
    private BookDB bdb ;

    public MyModel(BookDB bdb) {
        this.bdb = bdb;
    }
    public final static String  BOOKID = "bookID";
    public final static String  BOOK_TITLE = "bookTitle";
    public final static String  BOOK_AUTHOR = "bookAuthor";
    public final static String  BOOK_KEYWORD = "bookKeyword";
    public final static String  BOOK_CATEGORY = "bookCategory";

    
    public String getBookID() {
        return bookID;
    }

    public void setBookID(String BookID) {
        this.bookID = BookID;
        fireChanged(BOOKID, BookID);
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
        fireChanged(BOOK_TITLE, bookTitle);
        
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
        fireChanged(BOOK_AUTHOR, bookAuthor);
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
        fireChanged("bookStatus", bookStatus);
    }

    public String getBookKeyword() {
        return bookKeyword;
    }

    public void setBookKeyword(String bookKeyword) {
        this.bookKeyword = bookKeyword;
        fireChanged(BOOK_KEYWORD, bookKeyword);
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
        fireChanged(BOOK_CATEGORY, bookCategory);
    }
    
    public void addListener(MyModelListener listener){
        listeners.add(listener);
    }
    
    public void removeListener(MyModelListener listener){
        listeners.remove(listener);
    }
    
    private void fireChanged(String whatChanged, Object newValue){
        MyModelEvent event = new MyModelEvent(whatChanged, newValue);
        for(MyModelListener listener: listeners){
            listener.modelChanged(event);
        }
    }
    
    public void saveToDB() throws SQLException{
        Book book = new Book();
        book.setId(bookID);
        book.setTitle(bookTitle);
        book.setAuthor(bookAuthor);
        book.setKeyword(bookKeyword);
        book.setCategory(bookCategory);
        bdb.addBook(book);
    }
}
