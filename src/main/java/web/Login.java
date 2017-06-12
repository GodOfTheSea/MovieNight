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

/**
 * Need to find a way to remember(by ID) when you are logged in
 */


@WebServlet("/Login")
public class Login extends HttpServlet {

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        String email = request.getParameter("email"); // email isEmpty() not NULL
        String pass = request.getParameter("password"); // pass isEmpty() not NULL

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter print = resp.getWriter();

        try {
            String message = verifyPerson(email,pass);
            if (message.equals("User found")){
                resp.sendRedirect("home.html");
            }
            else {
                request.setAttribute("message", message);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
                dispatcher.forward(request, resp);
            }

        } catch (ClassNotFoundException e) {
            print.println("<div class='error'><b>Unable initialize database connection<b></div>");
        } catch (SQLException e) {
            print.println("<div class='error'><b>Unable to write to database! " + e.getMessage() + "<b></div>");
        } catch (IllegalArgumentException e) {
            print.println("<div class='error'><b>Unable to change the date! " +e.getMessage() +"<b></div>");
        } catch (NullPointerException e) {
            print.println("<div class='error'><b>Problems!<b></div>");
        }

        print.close();

    }

    private static String verifyPerson(String email, String pass) throws ClassNotFoundException, SQLException {
        if (email.isEmpty()){
            return "Please enter your email!";
        } else if (pass.isEmpty()){
            return "Please enter your password!";
        }
        List<Persons> personsEntries = PersonsRepository.read();
        if (!PersonsRepository.findPersonByEmailAndPassword(personsEntries,email,pass)) {
            return "Invalid user or password!";
        }
        return "User found";

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
