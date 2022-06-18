package com.devtiago.logisticsystem.service;

import com.devtiago.logisticsystem.domain.Client;
import com.devtiago.logisticsystem.domain.exception.DomainException;
import com.devtiago.logisticsystem.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public Client get(Long clientId){
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new DomainException("Client not found"));
    }

    @Transactional
    public Client save(Client client) {
        boolean emailExistent = clientRepository.findByEmail(client.getEmail())
                .stream()
                .anyMatch(clientExistent -> !clientExistent.equals(client));

        if (emailExistent){
            throw new DomainException("There is already a customer with this registered email.");
        }

        return clientRepository.save(client);

    }

    @Transactional
    public void delete(Long clientId) {

        clientRepository.deleteById(clientId);
    }
}
