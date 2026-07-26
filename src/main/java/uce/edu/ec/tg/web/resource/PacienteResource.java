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

@Path("/paciente")
public class PacienteResource {

    @Inject
    private PacienteService pacienteService;

    @POST
    @Path("/crearPaciente")
    public Paciente guardarPaciente(Paciente paciente) {
        return this.pacienteService.crearPaciente(paciente);
    }

    @GET
    @Path("/obtenerPacientePorId/{id}")
    public Paciente obtenerPacientePorId(@PathParam("id") Integer id) {
        return this.pacienteService.obtenerPacientePorId(id);
    }

    @PUT
    @Path("/actualizarPaciente/{id}")
    public void actualizarPaciente(Paciente paciente, @PathParam("id") Integer id) {
        this.pacienteService.actualizarPaciente(paciente, id);
    }

    @DELETE
    @Path("/eliminarPaciente/{id}")
    public void eliminarPaciente(@PathParam("id") Integer id) {
        this.pacienteService.eliminarPacientePorId(id);
    }

}
