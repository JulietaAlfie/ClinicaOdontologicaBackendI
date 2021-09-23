package com.dh.clinica.service;

import com.dh.clinica.exceptions.BadRequestException;
import com.dh.clinica.model.Turno;
import java.util.List;
import java.util.Optional;

public interface TurnoService {
    List<Turno> obtenerTodos();
    Optional<Turno> obtener(Integer id);
    Turno guardar(Turno turno) throws BadRequestException;
    void eliminar(Integer id);
    Turno actualizar(Turno turno);
}
