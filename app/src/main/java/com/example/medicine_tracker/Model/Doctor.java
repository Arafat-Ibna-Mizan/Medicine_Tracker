package com.example.medicine_tracker.Model;

public class Doctor {
    private  String doc_name;
    private int id;
    private String first_date;
    private String meet_date;
    private byte[] picture;

    public Doctor() {

    }
    public Doctor(String doc_name, int id, String first_date, String meet_date, byte[] picture) {
        this.doc_name = doc_name;
        this.id = id;
        this.first_date = first_date;
        this.meet_date = meet_date;
        this.picture = picture;
    }




    public String getDoc_name() {
        return doc_name;
    }

    public void setDoc_name(String doc_name) {
        this.doc_name = doc_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_date() {
        return first_date;
    }

    public void setFirst_date(String first_date) {
        this.first_date = first_date;
    }

    public String getMeet_date() {
        return meet_date;
    }

    public void setMeet_date(String meet_date) {
        this.meet_date = meet_date;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}
