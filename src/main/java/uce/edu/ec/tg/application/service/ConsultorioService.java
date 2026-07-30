package uce.edu.ec.tg.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;
import uce.edu.ec.tg.domain.model.Consultorio;
import uce.edu.ec.tg.infrastructure.repository.ConsultorioRepositoryImpl;

@ApplicationScoped
@Transactional
public class ConsultorioService {

    @Inject
    private ConsultorioRepositoryImpl consultorioRepositoryImpl;

    // CRUD Basico

    public Consultorio guardarConsultorio(Consultorio consultorio) {
        Consultorio existente = this.consultorioRepositoryImpl.buscarPorNombre(consultorio.getNombreConsultorio());
        if (existente != null) {
            throw new RuntimeException("Ya existe un consultorio con el nombre: " + consultorio.getNombreConsultorio());
        }
        this.consultorioRepositoryImpl.persist(consultorio);
        return consultorio;
    }

    public Consultorio buscarConsultorioPorId(Integer id) {
        return this.consultorioRepositoryImpl.findById(id);
    }

    public List<Consultorio> obtenerTodosLosConsultorios() {
        return this.consultorioRepositoryImpl.listAll();
    }

    public Consultorio actualizarConsultorio(Consultorio consultorio, Integer id) {
        Consultorio consultorioAntiguo = this.buscarConsultorioPorId(id);
        if (consultorioAntiguo == null) {
            throw new RuntimeException("No existe consultorio con id: " + id);
        }

        if (consultorio.getNombreConsultorio() != null) {
            consultorioAntiguo.setNombreConsultorio(consultorio.getNombreConsultorio());
        }
        if (consultorio.getDireccion() != null) {
            consultorioAntiguo.setDireccion(consultorio.getDireccion());
        }
        if (consultorio.getPiso() != null) {
            consultorioAntiguo.setPiso(consultorio.getPiso());
        }
        if (consultorio.getTelefono() != null) {
            consultorioAntiguo.setTelefono(consultorio.getTelefono());
        }
        return consultorioAntiguo;
    }

    public Consultorio eliminarConsultorio(Integer id) {
        Consultorio consultorio = this.buscarConsultorioPorId(id);
        if (consultorio == null) {
            throw new RuntimeException("No existe consultorio con id: " + id);
        }

        // Aqui SI validamos: no se puede borrar si tiene citas asociadas
        if (consultorio.getCitasMedicas() != null && !consultorio.getCitasMedicas().isEmpty()) {
            throw new RuntimeException("El consultorio tiene citas médicas asociadas, no se puede eliminar.");
        }

        this.consultorioRepositoryImpl.delete(consultorio);
        return consultorio;
    }


}