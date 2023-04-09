package com.hotel.test;

import com.hotel.views.ReservasView;

import javax.swing.*;
import java.awt.*;

public class TestFrames {
    public static void main(String[] args) throws Exception {
        JDialog jDialog = new JDialog();
        jDialog.setLayout(new GridBagLayout());
        jDialog.add(new JLabel("Please wait..."));
        jDialog.setMinimumSize(new Dimension(150, 50));
        jDialog.setResizable(false);
        jDialog.setModal(false);
        jDialog.setUndecorated(true);
        jDialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        jDialog.setLocationRelativeTo(null);
        jDialog.setVisible(true);
    }
}
