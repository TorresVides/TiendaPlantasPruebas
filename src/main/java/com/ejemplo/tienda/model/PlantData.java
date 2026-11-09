package com.ejemplo.tienda.model;

public class PlantData {
    private Double price;
    private Integer stock;
    private String species;

    public PlantData() {}

    public PlantData(Double price, Integer stock, String species) {
        this.price = price;
        this.stock = stock;
        this.species = species;
    }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }
}
