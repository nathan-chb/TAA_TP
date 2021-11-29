package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.doctolib.UtilisateurDAO;
import fr.istic.taa.jaxrs.domain.Pet;
import fr.istic.taa.jaxrs.domain.Professionel;
import fr.istic.taa.jaxrs.domain.Utilisateur;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/docto")
@Produces({"application/json", "application/xml"})
public class DoctolibRessource {

    UtilisateurDAO users = new UtilisateurDAO();


    @GET
    @Path("/displayClients")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Utilisateur> getUser()  {
        return users.findAll();
    }

    @POST
    @Path("/addUser")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public void createCustomer(@FormParam("nom") String nom,
                                 @FormParam("prenom") String prenom) {
        Utilisateur user = new Utilisateur();
        user.setUtilisateurPK(new Utilisateur.UtilisateurPK(nom, prenom));
        users.save(user);
    }
}
