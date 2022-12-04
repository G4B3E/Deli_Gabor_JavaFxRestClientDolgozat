package com.example.deli_gabor_javafxrestclientdolgozat;

public class Movie {
    private int id;
    private String name;
    private int year;
    private String prize;

    public Movie(int id, String name, int year, String prize) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.prize = prize;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }
}
