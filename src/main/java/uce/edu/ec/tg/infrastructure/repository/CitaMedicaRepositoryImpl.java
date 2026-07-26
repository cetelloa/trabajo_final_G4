package uce.edu.ec.tg.infrastructure.repository;

import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import uce.edu.ec.tg.domain.model.CitaMedica;

@ApplicationScoped
@Transactional
public class CitaMedicaRepositoryImpl implements PanacheRepositoryBase<CitaMedica, Integer> {

    public CitaMedica buscarCitaPorCedulaPaciente(String cedulaPaciente) {
        return find("paciente.cedula", cedulaPaciente).firstResult();
    }

    public CitaMedica buscarCitaPorCedulaMedico(String cedulaMedico) {
        return find("medico.cedula", cedulaMedico).firstResult();
    }

    public CitaMedica buscarCitaPorFecha(LocalDate fechaCita) {
        return find("fechaCita", fechaCita).firstResult();
    }

}
