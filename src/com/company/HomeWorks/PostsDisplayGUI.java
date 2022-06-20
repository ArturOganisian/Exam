package com.company.HomeWorks;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static com.company.HomeWorks.LoggedInGUI.l;
import static com.company.HomeWorks.Main.data;

public class PostsDisplayGUI extends JFrame{
    JPanel PostsGUI;
    private JButton goBackButton;
    private JScrollPane Scroll;
    private JTable postsTable;

    static PostsDisplayGUI pg = new PostsDisplayGUI();


    public PostsDisplayGUI() {
        String col[] = {"Name", "Post"};
        DefaultTableModel DataTable = new DefaultTableModel(col,data);
        postsTable.setModel(DataTable);

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pg.dispose();
                callLoggedIn();
            }
        });
    }
    public static void callLoggedIn(){
        l.setContentPane(new LoggedInGUI().LoggedInFlow);
        l.setVisible(true);
        l.pack();
    }


    public static void main(String[] args) {
        pg.setContentPane(new PostsDisplayGUI().PostsGUI);
        pg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pg.setSize(800,600);
        pg.setVisible(true);
        pg.pack();
    }

}
