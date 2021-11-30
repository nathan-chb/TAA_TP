package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.doctolib.CompteDAO;
import fr.istic.taa.jaxrs.domain.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compte")
public class CompteController {

    @Autowired
    CompteDAO compteDao;

    @RequestMapping("/")
    @ResponseBody
    public List<Compte> findAll()  {
        return compteDao.findAll();
    }

    @RequestMapping("/{adrCompte}")
    @ResponseBody
    public Compte findOne(@PathVariable("adrCompte") String adresse)  {
        return compteDao.findOne(adresse);
    }

    @RequestMapping("/addCompte")
    @ResponseBody
    public String addCompte( @RequestParam Compte compte)  {
        compteDao.save(compte);
        return "Compte ajouté !";
    }

    @RequestMapping("/delete/{adrCompte}")
    @ResponseBody
    public String deleteCompte( @PathVariable("adrCompte") String adresse)  {
        Compte compte = compteDao.findOne(adresse);
        compteDao.delete(compte);
        return "Compte supprimé";
    }


}

