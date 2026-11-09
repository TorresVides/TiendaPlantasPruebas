package com.ejemplo.tienda.service;

import com.ejemplo.tienda.model.Plant;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class PlantService {

    private final RestClient restClient;
    private static final String BASE_URL = "https://api.restful-api.dev/objects";

    public PlantService() {
        this.restClient = RestClient.builder()
                .baseUrl(BASE_URL)
                .build();
    }

    // Constructor alternativo que nos servirá más adelante para JUnit
    public PlantService(RestClient restClient) {
        this.restClient = restClient;
    }

    // POST: Guardar una planta en la API
    public Plant createPlant(Plant plant) {
        return restClient.post()
                .body(plant)
                .retrieve()
                .body(Plant.class);
    }

    // GET: Consultar una planta por su ID
    public Plant getPlantById(String id) {
        return restClient.get()
                .uri("/{id}", id)
                .retrieve()
                .body(Plant.class);
    }
}
