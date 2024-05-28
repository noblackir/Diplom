package ru.nikitina.restaurant.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nikitina.restaurant.model.Client;
import ru.nikitina.restaurant.service.ClientService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Client> post(@RequestBody Client client){
        return new ResponseEntity<>(clientService.save(client), HttpStatus.CREATED);
    }

    @PostMapping("/role/{id}/{role}")
    public ResponseEntity<Client> changeRole(@PathVariable(name = "id") Long id,
                                       @PathVariable(name = "role") String role){
        return new ResponseEntity<>(clientService.setRole(role, id), HttpStatus.CREATED);
    }

    @GetMapping("/{client_id}")
    public ResponseEntity<Client> getClient(@PathVariable Long client_id) {
        return new ResponseEntity<>(clientService.getClient(client_id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Client>> all() {
        return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK);
    }
}
