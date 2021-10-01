package com.dh.clinica.service;

import com.dh.clinica.model.Domicilio;

import java.util.List;
import java.util.Optional;

public interface DomicilioService {
    List<Domicilio> obtenerTodos();
    Optional<Domicilio> obtener(Integer id);
    Domicilio guardar(Domicilio domicilio);
    void eliminar(Integer id);
}
