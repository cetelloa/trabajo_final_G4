package uce.edu.ec.tg.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;
import uce.edu.ec.tg.domain.model.Especialidad;
import uce.edu.ec.tg.infrastructure.repository.EspecialidadRepositoryImpl;

@ApplicationScoped
@Transactional
public class EspecialidadService {

    @Inject
    private EspecialidadRepositoryImpl especialidadRepositoryImpl;

    // CRUD BASICO

    public Especialidad guardarEspecialidad(Especialidad especialidad) {
        Especialidad existente = this.especialidadRepositoryImpl.buscarPorNombre(especialidad.getNombre());
        if (existente != null) {
            throw new RuntimeException("Ya existe una especialidad con el nombre: " + especialidad.getNombre());
        }
        this.especialidadRepositoryImpl.persist(especialidad);
        return especialidad;
    }

    public Especialidad buscarEspecialidadPorId(Integer id) {
        return this.especialidadRepositoryImpl.findById(id);
    }

    public List<Especialidad> obtenerTodasLasEspecialidades() {
        return this.especialidadRepositoryImpl.listAll();
    }

    public Especialidad actualizarEspecialidad(Especialidad especialidad, Integer id) {
        Especialidad especialidadAntigua = this.buscarEspecialidadPorId(id);
        if (especialidadAntigua == null) {
            throw new RuntimeException("No existe especialidad con id: " + id);
        }
        if (especialidad.getNombre() != null) {
            especialidadAntigua.setNombre(especialidad.getNombre());
        }
        return especialidadAntigua;
    }

    public Especialidad eliminarEspecialidad(Integer id) {
        Especialidad especialidad = this.buscarEspecialidadPorId(id);
        if (especialidad == null) {
            throw new RuntimeException("No existe especialidad con id: " + id);
        }
        if (!especialidad.getMedicos().isEmpty()) {
            throw new RuntimeException("La especialidad tiene médicos asociados, no se puede eliminar.");
        }
        this.especialidadRepositoryImpl.delete(especialidad);
        return especialidad;
    }

}
