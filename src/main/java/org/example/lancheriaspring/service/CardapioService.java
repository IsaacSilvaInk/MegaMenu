package org.example.lancheriaspring.service;

import org.example.lancheriaspring.dao.CardapioDAO;
import org.example.lancheriaspring.model.Cardapio;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class CardapioService {

    public boolean inserir(Cardapio c) throws SQLException {
        return new CardapioDAO().inserir(c);
    }

    public boolean excluir(int codigoCardapio) throws SQLException {
        return new CardapioDAO().excluir(codigoCardapio);
    }

    public ArrayList<Cardapio> getLanchesDaLancheria(int idLancheria) throws SQLException {
        return new CardapioDAO().getLanchesDaLancheria(idLancheria);
    }
}