package com.dh.clinica.controller;

import com.dh.clinica.exceptions.ResourceNotFoundException;
import com.dh.clinica.model.Odontologo;

import com.dh.clinica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/odontologos")
@CrossOrigin("*")
public class OdontologoController {

    private final OdontologoService odontologoService;

    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }


    @PostMapping()
    public ResponseEntity<Odontologo> guardar(@RequestBody Odontologo odontologo) {

        return ResponseEntity.ok(odontologoService.guardar(odontologo));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> obtener(@PathVariable Integer id) {
        Odontologo odontologo = odontologoService.obtener(id);

        return ResponseEntity.ok(odontologo);
    }

    @PutMapping()
    public ResponseEntity<Odontologo> actualizar(@RequestBody Odontologo odontologo) {
        ResponseEntity<Odontologo> response;

        if (odontologo.getId() != null)
            response = ResponseEntity.ok(odontologoService.actualizar(odontologo));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id)  throws ResourceNotFoundException {
        odontologoService.eliminar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");

    }
    @GetMapping
    public ResponseEntity<List<Odontologo>> obtenerTodos(){
        return ResponseEntity.ok(odontologoService.obtenerTodos());
    }
}
