/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.g6.rentacar.repository;

import co.com.g6.rentacar.model.Client;

/**
 *
 * @author Caramu
 */
public interface ReservationCountClientProjection {
    Integer getReservationsCount();
    Client getClient();
}
