package uce.edu.ec.tg.domain.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
    @Column(name = "cons_nombre_consultorio", unique = true)
    private String nombreConsultorio;

    // Relacion con Medico
    @ManyToMany
    @JoinTable(name = "medi_consultorio", joinColumns = @JoinColumn(name = "cons_id"), inverseJoinColumns = @JoinColumn(name = "medi_id"))
    @JsonIgnore
    private List<Medico> medicos;

}
