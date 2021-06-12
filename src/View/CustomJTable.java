package View;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;


public class CustomJTable  {
    private JTable table;
    private JScrollPane scrollPane;
    public CustomJTable(JPanel panel, AbstractTableModel tableModel){
        panel.setPreferredSize(new Dimension(1000,1000));
        table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(800,800));
        scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
    }

    public JTable getTable() {
        return table;
    }


}
