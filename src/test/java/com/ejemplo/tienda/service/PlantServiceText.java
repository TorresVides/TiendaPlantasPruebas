package com.ejemplo.tienda.service;

import com.ejemplo.tienda.model.Plant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestClient;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

class PlantServiceTest {

    private PlantService plantService;
    private MockRestServiceServer mockServer;

    @BeforeEach
    void setUp() {
        // Configuramos el cliente con el simulador antes de cada prueba
        RestClient.Builder builder = RestClient.builder().baseUrl("https://api.restful-api.dev/objects");
        mockServer = MockRestServiceServer.bindTo(builder).build();
        plantService = new PlantService(builder.build());
    }

    @Test
    void testGetPlantById_Exito() {
        // 1. Arrange (Preparar la respuesta simulada)
        String jsonSimulado = """
            {
                "id": "123",
                "name": "Helecho Boston"
            }
            """;

        mockServer.expect(requestTo("https://api.restful-api.dev/objects/123"))
                .andRespond(withSuccess(jsonSimulado, MediaType.APPLICATION_JSON));

        // 2. Act (Llamar a nuestro método)
        Plant resultado = plantService.getPlantById("123");

        // 3. Assert (Comprobar resultados)
        assertNotNull(resultado);
        assertEquals("123", resultado.getId());
        assertEquals("Helecho Boston", resultado.getName());
    }
}