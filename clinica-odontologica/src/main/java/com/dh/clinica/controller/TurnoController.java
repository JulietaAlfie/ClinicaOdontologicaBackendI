package com.dh.clinica.controller;

import com.dh.clinica.exceptions.BadRequestException;
import com.dh.clinica.exceptions.ResourceNotFoundException;
import com.dh.clinica.model.Turno;
import com.dh.clinica.model.TurnoDTO;
import com.dh.clinica.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RelationServiceNotRegisteredException;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/turnos")
@CrossOrigin("*")
public class TurnoController {

    private final TurnoService turnoService;
    private final PacienteService pacienteService;
    private final OdontologoService odontologoService;


    @Autowired
    public TurnoController(TurnoService turnoService,PacienteService pacienteService, OdontologoService odontologoService) {
        this.turnoService = turnoService;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> registrarTurno(@RequestBody TurnoDTO turnoDTO) throws BadRequestException{
        turnoService.guardar(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<Collection<TurnoDTO>> listar() {
        return ResponseEntity.ok(turnoService.obtenerTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) throws ResourceNotFoundException {
            turnoService.eliminar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
    }

    @PutMapping
    public ResponseEntity<HttpStatus> actualizarTurno(@RequestBody TurnoDTO turnoDTO) {
        turnoService.actualizar(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> procesarErrorBadRequest(BadRequestException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}
