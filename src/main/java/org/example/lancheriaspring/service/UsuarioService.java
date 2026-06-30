package org.example.lancheriaspring.service;

import org.example.lancheriaspring.dao.UsuarioDAO;
import org.example.lancheriaspring.model.Usuario;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class UsuarioService {

    public ArrayList<Usuario> getUsuarios() throws SQLException {
        return new UsuarioDAO().getUsuarios();
    }

    public boolean inserir(Usuario u) throws SQLException {
        return new UsuarioDAO().inserir(u);
    }

    public boolean excluir(Usuario u) throws SQLException {
        return new UsuarioDAO().excluir(u);
    }

    public boolean atualizar(Usuario u) throws SQLException {
        return new UsuarioDAO().atualizar(u);
    }

    public Usuario getUsuarioPorId(int id) throws SQLException {
        return new UsuarioDAO().getUsuarioPorId(id);
    }
}