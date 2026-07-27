package uce.edu.ec.tg.application.service;

import java.time.LocalDate;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.tg.domain.model.CitaMedica;
import uce.edu.ec.tg.domain.model.Medico;
import uce.edu.ec.tg.domain.model.Paciente;
import uce.edu.ec.tg.infrastructure.repository.CitaMedicaRepositoryImpl;
import uce.edu.ec.tg.infrastructure.repository.MedicoRepositoryImpl;
import uce.edu.ec.tg.infrastructure.repository.PacienteRepositoryImpl;

@ApplicationScoped
@Transactional
public class CitaMedicaService {

    @Inject
    private CitaMedicaRepositoryImpl citaMedicaRepositoryImpl;

    @Inject
    private PacienteRepositoryImpl pacienteRepositoryImpl;

    @Inject
    private MedicoRepositoryImpl medicoRepositoryImpl;

    // CRUD BASICO

    public CitaMedica crearCitaMedica(String cedulaPaciente, String cedulaMedico, LocalDate fechaCita) {
        Paciente paciente = this.pacienteRepositoryImpl.buscarPorCedula(cedulaPaciente);
        Medico medico = this.medicoRepositoryImpl.buscarPorCedula(cedulaMedico);
        CitaMedica citaMedica = new CitaMedica();
        citaMedica.setFechaCita(fechaCita);
        citaMedica.setPaciente(paciente);
        citaMedica.setMedico(medico);
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

    public CitaMedica actualizarCitaMedica(String cedulaPaciente, String cedulaMedico, LocalDate fechaCita, Integer id) {
        CitaMedica citaMedicaExistente = this.obtenerCitaMedicaPorId(id);
        if (citaMedicaExistente != null) {
            if (fechaCita != null)
                citaMedicaExistente.setFechaCita(fechaCita);
            if (cedulaPaciente != null) {
                Paciente paciente = this.pacienteRepositoryImpl.buscarPorCedula(cedulaPaciente);
                citaMedicaExistente.setPaciente(paciente);
            }
            if (cedulaMedico != null) {
                Medico medico = this.medicoRepositoryImpl.buscarPorCedula(cedulaMedico);
                citaMedicaExistente.setMedico(medico);
            }
        }
        return citaMedicaExistente;
    }

    // Metodos solicitados

    public List<CitaMedica> buscarCitaPorCedulaPaciente(String cedulaPaciente) {
        return this.citaMedicaRepositoryImpl.buscarCitasPorCedulaPaciente(cedulaPaciente);
    }

    public List<CitaMedica> buscarCitaPorCedulaMedico(String cedulaMedico) {
        return this.citaMedicaRepositoryImpl.buscarCitaPorCedulaMedico(cedulaMedico);
    }

    public CitaMedica buscarCitaPorFecha(LocalDate fechaCita) {
        return this.citaMedicaRepositoryImpl.buscarCitaPorFecha(fechaCita);
    }

}
