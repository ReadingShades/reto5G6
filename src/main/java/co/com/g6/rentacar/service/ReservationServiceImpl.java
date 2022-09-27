/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.g6.rentacar.service;

import co.com.g6.rentacar.model.Reservation;
import co.com.g6.rentacar.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Caramu
 */
@Service
public class ReservationServiceImpl implements ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepositorio;

    @Override
    public List<Reservation> getAll() {
        return reservationRepositorio.getAll();
    }

    @Override
    public Optional<Reservation> getReservation(Integer reservationId) {
        return reservationRepositorio.getReservation(reservationId);
    }

    @Override
    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return reservationRepositorio.save(reservation);
        } else {
            Optional<Reservation> reservation1 = reservationRepositorio.getReservation(reservation.getIdReservation());
            if (reservation1.isEmpty()) {
                return reservationRepositorio.save(reservation);
            } else {
                return reservation;
            }
        }
    }

    @Override
    public Reservation update(Reservation reservation) {
        return reservationRepositorio.save(reservation);
    }

    @Override
    public void delete(Reservation reservation) {
        reservationRepositorio.delete(reservation);
    }

    @Override
    public void deleteById(Integer id) {
        reservationRepositorio.deleteById(id);
    }
}
