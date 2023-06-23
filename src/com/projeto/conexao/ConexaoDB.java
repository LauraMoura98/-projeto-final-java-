package com.projeto.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoDB{
    private static Connection conexao = null;

    private String fonte = "projeto_final";

    private ConexaoDB() throws ClassNotFoundException {

        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ fonte + "?useTimezone=true&serverTimezone=UTC" , "root", "N77Xl^m&5Kl8");
        }

        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro na conexão com o banco de dados.");
        }
    }

    public static Connection getInstance() throws ClassNotFoundException {
        if (conexao == null) {
            new ConexaoDB();
        }
        return conexao;
    }
}
