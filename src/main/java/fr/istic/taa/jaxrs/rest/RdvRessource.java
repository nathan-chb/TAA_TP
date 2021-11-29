package fr.istic.taa.jaxrs.rest;


import fr.istic.taa.jaxrs.dao.doctolib.RdvDAO;
import fr.istic.taa.jaxrs.domain.Compte;
import fr.istic.taa.jaxrs.domain.Rdv;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/Rdv")
@Produces({"application/json", "application/xml"})
public class RdvRessource {

    RdvDAO rdvDAO = new RdvDAO();

    @GET
    @Path("/")
    public List<Rdv> findAll()  {
        return rdvDAO.findAll();
    }

    @GET
    @Path("/{RdvId}")
    public Rdv findOne(@PathParam("RdvId") String RdvId)  {
        return rdvDAO.findOne(RdvId);
    }

    @POST
    @Path("/addRdv")
    @Consumes("application/json")
    public Response addRdv( @Parameter(required = true) Rdv rdv)  {
        rdvDAO.save(rdv);
        return Response.ok().entity("SUCCESS").build();
    }

    @POST
    @Path("/delete/{RdvId}")
    public Response deleteRdv( @PathParam("RdvId") String RdvId)  {
        Rdv rdv = rdvDAO.findOne(RdvId);
        rdvDAO.delete(rdv);
        return Response.ok().entity("SUCCESS").build();
    }



}
