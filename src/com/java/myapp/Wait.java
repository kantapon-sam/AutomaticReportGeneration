package com.java.myapp;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Wait extends JFrame {

    public Wait() {

        // JFrame Property
        super("Please wait"); // Title
        setSize(250, 80);
        setLocation(500, 280);
        setResizable(false);
        // Icon
        Image image = new ImageIcon("image\\custom-reports.png").getImage();
        setIconImage(image);
        // Text Label
        JLabel welcome = new JLabel("Please wait for success");
        welcome.setBounds(60, 15, 150, 10);

        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(welcome);

        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);

    }
}
