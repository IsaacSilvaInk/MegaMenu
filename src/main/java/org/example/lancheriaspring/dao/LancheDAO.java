package org.example.lancheriaspring.dao;

import org.example.lancheriaspring.model.Lanche;
import org.example.lancheriaspring.util.ConectaDBPostgres;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Repository
public class LancheDAO {

    private static Connection conexao;
    private static Statement stmt;
    private static ResultSet rs;

    public LancheDAO() throws SQLException {
        conexao = ConectaDBPostgres.getConexao();
        stmt = conexao.createStatement();
    }

    public boolean inserir(Lanche l) throws SQLException {

        String sql = "INSERT INTO lanche(nome, descricao) " +
                "VALUES('" + l.getNome() + "','" + l.getDescricao() + "')";

        System.out.println("SQL --> " + sql);

        stmt.execute(sql);

        return true;
    }

    public boolean excluir(Lanche l) throws SQLException {

        String sql = "DELETE FROM lanche WHERE codigo=" + l.getCodigo();

        stmt.execute(sql);

        return true;
    }

    public boolean atualizar(Lanche l) throws SQLException {

        String sql = "UPDATE lanche " +
                "SET nome='" + l.getNome() + "', " +
                "descricao='" + l.getDescricao() + "' " +
                "WHERE codigo=" + l.getCodigo();

        System.out.println("SQL --> " + sql);

        stmt.execute(sql);

        return true;
    }

    public ArrayList<Lanche> getLanchesPorNome(String nome) throws SQLException {

        ArrayList<Lanche> lanches = new ArrayList<>();

        ResultSet rs = stmt.executeQuery(
                "SELECT * FROM lanche WHERE nome LIKE '%" + nome + "%'");

        while (rs.next()) {

            Lanche lanche = new Lanche();

            lanche.setCodigo(rs.getInt("codigo"));
            lanche.setNome(rs.getString("nome"));
            lanche.setDescricao(rs.getString("descricao"));

            lanches.add(lanche);
        }

        return lanches;
    }

    public Lanche getLanchePorId(int id) throws SQLException {

        Lanche lanche = null;

        String sql = "SELECT * FROM lanche WHERE codigo = " + id;

        System.out.println("SQL -> " + sql);

        ResultSet rs = stmt.executeQuery(sql);

        if (rs.next()) {

            lanche = new Lanche();

            lanche.setCodigo(rs.getInt("codigo"));
            lanche.setNome(rs.getString("nome"));
            lanche.setDescricao(rs.getString("descricao"));
        }

        return lanche;
    }

    public ArrayList<Lanche> getLanches() throws SQLException {

        ArrayList<Lanche> lanches = new ArrayList<>();

        ResultSet rs = stmt.executeQuery("SELECT * FROM lanche");

        while (rs.next()) {

            Lanche lanche = new Lanche();

            lanche.setCodigo(rs.getInt("codigo"));
            lanche.setNome(rs.getString("nome"));
            lanche.setDescricao(rs.getString("descricao"));

            lanches.add(lanche);
        }

        return lanches;
    }
}