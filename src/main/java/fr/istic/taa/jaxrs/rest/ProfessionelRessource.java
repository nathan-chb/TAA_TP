package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.domain.Professionel;
import io.swagger.v3.oas.annotations.Parameter;
import fr.istic.taa.jaxrs.dao.doctolib.ProfessionelDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;


public class ProfessionelRessource {

    ProfessionelDAO professionelDAO = new ProfessionelDAO();


    @GET
    @Path("/")
    public List<Professionel> findAll()  {
        return professionelDAO.findAll();
    }

    @GET
    @Path("/{proId}")
    public Professionel findOne(@PathParam("proId") Long proId)  {
        return professionelDAO.findOne(proId);
    }

    @POST
    @Path("/addPro")
    @Consumes("application/json")
    public Response addPro(
            @Parameter(required = true) Professionel professionel) {
        professionelDAO.save(professionel);
        return Response.ok().entity("SUCCESS").build();
    }

    @POST
    @Path("/delete/{proId}")
    public Response deleteUser(
            @PathParam("proId") Long proId) {
        // delete pro
        Professionel user = professionelDAO.findOne(proId);
        professionelDAO.delete(user);
        return Response.ok().entity("SUCCESS").build();
    }

}
