package web.loginWithFilter;

import db.PersonsRepository;
import domain.Persons;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/Login")
public class Login extends HttpServlet {

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        String email = request.getParameter("email"); // email isEmpty() not NULL
        String pass = request.getParameter("password"); // pass isEmpty() not NULL

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter print = resp.getWriter();
//        request.getRequestDispatcher("login.jsp").include(request, resp);

        try {
            Persons p = PersonsRepository.findPersonByEmailAndPassword(PersonsRepository.read(),email,pass);
            HttpSession session=request.getSession();
            session.setAttribute("name",p);
            resp.sendRedirect("home2.html");
            System.out.println("Online is: " + p.toString());

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


}
