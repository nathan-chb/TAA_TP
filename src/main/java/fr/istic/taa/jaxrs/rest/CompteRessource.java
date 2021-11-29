package fr.istic.taa.jaxrs.rest;


import fr.istic.taa.jaxrs.dao.doctolib.CompteDAO;
import fr.istic.taa.jaxrs.domain.Compte;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/comptes")
@Produces({"application/json", "application/xml"})
public class CompteRessource {

    CompteDAO compteDao = new CompteDAO();

    @GET
    @Path("/")
    public List<Compte> findAll()  {
        return compteDao.findAll();
    }

    @GET
    @Path("/{adrCompte}")
    public Compte findOne(@PathParam("adrCompte") String adresse)  {
        return compteDao.findOne(adresse);
    }

    @POST
    @Path("/addCompte")
    @Consumes("application/json")
    public Response addCompte( @Parameter(required = true) Compte compte)  {
        compteDao.save(compte);
        return Response.ok().entity("SUCCESS").build();
    }

    @POST
    @Path("/delete/{adrCompte}")
    public Response deleteCompte( @PathParam("adrCompte") String adresse)  {
        Compte compte = compteDao.findOne(adresse);
        compteDao.delete(compte);
        return Response.ok().entity("SUCCESS").build();
    }


}

