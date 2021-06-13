package View;

import Model.Book;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class BookTableModel extends AbstractTableModel {
    private String[] cols = {"ISBN","title","publisher","author","publication_year","price","category","no_copies"};
    private ArrayList<Book> books;

    public BookTableModel(){
        books = new ArrayList<>();
        books.add(new Book("1","title","pub","au","45","54","sd","57","57"));
    }

    @Override
    public int getRowCount() {
        return books.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int r, int c) {
        switch (c){
            case 0:
                return books.get(r).getISBN();
            case 1:
                return books.get(r).getTitle();
            case 2:
                return books.get(r).getPublisher();
            case 3:
                return books.get(r).getAuthor();
            case 4:
                return books.get(r).getPublicationYear();
            case 5:
                return books.get(r).getPrice();
            case 6:
                return books.get(r).getCategory();
            case 7:
                return books.get(r).getNumOfCopies();
        }
        return null;
    }
    public String getColumnName(int c){
        return cols[c];
    }
    public void setValueAt(Object value, int r, int c){
        switch (c){
            case 0:
                books.get(r).setISBN((String) value);
                break;
            case 1:
                books.get(r).setTitle((String) value);
                break;
            case 2:
                books.get(r).setPublisher((String) value);
                break;
            case 3:
                books.get(r).setAuthor((String) value);
                break;
            case 4:
                books.get(r).setPublicationYear((String) value);
                break;
            case 5:
                books.get(r).setPrice((String) value);
                break;
            case 6:
                books.get(r).setCategory((String) value);
                break;
            case 7:
                books.get(r).setNumOfCopies((String) value);
        }
        fireTableCellUpdated(r,c);
    }

    public boolean isCellEditable(int row, int col){
        return true;
    }

    public void newBook(){
        books.add(new Book("ISBN","title","publisher","author","publication_year","price","category","num_of_copies","threshold_num"));
        fireTableDataChanged();
    }
    public void deleteBook(int index){
        if(index < 0 || index >= books.size()) return;
        books.remove(index);
        fireTableDataChanged();
    }


}
