/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.g6.rentacar.repository;

import co.com.g6.rentacar.model.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Caramu
 */
public interface ReservationCRUDRepository extends CrudRepository<Reservation, Integer> {

    Integer countByStatusIs(String status);

    List<Reservation> findByStartDateBetween(Date startDate, Date endDate);

    @Query(value = "SELECT COUNT(reservations.ID_RESERVATION ) AS ReservationCount, reservations.ID_CLIENT  AS IdClient FROM reservations GROUP BY IdClient ORDER BY ReservationCount DESC", nativeQuery = true)
    // Experimental JPA query for multidb compatibility
    //@Query(value = "SELECT COUNT(rt.idReservation), rt.client.idClient FROM Reservation rt LEFT JOIN FETCH rt.client rclt GROUP BY rt.client.idClient ORDER BY COUNT(rt.idReservation) DESC")
    List<ReservationCountPerClientProjection> getReservationsCountByClient();
}
