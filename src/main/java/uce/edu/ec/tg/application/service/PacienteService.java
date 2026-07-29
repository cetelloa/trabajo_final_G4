package uce.edu.ec.tg.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.tg.domain.model.Paciente;
import java.util.List;
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

    public List<Paciente> obtenerTodosLosPacientes() {
        return this.pacienteRepositoryImpl.listAll();
    }

    public Paciente eliminarPacientePorId(Integer id) {
        Paciente paciente = this.obtenerPacientePorId(id);

        if (paciente == null) {
            throw new RuntimeException("No se encuentra registrado un paciente con id: " + id);
        }
        if (!paciente.getCitasMedicas().isEmpty()) {
            throw new RuntimeException("El paciente tiene citas médicas pendientes, no se puede eliminar.");
        }

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
        }
        return pacienteExistente;
    }

}
