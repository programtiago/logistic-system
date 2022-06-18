package com.devtiago.logisticsystem.controller;

import com.devtiago.logisticsystem.domain.Client;
import com.devtiago.logisticsystem.repository.ClientRepository;
import com.devtiago.logisticsystem.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "api/clients")
public class ClientController {
    private static final Logger LOG = LoggerFactory.getLogger(ClientController.class);

    private final ClientService clientService;
    private final ClientRepository clientRepository;

    public ClientController(ClientService clientService, ClientRepository clientRepository) {
        this.clientService = clientService;
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> find(@PathVariable Long id){
        return clientRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client add(@Valid @RequestBody Client client){
        return clientService.save(client);
    }
}
