package com.java.myapp;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StopProgram extends JFrame implements ActionListener {

    private final JFrame frame;

    public StopProgram() {

        this.frame = new JFrame();
        this.frame.setVisible(true);

        this.frame.setTitle("AutomaticReportGeneration");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image image = new ImageIcon("image\\custom-reports.png").getImage();
        this.frame.setIconImage(image);
        JPanel panel = new JPanel();

        JButton btnClose = new JButton("Stop Program");
        btnClose.setBackground(new java.awt.Color(255, 0, 0));
        btnClose.addActionListener(this);
        panel.add(btnClose);

        this.frame.add(panel);
        this.frame.pack();
        this.frame.setSize(200, 100);
        this.frame.setLocation(1100, 10);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.frame.setVisible(false);
        this.frame.dispose();
        System.exit(0);
    }
}
