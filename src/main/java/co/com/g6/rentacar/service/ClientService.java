/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.g6.rentacar.service;

import co.com.g6.rentacar.model.Client;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Caramu
 */
public interface ClientService {    
    
    public List<Client> getAll();

    public Optional<Client> getClient(Integer clientId);

    public Client save(Client client);
    
    public Client update(Client client);
    
    public void delete(Client client);
    
    public void deleteById(Integer id);
}
