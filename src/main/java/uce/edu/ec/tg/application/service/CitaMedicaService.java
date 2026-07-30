package uce.edu.ec.tg.application.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.tg.domain.model.CitaMedica;
import uce.edu.ec.tg.domain.model.Consultorio;
import uce.edu.ec.tg.domain.model.Medico;
import uce.edu.ec.tg.domain.model.Paciente;
import uce.edu.ec.tg.infrastructure.repository.CitaMedicaRepositoryImpl;
import uce.edu.ec.tg.infrastructure.repository.ConsultorioRepositoryImpl;
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

    @Inject
    private ConsultorioRepositoryImpl consultorioRepositoryImpl;

    // CRUD BASICO

    public CitaMedica crearCitaMedica(String cedulaPaciente, String cedulaMedico, String nombreConsultorio,
            String motivoConsulta, String observaciones, LocalDate fechaCita, LocalTime horaCita) {

        Paciente paciente = this.pacienteRepositoryImpl.buscarPorCedula(cedulaPaciente);
        Medico medico = this.medicoRepositoryImpl.buscarPorCedula(cedulaMedico);
        Consultorio consultorio = this.consultorioRepositoryImpl.buscarPorNombre(nombreConsultorio);

        if (paciente == null) {
            throw new RuntimeException("No existe paciente con cédula: " + cedulaPaciente);
        }
        if (medico == null) {
            throw new RuntimeException("No existe médico con cédula: " + cedulaMedico);
        }
        if (consultorio == null) {
            throw new RuntimeException("No existe consultorio con nombre: " + nombreConsultorio);
        }

        CitaMedica citaMedica = new CitaMedica();
        citaMedica.setPaciente(paciente);
        citaMedica.setMedico(medico);
        citaMedica.setConsultorio(consultorio);
        citaMedica.setFechaCita(fechaCita);
        citaMedica.setHoraCita(horaCita);
        citaMedica.setMotivoConsulta(motivoConsulta);
        citaMedica.setObservaciones(observaciones);
        this.citaMedicaRepositoryImpl.persist(citaMedica);
        return citaMedica;
    }

    public CitaMedica obtenerCitaMedicaPorId(Integer id) {
        return this.citaMedicaRepositoryImpl.findById(id);
    }

    public List<CitaMedica> obtenerTodasLasCitas() {
        return this.citaMedicaRepositoryImpl.listAll();
    }

    public CitaMedica eliminarCitaMedicaPorId(Integer id) {
        CitaMedica citaMedica = this.obtenerCitaMedicaPorId(id);
        if (citaMedica == null) {
            throw new RuntimeException("No existe cita con id: " + id);
        }
        this.citaMedicaRepositoryImpl.delete(citaMedica);
        return citaMedica;
    }

    public CitaMedica actualizarCitaMedica(String cedulaPaciente, String cedulaMedico, String nombreConsultorio,
            String motivoConsulta, String observaciones, LocalDate fechaCita, LocalTime horaCita, Integer id) {

        CitaMedica citaMedicaExistente = this.obtenerCitaMedicaPorId(id);

        if (citaMedicaExistente == null) {
            throw new RuntimeException("No existe cita con id: " + id);
        }

        if (fechaCita != null) {
            citaMedicaExistente.setFechaCita(fechaCita);
        }

        if (horaCita != null) {
            citaMedicaExistente.setHoraCita(horaCita);
        }

        if (cedulaPaciente != null) {
            Paciente paciente = this.pacienteRepositoryImpl.buscarPorCedula(cedulaPaciente);
            if (paciente == null)
                throw new RuntimeException("No existe paciente con cédula: " + cedulaPaciente);
            citaMedicaExistente.setPaciente(paciente);
        }

        if (cedulaMedico != null) {
            Medico medico = this.medicoRepositoryImpl.buscarPorCedula(cedulaMedico);
            if (medico == null)
                throw new RuntimeException("No existe médico con cédula: " + cedulaMedico);
            citaMedicaExistente.setMedico(medico);
        }

        if (nombreConsultorio != null) {
            Consultorio consultorio = this.consultorioRepositoryImpl.buscarPorNombre(nombreConsultorio);
            if (consultorio == null)
                throw new RuntimeException("No existe consultorio con nombre: " + nombreConsultorio);
            citaMedicaExistente.setConsultorio(consultorio);
        }

        if (motivoConsulta != null) {
            citaMedicaExistente.setMotivoConsulta(motivoConsulta);
        }
        if (observaciones != null) {
            citaMedicaExistente.setObservaciones(observaciones);
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

    public List<CitaMedica> buscarCitaPorFecha(LocalDate fechaCita) {
        return this.citaMedicaRepositoryImpl.buscarCitaPorFecha(fechaCita);
    }

}