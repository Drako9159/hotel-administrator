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

    public int delete_guest(Integer id) {
        return guestDAO.deleteGuest(id);
    }

    public int update_guest(Integer id, String first_name, String last_name,
                            String date_of_birth, String nationality, String telephone, Integer reservation_id) {
        return guestDAO.updateGuest(id, first_name, last_name, date_of_birth, nationality, telephone, reservation_id);
    }

    public List<Guest> search(Integer id){
        return guestDAO.search(id);
    }
}
