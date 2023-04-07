package com.hotel.test;


import com.hotel.controller.ReservationController;
import com.hotel.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class TestPoolConnection {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        for (int i = 0; i < 20; i++){
            Connection con = connectionFactory.recuperaConexion();
            ReservationController reservations = new ReservationController();
            System.out.println(reservations.listar());
            System.out.println("Abriendo la conexión número "+(i+1));

        }
    }
}