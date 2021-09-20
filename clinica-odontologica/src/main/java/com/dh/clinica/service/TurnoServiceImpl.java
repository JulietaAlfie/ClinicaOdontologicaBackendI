package com.dh.clinica.service;

import com.dh.clinica.model.Turno;
import com.dh.clinica.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoServiceImpl implements TurnoService {
    private final TurnoRepository turnoRepository;


    @Autowired
    public TurnoServiceImpl(TurnoRepository turnoRepository){this.turnoRepository = turnoRepository;}

    @Override
    public List<Turno> obtenerTodos() {
        return turnoRepository.findAll();
    }

    @Override
    public Optional<Turno> obtener(Integer id) {
        return turnoRepository.findById(id);
    }

    @Override
    public Turno guardar(Turno turno) {
        return turnoRepository.save(turno);

    }

    @Override
    public void eliminar(Integer id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public Turno actualizar(Turno turno){
       return turnoRepository.save(turno);

    }
}
