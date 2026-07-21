package uce.edu.ec.tg.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.tg.domain.model.RecetaMedica;
import uce.edu.ec.tg.infrastructure.repository.RecetaMedicaRepositoryImpl;

@ApplicationScoped
@Transactional
public class RecetaMedicaService {

    @Inject
    private RecetaMedicaRepositoryImpl recetaMedicaRepositoryImpl;

    public void crearReceta(RecetaMedica recetaMedica) {
        this.recetaMedicaRepositoryImpl.persist(recetaMedica);
    }

    public RecetaMedica obtenerRecetaPorId(Integer id) {
        return this.recetaMedicaRepositoryImpl.findById(id);
    }

    public void eliminarRecetaPorId(Integer id) {
        this.recetaMedicaRepositoryImpl.deleteById(id);
    }

    public void actualizarReceta(RecetaMedica recetaMedica, Integer id) {

        RecetaMedica recetaExistente = this.obtenerRecetaPorId(id);

        if (recetaExistente != null) {

            recetaExistente.setMedicamento(
                    recetaMedica.getMedicamento());

            recetaExistente.setDosis(
                    recetaMedica.getDosis());

            recetaExistente.setIndicaciones(
                    recetaMedica.getIndicaciones());

            recetaExistente.setPacienteId(
                    recetaMedica.getPacienteId());

            recetaExistente.setFechaReceta(
                    recetaMedica.getFechaReceta());
        }
    }
}