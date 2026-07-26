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

    // CRUD Basico

    public Consultorio guardarConsultorio(Consultorio consultorio) {
        this.consultorioRepositoryImpl.persist(consultorio);
        return consultorio;
    }

    public Consultorio buscarConsultorioPorId(Integer id) {
        return this.consultorioRepositoryImpl.findById(id);
    }

    public Consultorio actualizarConsultorio(Consultorio consultorio, Integer id) {
        Consultorio consultorioAntiguo = this.buscarConsultorioPorId(id);
        consultorioAntiguo.setNombre_consultorio(consultorio.getNombre_consultorio());
        consultorioAntiguo.setMedicos(consultorio.getMedicos());
        return consultorioAntiguo;
    }

    public Consultorio eliminarConsultorio(Integer id) {
        Consultorio consultorio = this.buscarConsultorioPorId(id);
        this.consultorioRepositoryImpl.delete(consultorio);
        return consultorio;
    }

}
