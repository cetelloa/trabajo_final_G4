package uce.edu.ec.tg.domain.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "especialidad")
@Getter
@Setter
public class Especialidad extends PanacheEntityBase {

    @SequenceGenerator(name = "generator_especialidad_seq", sequenceName = "especialidad_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_especialidad_seq")
    @Id
    @Column(name = "espe_id")
    private Integer id;
    @Column(name = "espe_nombre")
    private String nombre;

    // Relacion con medico
    @ManyToMany(mappedBy = "especialidades")
    @JsonIgnore
    private List<Medico> medicos;

     // Relacion con CitaMedica
    @OneToMany(mappedBy = "especialidad")
    @JsonIgnore
    private List<CitaMedica> citasMedicas;
}
