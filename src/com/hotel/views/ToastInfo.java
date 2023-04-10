package com.hotel.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class ToastInfo {
    private JDialog jDialogToast;
    public ToastInfo(String message){
        jDialogToast = new JDialog();
        jDialogToast.setLayout(new GridBagLayout());
        jDialogToast.add(new JLabel(message));
        jDialogToast.setMinimumSize(new Dimension(150, 50));
        jDialogToast.setResizable(false);
        jDialogToast.setModal(true);
        jDialogToast.setUndecorated(true);
        jDialogToast.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        jDialogToast.setLocationRelativeTo(null);
    }
    public void show() {
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                jDialogToast.setVisible(true);
                try {
                    Thread.sleep(1000);
                    jDialogToast.setVisible(false);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread2.start();
    }
    public void hide() {
        jDialogToast.setVisible(false);
    }

}
