package uce.edu.ec.tg.web.resource;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearCitaRequest {
    private String cedulaPaciente;
    private String cedulaMedico;
    private LocalDate fechaCita;
}
