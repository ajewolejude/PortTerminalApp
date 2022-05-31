package com.terminal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {
    private JPanel mainPanel;
    private JTextField destination;
    private JTextField textField2;
    private JPanel port;
    private JTextField cell00;
    private JTextField cell03;
    private JTextField cell11;
    private JTextField cell12;
    private JTextField cell13;
    private JTextField cell23;
    private JTextField cell22;
    private JTextField cell21;
    private JTextField cell20;
    private JTextField cell01;
    private JTextField cell02;
    private JTextField cell10;
    private JTextField cell30;
    private JTextField cell32;
    private JTextField cell33;
    private JTextField cell31;
    private JButton drop;
    private JLabel count;


    public Home() {
        drop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, cell00.getText());
            }
        });

    }

    public static void main(String[] args) {

        JFrame jFrame = new JFrame("Home");
        jFrame.setContentPane(new Home().mainPanel);
        jFrame.setTitle("Port Terminal Problem");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);


    }
}
