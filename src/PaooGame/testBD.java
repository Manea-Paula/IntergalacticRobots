package PaooGame;

import java.sql.*;
public class testBD {
    public static void main(String[] args) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
       //     c = DriverManager.getConnection("jdbc:sqlite:baza1.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM joc;" );
            while ( rs.next() ) {
                String name = rs.getString("nume");
                int scor = rs.getInt("scor");

                System.out.println("nume: "+name+" scor: "+scor);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
}