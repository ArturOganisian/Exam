package com.company.HomeWorks;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.company.HomeWorks.JavaGUI.j;
import static com.company.HomeWorks.LoggedInGUI.l;
import static com.company.HomeWorks.Main.loginUser;
import static com.company.HomeWorks.Main.isLoggedIn;
import static com.company.HomeWorks.Main.currentUserName;

public class LogInGUI extends JFrame{
    JPanel Login;
    private JLabel LogInGUI;
    private JTextField textField1;
    private JTextField textField2;
    private JButton okButton;
    private JLabel UserName;
    private JLabel Password;

    static LogInGUI logos = new LogInGUI();

    public LogInGUI() {
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String uName = textField1.getText();
                String pass = textField2.getText();
                loginUser(uName,pass);
                if(isLoggedIn == true){
                    currentUserName = uName;
                    logos.dispose();
                    callLoggedIn();
                }
                else{
                    logos.dispose();
                    callMain();
                }
            }
        });
    }
    public static void callLoggedIn(){
        l.setContentPane(new LoggedInGUI().LoggedInFlow);
        l.setVisible(true);
        l.pack();
    }
    public static void callMain(){
        j.setVisible(true);
    }
    public static void main(String[] args) {
        logos.setContentPane(new LogInGUI().LogInGUI);
        logos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logos.setSize(800,600);
        logos.setLocationRelativeTo(null);
        logos.setVisible(true);
        logos.pack();
    }
}
