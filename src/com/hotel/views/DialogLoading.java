package com.hotel.views;

import javax.swing.*;
import java.awt.*;

public class DialogLoading {
    private JDialog jDialog;

    public DialogLoading() {
        jDialog = new JDialog();
        jDialog.setLayout(new GridBagLayout());
        jDialog.add(new JLabel("Por fávor espera..."));
        jDialog.setMinimumSize(new Dimension(150, 50));
        jDialog.setResizable(false);
        jDialog.setModal(true);
        jDialog.setUndecorated(true);
        jDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        jDialog.setLocationRelativeTo(null);
    }

    public void show() {
        jDialog.setVisible(true);
    }

    public void hide() {
        jDialog.setVisible(false);
    }
}
