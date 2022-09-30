/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.g6.rentacar.service;

import co.com.g6.rentacar.model.Machine;
import co.com.g6.rentacar.repository.MachineRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Caramu
 */
@Service
public class MachineServiceImpl implements MachineService {
    
    @Autowired
    private MachineRepository machineRepositorio;

    @Override
    public List<Machine> getAll() {
        return machineRepositorio.getAll();
    }

    @Override
    public Optional<Machine> getMachine(Integer machineId) {
        return machineRepositorio.getMachine(machineId);
    }

    @Override
    public Machine save(Machine machine) {
        if (machine.getId() == null) {
            return machineRepositorio.save(machine);
        } else {
            Optional<Machine> machine1 = machineRepositorio.getMachine(machine.getId());
            if (machine1.isEmpty()) {
                return machineRepositorio.save(machine);
            } else {
                return machine;
            }
        }
    }

    @Override
    public Machine update(Machine dataCarrier) {
        if (dataCarrier.getId()!= null) {
            // Optional allows us to check for nullability/existance of an entry
            Optional<Machine> currentEntry = machineRepositorio.getMachine(dataCarrier.getId());
            if (currentEntry.isEmpty()) {
                // If no matching Id/Entry is found then create a new dataCarrier/entry
                return machineRepositorio.save(dataCarrier);
            } else {
                // If a matching Id/Entry is found then retrieve current entry 
                // to and update fields but preserve relations
                Machine updatedEntry = currentEntry.get();
                updatedEntry.setName(dataCarrier.getName());
                updatedEntry.setBrand(dataCarrier.getBrand());
                updatedEntry.setYear(dataCarrier.getYear());
                updatedEntry.setDescription(dataCarrier.getDescription());
                return machineRepositorio.save(updatedEntry);
            }
        } else {
            // If Id is missing from dataCarrier then return it as response
            return dataCarrier;            
        }
    }

    @Override
    public void delete(Machine machine) {
        machineRepositorio.delete(machine);
    }

    @Override
    public void deleteById(Integer id) {
        machineRepositorio.deleteById(id);
    }

    @Override
    public void deleteAll() {
        machineRepositorio.deleteAll();
    }
}
