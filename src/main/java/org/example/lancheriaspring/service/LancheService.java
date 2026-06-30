package org.example.lancheriaspring.service;

import org.example.lancheriaspring.dao.LancheDAO;
import org.example.lancheriaspring.model.Lanche;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class LancheService {

    public ArrayList<Lanche> getLanches() throws SQLException {
        return new LancheDAO().getLanches();
    }

    public boolean inserir(Lanche l) throws SQLException {
        return new LancheDAO().inserir(l);
    }

    public boolean excluir(Lanche l) throws SQLException {
        return new LancheDAO().excluir(l);
    }

    public boolean atualizar(Lanche l) throws SQLException {
        return new LancheDAO().atualizar(l);
    }

    public Lanche getLanchePorId(int id) throws SQLException {
        return new LancheDAO().getLanchePorId(id);
    }
}