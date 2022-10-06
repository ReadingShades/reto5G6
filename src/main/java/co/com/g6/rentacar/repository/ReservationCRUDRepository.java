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

    List<Reservation> findByStartDateBetween(Date date1, Date date2);

    @Query(value = "SELECT COUNT(reservations.ID_RESERVATION ) AS ReservationCount, reservations.ID_CLIENT  AS IdClient FROM reservations GROUP BY IdClient ORDER BY ReservationCount DESC", nativeQuery = true)
    //@Query(value = "SELECT COUNT(r.idReservation ) AS c, r.client.idClient  AS i FROM Reservation r GROUP BY i ORDER BY c DESC")
    List<ReservationCountPerClientProjection> getReservationsCountByClient();
}
