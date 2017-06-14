package web;


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
import java.util.List;


/**
 *In order to change your password twice you need to re-login after the first change
 * */



@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String pass = request.getParameter("password");
        String newPass = request.getParameter("newPassword");
        String repeatNewPass = request.getParameter("repeatNewPassword");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter print = resp.getWriter();

        HttpSession session = request.getSession(false);
        Persons p = (Persons) session.getAttribute("name");

        try {
            if (!p.getPassword().trim().equals(pass.trim())) {
                request.setAttribute("message", "Your preview password is incorrect!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/changePassword.jsp");
                dispatcher.forward(request, resp);
            }
        }catch (NullPointerException e){
            request.setAttribute("message", "You need to login again in order to change your new password!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/changePassword.jsp");
            dispatcher.forward(request, resp);
        }

        if (newPass.trim().equals(repeatNewPass.trim())) {
            try {
                List<Persons> personsEntries = PersonsRepository.read();
                if (p.equalsPersons((PersonsRepository.findPersonByEmailAndPassword(personsEntries, p.getEmail().trim(), p.getPassword().trim())))) {
                    PersonsRepository.changePassword(p.getEmail(),newPass);
                    Persons pers = PersonsRepository.findPersonByEmailAndPassword(PersonsRepository.read(),p.getEmail(),newPass);
                    session.setAttribute("name",pers); // Reset the session to the same USER with the new PASS
                    request.setAttribute("message", "Your password has been successfully changed.");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/changePassword.jsp");
                    dispatcher.forward(request, resp);
                } else {
                    request.setAttribute("message", "You are not registered on our site!");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/changePassword.jsp");
                    dispatcher.forward(request, resp);
                }
            } catch (ClassNotFoundException e) {
                print.println("<div class='error'><b>Unable initialize database connection<b></div>");
            } catch (SQLException e) {
                print.println("<div class='error'><b>Unable to write to database! " + e.getMessage() + "<b></div>");
            }  catch (NullPointerException e) {
                print.println("<div class='error'><b>Problems!<b></div>");
            }
        } else{
            request.setAttribute("message", "Password does not match the confirm password!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/changePassword.jsp");
            dispatcher.forward(request, resp);
        }

    }

    @Override
        public void init () throws ServletException {
            super.init();
            getServletContext().log("init() called");
        }

    @Override
    public void destroy () {
        System.out.println("Destroying Servlet!");
        super.destroy();
    }

}
