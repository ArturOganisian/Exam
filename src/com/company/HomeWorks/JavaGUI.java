package com.company.HomeWorks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;
import com.company.HomeWorks.RegistrationGUI;

import static com.company.HomeWorks.RegistrationGUI.regis;
import static com.company.HomeWorks.LogInGUI.logos;

public class JavaGUI extends JFrame{
    JPanel Main;
    private JButton Register;
    private JButton logInButton;
    private JButton exitButton;
    private JLabel MainGUI;
    static JavaGUI j = new JavaGUI();

    public JavaGUI() {
        Register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == Register){
                    j.dispose();
                    callRegistration();
                }
            }
        });
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == logInButton){
                    j.dispose();
                    callLogIn();
                }
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent quitEvent) {
                System.exit(0);
            }
        });
    }
    public static void callRegistration(){
        regis.setContentPane(new RegistrationGUI().Registration);
        regis.setVisible(true);
        regis.pack();
    }
    public static void callLogIn(){
        logos.setContentPane(new LogInGUI().Login);
        logos.setVisible(true);
        logos.pack();
    }

    public static void main(String[] args) {

        j.setContentPane(new JavaGUI().Main);
        j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        j.setSize(1360,768);
        j.setLocationRelativeTo(null);
        j.setVisible(true);
        j.pack();
    }
}
