package com.dh.clinica.service;

import com.dh.clinica.model.Paciente;
import java.util.List;
import java.util.Optional;

public interface PacienteService {
    List<Paciente> obtenerTodos();
    Optional<Paciente> obtener(Integer id);
    Paciente guardar(Paciente paciente);
    void eliminar(Integer id);
    Paciente actualizar(Paciente paciente);
}
