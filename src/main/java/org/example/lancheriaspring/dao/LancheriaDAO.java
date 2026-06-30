package org.example.lancheriaspring.dao;

import org.example.lancheriaspring.model.Lancheria;
import org.example.lancheriaspring.util.ConectaDBPostgres;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Repository
public class LancheriaDAO {

    private static Connection conexao;
    private static Statement stmt;
    private static ResultSet rs;

    public LancheriaDAO() throws SQLException {
        conexao = ConectaDBPostgres.getConexao();
        stmt = conexao.createStatement();
    }

    public boolean inserir(Lancheria lan) throws SQLException {

        String sql = "INSERT INTO lancheria(endereco, nome) " +
                "VALUES('" + lan.getEndereco() + "','" + lan.getNome() + "')";

        System.out.println("SQL --> " + sql);

        stmt.execute(sql);

        return true;
    }

    public boolean excluir(Lancheria lan) throws SQLException {

        String sql = "DELETE FROM lancheria WHERE codigo=" + lan.getCodigo();

        stmt.execute(sql);

        return true;
    }

    public boolean atualizar(Lancheria lan) throws SQLException {

        String sql = "UPDATE lancheria " +
                "SET endereco='" + lan.getEndereco() + "', " +
                "nome='" + lan.getNome() + "' " +
                "WHERE codigo=" + lan.getCodigo();

        System.out.println("SQL --> " + sql);

        stmt.execute(sql);

        return true;
    }

    public ArrayList<Lancheria> getLancheriasPorNome(String nome) throws SQLException {

        ArrayList<Lancheria> lancherias = new ArrayList<>();

        ResultSet rs = stmt.executeQuery(
                "SELECT * FROM lancheria WHERE nome LIKE '%" + nome + "%'");

        while (rs.next()) {

            Lancheria lancheria = new Lancheria();

            lancheria.setCodigo(rs.getInt("codigo"));
            lancheria.setEndereco(rs.getString("endereco"));
            lancheria.setNome(rs.getString("nome"));

            lancherias.add(lancheria);
        }

        return lancherias;
    }

    public Lancheria getLancheriaPorId(int id) throws SQLException {

        Lancheria lancheria = null;

        String sql = "SELECT * FROM lancheria WHERE codigo = " + id;

        System.out.println("SQL -> " + sql);

        ResultSet rs = stmt.executeQuery(sql);

        if (rs.next()) {

            lancheria = new Lancheria();

            lancheria.setCodigo(rs.getInt("codigo"));
            lancheria.setEndereco(rs.getString("endereco"));
            lancheria.setNome(rs.getString("nome"));
        }

        return lancheria;
    }

    public ArrayList<Lancheria> getLancherias() throws SQLException {

        ArrayList<Lancheria> lancherias = new ArrayList<>();

        ResultSet rs = stmt.executeQuery("SELECT * FROM lancheria");

        while (rs.next()) {

            Lancheria lancheria = new Lancheria();

            lancheria.setCodigo(rs.getInt("codigo"));
            lancheria.setEndereco(rs.getString("endereco"));
            lancheria.setNome(rs.getString("nome"));

            lancherias.add(lancheria);
        }

        return lancherias;
    }
}