package uce.edu.ec.tg.domain.model;

import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cita_medica")
@Getter
@Setter
public class CitaMedica extends PanacheEntityBase {

    @SequenceGenerator(name = "generator_cita_medica_seq", sequenceName = "cita_medica_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_cita_medica_seq")
    @Id
    @Column(name = "cita_id")
    private Integer id;
    @Column(name = "cita_cedula_paciente")
    private String cedulaPaciente;
    @Column(name = "cita_cedula_doctor")
    private String cedulaDoctor;
    @Column(name = "cita_fecha_cita")
    private LocalDate fechaCita;

}
