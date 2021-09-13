package servlet;

import DAO.ProfessionelDAO;
import DAO.UtilisateurDAO;
import model.Professionel;
import model.Utilisateur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="mytest",
        urlPatterns={"/bdd"})
public class MyServlet extends HttpServlet {

    ProfessionelDAO professionelDAO = new ProfessionelDAO();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Professionel> list = professionelDAO.findAll();
        PrintWriter p = resp.getWriter();
        resp.setContentType("text/html");
        p.print("<html> <table> ");
        int iter = 0;
        for (Professionel i : list){
            p.print("<tr> <td>" + i.getUtilisateurPK().getNom()+ "</td>");
            p.print("<td>" + i.getUtilisateurPK().getPrenom()+ "</td>");
            p.print("<td> <input type=\"submit\" name=\"button"+ i +"\" value=\"delete\" /> </td> </tr>");
            iter++;
        }
        p.print("</table>");
        p.println("\n<html>\n" +
                "<body>\n" +
                "<FORM Method=\"POST\" Action=\"/bdd\">\n" +
                "    Prenom :         <INPUT type=\"text\" size=\"20\" name=\"name\"><BR>\n" +
                "    Nom :     <INPUT type=\"text\" size=\"20\" name=\"firstname\"><BR>\n" +
                "    <INPUT type=submit value=Send>\n" +
                "</FORM>\n" +
                "</body>\n" +
                "</html>\n");
        p.flush();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Professionel user = new Professionel();
        user.setUtilisateurPK(new Utilisateur.UtilisateurPK(req.getParameter("name"), req.getParameter("firstname")));
        professionelDAO.update(user);
        doGet(req, resp);
    }
}
