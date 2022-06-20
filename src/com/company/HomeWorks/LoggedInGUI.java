package com.company.HomeWorks;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.company.HomeWorks.JavaGUI.j;
import static com.company.HomeWorks.Main.logout;
import static com.company.HomeWorks.PostGUI.p;
import static com.company.HomeWorks.PostsDisplayGUI.pg;

public class LoggedInGUI extends JFrame{
    JPanel LoggedInFlow;
    private JButton postButton;
    private JButton seePostsButton;
    private JButton logOutButton;
    private JButton exitButton;
    private JLabel Loggedinflow;
    static LoggedInGUI l = new LoggedInGUI();

    public LoggedInGUI() {
        postButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == postButton){
                    l.dispose();
                    callposting();
                }
            }
        });
        seePostsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == seePostsButton){
                    l.dispose();
                    callSeeAllPosts();
                }
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logout();
                l.dispose();
                callMain();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void callMain() {
        j.setContentPane(new JavaGUI().Main);
        j.setVisible(true);
        j.pack();
    }

    private void callSeeAllPosts() {
        pg.setContentPane(new PostsDisplayGUI().PostsGUI);
        pg.setVisible(true);
        pg.pack();
    }

    private void callposting() {
        p.setContentPane(new PostGUI().PostGUI);
        p.setVisible(true);
        p.pack();
    }

    public static void main(String[] args) {
        l.setContentPane(new LoggedInGUI().LoggedInFlow);
        l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l.setSize(800,600);
        l.setLocationRelativeTo(null);
        l.setVisible(true);
        l.pack();
    }
}
