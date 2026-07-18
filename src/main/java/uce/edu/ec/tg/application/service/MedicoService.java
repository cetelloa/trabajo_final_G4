package uce.edu.ec.tg.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.tg.domain.model.Medico;
import uce.edu.ec.tg.infrastructure.repository.MedicoRepositoryImpl;

@ApplicationScoped
@Transactional
public class MedicoService {

    @Inject
    private MedicoRepositoryImpl medicoRepositoryImpl;

    // CRUD BASICO

    public void crearMedico(Medico medico) {
        this.medicoRepositoryImpl.persist(medico);
    }

    public Medico obtenerMedicoPorId(Integer id) {
        return this.medicoRepositoryImpl.findById(id);
    }

    public void eliminarMedicoPorId(Integer id) {
        this.medicoRepositoryImpl.deleteById(id);
    }

    public void actualizarMedico(Medico medico, Integer id) {
        Medico medicoExistente = this.obtenerMedicoPorId(id);
        if (medicoExistente != null) {
            medicoExistente.setNombre(medico.getNombre());
            medicoExistente.setApellido(medico.getApellido());
            medicoExistente.setEspecialidad(medico.getEspecialidad());
            medicoExistente.setCedula(medico.getCedula());
        }
    }

}
