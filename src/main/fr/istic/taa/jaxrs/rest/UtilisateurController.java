package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.doctolib.UtilisateurDAO;
import fr.istic.taa.jaxrs.domain.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {

    @Autowired
    UtilisateurDAO utilisateurDAO;

    @RequestMapping("/")
    @ResponseBody
    public List<Utilisateur> findAll()  {
        return utilisateurDAO.findAll();
    }

    @RequestMapping("/{utilisateurId}")
    @ResponseBody
    public Utilisateur findOne(@PathVariable("utilisateurId") Utilisateur.UtilisateurPK utilisateurId)  {
        return utilisateurDAO.findOne(utilisateurId);
    }

    @RequestMapping("/addUtilisateur")
    @ResponseBody
    public String addCompte(@RequestParam Utilisateur utilisateur)  {
        utilisateurDAO.save(utilisateur);
        return "utilisateur ajouté !";
    }

    @RequestMapping("/delete/{utilisateurId}")
    @ResponseBody
    public String deleteCompte(@PathVariable("utilisateurId") Utilisateur.UtilisateurPK utilisateurId)  {
        Utilisateur utilisateur = utilisateurDAO.findOne(utilisateurId);
        utilisateurDAO.delete(utilisateur);
        return "utilisateur supprimé";
    }


}
