package uce.edu.ec.tg.web.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import uce.edu.ec.tg.application.service.EspecialidadService;
import uce.edu.ec.tg.domain.model.Especialidad;

@Path("/especialidades")
public class EspecialidadResource {

    @Inject
    private EspecialidadService especialidadService;

    @POST
    @Path("/crear")
    public Especialidad crearEspecialidad(Especialidad especialidad) {
        return this.especialidadService.guardarEspecialidad(especialidad);
    }

    @PUT
    @Path("/{especialidadId}/medicos/{medicoId}")
    public Especialidad agregarMedico(
            @PathParam("especialidadId") Integer especialidadId,
            @PathParam("medicoId") Integer medicoId) {
        return this.especialidadService.agregarMedico(especialidadId, medicoId);
    }

}
