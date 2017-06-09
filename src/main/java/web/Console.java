package web;

import domain.Movies;
import db.MoviesRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;



@WebServlet("/Console")

public class Console extends HttpServlet {

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //choose your db

        //get input as a string
        String type = request.getParameter("type");
        String name = request.getParameter("name");
        String genre = request.getParameter("genre");
        String data =request.getParameter("date");
        String wdata = request.getParameter("wdate");
        String duration = request.getParameter("duration");
        String storyline = request.getParameter("storyline");
        String stars = request.getParameter("stars");
        String director = request.getParameter("director");
        int seasons = request.getIntHeader("seasons");
        int episodes = request.getIntHeader("episodes");
        int note = request.getIntHeader("note");
        int favorit = request.getIntHeader("favorit");



        response.setContentType("text/html;charset=UTF-8");
        PrintWriter print = response.getWriter();

            try{
                Movies entry = new Movies(type,name,genre,data,wdata,duration,storyline,stars,director,seasons,episodes,note,favorit);
                MoviesRepository.insert(entry);
            }catch (ClassNotFoundException e){
                print.println("<div class='error'><b>Unable initialize database connection<b></div>");
            }catch (SQLException e) {
                print.println("<div class='error'><b>Unable to write to database!"+e.getMessage()+"<b></div>");
            }



        print.close();
    }



    @Override
    public void init() throws ServletException{
        super.init();
        getServletContext().log("init() called");
    }

    @Override
    public void destroy(){
        System.out.println("Destroying servlet!");
        super.destroy();
    }
}
