package com.hotel.modelo;
public class Guest {
    private Integer id;
    private String first_name;
    private String last_name;
    private String date_of_birth;
    private String nationality;
    private String telephone;
    private Integer reservation_id;


    public Guest(String first_name, String last_name, String date_of_birth, String nationality, String telephone, Integer reservation_id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_of_birth = date_of_birth;
        this.nationality = nationality;
        this.telephone = telephone;
        this.reservation_id = reservation_id;
    }
    public Guest(Integer id ,String first_name, String last_name, String date_of_birth, String nationality, String telephone, Integer reservation_id) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_of_birth = date_of_birth;
        this.nationality = nationality;
        this.telephone = telephone;
        this.reservation_id = reservation_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(Integer reservation_id) {
        this.reservation_id = reservation_id;
    }

    @Override
    public String toString() {
        return String.format("{ id: %s, first_name: %s, last_name: %s, date_of_birth: %s, nationality: %s, telephone: %s, reservation_id: %s }",
                this.id, this.first_name, this.last_name, this.date_of_birth, this.nationality, telephone, reservation_id);
    }


}