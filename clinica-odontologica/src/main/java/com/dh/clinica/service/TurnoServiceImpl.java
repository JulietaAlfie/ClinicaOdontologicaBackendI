package com.dh.clinica.service;

import com.dh.clinica.exceptions.BadRequestException;
import com.dh.clinica.exceptions.ResourceNotFoundException;
import com.dh.clinica.model.Turno;
import com.dh.clinica.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoServiceImpl implements TurnoService {
    private final TurnoRepository turnoRepository;
    private PacienteService pacienteService;
    private OdontologoService odontologoService;


    @Autowired
    public TurnoServiceImpl(TurnoRepository turnoRepository, PacienteService pacienteService, OdontologoService odontologoService) {
        this.turnoRepository = turnoRepository;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }

    @Override
    public List<Turno> obtenerTodos() {
        return turnoRepository.findAll();
    }

    @Override
    public Optional<Turno> obtener(Integer id) {
        return turnoRepository.findById(id);
    }

    @Override
    public Turno guardar(Turno turno) throws BadRequestException{
        if(pacienteService.obtener(turno.getPaciente().getId()).isEmpty() || odontologoService.obtener(turno.getOdontologo().getId()).isEmpty()){
            throw new BadRequestException("No existe el odontologo/ paciente requerido");
        }
        return turnoRepository.save(turno);
    }

    @Override
    public void eliminar(Integer id) throws ResourceNotFoundException {
        if(obtener(id).isEmpty())
            throw  new ResourceNotFoundException("No existe turno con id: "+id);
        turnoRepository.deleteById(id);
    }

    @Override
    public Turno actualizar(Turno turno){
       return turnoRepository.save(turno);

    }
}
