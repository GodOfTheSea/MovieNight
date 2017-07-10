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
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Movies(Type, Name , Genre , Date , Wdate , Duration , StoryLine , Actors, Producers, Seasons , Episodes , Reviews , Favorit) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        preparedStatement.setString(1, entry.getType());
        preparedStatement.setString(2, entry.getName());
        preparedStatement.setString(3, entry.getGenre());
        preparedStatement.setString(4, entry.getLdate());
        preparedStatement.setString(5, entry.getWdate());
        preparedStatement.setString(6, entry.getDuration());
        preparedStatement.setString(7, entry.getStoryline());
        preparedStatement.setString(8, entry.getActors());
        preparedStatement.setString(9, entry.getProducers());
        preparedStatement.setInt(10, entry.getSeasons());
        preparedStatement.setInt(11,entry.getEpisodes());
        preparedStatement.setInt(12, entry.getReviews());
        preparedStatement.setBoolean(13, entry.getFavorite());
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
        //3.create a query statement
        Statement statement = connection.createStatement();
        //4.execute a query
        ResultSet resultset = statement.executeQuery("SELECT id, Type, Name, Genre, Date, Wdate, Duration, StoryLine, Actors, Producers, Seasons, Episodes, Reviews, Favorite FROM Movies");
        //5.iterate the result set and print the values
        List<Movies> movies = new ArrayList<>();
        while (resultset.next()){
            Movies film = new Movies(
                    resultset.getString("Type"),
                    resultset.getString("Name"),
                    resultset.getString("Genre"),
                    resultset.getString("Date"),
                    resultset.getString("Wdate"),
                    resultset.getString("Duration"),
                    resultset.getString("StoryLine"),
                    resultset.getString("Actors"),
                    resultset.getString("Producers"),
                    resultset.getInt("Seasons"),
                    resultset.getInt("Episodes"),
                    resultset.getInt("Reviews"),
                    resultset.getBoolean("Favorite")
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

    public static void deleteMovie(long id) throws ClassNotFoundException, SQLException {
        // 1. load the driver
        Class.forName("org.postgresql.Driver");

        // 2. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 3. create a query statement
        PreparedStatement st = conn.prepareStatement("DELETE FROM movies WHERE id = ?");
        st.setLong(1,id);
        st.executeUpdate();

        st.close();
        conn.close();
    }

    public static List<Movies> sortByFavorites() throws ClassNotFoundException, SQLException {
        // 1. load the driver
        Class.forName("org.postgresql.Driver");

        // 2. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 3. create a query statement
        Statement st = conn.createStatement();

        // 4. execute a query
        ResultSet resultSet = st.executeQuery("SELECT id, Type, Name, Genre, Date, Wdate, Duration, StoryLine, Actors, Producers, Seasons, Episodes, Reviews, Favorite FROM Movies WHERE favorite = TRUE ");

        // 5. iterate the result set and print the values
        List<Movies> journalEntries = new ArrayList<>();
        while (resultSet.next()) {
            Movies journalEntry = new Movies(
                    resultSet.getString("Type"),
                    resultSet.getString("Name"),
                    resultSet.getString("Genre"),
                    resultSet.getString("Date"),
                    resultSet.getString("Wdate"),
                    resultSet.getString("Duration"),
                    resultSet.getString("StoryLine"),
                    resultSet.getString("Actors"),
                    resultSet.getString("Producers"),
                    resultSet.getInt("Seasons"),
                    resultSet.getInt("Episodes"),
                    resultSet.getInt("Reviews"),
                    resultSet.getBoolean("Favorite")
            );
            journalEntry.setId(resultSet.getLong("id"));
            journalEntries.add(journalEntry);
        }

        // 6. close the objects
        resultSet.close();
        st.close();
        conn.close();
        return journalEntries;
    }





    public static List<Movies> orderByName() throws ClassNotFoundException, SQLException {
        // 1. load the driver
        Class.forName("org.postgresql.Driver");

        // 2. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 3. create a query statement
        Statement st = conn.createStatement();

        // 4. execute a query
        ResultSet resultSet = st.executeQuery("SELECT id, Type, Name, Genre, Date, Wdate, Duration, StoryLine, Actors, Producers, Seasons, Episodes, Reviews, Favorite FROM Movies ORDER BY ASC ");

        // 5. iterate the result set and print the values
        List<Movies> journalEntries = new ArrayList<>();
        while (resultSet.next()) {
            Movies journalEntry = new Movies(
                    resultSet.getString("Type"),
                    resultSet.getString("Name"),
                    resultSet.getString("Genre"),
                    resultSet.getString("Date"),
                    resultSet.getString("Wdate"),
                    resultSet.getString("Duration"),
                    resultSet.getString("StoryLine"),
                    resultSet.getString("Actors"),
                    resultSet.getString("Producers"),
                    resultSet.getInt("Seasons"),
                    resultSet.getInt("Episodes"),
                    resultSet.getInt("Reviews"),
                    resultSet.getBoolean("Favorite")
            );
            journalEntry.setId(resultSet.getLong("id"));
            journalEntries.add(journalEntry);
        }

        // 6. close the objects
        resultSet.close();
        st.close();
        conn.close();
        return journalEntries;
    }








}
