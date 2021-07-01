package br.com.curso.exerciciossb.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class PrimeiroController {

    @GetMapping(path = {"/ola", "/saudacoes"})
    public String ola() {
        return "Olá Spring Boot!";
    }

    @PostMapping(path = {"/olas"})
    public String teste() {
        return "Olá Spring Boot! (POST)";
    }
}
