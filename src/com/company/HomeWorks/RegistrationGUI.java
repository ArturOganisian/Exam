package com.company.HomeWorks;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.company.HomeWorks.JavaGUI.j;
import static com.company.HomeWorks.Main.registerUser;

public class RegistrationGUI extends JFrame{
    JPanel Registration;
    private JLabel RegistrationGUI;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel UserName;
    private JLabel Password;
    private JButton okButton;

    static RegistrationGUI regis = new RegistrationGUI();

    public RegistrationGUI() {
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String uName = textField1.getText();
                String pass = textField2.getText();
                registerUser(uName,pass);
                regis.dispose();
                callMain();
            }
        });
    }
    public static void callMain(){
        j.setVisible(true);
    }

    public static void main(String[] args) {
        regis.setContentPane(new RegistrationGUI().Registration);
        regis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        regis.setSize(800,600);
        regis.setLocationRelativeTo(null);
        regis.setVisible(true);
        regis.pack();
    }

}
