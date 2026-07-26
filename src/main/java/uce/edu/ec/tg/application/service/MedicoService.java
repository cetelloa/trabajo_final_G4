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

    public Medico crearMedico(Medico medico) {
        this.medicoRepositoryImpl.persist(medico);
        return medico;
    }

    public Medico obtenerMedicoPorId(Integer id) {
        return this.medicoRepositoryImpl.findById(id);
    }

    public Medico eliminarMedicoPorId(Integer id) {
        Medico medico = this.obtenerMedicoPorId(id);
        this.medicoRepositoryImpl.delete(medico);
        return medico;
    }

    public Medico actualizarMedico(Medico medico, Integer id) {
        Medico medicoExistente = this.obtenerMedicoPorId(id);
        if (medicoExistente != null) {
            medicoExistente.setNombre(medico.getNombre());
            medicoExistente.setApellido(medico.getApellido());
            medicoExistente.setCedula(medico.getCedula());
        }
        return medicoExistente;
    }

}
