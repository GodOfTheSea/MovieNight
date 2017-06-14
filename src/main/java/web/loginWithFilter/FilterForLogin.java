package web.loginWithFilter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import static db.PersonsRepository.findDuplicatedEmail;
import static db.PersonsRepository.verifyPerson;


@WebFilter("/Login")
public class FilterForLogin implements Filter {
    private FilterConfig filterConfig;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        String email = request.getParameter("email"); // email isEmpty() not NULL
        String pass = request.getParameter("password"); // pass isEmpty() not NULL

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter print = resp.getWriter();
//        request.getRequestDispatcher("login.jsp").include(request, resp);

        try {
            String message = verifyPerson(email,pass);
            if (message.equals("User found")){
                chain.doFilter(request, resp);
            }
            else {
                request.setAttribute("message", message);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
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

    @Override
    public void destroy() {
        filterConfig = null;
    }
}
