package com.dh.clinica.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class TurnoDTO {
    private Integer id;
    private Date date;
    private Integer pacienteId;
    private Integer odontologoId;

}