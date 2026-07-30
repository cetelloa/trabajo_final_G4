package uce.edu.ec.tg.application.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearCitaRequest {
    private String cedulaPaciente;
    private String cedulaMedico;
    private String nombreConsultorio;
    private String motivoConsulta;
    private String observaciones;
    private LocalDate fechaCita;
    private LocalTime horaCita;
}