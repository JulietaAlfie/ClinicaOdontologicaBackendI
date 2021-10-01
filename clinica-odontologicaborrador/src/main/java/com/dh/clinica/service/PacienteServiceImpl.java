package com.dh.clinica.service;

import com.dh.clinica.exceptions.ResourceNotFoundException;
import com.dh.clinica.model.Paciente;
import com.dh.clinica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService{
    private final PacienteRepository pacienteRepository;
    private DomicilioServiceImpl domicilioService;

    @Autowired
    public PacienteServiceImpl(PacienteRepository pacienteRepository, DomicilioServiceImpl domicilioService){
        this.pacienteRepository = pacienteRepository;
        this.domicilioService = domicilioService;
    }

    @Override
    public List<Paciente> obtenerTodos() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente obtener(Integer id) {
        return pacienteRepository.getById(id);
    }

    @Override
    public Paciente guardar(Paciente paciente) {
        paciente.setDomicilio(domicilioService.guardar(paciente.getDomicilio()));
       return pacienteRepository.save(paciente);

    }

    @Override
    public void eliminar(Integer id) throws ResourceNotFoundException {
//        if(obtener(id).isEmpty())
//            throw  new ResourceNotFoundException("No existe paciente con id: "+id);
       pacienteRepository.deleteById(id);
    }

    @Override
    public Paciente actualizar(Paciente paciente){
        pacienteRepository.save(paciente);
        return paciente;
    }
}
