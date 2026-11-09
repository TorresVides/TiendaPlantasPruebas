package com.ejemplo.tienda.model;

public class Plant {
    private String id;
    private String name;
    private PlantData data;

    public Plant() {}

    public Plant(String id, String name, PlantData data) {
        this.id = id;
        this.name = name;
        this.data = data;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public PlantData getData() { return data; }
    public void setData(PlantData data) { this.data = data; }
}
