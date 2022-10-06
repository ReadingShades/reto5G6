/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.g6.rentacar.service;

import co.com.g6.rentacar.model.Client;
import co.com.g6.rentacar.model.Reservation;
import co.com.g6.rentacar.repository.ClientRepository;
import co.com.g6.rentacar.repository.ReservationCountPerClientProjection;
import co.com.g6.rentacar.repository.ReservationRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
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
    
    @Autowired
    private ClientRepository clientRepositorio;

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
    public Reservation update(Reservation dataCarrier) {
        if (dataCarrier.getIdReservation()!= null) {
            // Optional allows us to check for nullability/existance of an entry
            Optional<Reservation> currentEntry = reservationRepositorio.getReservation(dataCarrier.getIdReservation());
            if (currentEntry.isEmpty()) {
                // If no matching Id/Entry is found then create a new dataCarrier/entry
                return reservationRepositorio.save(dataCarrier);
            } else {
                // If a matching Id/Entry is found then retrieve current entry 
                // to and update fields but preserve relations
                Reservation updatedEntry = currentEntry.get();
                updatedEntry.setStartDate(dataCarrier.getStartDate());
                updatedEntry.setDevolutionDate(dataCarrier.getDevolutionDate());
                updatedEntry.setStatus(dataCarrier.getStatus());
                updatedEntry.setScore(dataCarrier.getScore());
                return reservationRepositorio.save(updatedEntry);
            }
        } else {
            // If Id is missing from dataCarrier then return it as response
            return dataCarrier;            
        }
    }

    @Override
    public void delete(Reservation reservation) {
        reservationRepositorio.delete(reservation);
    }

    @Override
    public void deleteById(Integer id) {
        reservationRepositorio.deleteById(id);
    }

    @Override
    public void deleteAll() {
        reservationRepositorio.deleteAll();
    }

    @Override
    public LinkedHashMap<String, Integer> getStatusReport() {
        LinkedHashMap<String, Integer> statusReport = new LinkedHashMap<String, Integer>();
        statusReport.put("completed", reservationRepositorio.getCountByStatus("completed"));
        statusReport.put("cancelled", reservationRepositorio.getCountByStatus("cancelled"));
        return statusReport;
    }

    @Override
    public List<Reservation> getReservationsBetweenDates(Date date1, Date date2) {
        return reservationRepositorio.getReservationsBetweenDates(date1, date2);
    }

    @Override
    public List<ReservationCountByClientDTO> getClientReport() {
        // LinkedHashMap retains insertion order which is necessary to construct a Desc list
        ArrayList<ReservationCountByClientDTO> clientReport = new ArrayList<>();
        // We take the list of all clients and then we'll move them to a LinkedHashMap<idClient, Client>
        ArrayList<Client> clientList = (ArrayList) clientRepositorio.getAll();
        LinkedHashMap<Integer, Client> clientMap = new LinkedHashMap<>();
        for (int i = 0, n = clientList.size(); i < n; i++) {            
            clientMap.put(clientList.get(i).getIdClient(), clientList.get(i));            
        }
        // We get the DescList of reservations count per client and then with the previous list 
        // construct the report through DTOs
        ArrayList<ReservationCountPerClientProjection> reservationCountDescList = (ArrayList) reservationRepositorio.getReservationsTotalByClient();
        for(int i = 0, n = reservationCountDescList.size(); i < n; i++) {
            //System.out.println(reservationCountDescList.get(i).getReservationCount());
            Integer total = reservationCountDescList.get(i).getReservationCount();
            Client respectiveClient = clientMap.get(reservationCountDescList.get(i).getIdClient());
            clientReport.add(new ReservationCountByClientDTO(total, respectiveClient));
        }
        return clientReport;
    }
}
