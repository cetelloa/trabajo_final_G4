package uce.edu.ec.tg.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.tg.domain.model.Especialidad;
import uce.edu.ec.tg.domain.model.Medico;
import uce.edu.ec.tg.infrastructure.repository.EspecialidadRepositoryImpl;

@ApplicationScoped
@Transactional
public class EspecialidadService {

    @Inject
    private EspecialidadRepositoryImpl especialidadRepositoryImpl;

    @Inject
    private MedicoService medicoService;

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
        especialidadAntigua.setNombre(especialidad.getNombre());
        especialidadAntigua.setMedicos(especialidad.getMedicos());
        return especialidadAntigua;
    }

    public Especialidad eliminarEspecialidad(Integer id) {
        Especialidad especialidad = this.buscarEspecialidadPorId(id);
        this.especialidadRepositoryImpl.delete(especialidad);
        return especialidad;
    }

    // Agregar especialidad a Medico

    public Especialidad agregarMedico(Integer especialidadId, Integer medicoId) {
        Especialidad especialidad = this.buscarEspecialidadPorId(especialidadId);
        Medico medico = this.medicoService.obtenerMedicoPorId(medicoId);
        especialidad.getMedicos().add(medico);
        return especialidad;
    }

}
