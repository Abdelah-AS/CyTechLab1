package com.example.demo;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ProduitController {

    private final Map<Integer, Produit> produits = Map.of(
        1, new Produit(1, "Ordinateur", 1200),
        2, new Produit(2, "Clavier", 50),
        3, new Produit(3, "Souris", 25)
    );

    @GetMapping("/produits/{id}")
    public Produit chercherProduit(@PathVariable("id") int id) {
        Produit produit = produits.get(id);

        if (produit == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Produit introuvable"
            );
        }

        return produit;
    }
}