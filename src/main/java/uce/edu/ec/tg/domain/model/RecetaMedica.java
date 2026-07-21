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
@Table(name = "receta_medica")
@Getter
@Setter
public class RecetaMedica extends PanacheEntityBase {


    @SequenceGenerator(name = "generator_receta_medica_seq", sequenceName = "receta_medica_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_receta_medica_seq")
    @Id
    @Column(name = "receta_id")
    private Integer id;

    @Column(name = "receta_medicamento")
    private String medicamento;

    @Column(name = "receta_dosis")
    private String dosis;

    @Column(name = "receta_indicaciones")
    private String indicaciones;

    @Column(name = "receta_paciente_id")
    private Integer pacienteId;

    @Column(name = "receta_fecha_receta")
    private LocalDate fechaReceta;

    @ManyToOne
    @JoinColumn(name = "receta_paciente_id", insertable = false, updatable = false)
    private Paciente paciente;

}
