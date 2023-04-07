package com.hotel.controller;


import com.hotel.dao.GuestDAO;
import com.hotel.dao.ReservationDAO;
import com.hotel.factory.ConnectionFactory;
import com.hotel.modelo.Guest;
import com.hotel.modelo.Reservation;
import com.hotel.views.ReservasView;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.zip.CheckedInputStream;

public class GuestController {
    private GuestDAO guestDAO;


    public GuestController() {
        this.guestDAO = new GuestDAO(new ConnectionFactory().recuperaConexion());
    }

    public List<Guest> listar() {
        return guestDAO.listar();
    }

    public void save_guest(Guest guest) {
        guestDAO.saveGuest(guest);


    }
}
