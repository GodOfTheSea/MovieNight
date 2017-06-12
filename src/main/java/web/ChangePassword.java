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


/**
 *Change Password. You need to be logged in.
 * Being logged in implies that the email is known*/



@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet{

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
//        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        String newPass = request.getParameter("newPassword");
        String repeatNewPass = request.getParameter("repeatNewPassword");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter print = resp.getWriter();

//        try {
//            Persons pers = PersonsRepository.findPersonByEmailAndPassword(PersonsRepository.read(),email,pass);
//            if (pers == null){
//                print.println("<b>Your preview password is incorrect! </b>");
//            }
//
//        }


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
