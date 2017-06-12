package web;


import db.PersonsRepository;
import domain.Persons;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/PersonList")
public class PersonsList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<head>");
        out.println("<title> My USERS </title>");
        addStyle(out);
        out.println("</head>");

        try {
            out.println("<h2>The Persons Database</h2>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>Id</th>");
            out.println("<th>First Name</th>");
            out.println("<th>Last Name</th>");
            out.println("<th>Gender</th>");
            out.println("<th>Datan</th>");
            out.println("<th>Phone</th>");
            out.println("<th>Email</th>");
            out.println("<th>Password</th>");
            out.println("</tr>");
            List<Persons> personEntries = PersonsRepository.read();
            for (Persons person : personEntries) {
                out.println("<tr>");
                out.println("<td>"+person.getId()+"</td>");
                out.println("<td>"+person.getFirstName()+"</td>");
                out.println("<td>"+person.getLastName()+"</td>");
                out.println("<td>"+person.getGender()+"</td>");
                out.println("<td>"+person.getDatan()+"</td>");
                out.println("<td>"+person.getPhone()+"</td>");
                out.println("<td>"+person.getEmail()+"</td>");
                out.println("<td>"+person.getPassword()+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        } catch (ClassNotFoundException e) {
            out.println("<div class='error'><b>Unable initialize database connection<b></div>");
        } catch (SQLException e) {
            out.println("<div class='error'><b>Unable to write to database! " +  e.getMessage() +"<b></div>");
        }
        addBackButton(out);
        out.close();
    }

    private void addStyle(PrintWriter out) {
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/ListareStyle.css\">");
    }
    private void addBackButton(PrintWriter out) {
        out.println("<br/><a href='/'>Go Back</a>");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        getServletContext().log("init() called");
    }

    @Override
    public void destroy(){
        System.out.println("Destroying Servlet!");
        super.destroy();
    }

}
