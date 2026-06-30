package org.example.lancheriaspring.service;

import org.example.lancheriaspring.dao.UsuarioDAO;
import org.example.lancheriaspring.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public Usuario autenticar(String nome, String senha) {

        try {

            UsuarioDAO dao = new UsuarioDAO();

            return dao.autenticar(nome, senha);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;
    }

}