package web.admin;


import db.MoviesRepository;
import domain.Movies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/MoviesList")
public class MoviesList extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        //get input as string
//        String date = request.getParameter("date");
//        final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        java.util.Date datetime = new java.util.Date();
//        String date = sdf.format(datetime);
//        System.out.println(date);

//        String type, String name, String genre, String ldate, String wdate, String duration, String storyline,
//                String stars, String director, int seasons, int episodes, int note, int favorite

        String type = request.getParameter("type");
        String name = request.getParameter("name");
        String genre = request.getParameter("genre");
        String ldate = request.getParameter("ldate");
        String wdate = request.getParameter("wdate");
        String duration = request.getParameter("duration");
        String storyline = request.getParameter("storyline");
        String stars = request.getParameter("stars");
        String director = request.getParameter("director");
        int seasons = Integer.parseInt(request.getParameter("seasons"));
        int episodes = Integer.parseInt(request.getParameter("episodes"));
        int note = Integer.parseInt(request.getParameter("note"));
        boolean favorite = Boolean.valueOf(request.getParameter("favorite"));

//        System.out.println(date + time);
        // write results to response
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        addStyle(out);

        try {
            Movies entry = new Movies(type, name, genre, ldate, wdate, duration, storyline, stars, director,
                    seasons, episodes, note, favorite);
            MoviesRepository.insert(entry);
            out.println("<b>Inserted new journal entry" + entry + "</b>");
        } catch (IllegalArgumentException e) {
            out.println("<dif class='error'><b>Unable to parse date! Expected format is yyyy-MM-dd but was " + ldate +
            " / " + wdate);
        } catch (ClassNotFoundException e) {
            out.println("<div class='error'><b>Unable initialize database connection" +e.getMessage() + "<b></div>");
        } catch (SQLException e) {
            out.println("<div class='error'><b>Unable to write to database! " +  e.getMessage() +"<b></div>");
        }


        addBackButton(out);

        // finished writing, send to browser
        out.close();

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        addStyle(out);
        String action = req.getParameter("action");

        if(action == null){
            action = "list";
        }

        if (action.equals("list")) getAllMovies(resp);
        if (action.equals("delete")) {
            deleteMovie(req, resp);
        }
    }

    private void getAllMovies(HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<head>");
        out.println("<title> My Movies Night </title>");
        addStyle(out);
        out.println("</head>");
        //        String type, String name, String genre, String ldate, String wdate, String duration, String storyline,
//                String stars, String director, int seasons, int episodes, int note, int favorite

        try {
            out.println("<h2>The Movies Database</h2>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>Id</th>");
            out.println("<th>Type</th>");
            out.println("<th>Name</th>");
            out.println("<th>Genre</th>");
            out.println("<th>LDate</th>");
            out.println("<th>WDate</th>");
            out.println("<th>Duration</th>");
            out.println("<th>StoryLine</th>");
            out.println("<th>Actors</th>");
            out.println("<th>Producers</th>");
            out.println("<th>Seasons</th>");
            out.println("<th>Episodes</th>");
            out.println("<th>Reviews</th>");
            out.println("<th>Favorite</th>");
            out.println("<th>Delete</th>");
            out.println("</tr>");
            List<Movies> movies = MoviesRepository.read();
            for (Movies movie : movies) {
                out.println("<tr>");
                out.println("<td>"+movie.getId()+"</td>");
                out.println("<td>"+movie.getType()+"</td>");
                out.println("<td>"+movie.getName()+"</td>");
                out.println("<td>"+movie.getGenre()+"</td>");
                out.println("<td>"+movie.getLdate()+"</td>");
                out.println("<td>"+movie.getWdate()+"</td>");
                out.println("<td>"+movie.getDuration()+"</td>");
                out.println("<td>"+movie.getStoryline()+"</td>");
                out.println("<td>"+movie.getActors()+"</td>");
                out.println("<td>"+movie.getProducers()+"</td>");
                out.println("<td>"+movie.getSeasons()+"</td>");
                out.println("<td>"+movie.getEpisodes()+"</td>");
                out.println("<td>"+movie.getReviews()+"</td>");
                out.println("<td>"+movie.getFavorite()+"</td>");
                out.println("<td>"+"<a href=\"/MoviesList?action=delete&id="+movie.getId()+"\">X</a>"+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        } catch (ClassNotFoundException e) {
            out.println("<div class='error'><b>Unable initialize database connection<b></div>");
            System.out.println("Aici e problema "+ e.getMessage());
        } catch (SQLException e) {
            out.println("<div class='error'><b>Unable to write to database! " +  e.getMessage() +"<b></div>");
        }
        addBackButton(out);
        out.close();
    }

    private void deleteMovie(HttpServletRequest request, HttpServletResponse resp) throws IOException {
        // write results to response
//        String action = request.getParameter("action");
        String id = request.getParameter("id");
        long x = Integer.parseInt(id);

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        addStyle(out);
        try {
            MoviesRepository.deleteMovie(x);
            out.println("<b>Deleted new journal entry" + id + "</b>");
            addBackButton(out);
        }
        catch (SQLException e){
            out.println("<div class='error'><b>Unable to write to database! " + e.getMessage() + "<b></div>");
        }
        catch (ClassNotFoundException e){
            out.println("<div class='error'><b>Unable initialize database connection<b></div>");
        }
//        FoodRepository.delete(entry);

        // finished writing, send to browser
        out.close();
    }







    private void addBackButton(PrintWriter out) {
        out.println("<br/><h2><a href='/home.html'>HOME PAGE</a></h2>");

    }

    private void addStyle(PrintWriter out) {
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/ListareStyle.css\">");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("init() called.");
    }

    @Override
    public void destroy() {
        System.out.println("Destroying Servlet!");
        super.destroy();
    }
}
