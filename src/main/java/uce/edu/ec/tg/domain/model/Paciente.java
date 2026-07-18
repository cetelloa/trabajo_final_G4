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
@Table(name = "paciente")
@Getter
@Setter
public class Paciente extends PanacheEntityBase {

    @SequenceGenerator(name = "generator_paciente_seq", sequenceName = "paciente_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_paciente_seq")
    @Id
    @Column(name = "paci_id")
    private Integer id;
    @Column(name = "paci_nombre")
    private String nombre;
    @Column(name = "paci_apellido")
    private String apellido;
    @Column(name = "paci_cedula")
    private String cedula;

}
