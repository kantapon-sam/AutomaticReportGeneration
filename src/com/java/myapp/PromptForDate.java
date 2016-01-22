package com.java.myapp;

import java.util.*;
import javax.swing.*;

public class PromptForDate {

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(
                            UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
                SpinnerDateModel dateModelStart = new SpinnerDateModel(
                        new Date(), null, null, Calendar.DAY_OF_MONTH);
                JSpinner dateSpinnerStart = new JSpinner(dateModelStart);
                dateSpinnerStart.setEditor(
                        new JSpinner.DateEditor(dateSpinnerStart, "dd/MM/yyyy"));

                JOptionPane.showMessageDialog(
                        null, dateSpinnerStart, "Start",
                        JOptionPane.QUESTION_MESSAGE);

                System.out.println(dateModelStart.getValue());

                SpinnerDateModel dateModelStop = new SpinnerDateModel(
                        new Date(), null, null, Calendar.DAY_OF_MONTH);
                JSpinner dateSpinnerStop = new JSpinner(dateModelStop);
                dateSpinnerStop.setEditor(
                        new JSpinner.DateEditor(dateSpinnerStop, "dd/MM/yyyy"));

                JOptionPane.showMessageDialog(
                        null, dateSpinnerStop, "Stop",
                        JOptionPane.QUESTION_MESSAGE);

                System.out.println(dateModelStop.getValue());

            }
        };
        SwingUtilities.invokeLater(r);
    }
}
