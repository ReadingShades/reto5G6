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
    public Client update(Client client) {
        return clientRepositorio.save(client);
    }

    @Override
    public void delete(Client client) {
        clientRepositorio.delete(client);
    }

    @Override
    public void deleteById(Integer id) {
        clientRepositorio.deleteById(id);
    }
}
