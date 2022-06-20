package com.company.HomeWorks;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.company.HomeWorks.JavaGUI.j;
import static com.company.HomeWorks.LoggedInGUI.l;
import static com.company.HomeWorks.Main.currentUserName;
import static com.company.HomeWorks.Main.writePost;

public class PostGUI extends JFrame{
    private JTextField textField1;
    private JButton okButton;
    JPanel PostGUI;
    private JLabel Post;

    static PostGUI p = new PostGUI();

    public PostGUI() {
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String post = textField1.getText();
                writePost(post);
                p.dispose();
                callLoggedUI();
            }
        });
    }
    private void callLoggedUI() {
        l.setContentPane(new LoggedInGUI().LoggedInFlow);
        l.setVisible(true);
        l.pack();
    }

    public static void main(String[] args) {
        p.setContentPane(new PostGUI().Post);
        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p.setSize(800,600);
        p.setLocationRelativeTo(null);
        p.setVisible(true);
        p.pack();
    }


}
