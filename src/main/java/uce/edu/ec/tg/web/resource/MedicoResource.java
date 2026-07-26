package uce.edu.ec.tg.web.resource;

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
    public Medico guardarMedico(Medico medico) {
        return this.medicoService.crearMedico(medico);
    }

    @GET
    @Path("/obtenerMedicoPorId/{id}")
    public Medico obtenerMedicoPorId(@PathParam("id") Integer id) {
        return this.medicoService.obtenerMedicoPorId(id);
    }

    @PUT
    @Path("/actualizarMedico/{id}")
    public void actualizarMedico(Medico medico, @PathParam("id") Integer id) {
        this.medicoService.actualizarMedico(medico, id);
    }

    @DELETE
    @Path("/eliminarMedico/{id}")
    public void eliminarMedico(@PathParam("id") Integer id) {
        this.medicoService.eliminarMedicoPorId(id);
    }

    // Agregar especialidad

    @PUT
    @Path("/{medicoId}/especialidades/{especialidadId}")
    public Medico agregarEspecialidad(@PathParam("medicoId") Integer medicoId,
            @PathParam("especialidadId") Integer especialidadId) {
        return this.medicoService.agregarEspecialidad(medicoId, especialidadId);
    }

}
