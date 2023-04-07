package com.hotel.factory;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
    private DataSource datasource;
    public ConnectionFactory(){
        var pooledDataSource = new ComboPooledDataSource();
        pooledDataSource.setJdbcUrl("jdbc:mysql://localhost/hotel?useTimeZone=true&serverTimeZone=UTC");
        pooledDataSource.setUser("root");
        pooledDataSource.setPassword("password");

        pooledDataSource.setMaxPoolSize(10);
        this.datasource = pooledDataSource;
    }
    public Connection recuperaConexion(){
        try{
            return this.datasource.getConnection();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
