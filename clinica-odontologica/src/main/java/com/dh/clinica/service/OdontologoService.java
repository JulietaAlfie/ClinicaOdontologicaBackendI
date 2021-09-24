package com.dh.clinica.service;

import com.dh.clinica.exceptions.ResourceNotFoundException;
import com.dh.clinica.model.Odontologo;
import java.util.List;
import java.util.Optional;

public interface OdontologoService {
    List<Odontologo> obtenerTodos();
    Optional<Odontologo> obtener(Integer id);
    Odontologo guardar(Odontologo odontologo);
    void eliminar(Integer id) throws ResourceNotFoundException;
    Odontologo actualizar(Odontologo odontologo);
}
