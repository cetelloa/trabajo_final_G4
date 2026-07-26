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

@Path("/consultorios")
public class ConsultorioResource {

    @Inject
    private ConsultorioService consultorioService;

    @POST
    @Path("/crear")
    public Consultorio crearConsultorio(Consultorio consultorio) {
        return this.consultorioService.guardarConsultorio(consultorio);
    }

    @GET
    @Path("/obtenerConsultorioPorId/{id}")
    public Consultorio obtenerConsultorioPorId(@PathParam("id") Integer id) {
        return this.consultorioService.buscarConsultorioPorId(id);
    }

    @PUT
    @Path("/actualizarConsultorio/{id}")
    public void actualizarConsultorio(Consultorio consultorio, @PathParam("id") Integer id) {
        this.consultorioService.actualizarConsultorio(consultorio, id);
    }

    @DELETE
    @Path("/eliminarConsultorio/{id}")
    public void eliminarConsultorio(@PathParam("id") Integer id) {
        this.consultorioService.eliminarConsultorio(id);
    }

}
