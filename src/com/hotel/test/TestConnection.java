package com.hotel.test;


import com.hotel.controller.GuestController;
import com.hotel.controller.ReservationController;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {

    public static void main(String[] args) throws SQLException {
        ReservationController reservations = new ReservationController();
        GuestController guestController = new GuestController();
        System.out.println(guestController.listar());
    }

}
