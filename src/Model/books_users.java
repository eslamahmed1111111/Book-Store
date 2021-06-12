package Model;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class books_users {
    public static void main(String[] args) {
        JFrame frame = new JFrame("books_users");
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel books_panel = new JPanel();
      /* JTextField textField1 = new JTextField();
        JButton button1 = new JButton();
        JButton button2 = new JButton();
        JButton button3 = new JButton();*/



        BoxLayout boxlayout = new BoxLayout(books_panel, BoxLayout.Y_AXIS);

        // Set the BoxLayout to be Y_AXIS from top to down
        //BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

        books_panel.setLayout(boxlayout);

        // Set border for the panel
        books_panel.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));
        //panel.setBorder(new EmptyBorder(new Insets(50, 80, 50, 80)));

        // Define new buttons
        JButton jb1 = new JButton("Button 1");
        JButton jb2 = new JButton("Button 2");
        JButton jb3 = new JButton("Button 3");

        // Add buttons to the frame (and spaces between buttons)
        books_panel.add(jb1);
        //panel.add(Box.createRigidArea(new Dimension(0, 60)));
        books_panel.add(jb2);
        //panel.add(Box.createRigidArea(new Dimension(0, 60)));
        books_panel.add(jb3);

        frame.add(books_panel);
        frame.pack();
        frame.setVisible(true);

    }
}
