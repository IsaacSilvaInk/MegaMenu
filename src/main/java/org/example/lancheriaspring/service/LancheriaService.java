package org.example.lancheriaspring.service;

import org.example.lancheriaspring.dao.LancheriaDAO;
import org.example.lancheriaspring.model.Lancheria;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class LancheriaService {

    public ArrayList<Lancheria> getLancherias() throws SQLException {
        return new LancheriaDAO().getLancherias();
    }

    public boolean inserir(Lancheria lan) throws SQLException {
        return new LancheriaDAO().inserir(lan);
    }

    public boolean excluir(Lancheria lan) throws SQLException {
        return new LancheriaDAO().excluir(lan);
    }

    public boolean atualizar(Lancheria lan) throws SQLException {
        return new LancheriaDAO().atualizar(lan);
    }

    public Lancheria getLancheriaPorId(int id) throws SQLException {
        return new LancheriaDAO().getLancheriaPorId(id);
    }
}