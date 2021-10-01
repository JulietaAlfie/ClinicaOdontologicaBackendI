package com.dh.clinica.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private String dni;
    private String domicilio;
}
