package uce.edu.ec.tg.domain.model;

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
@Table(name = "medico")
@Getter
@Setter
public class Medico extends PanacheEntityBase {

    @SequenceGenerator(name = "generator_medico_seq", sequenceName = "medico_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_medico_seq")
    @Id
    @Column(name = "medi_id")
    private Integer id;
    @Column(name = "medi_nombre")
    private String nombre;
    @Column(name = "medi_apellido")
    private String apellido;
    @Column(name = "medi_especialidad")
    private String especialidad;
    @Column(name = "medi_cedula")
    private String cedula;

}
