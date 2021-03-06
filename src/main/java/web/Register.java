package web;



import db.PersonsRepository;
import domain.Persons;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/Register")
public class Register extends  HttpServlet {

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        // get input as string
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String gender = request.getParameter("gender");
        String day = request.getParameter("day");
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        String dateofbirth = day+"-"+month+"-"+year;

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter print = resp.getWriter();

        try {
            Persons entry = new Persons(firstname, lastname, gender, dateofbirth, phone, email, password);
            List<Persons> personEntries = PersonsRepository.read();
            if (PersonsRepository.findDuplicatedEmail(personEntries,email)){
                request.setAttribute("message", "Email address already in use!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
                dispatcher.forward(request, resp);
            } else {
                PersonsRepository.insert(entry);
                print.println("<b>Inserted new journal entry" + entry + "</b>");
            }
        } catch (ClassNotFoundException e) {
            print.println("<div class='error'><b>Unable initialize database connection<b></div>");
        } catch (SQLException e) {
            print.println("<div class='error'><b>Unable to write to database! " +  e.getMessage() +"<b></div>");
        } catch (IllegalArgumentException e){
            print.println("<div class='error'><b>Unable to change the date!<b></div>");
        } catch (NullPointerException e) {
            print.println("<div class='error'><b>Problems!<b></div>");
        }

        resp.sendRedirect("login.jsp");

        print.close();
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