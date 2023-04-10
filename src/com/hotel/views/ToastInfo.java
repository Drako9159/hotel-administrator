package com.hotel.views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ToastInfo {
    private JDialog jDialogToast;

    public ToastInfo(String message) {
        jDialogToast = new JDialog();
        jDialogToast.setLayout(new GridBagLayout());
        jDialogToast.add(new JLabel(message));
        jDialogToast.setMinimumSize(new Dimension(190, 50));
        jDialogToast.setResizable(false);
        jDialogToast.setModal(true);
        jDialogToast.setUndecorated(true);
        jDialogToast.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        jDialogToast.setLocationRelativeTo(null);



        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                jDialogToast.setVisible(true);
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    jDialogToast.setVisible(false);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread2.start();
    }
}
