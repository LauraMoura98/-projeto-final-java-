package com.projeto.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.projeto.classes.Garcom;
import com.projeto.conexao.ConexaoDB;

public class ProjetoFinalDAO {

    static Connection conexao = null;

    public static void inserirGarcom(Garcom g) throws Exception {
        conexao = ConexaoDB.getInstance();

        String sql = "INSERT INTO GARCOM (ID_GARCOM,NOME,CPF,DATA_NASCIMENTO,EMAIL,TELEFONE,SEXO,SALARIO_FIXO) VALUES (?,?,?,?,?,?,?,?)";

        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setInt(1, g.getId_garcom());
        stmt.setString(2,g.getNome());
        stmt.setString(3,g.getCpf());
        stmt.setString(4, g.getDataNascimento());
        stmt.setString(5,g.getEmail());
        stmt.setString(6,g.getTelefone());
        stmt.setString(7, g.getSexo());
        stmt.setFloat(8,g.getSalarioFixo());

        stmt.execute();
        stmt.close();

    }

    public static  Garcom buscarGarcom(String buscaEmail) throws Exception {
        conexao = ConexaoDB.getInstance();

        String sql = "SELECT * FROM GARCOM WHERE EMAIL LIKE ?";

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, buscaEmail);
        ResultSet resultado = stmt.executeQuery();

        Garcom g = null;
        if(resultado.next()) {
            g = new Garcom(resultado.getInt("ID_GARCOM"),resultado.getString("NOME"),resultado.getString("CPF"),
                    resultado.getString("DATA_NASCIMENTO"),resultado.getString("EMAIL"),resultado.getString("TELEFONE"),resultado.getString("SEXO"),
                    resultado.getFloat("SALARIO_FIXO"));
        }
        resultado.close();
        stmt.close();


        return g;
    }


    public static void deletarGarcom(String removerPessoaEmail) throws Exception {
        conexao = ConexaoDB.getInstance();
        String sql = "DELETE FROM GARCOM WHERE EMAIL LIKE ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, removerPessoaEmail);

        stmt.execute();
        stmt.close();

    }

    public static void alterarGarcom(Garcom gAlterar) throws ClassNotFoundException, SQLException {
        conexao = ConexaoDB.getInstance();
        String sql = "UPDATE GARCOM SET NOME = ?,CPF = ?,DATA_NASCIMENTO = ?,EMAIL = ?,TELEFONE = ?,SEXO = ?,SALARIO_FIXO = ? WHERE ID_GARCOM = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setString(1,gAlterar.getNome());
        stmt.setString(2,gAlterar.getCpf());
        stmt.setString(3, gAlterar.getDataNascimento());
        stmt.setString(4,gAlterar.getEmail());
        stmt.setString(5,gAlterar.getTelefone());
        stmt.setString(6, gAlterar.getSexo());
        stmt.setFloat(7,gAlterar.getSalarioFixo());
        stmt.setFloat(8,gAlterar.getId_garcom());

        stmt.execute();
        stmt.close();
    }
    public static void MediaSalario() throws Exception {
        conexao = ConexaoDB.getInstance();

        String sql = "SELECT AVG(SALARIO_FIXO) AS MEDIA FROM GARCOM";

        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet resultado = stmt.executeQuery(sql);

        if(resultado.next()) {
            double mediaSal = resultado.getDouble("MEDIA");
            System.out.println("A média dos salários é de: R$" + Math.round(mediaSal * 100.0) / 100.0);
        }
        resultado.close();
        stmt.close();

    }
}
