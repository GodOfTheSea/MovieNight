package web;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Home")
public class Home extends HttpServlet{

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {


        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.print("<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Home</title>\n" +
                "</head>");

        out.print("<body>\n" +
                "<a href=\"listareTest.html\" type=\"link\" class=\"mesaj welcome\" > ENTER </a>\n" +
                "\n" +
                "<a href=\"changePassword.jsp\" type=\"link\" class=\"mesaj welcome\" > Change Password </a>\n" +
                "\n" +
                "<a style=\"color: #e50914\" href=\"Logout\">Logout</a> |\n" +
                "<a style=\"color: #182b40\" href=\"Profile\">Profile</a>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "</body>");

        out.print("<br>welcome to servlet<br>");

    }

    }

