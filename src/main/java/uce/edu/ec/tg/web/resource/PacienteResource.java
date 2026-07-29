package uce.edu.ec.tg.web.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import uce.edu.ec.tg.application.service.PacienteService;
import uce.edu.ec.tg.domain.model.Paciente;
import java.util.List;

@Path("/paciente")
public class PacienteResource {

    @Inject
    private PacienteService pacienteService;

    @POST
    @Path("/crearPaciente")
    // http://localhost:8080/paciente/crearPaciente
    public Paciente guardarPaciente(Paciente paciente) {
        return this.pacienteService.crearPaciente(paciente);
    }

    @GET
    @Path("/obtenerPacientePorId/{id}")
    // http://localhost:8080/paciente/obtenerPacientePorId/1
    public Paciente obtenerPacientePorId(@PathParam("id") Integer id) {
        return this.pacienteService.obtenerPacientePorId(id);
    }

    @GET
    @Path("/obtenerTodosLosPacientes")
    // http://localhost:8080/paciente/obtenerTodosLosPacientes
    public List<Paciente> obtenerTodosLosPacientes() {
        return this.pacienteService.obtenerTodosLosPacientes();
    }

    @PUT
    @Path("/actualizarPaciente/{id}")
    // http://localhost:8080/paciente/actualizarPaciente/1
    public Paciente actualizarPaciente(Paciente paciente, @PathParam("id") Integer id) {
        return this.pacienteService.actualizarPaciente(paciente, id);
    }

    @DELETE
    @Path("/eliminarPaciente/{id}")
    // http://localhost:8080/paciente/eliminarPaciente/1
    public Paciente eliminarPaciente(@PathParam("id") Integer id) {
        return this.pacienteService.eliminarPacientePorId(id);
    }

}
