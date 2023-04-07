package com.hotel.modelo;

public class Reservation {
    private Integer id;
    private String check_in;
    private String check_out;
    private String value;
    private String payment_method;

    public Reservation(String check_in, String check_out, String value, String payment_method) {
        this.check_in = check_in;
        this.check_out = check_out;
        this.value = value;
        this.payment_method = payment_method;
    }

    public Reservation(Integer id, String check_in, String check_out, String value, String payment_method) {
        this.id = id;
        this.check_in = check_in;
        this.check_out = check_out;
        this.value = value;
        this.payment_method = payment_method;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCheck_in() {
        return check_in;
    }

    public void setCheck_in(String check_in) {
        this.check_in = check_in;
    }

    public String getCheck_out() {
        return check_out;
    }

    public void setCheck_out(String check_out) {
        this.check_out = check_out;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    @Override
    public String toString() {
        return String.format("{ id: %s, check_in: %s, check_out: %s, value: %s, payment_method: %s }", this.id, this.check_in, this.check_out, this.value, this.payment_method);
    }

}
