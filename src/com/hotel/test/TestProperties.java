package com.hotel.test;

import java.io.FileInputStream;
import java.util.Properties;

public class TestProperties {
    public static void main(String[] args) {
        Properties props = new Properties();
        try{
            props.load(new FileInputStream("database/config.properties"));
            String dayValue = props.getProperty("app.dayValue");
            System.out.println(dayValue);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
