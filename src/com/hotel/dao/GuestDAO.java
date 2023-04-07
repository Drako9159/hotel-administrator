package com.hotel.dao;


import com.hotel.modelo.Guest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuestDAO {
    final private Connection con;

    public GuestDAO(Connection con) {
        this.con = con;
    }

    public List<Guest> listar() {
        List<Guest> resultado = new ArrayList<>();
        try {
            final PreparedStatement statement = con.prepareStatement("SELECT id, " +
                    "first_name, last_name, date_of_birth, nationality, telephone, reservation_id FROM guests");

            try (statement) {
                statement.execute();
                final ResultSet resultSet = statement.getResultSet();
                try (resultSet) {
                    while (resultSet.next()) {
                        Guest fila = new Guest(resultSet.getInt("id"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name"),
                                resultSet.getString("date_of_birth"),
                                resultSet.getString("nationality"),
                                resultSet.getString("telephone"),
                                resultSet.getInt("reservation_id"));
                        resultado.add(fila);
                    }
                }
                return resultado;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveGuest(Guest guest) {
        try (con) {
            final PreparedStatement statement = con.prepareStatement("INSERT INTO guests " +
                            "(first_name, last_name, date_of_birth, nationality, telephone, reservation_id) " +
                            "VALUES (?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            try (statement) {
                registerExect(guest, statement);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void registerExect(Guest guest, PreparedStatement statement) throws SQLException {
        statement.setString(1, guest.getFirst_name());
        statement.setString(2, guest.getLast_name());
        statement.setString(3, guest.getDate_of_birth());
        statement.setString(4, guest.getNationality());
        statement.setString(5, guest.getTelephone());
        statement.setInt(6, guest.getReservation_id());
        statement.execute();

        final ResultSet resultSet = statement.getGeneratedKeys();
        try (resultSet) {
            while (resultSet.next()) {
                guest.setId(resultSet.getInt(1));
                System.out.println(String.format("Fue insertado el huesped ID %s", guest));
            }
        }

    }
}