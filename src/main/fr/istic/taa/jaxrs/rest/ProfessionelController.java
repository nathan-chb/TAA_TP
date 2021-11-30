package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.doctolib.ProfessionelDAO;
import fr.istic.taa.jaxrs.domain.Professionel;
import fr.istic.taa.jaxrs.domain.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/professionel")
public class ProfessionelController {

    @Autowired
    ProfessionelDAO professionelDAO;

    @RequestMapping("/")
    @ResponseBody
    public List<Utilisateur> findAll()  {
        return professionelDAO.findAll();
    }

    @RequestMapping("/{proId}")
    @ResponseBody
    public Professionel findOne(@PathVariable("proId") Utilisateur.UtilisateurPK proId)  {
        return professionelDAO.findOne(proId);
    }

    @RequestMapping("/addPro")
    @ResponseBody
    public String addPro(@RequestParam Professionel professionel) {
        professionelDAO.save(professionel);
        return "pro ajouté !";
    }

    @RequestMapping("/delete/{proId}")
    @ResponseBody
    public String deleteUser( @PathVariable("proId") Utilisateur.UtilisateurPK proId) {
        Professionel user = professionelDAO.findOne(proId);
        professionelDAO.delete(user);
        return "pro supprimé";
    }

}
