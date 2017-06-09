package web;

import db.PersonsRepository;
import domain.MyExceptions;
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

import static db.PersonsRepository.check;



@WebServlet("/RegisterPassword")
public class RegisterPassword extends HttpServlet {

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        // get input as string
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        String error;
// = request.getParameter("error");


        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter print = resp.getWriter();


        try {
//                Persons entry = new Persons(pass);
//                long id = PersonsRepository.findPerson(PersonsRepository.read(),email);
//                if (id != 0){
//                    Password entry = new Password(pass);
//                    PersonsRepository.insertPassword(entry);
//                }
//                  List<Persons> PersonsEntry = PersonsRepository.read();
//                  for (Persons p : PersonsEntry){
//                      if(p.getEmail().equals(email) && p.getPassword().equals(pass))
//                          resp.sendRedirect("index.html");
//                      else{
//
//                      }
//                  }


//                PersonsRepository.insertPassword(entry);
//                print.println("<b>Inserted new journal entry" + entry + "</b>");


//            if (PersonsRepository.check(email, pass)) {
//                resp.sendRedirect("home.html");
//            }
            resp.sendRedirect("home.html");
            PersonsRepository.check();


        } catch (ClassNotFoundException e) {
            print.println("<div class='error'><b>Unable initialize database connection<b></div>");
        } catch (SQLException e) {
            print.println("<div class='error'><b>Unable to write to database! " + e.getMessage() + "<b></div>");
        } catch (IllegalArgumentException e) {
            print.println("<div class='error'><b>Unable to change the date!<b></div>");
        } catch (NullPointerException e) {
            print.println("<div class='error'><b>Problems!<b></div>");
        } catch (MyExceptions e){
            print.println();
        }

//            } catch (MyExceptions e) {
////                print.println("<div class='error'>" + e.sendMsg() + "</div>");
////                resp.sendError(1,"Invalid username or password!");
//                error = "Invalid username or password!";
//                print.println("<div id='error'>"+error+"</div>");
//            }

//            print.println("a mers!");
//
//            resp.sendRedirect("index.html");

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
