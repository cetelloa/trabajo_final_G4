package uce.edu.ec.tg.web.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import uce.edu.ec.tg.application.service.MedicoService;
import uce.edu.ec.tg.domain.model.Medico;

@Path("/medico")
public class MedicoResource {

    @Inject
    private MedicoService medicoService;

    @POST
    @Path("/crearMedico")
    // http://localhost:8080/medico/crearMedico
    public Medico guardarMedico(Medico medico) {
        return this.medicoService.crearMedico(medico);
    }

    @GET
    @Path("/obtenerMedicoPorId/{id}")
    // http://localhost:8080/medico/obtenerMedicoPorId/1
    public Medico obtenerMedicoPorId(@PathParam("id") Integer id) {
        return this.medicoService.obtenerMedicoPorId(id);
    }

    @GET
    @Path("/obtenerTodosLosMedicos")
    // http://localhost:8080/medico/obtenerTodosLosMedicos
    public List<Medico> obtenerTodosLosMedicos() {
        return this.medicoService.obtenerTodosLosMedicos();
    }

    @PUT
    @Path("/actualizarMedico/{id}")
    // http://localhost:8080/medico/actualizarMedico/1
    public Medico actualizarMedico(Medico medico, @PathParam("id") Integer id) {
        return this.medicoService.actualizarMedico(medico, id);
    }

    @DELETE
    @Path("/eliminarMedico/{id}")
    // http://localhost:8080/medico/eliminarMedico/1
    public Medico eliminarMedico(@PathParam("id") Integer id) {
        return this.medicoService.eliminarMedicoPorId(id);
    }

    // Especialidades

    @PUT
    @Path("/{medicoId}/especialidades/{especialidadId}")
    // http://localhost:8080/medico/1/especialidades/1
    public Medico agregarEspecialidad(@PathParam("medicoId") Integer medicoId,
            @PathParam("especialidadId") Integer especialidadId) {
        return this.medicoService.agregarEspecialidad(medicoId, especialidadId);
    }

    
}