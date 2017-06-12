package db;


import domain.Movies;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MoviesRepository {

    final static String URL = "jdbc:postgresql://54.93.65.5:5432/QA7_PCG";
    final static String USERNAME = "fasttrackit_dev";
    final static String PASSWORD = "fasttrackit_dev";



    public static void insert(Movies entry) throws ClassNotFoundException, SQLException {
        //1.load the driver
        Class.forName("org.postgresql.Driver");
        //2.obtain a connection
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        //3.create a query statement
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Movies(Type, Name , Gender , Date , Wdate , Duration , StoryLine , Stars , Director , Seasons , Episodes , Note , Favorit) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        preparedStatement.setString(1, entry.getType());
        preparedStatement.setString(2, entry.getName());
        preparedStatement.setString(3, entry.getGenre());
        preparedStatement.setString(4, entry.getLdate());
        preparedStatement.setString(5, entry.getWdate());
        preparedStatement.setString(6, entry.getDuration());
        preparedStatement.setString(7, entry.getStoryline());
        preparedStatement.setString(8, entry.getStars());
        preparedStatement.setString(9, entry.getDirector());
        preparedStatement.setInt(10, entry.getSeasons());
        preparedStatement.setInt(11,entry.getEpisodes());
        preparedStatement.setInt(12, entry.getNote());
        preparedStatement.setInt(13, entry.getFavorite());
        //4.Execute a prepared statement
        int rowsInserted = preparedStatement.executeUpdate();
        System.out.println("Inserted "+rowsInserted+" rows.");
        //5.close the objects
        preparedStatement.close();
        connection.close();
    }


    public static List<Movies> read() throws ClassNotFoundException, SQLException {
        //1.load the driver
        Class.forName("org.postgresql.Driver");
        //2.obtain a connection
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        //3.create a querry statement
        Statement statement = connection.createStatement();
        //4.execute a query
        ResultSet resultset = statement.executeQuery("SELECT Type, Name, Gender, Date, Wdate, Duration, StoryLine, Stars, Director, Seasons, Episodes, Note, Favorit FROM Movies");
        //5.iterate the result set and print the values
        List<Movies> Filme = new ArrayList<>();
        while (resultset.next()){
            Movies film = new Movies(
                    resultset.getString("Type"),
                    resultset.getString("Name"),
                    resultset.getString("Gender"),
                    resultset.getString("Date"),
                    resultset.getString("Wdate"),
                    resultset.getString("Duration"),
                    resultset.getString("StoryLine"),
                    resultset.getString("Stars"),
                    resultset.getString("Director"),
                    resultset.getInt("Seasons"),
                    resultset.getInt("Episodes"),
                    resultset.getInt("Note"),
                    resultset.getInt("Favorit")
                    );
            film.setId(resultset.getLong("id"));
            Filme.add(film);
        }
        //6.close the objects
        resultset.close();
        statement.close();
        connection.close();
        return Filme;
    }
}
