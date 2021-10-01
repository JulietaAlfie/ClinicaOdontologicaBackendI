package com.dh.clinica.service;

import com.dh.clinica.exceptions.BadRequestException;
import com.dh.clinica.exceptions.ResourceNotFoundException;
import com.dh.clinica.model.Turno;
import com.dh.clinica.model.TurnoDTO;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface TurnoService {
    Collection<TurnoDTO> obtenerTodos();
    TurnoDTO obtener(Integer id);
    void guardar(TurnoDTO turnoDTO) throws BadRequestException;
    void eliminar(Integer id) throws ResourceNotFoundException;
    void actualizar(TurnoDTO turnoDTO);
}
