package uce.edu.ec.tg.application.service;

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

    public Especialidad guardarEspecialidad(Especialidad especialidad) {
        this.especialidadRepositoryImpl.persist(especialidad);
        return especialidad;
    }

    public Especialidad buscarEspecialidadPorId(Integer id) {
        return this.especialidadRepositoryImpl.findById(id);
    }

    public Especialidad actualizarEspecialidad(Especialidad especialidad, Integer id) {
        Especialidad especialidadAntigua = this.buscarEspecialidadPorId(id);
        if (especialidad.getNombre() != null)
            especialidadAntigua.setNombre(especialidad.getNombre());
        return especialidadAntigua;
    }

    public Especialidad eliminarEspecialidad(Integer id) {
        Especialidad especialidad = this.buscarEspecialidadPorId(id);
        this.especialidadRepositoryImpl.delete(especialidad);
        return especialidad;
    }

}
