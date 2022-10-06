/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.g6.rentacar.service;

import co.com.g6.rentacar.model.Reservation;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Caramu
 */
public interface ReservationService {    
    
    public List<Reservation> getAll();

    public Optional<Reservation> getReservation(Integer reservationId);

    public Reservation save(Reservation reservation);
    
    public Reservation update(Reservation reservation);
    
    public void delete(Reservation reservation);
    
    public void deleteById(Integer id);
    
    public void deleteAll();
    
    public HashMap<String,Integer> getStatusReport();
    
    public List<Reservation> getReservationsBetweenDates(Date date1, Date date2);
    
    public List<Reservation> getReservationsBetweenDates(String date1, String date2);
    
    public List<ReservationCountByClientDTO> getClientReport();
}
