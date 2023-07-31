package com.example.medicine_tracker.Model;

public class Medicine {
    private int doctor_id;
    private int id;
    private String name;
    private int morning;
    private int day;
    private int night;
    private int before_meal;
    private int after_meal;
    private double quantity;
    private int no_of_days;
    private int rem_medicine;


    public Medicine(int doctor_id,int id, String name, int morning, int day,
                    int night, int before_meal, int after_meal, double quantity,
                    int no_of_days,int rem_medicine) {
        this.doctor_id = doctor_id;
        this.id = id;
        this.name = name;
        this.morning = morning;
        this.day = day;
        this.night = night;
        this.before_meal = before_meal;
        this.after_meal = after_meal;
        this.quantity = quantity;
        this.no_of_days = no_of_days;
        this.rem_medicine=rem_medicine;

    }

    public Medicine() {

    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMorning() {
        return morning;
    }

    public void setMorning(int morning) {
        this.morning = morning;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getNight() {
        return night;
    }

    public void setNight(int night) {
        this.night = night;
    }

    public int getBefore_meal() {
        return before_meal;
    }

    public void setBefore_meal(int before_meal) {
        this.before_meal = before_meal;
    }

    public int getAfter_meal() {
        return after_meal;
    }

    public void setAfter_meal(int after_meal) {
        this.after_meal = after_meal;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public int getNo_of_days() {
        return no_of_days;
    }

    public void setNo_of_days(int no_of_days) {
        this.no_of_days = no_of_days;
    }

    public int getRem_medicine() {
        return rem_medicine;
    }

    public void setRem_medicine(int rem_medicine) {
        this.rem_medicine = rem_medicine;
    }




}
