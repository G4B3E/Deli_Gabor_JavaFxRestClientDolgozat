package com.example.deli_gabor_javafxrestclientdolgozat;

public class Movie {
    private int id;
    private int Year;
    private String Movies;
    private String Prizes;

    public Movie(int id, int year, String movies, String prizes) {
        this.id = id;
        Year = year;
        Movies = movies;
        Prizes = prizes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public String getMovies() {
        return Movies;
    }

    public void setMovies(String movies) {
        Movies = movies;
    }

    public String getPrizes() {
        return Prizes;
    }

    public void setPrizes(String prizes) {
        Prizes = prizes;
    }
}




