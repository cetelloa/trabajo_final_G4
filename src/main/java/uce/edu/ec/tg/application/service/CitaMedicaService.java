package uce.edu.ec.tg.application.service;

import java.time.LocalDate;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.tg.domain.model.CitaMedica;
import uce.edu.ec.tg.infrastructure.repository.CitaMedicaRepositoryImpl;

@ApplicationScoped
@Transactional
public class CitaMedicaService {

    @Inject
    private CitaMedicaRepositoryImpl citaMedicaRepositoryImpl;

    // CRUD BASICO

    public CitaMedica crearCitaMedica(CitaMedica citaMedica) {
        this.citaMedicaRepositoryImpl.persist(citaMedica);
        return citaMedica;
    }

    public CitaMedica obtenerCitaMedicaPorId(Integer id) {
        return this.citaMedicaRepositoryImpl.findById(id);
    }

    public CitaMedica eliminarCitaMedicaPorId(Integer id) {
        CitaMedica citaMedica = this.obtenerCitaMedicaPorId(id);
        this.citaMedicaRepositoryImpl.delete(citaMedica);
        return citaMedica;
    }

    public CitaMedica actualizarCitaMedica(CitaMedica citaMedica, Integer id) {
        CitaMedica citaMedicaExistente = this.obtenerCitaMedicaPorId(id);
        if (citaMedicaExistente != null) {
            citaMedicaExistente.setFechaCita(citaMedica.getFechaCita());
            citaMedicaExistente.setMedico(citaMedica.getMedico());
            citaMedicaExistente.setPaciente(citaMedica.getPaciente());
        }
        return citaMedicaExistente;
    }

    // Metodos solicitados

    public CitaMedica buscarCitaPorCedulaPaciente(String cedulaPaciente) {
        return this.citaMedicaRepositoryImpl.buscarCitaPorCedulaPaciente(cedulaPaciente);
    }

    public CitaMedica buscarCitaPorCedulaMedico(String cedulaMedico) {
        return this.citaMedicaRepositoryImpl.buscarCitaPorCedulaMedico(cedulaMedico);
    }

    public CitaMedica buscarCitaPorFecha(LocalDate fechaCita) {
        return this.citaMedicaRepositoryImpl.buscarCitaPorFecha(fechaCita);
    }

}
