package uce.edu.ec.tg.web.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import uce.edu.ec.tg.application.service.EspecialidadService;
import uce.edu.ec.tg.domain.model.Especialidad;

@Path("/especialidad")
public class EspecialidadResource {

    @Inject
    private EspecialidadService especialidadService;

    @POST
    @Path("/crearEspecialidad")
    // http://localhost:8080/especialidad/crearEspecialidad
    // body: {"nombre": "Pediatría", "descripcion": "Atención médica especializada en niños"}
    public Especialidad crearEspecialidad(Especialidad especialidad) {
        return this.especialidadService.crearEspecialidad(especialidad);
    }

    @GET
    @Path("/obtenerEspecialidadPorId/{id}")
    // http://localhost:8080/especialidad/obtenerEspecialidadPorId/1
    public Especialidad obtenerEspecialidadPorId(@PathParam("id") Integer id) {
        return this.especialidadService.obtenerEspecialidadPorId(id);
    }

    @GET
    @Path("/obtenerTodasLasEspecialidades")
    // http://localhost:8080/especialidad/obtenerTodasLasEspecialidades
    public List<Especialidad> obtenerTodasLasEspecialidades() {
        return this.especialidadService.obtenerTodasLasEspecialidades();
    }

    @PUT
    @Path("/actualizarEspecialidad/{id}")
    // http://localhost:8080/especialidad/actualizarEspecialidad/1
    public Especialidad actualizarEspecialidad(Especialidad especialidad, @PathParam("id") Integer id) {
        return this.especialidadService.actualizarEspecialidad(especialidad, id);
    }

    @DELETE
    @Path("/eliminarEspecialidad/{id}")
    // http://localhost:8080/especialidad/eliminarEspecialidad/1
    public Especialidad eliminarEspecialidad(@PathParam("id") Integer id) {
        return this.especialidadService.eliminarEspecialidadPorId(id);
    }

}