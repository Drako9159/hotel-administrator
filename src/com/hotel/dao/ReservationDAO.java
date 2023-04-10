package com.hotel.dao;


import com.hotel.modelo.Reservation;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {
    final private Connection con;

    public ReservationDAO(Connection con) {
        this.con = con;
    }

    public List<Reservation> listar() {
        List<Reservation> resultado = new ArrayList<>();
        try {
            final PreparedStatement statement = con.prepareStatement("SELECT id, check_in, check_out, value, payment_method FROM reservations");

            try (statement) {
                statement.execute();
                final ResultSet resultSet = statement.getResultSet();
                try (resultSet) {
                    while (resultSet.next()) {
                        Reservation fila = new Reservation(resultSet.getInt("id"),
                                resultSet.getString("check_in"),
                                resultSet.getString("check_out"),
                                resultSet.getString("value"),
                                resultSet.getString("payment_method"));
                        resultado.add(fila);
                    }
                }
                return resultado;
            }
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    public List<Reservation> search(Integer id) {
        List<Reservation> resultado = new ArrayList<>();
        try {
            final PreparedStatement statement = con.prepareStatement("SELECT id, check_in, check_out, value, payment_method FROM reservations WHERE id = ? ");
            try (statement) {

                statement.setInt(1, id);
                statement.execute();
                final ResultSet resultSet = statement.getResultSet();
                try (resultSet) {
                    while (resultSet.next()) {
                        Reservation fila = new Reservation(resultSet.getInt("id"),
                                resultSet.getString("check_in"),
                                resultSet.getString("check_out"),
                                resultSet.getString("value"),
                                resultSet.getString("payment_method"));
                        resultado.add(fila);
                    }
                }
                return resultado;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveReservation(Reservation reservation) {
        try (con) {
            final PreparedStatement statement = con.prepareStatement("INSERT INTO reservations " +
                            "(check_in, check_out, value, payment_method) VALUES (?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            try (statement) {
                registerExect(reservation, statement);
            }
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

    }

    public void registerExect(Reservation reservation, PreparedStatement statement) throws SQLException {
        statement.setString(1, reservation.getCheck_in());
        statement.setString(2, reservation.getCheck_out());
        statement.setString(3, reservation.getValue());
        statement.setString(4, reservation.getPayment_method());
        statement.execute();

        final ResultSet resultSet = statement.getGeneratedKeys();
        try (resultSet) {
            while (resultSet.next()) {
                reservation.setId(resultSet.getInt(1));
                System.out.println(String.format("Fue insertada la reserva ID %s", reservation));
            }
        }
    }

    public int deleteReservation(Integer id) {
        try {
            final PreparedStatement statement = con.prepareStatement("DELETE FROM reservations WHERE id = ?");
            try (statement) {
                statement.setInt(1, id);
                statement.execute();
                return statement.getUpdateCount();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No es posible eliminar este elemento");
            throw new RuntimeException(e);
        }
    }
    public int updateReservation(Integer id, String check_in, String check_out, String value, String payment_method){
        try{
            final PreparedStatement statement = con.prepareStatement("UPDATE reservations SET check_in= ?, "+
                    "check_out= ?, value= ?, payment_method= ? WHERE id= ? ");
            try(statement){
                statement.setString(1, check_in);
                statement.setString(2, check_out);
                statement.setString(3, value);
                statement.setString(4, payment_method);
                statement.setInt(5, id);
                statement.execute();
                return statement.getUpdateCount();
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}