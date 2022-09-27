/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.g6.rentacar.repository;

import co.com.g6.rentacar.model.Machine;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Caramu
 */
@Repository
public class MachineRepository {
    @Autowired
    private MachineCRUDRepository machineCRUDRepository;
    
    public List<Machine> getAll() { return (List<Machine>) machineCRUDRepository.findAll(); }
    
    public Optional<Machine> getMachine(Integer id) { return machineCRUDRepository.findById(id); }
    
    public Machine save(Machine machine) { return machineCRUDRepository.save(machine); }
    
    public void delete(Machine machine) { machineCRUDRepository.delete(machine); }
    
    public void deleteById(Integer machineId) { machineCRUDRepository.deleteById(machineId); }
}
