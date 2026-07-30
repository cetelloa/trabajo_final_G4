package uce.edu.ec.tg.application.service;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.tg.domain.model.Especialidad;
import uce.edu.ec.tg.domain.model.Medico;
import uce.edu.ec.tg.infrastructure.repository.EspecialidadRepositoryImpl;
import uce.edu.ec.tg.infrastructure.repository.MedicoRepositoryImpl;

@ApplicationScoped
@Transactional
public class MedicoService {

    @Inject
    private MedicoRepositoryImpl medicoRepositoryImpl;

    @Inject
    private EspecialidadRepositoryImpl especialidadRepositoryImpl;

    // CRUD BASICO

    public Medico crearMedico(Medico medico) {
        Medico existente = this.medicoRepositoryImpl.buscarPorCedula(medico.getCedula());
        if (existente != null) {
            throw new RuntimeException("Ya existe un médico registrado con la cédula: " + medico.getCedula());
        }
        this.medicoRepositoryImpl.persist(medico);
        return medico;
    }

    public Medico obtenerMedicoPorId(Integer id) {
        return this.medicoRepositoryImpl.findById(id);
    }

    public List<Medico> obtenerTodosLosMedicos() {
        return this.medicoRepositoryImpl.listAll();
    }

    public Medico eliminarMedicoPorId(Integer id) {
        Medico medico = this.obtenerMedicoPorId(id);
        if (medico == null) {
            throw new RuntimeException("No se encuentra registrado un medico con id: " + id);
        }
        if (medico.getCitasMedicas() != null && !medico.getCitasMedicas().isEmpty()) {
            throw new RuntimeException("El medico tiene citas médicas asociadas, no se puede eliminar.");
        }
        this.medicoRepositoryImpl.delete(medico);
        return medico;
    }

    public Medico actualizarMedico(Medico medico, Integer id) {
        Medico medicoExistente = this.obtenerMedicoPorId(id);
        if (medicoExistente == null) {
            throw new RuntimeException("No se encuentra registrado un medico con id: " + id);
        }
        if (medico.getNombre() != null)
            medicoExistente.setNombre(medico.getNombre());
        if (medico.getApellido() != null)
            medicoExistente.setApellido(medico.getApellido());
        return medicoExistente;
    }

    // Especialidades

    public Medico agregarEspecialidad(Integer medicoId, Integer especialidadId) {
        Medico medico = this.obtenerMedicoPorId(medicoId);
        if (medico == null) {
            throw new RuntimeException("No existe médico con id: " + medicoId);
        }
        Especialidad especialidad = this.especialidadRepositoryImpl.findById(especialidadId);
        if (especialidad == null) {
            throw new RuntimeException("No existe especialidad con id: " + especialidadId);
        }
        if (medico.getEspecialidades() == null) {
            medico.setEspecialidades(new ArrayList<>());
        }
        if (!medico.getEspecialidades().contains(especialidad)) {
            medico.getEspecialidades().add(especialidad);
        }
        return medico;
    }

}