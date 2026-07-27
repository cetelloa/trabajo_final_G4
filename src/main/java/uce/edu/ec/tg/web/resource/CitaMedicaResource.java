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
import uce.edu.ec.tg.application.dtos.ActualizarCitaRequest;
import uce.edu.ec.tg.application.dtos.CrearCitaRequest;
import uce.edu.ec.tg.application.service.CitaMedicaService;
import uce.edu.ec.tg.domain.model.CitaMedica;

@Path("/citaMedica")
public class CitaMedicaResource {

    @Inject
    private CitaMedicaService citaMedicaService;

    @POST
    @Path("/crearCita")
    // http://localhost:8080/citaMedica/crearCita
    // asi se crea el body {"cedulaPaciente": "1234567890", "cedulaMedico":
    // "0987654321", "fechaCita": "2024-03-15"}
    public CitaMedica guardarCita(CrearCitaRequest request) {
        return this.citaMedicaService.crearCitaMedica(
                request.getCedulaPaciente(),
                request.getCedulaMedico(),
                request.getFechaCita());
    }

    @GET
    @Path("/obtenerCitaPorId/{id}")
    // http://localhost:8080/citaMedica/obtenerCitaPorId/1
    public CitaMedica obtenerCitaPorId(@PathParam("id") Integer id) {
        return this.citaMedicaService.obtenerCitaMedicaPorId(id);
    }

    @PUT
    @Path("/actualizarCita/{id}")
    // http://localhost:8080/citaMedica/actualizarCita/1
    // asi va el body {"cedulaPaciente":175152556", "cedulaMedico": "1752625",
    // "fechaCita": "2024-03-15"}
    public CitaMedica actualizarCita(ActualizarCitaRequest request, @PathParam("id") Integer id) {
        return this.citaMedicaService.actualizarCitaMedica(
                request.getCedulaPaciente(),
                request.getCedulaMedico(),
                request.getFechaCita(),
                id);
    }

    @DELETE
    @Path("/eliminarCita/{id}")
    // http://localhost:8080/citaMedica/eliminarCita/1
    public CitaMedica eliminarCita(@PathParam("id") Integer id) {
        return this.citaMedicaService.eliminarCitaMedicaPorId(id);
    }

    // Metodos solicitados

    @GET
    @Path("/buscarCitaPorCedulaPaciente/{cedulaPaciente}")
    // http://localhost:8080/citaMedica/buscarCitaPorCedulaPaciente/123456789
    public List<CitaMedica> buscarCitaPorCedulaPaciente(@PathParam("cedulaPaciente") String cedulaPaciente) {
        return this.citaMedicaService.buscarCitaPorCedulaPaciente(cedulaPaciente);
    }

    @GET
    @Path("/buscarCitaPorCedulaMedico/{cedulaMedico}")
    // http://localhost:8080/citaMedica/buscarCitaPorCedulaMedico/123456789
    public List<CitaMedica> buscarCitaPorCedulaMedico(@PathParam("cedulaMedico") String cedulaMedico) {
        return this.citaMedicaService.buscarCitaPorCedulaMedico(cedulaMedico);
    }

    @GET
    @Path("/buscarCitaPorFecha/{fechaCita}")
    // http://localhost:8080/citaMedica/buscarCitaPorFecha/2022-01-01
    public CitaMedica buscarCitaPorFecha(@PathParam("fechaCita") LocalDate fechaCita) {
        return this.citaMedicaService.buscarCitaPorFecha(fechaCita);
    }

}
