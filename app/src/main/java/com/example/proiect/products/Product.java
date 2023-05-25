package com.example.proiect.products;

public class Product {
    private int id;
    private String name;
    private int calories;
    private double price;

    public Product() {
    }

    public Product(int id, String name, int calories, double price) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.price = price;
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

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
