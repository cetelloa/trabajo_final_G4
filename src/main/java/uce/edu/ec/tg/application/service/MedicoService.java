package uce.edu.ec.tg.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;
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
        this.medicoRepositoryImpl.delete(medico);
        return medico;
    }

    public Medico actualizarMedico(Medico medico, Integer id) {
        Medico medicoExistente = this.obtenerMedicoPorId(id);
        if (medicoExistente != null) {
            if (medico.getNombre() != null)
                medicoExistente.setNombre(medico.getNombre());
            if (medico.getApellido() != null)
                medicoExistente.setApellido(medico.getApellido());
            if (medico.getCedula() != null)
                medicoExistente.setCedula(medico.getCedula());
        }
        return medicoExistente;
    }

    // Agregar especialidad

    public Medico agregarEspecialidad(Integer medicoId, Integer especialidadId) {
        Medico medico = this.obtenerMedicoPorId(medicoId);
        Especialidad especialidad = this.especialidadRepositoryImpl.findById(especialidadId);
        medico.getEspecialidades().add(especialidad);
        return medico;
    }

}
