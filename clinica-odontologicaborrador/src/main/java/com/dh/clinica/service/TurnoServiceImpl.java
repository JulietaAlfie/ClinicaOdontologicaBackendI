package com.dh.clinica.service;

import com.dh.clinica.exceptions.BadRequestException;
import com.dh.clinica.exceptions.ResourceNotFoundException;
import com.dh.clinica.model.Turno;
import com.dh.clinica.model.TurnoDTO;
import com.dh.clinica.repository.TurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TurnoServiceImpl implements TurnoService {
    private final TurnoRepository turnoRepository;
    private PacienteService pacienteService;
    private OdontologoService odontologoService;

    @Autowired
    ObjectMapper mapper;


    @Autowired
    public TurnoServiceImpl(TurnoRepository turnoRepository, PacienteService pacienteService, OdontologoService odontologoService) {
        this.turnoRepository = turnoRepository;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }

    @Override
    public Collection<TurnoDTO> obtenerTodos() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDTO> turnosDTO = new HashSet<>();
        for (Turno turno : turnos) {
            TurnoDTO turnoDTO = new TurnoDTO();
            turnoDTO.setId(turno.getId());
            turnoDTO.setDate(turno.getDate());
            turnoDTO.setPacienteId(turno.getPaciente().getId());
            turnoDTO.setOdontologoId(turno.getOdontologo().getId());
            turnosDTO.add(turnoDTO);
        }
        return turnosDTO;
    }

    @Override
    public TurnoDTO obtener(Integer id) {
        TurnoDTO turnoDTO = null;
        Optional<Turno> turno = turnoRepository.findById(id);
        if (turno.isPresent()){
            turnoDTO = mapper.convertValue(turno, TurnoDTO.class);
        }
        return turnoDTO;
    }

    @Override
    public void guardar(TurnoDTO turnoDTO) throws BadRequestException{
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        turno.setPaciente(pacienteService.obtener(turnoDTO.getPacienteId()));
        turno.setOdontologo(odontologoService.obtener(turnoDTO.getOdontologoId()));
//        if(pacienteService.obtener(turno.getPaciente().getId()).isEmpty() || odontologoService.obtener(turno.getOdontologo().getId()).isEmpty()){
//            throw new BadRequestException("No existe el odontologo/ paciente requerido");
//        }
        turnoRepository.save(turno);
    }

    @Override
    public void eliminar(Integer id) throws ResourceNotFoundException {
        turnoRepository.deleteById(id);
    }

    @Override
    public void actualizar(TurnoDTO turnoDTO){
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        turno.setPaciente(pacienteService.obtener(turnoDTO.getPacienteId()));
        turno.setOdontologo(odontologoService.obtener(turnoDTO.getOdontologoId()));
        turnoRepository.save(turno);
    }
}
