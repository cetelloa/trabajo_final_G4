package uce.edu.ec.tg.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.tg.domain.model.Consultorio;
import uce.edu.ec.tg.infrastructure.repository.ConsultorioRepositoryImpl;

@ApplicationScoped
@Transactional
public class ConsultorioService {

    @Inject
    private ConsultorioRepositoryImpl consultorioRepositoryImpl;

    public void crearConsultorio(Consultorio consultorio) {
        this.consultorioRepositoryImpl.persist(consultorio);
    }

    public Consultorio obtenerConsultorioPorId(Integer id) {
        return this.consultorioRepositoryImpl.findById(id);
    }

    public void eliminarConsultorioPorId(Integer id) {
        this.consultorioRepositoryImpl.deleteById(id);
    }

    public void actualizarConsultorio(Consultorio consultorio, Integer id) {
        Consultorio consultorioExistente = this.obtenerConsultorioPorId(id);

        if (consultorioExistente != null) {
            consultorioExistente.setNumeroConsultorio(consultorio.getNumeroConsultorio());
            consultorioExistente.setArea(consultorio.getArea());
            consultorioExistente.setMedicoId(consultorio.getMedicoId());
        }
    }
}
