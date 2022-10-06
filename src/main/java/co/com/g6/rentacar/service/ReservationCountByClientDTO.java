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
public class ReservationCountByClientDTO {
    private final Integer total;
    private final Client client;

    public ReservationCountByClientDTO(Integer total, Client client) {
        this.total = total;
        this.client = client;
    }

    public Integer getTotal() {
        return total;
    }

    public Client getClient() {
        return client;
    }
    
    
}
