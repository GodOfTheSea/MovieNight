package db;

import domain.Persons;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PersonsRepository {
    final static String URL = "jdbc:postgresql://54.93.65.5:5432/QA7_PCG";
    final static String USERNAME = "fasttrackit_dev";
    final static String PASSWORD = "fasttrackit_dev";

    public static void insert(Persons entry) throws ClassNotFoundException, SQLException {
        // 1. load the driver
        Class.forName("org.postgresql.Driver");

        // 2. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 3. create a query statement
        PreparedStatement pSt = conn.prepareStatement("INSERT INTO persoane( FirstName, LastName, Gender, DateofBirth, Phone, Email, Password) VALUES (?, ?, ?, ?, ?, ?, ?)");
        pSt.setString(1, entry.getFirstName());
        pSt.setString(2, entry.getLastName());
        pSt.setString(3, entry.getGender());
        pSt.setString(4, entry.getDatan());
        pSt.setString(5, entry.getPhone());
        pSt.setString(6, entry.getEmail());
        pSt.setString(7, entry.getPassword());



        // 4. execute a prepared statement
        int rowsInserted = pSt.executeUpdate();
        System.out.println("Inserted " + rowsInserted + " rows.");

        // 5. close the objects
        pSt.close();
        conn.close();
    }

    public static void changePassword(String email, String pass) throws ClassNotFoundException, SQLException {
        // 1. load the driver
        Class.forName("org.postgresql.Driver");

        // 2. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 3. create a query statement
        PreparedStatement pSt = conn.prepareStatement("UPDATE persoane SET Password = ? WHERE Email = ? ");
        pSt.setString(2, email);
        pSt.setString(1, pass);


        // 4. execute a prepared statement
//        int rowsInserted =
        pSt.executeUpdate();
//        System.out.println("Inserted " + rowsInserted + " rows.");

        // 5. close the objects
        pSt.close();
        conn.close();
    }

    public static List<Persons> read() throws ClassNotFoundException, SQLException {
        // 1. load the driver
        Class.forName("org.postgresql.Driver");

        // 2. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 3. create a query statement
        Statement st = conn.createStatement();

        // 4. execute a query
        ResultSet rs = st.executeQuery("SELECT id,FirstName, LastName, Gender, DateOfBirth, Phone, Email, Password FROM persoane");


        // 5. iterate the result set and print the values
        List<Persons> PersonEntries = new ArrayList<>();
        while (rs.next()) {
            Persons person = new Persons(
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getString("gender"),
                    rs.getString("DateOfBirth"),
                    rs.getString("phone"),
                    rs.getString("email"),
                    rs.getString("password")
            );
            person.setId(rs.getLong("id"));
            PersonEntries.add(person);
        }

        // 6. close the objects
        rs.close();
        st.close();
        conn.close();
        return PersonEntries;
    }

    public static boolean findPersonByEmailAndPassword(List<Persons> personEntries, String email ,String pass) throws ClassNotFoundException, SQLException {

        for ( Persons p : personEntries){
            if (p.getEmail().trim().equals(email) && p.getPassword().trim().equals(pass)) {
                return true;
            }
        }
        return false;
    }

}
