package org.example.lancheriaspring.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaDBPostgres {

    public static Connection getConexao() {

        try {
            Class.forName("org.postgresql.Driver");

            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5434/lancheria",
                    "postgres",
                    "1234");

        } catch (ClassNotFoundException ex) {

            ex.printStackTrace();

        } catch (SQLException ex) {

            ex.printStackTrace();

        }

        return null;
    }

}