package com.example.medicine_tracker.Model;

import java.sql.Time;

public class Meal_time {
    private String meal_id;
    private String morning;
    private  String day;
    private String night;

    public Meal_time(String meal_id, String morning, String day, String night) {
        this.meal_id = meal_id;
        this.morning = morning;
        this.day = day;
        this.night = night;
    }

    public Meal_time() {

    }

    public String getMeal_id() {
        return meal_id;
    }

    public void setMeal_id(String meal_id) {
        this.meal_id = meal_id;
    }

    public String getMorning() {
        return morning;
    }

    public void setMorning(String morning) {
        this.morning = morning;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getNight() {
        return night;
    }

    public void setNight(String night) {
        this.night = night;
    }
}
