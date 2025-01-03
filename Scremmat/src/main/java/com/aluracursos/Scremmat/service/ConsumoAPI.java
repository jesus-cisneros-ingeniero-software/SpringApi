package com.aluracursos.Scremmat.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Clase para consumir datos desde una API mediante HTTP.
 */
public class ConsumoAPI {

    /**
     * Realiza una solicitud HTTP GET a la URL proporcionada y devuelve la respuesta en formato JSON.
     *
     * @param url La URL de la API a la que se desea realizar la solicitud.
     * @return La respuesta de la API en formato JSON.
     * @throws RuntimeException Si ocurre un error durante la solicitud HTTP.
     */
    public String obtenerDatos(String url) {
        // Crear un cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Crear la solicitud HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body(); // Devolver el cuerpo de la respuesta como String
        } catch (IOException e) {
            throw new RuntimeException("Error de E/S durante la solicitud HTTP: " + e.getMessage(), e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restablecer el estado de interrupción del hilo
            throw new RuntimeException("La solicitud HTTP fue interrumpida: " + e.getMessage(), e);
        }
    }
}
