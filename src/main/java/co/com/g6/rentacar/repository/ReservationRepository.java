/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.g6.rentacar.repository;

import co.com.g6.rentacar.model.Reservation;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Caramu
 */
@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCRUDRepository reservationCRUDRepository;
    
    public List<Reservation> getAll() { return (List<Reservation>) reservationCRUDRepository.findAll(); }
    
    public Optional<Reservation> getReservation(Integer id) { return reservationCRUDRepository.findById(id); }
    
    public Reservation save(Reservation reservation) { return reservationCRUDRepository.save(reservation); }
    
    public void delete(Reservation reservation) { reservationCRUDRepository.delete(reservation); }
    
    public void deleteById(Integer reservationId) { reservationCRUDRepository.deleteById(reservationId); }
    
    public void deleteAll() { reservationCRUDRepository.deleteAll(); }
    
    public Integer getCountByStatus(String status) { return reservationCRUDRepository.countByStatusIs(status); }
    
    public List<Reservation> getReservationsBetweenDates(Date startDate, Date endDate) { return reservationCRUDRepository.findByStartDateBetween(startDate, endDate); }
    
    public List<ReservationCountPerClientProjection> getReservationsTotalByClient() { return reservationCRUDRepository.getReservationsCountByClient(); }
}
