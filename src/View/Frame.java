package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Frame {
    private JFrame frame;
    private JComponent panel;

    public Frame(String title){
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        panel = getPanel(150,200);
        frame.setVisible(true);

    }


    public JPanel getPanel(int verticalBanding, int horizontalBanding){
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(new Insets(verticalBanding, horizontalBanding, verticalBanding, horizontalBanding)));
        return panel;
    }

    public JButton getButton(String text){
        JButton button = new JButton(text);
        button.setSize(200,100);
        return button;
    }

    public Component getEmptyHeight(int height){
        return Box.createRigidArea(new Dimension(0, height));
    }

    public Component getEmptyWidth(int width){
        return Box.createRigidArea(new Dimension(width,0));
    }

    public JMenuItem getTab(String title){
        JMenuItem item = new JMenuItem(title);
        item.setBorder(BorderFactory.createLineBorder(Color.black));
        return item;
    }

    public JPanel getPairLayouts(Component a, Component b){
        JPanel panel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(panel,BoxLayout.X_AXIS);
        panel.setLayout(boxLayout);
        panel.add(a);
        panel.add(getEmptyWidth(20));
        panel.add(b);
        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JComponent getMainPanel(){
        return panel;
    }

    public void setMainPanel(JComponent panel){
        this.panel = panel;
    }

    public void replacePanel(JPanel panel){
        getFrame().getContentPane().remove(getMainPanel());
        getFrame().getContentPane().add(panel);
        getFrame().validate();
    }


}
