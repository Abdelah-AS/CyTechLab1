package com.example.client_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class ClientController {

    private final RestClient restClient = RestClient.create(
        "http://localhost:8083"
    );

    @GetMapping(
        value = "/client/produit/{id}",
        produces = "application/json"
    )
    public String chercherProduit(@PathVariable("id") int id) {
        return restClient.get()
                .uri("/produits/{id}", id)
                .retrieve()
                .body(String.class);
    }
}