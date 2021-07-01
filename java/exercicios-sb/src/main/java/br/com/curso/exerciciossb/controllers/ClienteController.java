package br.com.curso.exerciciossb.controllers;

import br.com.curso.exerciciossb.model.entites.Cliente;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "clientes")
public class ClienteController {

    @GetMapping(path = "qualquer")
    public Cliente obterCliente() {
        return new Cliente(28, "Pedro", "123.456.789-00");
    }

    @GetMapping("/{id}")
    public Cliente obterClientePorId1(@PathVariable int id) {
        return new Cliente(id, "Marina", "987.654.321-00");
    }

    @GetMapping
    public Cliente obterClientePorId2(@RequestParam(name="id") int id) {
        return new Cliente(id, "Marina", "558.529.965-11");
    }
}
