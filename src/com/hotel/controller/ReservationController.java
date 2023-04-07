package com.hotel.controller;

import com.hotel.dao.ReservationDAO;
import com.hotel.factory.ConnectionFactory;
import com.hotel.modelo.Reservation;

import java.util.List;

public class ReservationController {
    private ReservationDAO reservationDAO;

    public ReservationController(){
        this.reservationDAO = new ReservationDAO(new ConnectionFactory().recuperaConexion());
    }
    public List<Reservation> listar(){
        return reservationDAO.listar();
    }
    public void save_reservation(Reservation reservation){
        reservationDAO.saveReservation(reservation);
    }
}
