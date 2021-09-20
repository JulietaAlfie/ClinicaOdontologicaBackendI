package com.dh.clinica.service;

import com.dh.clinica.model.Domicilio;
import com.dh.clinica.repository.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioServiceImpl implements DomicilioService{
    private final DomicilioRepository domicilioRepository;


    @Autowired
    public DomicilioServiceImpl(DomicilioRepository domicilioRepository){this.domicilioRepository = domicilioRepository;}

    @Override
    public List<Domicilio> obtenerTodos() {
        return domicilioRepository.findAll();
    }

    @Override
    public Optional<Domicilio> obtener(Integer id) {
        return domicilioRepository.findById(id);
    }

    @Override
    public Domicilio guardar(Domicilio domicilio) {
        return domicilioRepository.save(domicilio);
    }

    @Override
    public void eliminar(Integer id) {
        domicilioRepository.deleteById(id);
    }
}
