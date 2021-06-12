package View;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.jar.JarEntry;

public class HomePage extends Frame{

    public HomePage(String title) {
        super(title);
    }

    public void view(){
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        panel.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));

        panel1.setBorder(new EmptyBorder(new Insets(50, 80, 50, 80)));
        panel1.setBackground(Color.yellow);
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxlayout);
        panel.add(panel1);
        BoxLayout boxLayout1 = new BoxLayout(panel1,BoxLayout.X_AXIS);
        panel1.setLayout(boxLayout1);
        JPanel panel2 = new JPanel();
        panel.add(panel2);
        BoxLayout boxLayout2 = new BoxLayout(panel2,BoxLayout.X_AXIS);
        panel2.setLayout(boxLayout2);
        panel2.setBackground(Color.blue);

        panel2.setBorder(new EmptyBorder(new Insets(50, 80, 50, 80)));
        panel1.add(getButton("Sign Up"));
        panel1.add(getEmptyWidth(60));

        panel2.add(getButton("Sing Up"));
        panel2.add(getEmptyWidth(60));
        panel2.add(getButton("Sign In"));
        getFrame().add(panel);
        getFrame().pack();
    }



}
