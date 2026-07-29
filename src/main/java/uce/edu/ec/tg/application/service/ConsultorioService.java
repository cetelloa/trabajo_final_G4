package uce.edu.ec.tg.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;
import uce.edu.ec.tg.domain.model.Consultorio;
import uce.edu.ec.tg.domain.model.Medico;
import uce.edu.ec.tg.infrastructure.repository.ConsultorioRepositoryImpl;

@ApplicationScoped
@Transactional
public class ConsultorioService {

    @Inject
    private ConsultorioRepositoryImpl consultorioRepositoryImpl;

    @Inject
    private MedicoService medicoService;

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
        if (consultorioAntiguo == null) {
            throw new RuntimeException("No existe consultorio con id: " + id);
        }
        if (consultorio.getNombreConsultorio() != null) {
            consultorioAntiguo.setNombreConsultorio(consultorio.getNombreConsultorio());
        }
        return consultorioAntiguo;
    }

    public Consultorio eliminarConsultorio(Integer id) {
        Consultorio consultorio = this.buscarConsultorioPorId(id);
        if (consultorio == null) {
            throw new RuntimeException("No existe consultorio con id: " + id);
        }
        this.consultorioRepositoryImpl.delete(consultorio);
        return consultorio;
    }

    public List<Consultorio> obtenerTodosLosConsultorios() {
        return this.consultorioRepositoryImpl.listAll();
    }

    // Agregar medico al consultorio

    public Consultorio agregarMedico(Integer consultorioId, Integer medicoId) {
        Consultorio consultorio = this.buscarConsultorioPorId(consultorioId);
        if (consultorio == null) {
            throw new RuntimeException("No existe consultorio con id: " + consultorioId);
        }
        Medico medico = this.medicoService.obtenerMedicoPorId(medicoId);
        if (medico == null) {
            throw new RuntimeException("No existe médico con id: " + medicoId);
        }
        if (!consultorio.getMedicos().contains(medico)) {
            consultorio.getMedicos().add(medico);
        }
        return consultorio;
    }

}
