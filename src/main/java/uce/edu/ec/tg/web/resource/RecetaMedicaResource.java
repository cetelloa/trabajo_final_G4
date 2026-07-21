package uce.edu.ec.tg.web.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import uce.edu.ec.tg.application.service.RecetaMedicaService;
import uce.edu.ec.tg.domain.model.RecetaMedica;

@Path("/recetaMedica")
public class RecetaMedicaResource {

    @Inject
    private RecetaMedicaService recetaMedicaService;

    @POST
    @Path("/crearReceta")
    public void guardarReceta(RecetaMedica recetaMedica) {
        this.recetaMedicaService.crearReceta(recetaMedica);
    }

    @GET
    @Path("/obtenerRecetaPorId/{id}")
    public RecetaMedica obtenerRecetaPorId(@PathParam("id") Integer id) {
        return this.recetaMedicaService.obtenerRecetaPorId(id);
    }

    @PUT
    @Path("/actualizarReceta/{id}")
    public void actualizarReceta(RecetaMedica recetaMedica, @PathParam("id") Integer id) {
        this.recetaMedicaService.actualizarReceta(recetaMedica, id);
    }
    
    @DELETE
    @Path("/eliminarReceta/{id}")
    public void eliminarReceta(@PathParam("id") Integer id) {
        this.recetaMedicaService.eliminarRecetaPorId(id);
    }
}
