package com.ejemplo.tienda.controller;

import com.ejemplo.tienda.model.Plant;
import com.ejemplo.tienda.service.PlantService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/plantas")
public class PlantController {

    private final PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @PostMapping
    public Plant createPlant(@RequestBody Plant plant) {
        return plantService.createPlant(plant);
    }

    @GetMapping("/{id}")
    public Plant getPlantById(@PathVariable String id) {
        return plantService.getPlantById(id);
    }
}
