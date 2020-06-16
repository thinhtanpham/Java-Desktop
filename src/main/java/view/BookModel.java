package view;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;


import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import ws1.Book;

public class BookModel implements TableModel {

    public static final int COLUMN_COUNT = 5;
    private static final int BOOKID = 0;
    private static final int TITLE = 1;
    private static final int AUTHOR = 2;
    private static final int CATEGORY = 3;
    private static final int KEYWORD = 4;
    private final Class[] classes = new Class[]{String.class, String.class, String.class, String.class, String.class};
    private final String[] colums = new String[]{"BookID", "Title", "Author", "Category", "Keyword"};
    private List<Book> books = new ArrayList<Book>();
    private List<TableModelListener> listeners= new ArrayList<TableModelListener>();

    public BookModel() {

    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
        fireChange();
    }

    public int getRowCount() {
        return books.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_COUNT;
    }

    @Override
    public String getColumnName(int i) {
        return colums[i];
    }

    @Override
    public Class<?> getColumnClass(int i) {
        return classes[i];
    }

    
    public void fireChange(){
        TableModelEvent event = new TableModelEvent(this);
        for(TableModelListener listener: listeners){
            listener.tableChanged(event);
        }
        
    }
    
    @Override
    public boolean isCellEditable(int i, int i1) {
        return true;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Book book = books.get(row);
        switch(column)
        {
            case BOOKID: return book.getId();
            case AUTHOR: return book.getAuthor();
            case CATEGORY: return book.getCategory();
            case KEYWORD: return book.getKeyword();
            case TITLE: return book.getTitle();
        }
        return null;
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {

    }

    @Override
    public void addTableModelListener(TableModelListener tl) {
        listeners.add(tl);
    }

    @Override
    public void removeTableModelListener(TableModelListener tl) {
        listeners.remove(tl);
    }
    
  

}
