package com.example.java_ekaterine_mashchenko;

public class Flight{
    private String destination;
    private String time;
    private int seats;
    private int price;




    public <Int> Flight(String destination, String time, int seats, int price) {
        this.destination = destination;
        this.time = time;
        this.seats = seats;
        this.price = price;
    }





    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String  getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return destination+" "+time+" "+seats+" "+price;
    }
}