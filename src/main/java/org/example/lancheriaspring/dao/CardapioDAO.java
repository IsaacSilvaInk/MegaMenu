package org.example.lancheriaspring.dao;

import org.example.lancheriaspring.model.Cardapio;
import org.example.lancheriaspring.model.Lanche;
import org.example.lancheriaspring.util.ConectaDBPostgres;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Repository
public class CardapioDAO {

    private static Connection conexao;
    private static Statement stmt;

    public CardapioDAO() throws SQLException {
        conexao = ConectaDBPostgres.getConexao();
        stmt = conexao.createStatement();
    }

    public boolean inserir(Cardapio c) throws SQLException {
        String sql = "INSERT INTO cardapio(codigo_lancheria, codigo_lanche, preco) " +
                "VALUES(" + c.getLancheria().getCodigo() + ", " +
                c.getLanche().getCodigo() + ", " + c.getPreco() + ")";
        stmt.execute(sql);
        return true;
    }

    public boolean excluir(int codigoCardapio) throws SQLException {
        String sql = "DELETE FROM cardapio WHERE codigo=" + codigoCardapio;
        stmt.execute(sql);
        return true;
    }

    public ArrayList<Cardapio> getLanchesDaLancheria(int idLancheria) throws SQLException {
        ArrayList<Cardapio> cardapios = new ArrayList<>();

        String sql = "SELECT c.codigo as cod_cardapio, c.preco, l.codigo as cod_lanche, l.nome, l.descricao " +
                "FROM cardapio c " +
                "INNER JOIN lanche l ON c.codigo_lanche = l.codigo " +
                "WHERE c.codigo_lancheria = " + idLancheria;

        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Lanche lanche = new Lanche();
            lanche.setCodigo(rs.getInt("cod_lanche"));
            lanche.setNome(rs.getString("nome"));
            lanche.setDescricao(rs.getString("descricao"));

            Cardapio cardapio = new Cardapio();
            cardapio.setCodigo(rs.getInt("cod_cardapio"));
            cardapio.setPreco(rs.getDouble("preco"));
            cardapio.setLanche(lanche);

            cardapios.add(cardapio);
        }
        return cardapios;
    }
}
