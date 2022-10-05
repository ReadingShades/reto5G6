/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.g6.rentacar.repository;

import co.com.g6.rentacar.model.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Caramu
 */
public interface ReservationCRUDRepository extends CrudRepository<Reservation, Integer> {
    Integer countByStatusIs(String status);
    List<Reservation> findByStartDateBetween(Date date1, Date date2);
}
