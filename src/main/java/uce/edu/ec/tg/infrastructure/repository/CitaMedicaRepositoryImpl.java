package uce.edu.ec.tg.infrastructure.repository;

import java.time.LocalDate;
import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import uce.edu.ec.tg.domain.model.CitaMedica;

@ApplicationScoped
@Transactional
public class CitaMedicaRepositoryImpl implements PanacheRepositoryBase<CitaMedica, Integer> {

    public List<CitaMedica> buscarCitasPorCedulaPaciente(String cedulaPaciente) {
        return find("paciente.cedula", cedulaPaciente).list();
    }

    public List<CitaMedica> buscarCitaPorCedulaMedico(String cedulaMedico) {
        return find("medico.cedula", cedulaMedico).list();
    }

    public List<CitaMedica> buscarCitaPorFecha(LocalDate fechaCita) {
        return find("fechaCita", fechaCita).list();
    }

}
