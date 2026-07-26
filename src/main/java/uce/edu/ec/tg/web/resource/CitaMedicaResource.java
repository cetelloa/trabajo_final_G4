package uce.edu.ec.tg.web.resource;

import java.time.LocalDate;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import uce.edu.ec.tg.application.service.CitaMedicaService;
import uce.edu.ec.tg.domain.model.CitaMedica;

@Path("/citaMedica ")
public class CitaMedicaResource {

    @Inject
    private CitaMedicaService citaMedicaService;

    @POST
    @Path("/crearCita")
    public void guardarCita(CitaMedica cita) {
        this.citaMedicaService.crearCitaMedica(cita);
    }

    @GET
    @Path("/obtenerCitaPorId/{id}")
    public CitaMedica obtenerCitaPorId(@PathParam("id") Integer id) {
        return this.citaMedicaService.obtenerCitaMedicaPorId(id);
    }

    @PUT
    @Path("/actualizarCita/{id}")
    public void actualizarCita(CitaMedica cita, @PathParam("id") Integer id) {
        this.citaMedicaService.actualizarCitaMedica(cita, id);
    }

    @DELETE
    @Path("/eliminarCita/{id}")
    public void eliminarCita(@PathParam("id") Integer id) {
        this.citaMedicaService.eliminarCitaMedicaPorId(id);
    }

    // Metodos solicitados

    @GET
    @Path("/buscarCitaPorCedulaPaciente/{cedulaPaciente}")
    public List<CitaMedica> buscarCitaPorCedulaPaciente(@PathParam("cedulaPaciente") String cedulaPaciente) {
        return this.citaMedicaService.buscarCitaPorCedulaPaciente(cedulaPaciente);
    }

    @GET
    @Path("/buscarCitaPorCedulaMedico/{cedulaMedico}")
    public List<CitaMedica> buscarCitaPorCedulaMedico(@PathParam("cedulaMedico") String cedulaMedico) {
        return this.citaMedicaService.buscarCitaPorCedulaMedico(cedulaMedico);
    }

    @GET
    @Path("/buscarCitaPorFecha/{fechaCita}")
    public CitaMedica buscarCitaPorFecha(@PathParam("fechaCita") LocalDate fechaCita) {
        return this.citaMedicaService.buscarCitaPorFecha(fechaCita);
    }

}
