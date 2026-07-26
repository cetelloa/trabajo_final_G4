package uce.edu.ec.tg.domain.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "consultorio")
public class Consultorio extends PanacheEntityBase {

    @SequenceGenerator(name = "generator_consultorio_seq", sequenceName = "consultorio_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_consultorio_seq")
    @Id
    @Column(name = "cons_id")
    private Integer id;
    @Column(name = "cons_nombre_consultorio")
    private String nombre_consultorio;

    // Relacion con Medico
    @OneToOne
    @JoinColumn(name = "cons_medico_id", referencedColumnName = "medi_id")
    private Medico medico;

}
