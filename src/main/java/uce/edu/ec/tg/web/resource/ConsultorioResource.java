package uce.edu.ec.tg.web.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import uce.edu.ec.tg.application.service.ConsultorioService;
import uce.edu.ec.tg.domain.model.Consultorio;
import java.util.List;

@Path("/consultorios")
public class ConsultorioResource {

    @Inject
    private ConsultorioService consultorioService;

    @POST
    @Path("/crearConsultorio")
    // http://localhost:8080/consultorios/crearConsultorio
    public Consultorio crearConsultorio(Consultorio consultorio) {
        return this.consultorioService.guardarConsultorio(consultorio);
    }

    @GET
    @Path("/obtenerConsultorioPorId/{id}")
    // http://localhost:8080/consultorios/obtenerConsultorioPorId/1
    public Consultorio obtenerConsultorioPorId(@PathParam("id") Integer id) {
        return this.consultorioService.buscarConsultorioPorId(id);
    }

    @GET
    @Path("/obtenerTodosLosConsultorios")
    // http://localhost:8080/consultorios/obtenerTodosLosConsultorios
    public List<Consultorio> obtenerTodosLosConsultorios() {
        return this.consultorioService.obtenerTodosLosConsultorios();
    }

    @PUT
    @Path("/actualizarConsultorio/{id}")
    // http://localhost:8080/consultorios/actualizarConsultorio/1
    public Consultorio actualizarConsultorio(Consultorio consultorio, @PathParam("id") Integer id) {
        return this.consultorioService.actualizarConsultorio(consultorio, id);
    }

    @DELETE
    @Path("/eliminarConsultorio/{id}")
    // http://localhost:8080/consultorios/eliminarConsultorio/1
    public Consultorio eliminarConsultorio(@PathParam("id") Integer id) {
        return this.consultorioService.eliminarConsultorio(id);
    }

    // Agregar medico al consultorio
    @PUT
    @Path("/{consultorioId}/medicos/{medicoId}")
    // http://localhost:8080/consultorios/{consultorioId}/medicos/{medicoId}
    public Consultorio agregarMedico(@PathParam("consultorioId") Integer consultorioId,
            @PathParam("medicoId") Integer medicoId) {
        return this.consultorioService.agregarMedico(consultorioId, medicoId);
    }

}
