package com.hotel.test;

import javax.swing.*;

public class WaitingDialog {
    private JDialog dialog;
    public WaitingDialog() {
        dialog = new JDialog();
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setModal(true);
        JLabel label = new JLabel("Por favor, espere...");
        dialog.add(label);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
    }
    public void show() {
        dialog.setVisible(true);
    }
    public void hide() {
        dialog.setVisible(false);
    }
}


