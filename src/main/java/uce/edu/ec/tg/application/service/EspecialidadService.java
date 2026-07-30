package uce.edu.ec.tg.application.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.tg.domain.model.Especialidad;
import uce.edu.ec.tg.infrastructure.repository.EspecialidadRepositoryImpl;

@ApplicationScoped
@Transactional
public class EspecialidadService {

    @Inject
    private EspecialidadRepositoryImpl especialidadRepositoryImpl;

    // CRUD BASICO

    public Especialidad crearEspecialidad(Especialidad especialidad) {
        Especialidad existente = this.especialidadRepositoryImpl.buscarPorNombre(especialidad.getNombre());
        if (existente != null) {
            throw new RuntimeException("Ya existe una especialidad con el nombre: " + especialidad.getNombre());
        }
        this.especialidadRepositoryImpl.persist(especialidad);
        return especialidad;
    }

    public Especialidad obtenerEspecialidadPorId(Integer id) {
        return this.especialidadRepositoryImpl.findById(id);
    }

    public List<Especialidad> obtenerTodasLasEspecialidades() {
        return this.especialidadRepositoryImpl.listAll();
    }

    public Especialidad actualizarEspecialidad(Especialidad especialidad, Integer id) {
        Especialidad especialidadExistente = this.obtenerEspecialidadPorId(id);
        if (especialidadExistente == null) {
            throw new RuntimeException("No existe especialidad con id: " + id);
        }
        if (especialidad.getNombre() != null) {
            especialidadExistente.setNombre(especialidad.getNombre());
        }
        if (especialidad.getDescripcion() != null) {
            especialidadExistente.setDescripcion(especialidad.getDescripcion());
        }
        return especialidadExistente;
    }

    public Especialidad eliminarEspecialidadPorId(Integer id) {
        Especialidad especialidad = this.obtenerEspecialidadPorId(id);
        if (especialidad == null) {
            throw new RuntimeException("No existe especialidad con id: " + id);
        }
        if (especialidad.getMedicos() != null && !especialidad.getMedicos().isEmpty()) {
            throw new RuntimeException("La especialidad tiene médicos asignados, no se puede eliminar.");
        }
        this.especialidadRepositoryImpl.delete(especialidad);
        return especialidad;
    }

}