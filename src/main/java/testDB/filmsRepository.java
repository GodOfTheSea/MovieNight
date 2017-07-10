package testDB;


import domain.Film;


import java.sql.*;
import java.util.*;


public class filmsRepository {

    final static String URL = "jdbc:mysql://localhost:3306/moviesnight?autoReconnect=true&useSSL=false";
    final static String USERNAME = "root";
    final static String PASSWORD = "Lafamilia";

    public static List<Film> read() throws ClassNotFoundException, SQLException {
        //1.load the driver
        Class.forName("com.mysql.jdbc.Driver");
        //2.obtain a connection
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        //3.create a query statement
        Statement statement = connection.createStatement();
        //4.execute a query
        ResultSet resultset = statement.executeQuery("SELECT id, Title, Description, Runtime, release_date FROM movies");
        //5.iterate the result set and print the values
        List<Film> movies = new ArrayList<>();
        while (resultset.next()){
            Film film = new Film(
                    resultset.getString("Title"),
                    resultset.getString("Description"),
                    resultset.getString("Runtime"),
                    resultset.getDate("release_date")
            );
            film.setId(resultset.getLong("id"));
            movies.add(film);
        }
        //6.close the objects
        resultset.close();
        statement.close();
        connection.close();
        return movies;

    }

    public static List<String> readMovieGenre() throws ClassNotFoundException, SQLException {
        //1.load the driver
        Class.forName("com.mysql.jdbc.Driver");
        //2.obtain a connection
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        //3.create a query statement
        Statement statement = connection.createStatement();
        //4.execute a query
        ResultSet resultset = statement.executeQuery("select title from genres\n" +
                "where id in \n" +
                "(select genre_id from movie_genres where movie_id = 1);");
        //5.iterate the result set and print the values
        List<String> movieGenres = new ArrayList<>();
        while (resultset.next()){
            String genre = resultset.getString("title");
            movieGenres.add(genre);
        }
        //6.close the objects
        resultset.close();
        statement.close();
        connection.close();
        return movieGenres;

    }


//    public static void main(String[] args) {
////        java.util.Date date = new Date();
////        Film film = new Film("Oracle","ceva","12:12",date);
////        System.out.println(film.toString());
//
//        try{
//            List<Film> movies = read();
//            List<String> genres = readMovieGenre();
//
//            for (Film film : movies){
//                System.out.println(film.toString() + " " + "Genre:" + genres.toString());
//            }
////            for (String s : genres){
////                System.out.println(s);
////            }
//        }catch (ClassNotFoundException e) {
//            System.out.println("Unable initialize database connection");
//            System.out.println("Aici e problema "+ e.getMessage());
//        } catch (SQLException e) {
//            System.out.println("Unable to write to database! " +  e.getMessage());
//        }
//    }

}
