package uce.edu.ec.tg.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.tg.domain.model.CitaMedica;
import uce.edu.ec.tg.infrastructure.repository.CitaMedicaRepositoryImpl;

@ApplicationScoped
@Transactional
public class CitaMedicaService {

    @Inject
    private CitaMedicaRepositoryImpl citaMedicaRepositoryImpl;

    //CRUD BASICO

    public void crearCitaMedica(CitaMedica citaMedica) {
        this.citaMedicaRepositoryImpl.persist(citaMedica);
    }

    public CitaMedica obtenerCitaMedicaPorId(Integer id) {
        return this.citaMedicaRepositoryImpl.findById(id);
    }

    public void eliminarCitaMedicaPorId(Integer id) {
        this.citaMedicaRepositoryImpl.deleteById(id);
    }

    public void actualizarCitaMedica(CitaMedica citaMedica, Integer id) {
        CitaMedica citaMedicaExistente = this.obtenerCitaMedicaPorId(id);
        if (citaMedicaExistente != null) {
            citaMedicaExistente.setCedulaPaciente(citaMedica.getCedulaPaciente());
            citaMedicaExistente.setCedulaDoctor(citaMedica.getCedulaDoctor());
            citaMedicaExistente.setFechaCita(citaMedica.getFechaCita());
        }
    }

}
