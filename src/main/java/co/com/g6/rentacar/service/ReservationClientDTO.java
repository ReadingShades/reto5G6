/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.g6.rentacar.service;

import co.com.g6.rentacar.model.Client;

/**
 *
 * @author Caramu
 */
public class ReservationClientDTO {
    private final String element = "client";    
    private final Client client;

    public ReservationClientDTO(Client client) {
        this.client = client;
    }

    public String getElement() {
        return element;
    }

    public Client getClient() {
        return client;
    }
    
    
}
