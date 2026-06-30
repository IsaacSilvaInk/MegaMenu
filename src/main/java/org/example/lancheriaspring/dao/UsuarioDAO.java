package org.example.lancheriaspring.dao;

import org.example.lancheriaspring.model.Usuario;
import org.example.lancheriaspring.util.ConectaDBPostgres;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Repository
public class UsuarioDAO {

    private static Connection conexao;
    private static Statement stmt;
    private static ResultSet rs;

    public UsuarioDAO() throws SQLException {
        conexao = ConectaDBPostgres.getConexao();
        stmt = conexao.createStatement();
    }

    public Usuario autenticar(String nome, String senha) throws SQLException {

        String sql = "SELECT * FROM usuario " +
                "WHERE nome = '" + nome + "' " +
                "AND senha = '" + senha + "'";

        System.out.println("SQL Login: " + sql);

        rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setCodigo(rs.getInt("codigo"));
            usuario.setNome(rs.getString("nome"));
            usuario.setEmail(rs.getString("email"));
            usuario.setAtivo(rs.getBoolean("ativo"));

            return usuario;
        }

        return null;
    }

    public boolean inserir(Usuario u) throws SQLException {

        String sql = "INSERT INTO usuario(nome, email, senha, ativo) VALUES('" +
                u.getNome() + "','" +
                u.getEmail() + "','" +
                u.getSenha() + "'," +
                u.isAtivo() + ")";

        System.out.println("SQL -> " + sql);

        stmt.execute(sql);

        return true;
    }

    public boolean excluir(Usuario u) throws SQLException {

        String sql = "DELETE FROM usuario WHERE codigo=" + u.getCodigo();

        stmt.execute(sql);

        return true;
    }

    public boolean atualizar(Usuario u) throws SQLException {

        String sql = "UPDATE usuario SET " +
                "nome='" + u.getNome() + "', " +
                "email='" + u.getEmail() + "', " +
                "senha='" + u.getSenha() + "', " +
                "ativo=" + u.isAtivo() +
                " WHERE codigo=" + u.getCodigo();

        stmt.execute(sql);

        return true;
    }

    public ArrayList<Usuario> getUsuariosPorNome(String nome) throws SQLException {

        ArrayList<Usuario> usuarios = new ArrayList<>();

        ResultSet rs = stmt.executeQuery(
                "SELECT * FROM usuario WHERE nome LIKE '%" + nome + "%'");

        while (rs.next()) {

            Usuario usuario = new Usuario();

            usuario.setCodigo(rs.getInt("codigo"));
            usuario.setNome(rs.getString("nome"));
            usuario.setEmail(rs.getString("email"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setAtivo(rs.getBoolean("ativo"));

            usuarios.add(usuario);
        }

        return usuarios;
    }

    public ArrayList<Usuario> getUsuarios() throws SQLException {

        ArrayList<Usuario> usuarios = new ArrayList<>();

        ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");

        while (rs.next()) {

            Usuario usuario = new Usuario();

            usuario.setCodigo(rs.getInt("codigo"));
            usuario.setNome(rs.getString("nome"));
            usuario.setEmail(rs.getString("email"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setAtivo(rs.getBoolean("ativo"));

            usuarios.add(usuario);
        }

        return usuarios;
    }

    public Usuario getUsuarioPorId(int id) throws SQLException {

        Usuario usuario = null;

        String sql = "SELECT * FROM usuario WHERE codigo = " + id;

        ResultSet rs = stmt.executeQuery(sql);

        if (rs.next()) {

            usuario = new Usuario();

            usuario.setCodigo(rs.getInt("codigo"));
            usuario.setNome(rs.getString("nome"));
            usuario.setEmail(rs.getString("email"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setAtivo(rs.getBoolean("ativo"));
        }

        return usuario;
    }
}