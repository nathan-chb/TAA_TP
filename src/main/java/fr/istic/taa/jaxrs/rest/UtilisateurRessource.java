package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.doctolib.UtilisateurDAO;
import fr.istic.taa.jaxrs.domain.Compte;
import fr.istic.taa.jaxrs.domain.Utilisateur;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/utilisateurs")
@Produces({"application/json", "application/xml"})
public class UtilisateurRessource {
    UtilisateurDAO utilisateurDAO = new UtilisateurDAO();


    @GET
    @Path("/")
    public List<Utilisateur> findAll()  {
        return utilisateurDAO.findAll();
    }

    @GET
    @Path("/{utilisateurId}")
    public Utilisateur findOne(@PathParam("utilisateurId") String utilisateurId)  {
        return utilisateurDAO.findOne(utilisateurId);
    }

    @POST
    @Path("/addUtilisateur")
    @Consumes("application/json")
    public Response addCompte( @Parameter(required = true) Utilisateur utilisateur)  {
        utilisateurDAO.save(utilisateur);
        return Response.ok().entity("SUCCESS").build();
    }

    @POST
    @Path("/delete/{utilisateurId}")
    public Response deleteCompte( @PathParam("utilisateurId") String utilisateurId)  {
        Utilisateur utilisateur = utilisateurDAO.findOne(utilisateurId);
        utilisateurDAO.delete(utilisateur);
        return Response.ok().entity("SUCCESS").build();
    }


}
