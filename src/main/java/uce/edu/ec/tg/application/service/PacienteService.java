package uce.edu.ec.tg.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.tg.domain.model.Paciente;
import uce.edu.ec.tg.infrastructure.repository.PacienteRepositoryImpl;

@ApplicationScoped
@Transactional
public class PacienteService {

    @Inject
    private PacienteRepositoryImpl pacienteRepositoryImpl;

    // CRUD BASICO

    public Paciente crearPaciente(Paciente paciente) {
        this.pacienteRepositoryImpl.persist(paciente);
        return paciente;
    }

    public Paciente obtenerPacientePorId(Integer id) {
        return this.pacienteRepositoryImpl.findById(id);
    }

    public Paciente eliminarPacientePorId(Integer id) {
        Paciente paciente = this.obtenerPacientePorId(id);
        this.pacienteRepositoryImpl.delete(paciente);
        return paciente;
    }

    public Paciente actualizarPaciente(Paciente paciente, Integer id) {
        Paciente pacienteExistente = this.obtenerPacientePorId(id);
        if (pacienteExistente != null) {
            if (paciente.getNombre() != null)
                pacienteExistente.setNombre(paciente.getNombre());
            if (paciente.getApellido() != null)
                pacienteExistente.setApellido(paciente.getApellido());
            if (paciente.getCedula() != null)
                pacienteExistente.setCedula(paciente.getCedula());
        }
        return pacienteExistente;
    }

}
