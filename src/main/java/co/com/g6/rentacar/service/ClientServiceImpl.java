/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.g6.rentacar.service;

import co.com.g6.rentacar.model.Client;
import co.com.g6.rentacar.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Caramu
 */
@Service
public class ClientServiceImpl implements ClientService {
    
    @Autowired
    private ClientRepository clientRepositorio;

    @Override
    public List<Client> getAll() {
        return clientRepositorio.getAll();
    }

    @Override
    public Optional<Client> getClient(Integer clientId) {
        return clientRepositorio.getClient(clientId);
    }

    @Override
    public Client save(Client client) {
        if (client.getIdClient() == null) {
            return clientRepositorio.save(client);
        } else {
            Optional<Client> client1 = clientRepositorio.getClient(client.getIdClient());
            if (client1.isEmpty()) {
                return clientRepositorio.save(client);
            } else {
                return client;
            }
        }
    }

    @Override
    public Client update(Client dataCarrier) {
        if (dataCarrier.getIdClient()!= null) {
            // Optional allows us to check for nullability/existance of an entry
            Optional<Client> currentEntry = clientRepositorio.getClient(dataCarrier.getIdClient());
            if (currentEntry.isEmpty()) {
                // If no matching Id/Entry is found then create a new dataCarrier/entry
                return clientRepositorio.save(dataCarrier);
            } else {
                // If a matching Id/Entry is found then retrieve current entry 
                // to and update fields but preserve relations
                Client updatedEntry = currentEntry.get();
                updatedEntry.setEmail(dataCarrier.getEmail());
                updatedEntry.setPassword(dataCarrier.getPassword());
                updatedEntry.setName(dataCarrier.getName());
                updatedEntry.setAge(dataCarrier.getAge());
                return clientRepositorio.save(updatedEntry);
            }
        } else {
            // If Id is missing from dataCarrier then return it as response
            return dataCarrier;            
        }
    }

    @Override
    public void delete(Client client) {
        clientRepositorio.delete(client);
    }

    @Override
    public void deleteById(Integer id) {
        clientRepositorio.deleteById(id);
    }

    @Override
    public void deleteAll() {
        clientRepositorio.deleteAll();
    }
}
