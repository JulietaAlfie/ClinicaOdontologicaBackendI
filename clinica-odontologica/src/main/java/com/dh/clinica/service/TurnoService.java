package com.dh.clinica.service;

import com.dh.clinica.model.Turno;
import java.util.List;
import java.util.Optional;

public interface TurnoService {
    List<Turno> obtenerTodos();
    Optional<Turno> obtener(Integer id);
    Turno guardar(Turno turno);
    void eliminar(Integer id);
    Turno actualizar(Turno turno);
}
