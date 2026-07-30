package uce.edu.ec.tg.domain.model;

import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @Column(name = "cita_fecha_cita")
    private LocalDate fechaCita;

    // Relacion con Paciente
    @ManyToOne
    @JoinColumn(name = "cita_cedula_paciente", referencedColumnName = "paci_cedula")
    private Paciente paciente;

    // Relacion con Medico
    @ManyToOne
    @JoinColumn(name = "cita_cedula_doctor", referencedColumnName = "medi_cedula")
    private Medico medico;

    // Relacion con Especialidad
    @ManyToOne
    @JoinColumn(name = "cita_especialidad_id", referencedColumnName = "espe_id")
    private Especialidad especialidad;

}
