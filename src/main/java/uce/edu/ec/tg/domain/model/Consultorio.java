package uce.edu.ec.tg.domain.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

    @Column(name = "cons_direccion")
    private String direccion;

    @Column(name = "cons_piso")
    private String piso;

    @Column(name = "cons_telefono")
    private String telefono;

    // Relacion con CitaMedica
    @OneToMany(mappedBy = "consultorio")
    @JsonIgnore
    private List<CitaMedica> citasMedicas;

}
