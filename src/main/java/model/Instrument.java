package model;

public class Instrument {
    private int id;
    private String name;
    private double price;

    public Instrument(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    } // criação objeto instrumento

    // Getters e Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
}// config gett e sett
