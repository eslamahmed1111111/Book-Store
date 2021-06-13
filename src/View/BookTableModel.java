package View;

import Model.Book;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class BookTableModel extends AbstractTableModel {
    private int selectedCell = -1;
    private String[] cols = {"ISBN","title","publisher","author","publication_year","price","category","no_copies" , "threshold_quantity"};
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
        return 9;
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
            case 8:
                return books.get(r).getThresholdQuantity();
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
                break;
            case 8:
                books.get(r).setThresholdQuantity((String) value);
        }
        fireTableCellUpdated(r,c);
    }

    public boolean isCellEditable(int row, int col){
        if(row == selectedCell){
            if(col == 0) return getValueAt(row,col) == "ISBN";
            return true;
        }
        return false;
    }

    public void newBook(){
        books.add(new Book("ISBN","title","publisher","author","publication_year","price","category","no_copies","threshold_quantity"));
        fireTableDataChanged();
    }
    public void deleteBook(int index){
        if(index < 0 || index >= books.size()) return;
        books.remove(index);
        fireTableDataChanged();
    }

    public Book getCertainBook(int row){
        Book book = new Book();
        book.setISBN((String) getValueAt(row,0));
        book.setTitle((String) getValueAt(row,1));
        book.setPublisher((String) getValueAt(row,2));
        book.setAuthor((String) getValueAt(row,3));
        book.setPublicationYear((String) getValueAt(row,4));
        book.setPrice((String) getValueAt(row,5));
        book.setCategory((String) getValueAt(row,6));
        book.setNumOfCopies((String) getValueAt(row,7));
        book.setThresholdQuantity((String) getValueAt(row,8));
        return book;
    }


    public int getSelectedCell() {
        return selectedCell;
    }

    public void setSelectedCell(int selectedCell) {
        this.selectedCell = selectedCell;
    }
}
