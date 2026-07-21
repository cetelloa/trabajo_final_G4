package uce.edu.ec.tg.domain.model;

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
@Table(name = "consultorio")
@Getter
@Setter
public class Consultorio extends PanacheEntityBase {

    @SequenceGenerator(name = "generator_consultorio_seq", sequenceName = "consultorio_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_consultorio_seq")
    @Id
    @Column(name = "consultorio_id")
    private Integer id;

    @Column(name = "consultorio_numero")
    private Integer numeroConsultorio;

    @Column(name = "consultorio_area")
    private String area;

    @Column(name = "consultorio_medico")
    private Integer medicoId;

    @ManyToOne
    @JoinColumn(name = "consultorio_medico", insertable = false, updatable = false)
    private Medico medico;

}
