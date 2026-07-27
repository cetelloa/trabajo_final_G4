package uce.edu.ec.tg.web.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
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
    // http://localhost:8080/especialidades/crear
    public Especialidad crearEspecialidad(Especialidad especialidad) {
        return this.especialidadService.guardarEspecialidad(especialidad);
    }

    @GET
    @Path("/buscarEspecialidadPorId/{id}")
    // http://localhost:8080/especialidades/buscarEspecialidadPorId/1
    public Especialidad buscarEspecialidadPorId(@PathParam("id") Integer id) {
        return this.especialidadService.buscarEspecialidadPorId(id);
    }

    @PUT
    @Path("/actualizarEspecialidad/{id}")
    // http://localhost:8080/especialidades/actualizarEspecialidad/1
    public Especialidad actualizarEspecialidad(Especialidad especialidad, @PathParam("id") Integer id) {
        return this.especialidadService.actualizarEspecialidad(especialidad, id);
    }

    @DELETE
    @Path("/eliminarEspecialidad/{id}")
    // http://localhost:8080/especialidades/eliminarEspecialidad/1
    public Especialidad eliminarEspecialidad(@PathParam("id") Integer id) {
        return this.especialidadService.eliminarEspecialidad(id);
    }

}
