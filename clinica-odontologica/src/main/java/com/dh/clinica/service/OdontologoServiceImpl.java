package com.dh.clinica.service;

import com.dh.clinica.model.Odontologo;
import com.dh.clinica.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class OdontologoServiceImpl implements OdontologoService {

    private final OdontologoRepository odontologoRepository;


    @Autowired
    public OdontologoServiceImpl(OdontologoRepository odontologoRepository){this.odontologoRepository = odontologoRepository;}

    @Override
    public List<Odontologo> obtenerTodos() {
        return odontologoRepository.findAll();
    }

    @Override
    public Optional<Odontologo> obtener(Integer id) {
        return odontologoRepository.findById(id);
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    @Override
    public void eliminar(Integer id) {
        odontologoRepository.deleteById(id);
    }

    @Override
    public Odontologo actualizar(Odontologo odontologo){
        return odontologoRepository.save(odontologo);
    }
}
