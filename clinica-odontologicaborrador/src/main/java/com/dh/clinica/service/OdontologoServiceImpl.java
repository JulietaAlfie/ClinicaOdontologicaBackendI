package com.dh.clinica.service;

import com.dh.clinica.exceptions.ResourceNotFoundException;
import com.dh.clinica.model.Odontologo;
import com.dh.clinica.repository.OdontologoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class OdontologoServiceImpl implements OdontologoService {

    final static Logger log = Logger.getLogger(OdontologoServiceImpl.class);

    private final OdontologoRepository odontologoRepository;


    @Autowired
    public OdontologoServiceImpl(OdontologoRepository odontologoRepository){this.odontologoRepository = odontologoRepository;}

    @Override
    public List<Odontologo> obtenerTodos() {
        log.debug("Se genera lista de odontologos registrados");
        return odontologoRepository.findAll();
    }

    @Override
    public Odontologo obtener(Integer id) {
        log.debug("Se muestra el odontologo con id " + id);
        return odontologoRepository.getById(id);
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        log.debug("Registrando un odontologo con id: " + odontologo.getId());
        return odontologoRepository.save(odontologo);
    }

    @Override
    public void eliminar(Integer id) throws ResourceNotFoundException {
//        if(obtener(id).isEmpty())
//            throw  new ResourceNotFoundException("No existe odontologo con id: "+id);

        odontologoRepository.deleteById(id);
    }

    @Override
    public Odontologo actualizar(Odontologo odontologo){
        return odontologoRepository.save(odontologo);
    }
}
