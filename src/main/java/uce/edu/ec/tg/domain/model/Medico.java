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
import jakarta.persistence.OneToMany;
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
    @Column(name = "medi_cedula", unique = true)
    private String cedula;

    // Relacion con especialidad
    @ManyToMany
    @JoinTable(name = "medico_especialidad", joinColumns = @JoinColumn(name = "medi_id"), inverseJoinColumns = @JoinColumn(name = "espe_id"))
    @JsonIgnore
    private List<Especialidad> especialidades;

    // Relacion con CitaMedica
    @OneToMany(mappedBy = "medico")
    @JsonIgnore
    private List<CitaMedica> citasMedicas;

    // Relacion con Consultorio
    @ManyToMany(mappedBy = "medicos")
    @JsonIgnore
    private List<Consultorio> consultorios;

}
