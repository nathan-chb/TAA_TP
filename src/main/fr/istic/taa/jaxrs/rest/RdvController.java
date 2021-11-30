package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.doctolib.RdvDAO;
import fr.istic.taa.jaxrs.domain.Rdv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/rdv")
public class RdvController {

    @Autowired
    RdvDAO rdvDAO;

    @RequestMapping("/")
    @ResponseBody
    public List<Rdv> findAll()  {
        return rdvDAO.findAll();
    }

    @RequestMapping("/{RdvId}")
    @ResponseBody
    public Rdv findOne(@PathVariable("RdvId") Long RdvId)  {
        return rdvDAO.findOne(RdvId);
    }

    @RequestMapping("/addRdv")
    @ResponseBody
    public String addRdv(@RequestParam Rdv rdv)  {
        rdvDAO.save(rdv);
        return "RDV ajouté !";
    }

    @RequestMapping("/delete/{RdvId}")
    @ResponseBody
    public String deleteRdv(@PathVariable("RdvId") Long RdvId)  {
        Rdv rdv = rdvDAO.findOne(RdvId);
        rdvDAO.delete(rdv);
        return "rdv supprimé";
    }



}
