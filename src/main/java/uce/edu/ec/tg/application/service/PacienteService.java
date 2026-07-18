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

    public void crearPaciente(Paciente paciente) {
        this.pacienteRepositoryImpl.persist(paciente);
    }

    public Paciente obtenerPacientePorId(Integer id) {
        return this.pacienteRepositoryImpl.findById(id);
    }

    public void eliminarPacientePorId(Integer id) {
        this.pacienteRepositoryImpl.deleteById(id);
    }

    public void actualizarPaciente(Paciente paciente, Integer id) {
        Paciente pacienteExistente = this.obtenerPacientePorId(id);
        if (pacienteExistente != null) {
            pacienteExistente.setNombre(paciente.getNombre());
            pacienteExistente.setApellido(paciente.getApellido());
            pacienteExistente.setCedula(paciente.getCedula());
        }
    }

}
