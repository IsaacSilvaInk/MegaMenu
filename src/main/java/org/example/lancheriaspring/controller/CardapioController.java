package org.example.lancheriaspring.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.lancheriaspring.model.Cardapio;
import org.example.lancheriaspring.model.Lanche;
import org.example.lancheriaspring.model.Lancheria;
import org.example.lancheriaspring.service.CardapioService;
import org.example.lancheriaspring.service.LancheService;
import org.example.lancheriaspring.service.LancheriaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class CardapioController {

    @PostMapping("/cardapio")
    public String salvar(HttpServletRequest req, HttpServletResponse resp) {

        String lancheriaIdStr = req.getParameter("codigo_lancheria");
        String lancheIdStr = req.getParameter("codigo_lanche");
        String precoStr = req.getParameter("preco");

        try {

            if (lancheriaIdStr != null &&
                    lancheIdStr != null &&
                    precoStr != null) {

                int lancheriaId = Integer.parseInt(lancheriaIdStr);
                int lancheId = Integer.parseInt(lancheIdStr);

                double preco =
                        Double.parseDouble(precoStr.replace(",", "."));

                Lancheria lancheria = new Lancheria();
                lancheria.setCodigo(lancheriaId);

                Lanche lanche = new Lanche();
                lanche.setCodigo(lancheId);

                Cardapio cardapio =
                        new Cardapio(lanche, lancheria, preco);

                CardapioService service = new CardapioService();

                if (service.inserir(cardapio)) {

                    req.setAttribute(
                            "retorno",
                            "LANCHE ADICIONADO AO CARDÁPIO COM SUCESSO"
                    );

                } else {

                    req.setAttribute(
                            "retorno",
                            "PROBLEMAS AO ADICIONAR AO CARDÁPIO"
                    );
                }
            }

            return "redirect:/cardapio?codigo_lancheria=" + lancheriaIdStr;

        } catch (Exception e) {

            e.printStackTrace();

            req.setAttribute(
                    "erro",
                    "ALGO ACONTECEU, ENTRE EM CONTATO COM O SUPORTE"
            );

            return "cardapio";
        }
    }

    @GetMapping("/cardapio")
    public String listar(HttpServletRequest req) {

        String acao = req.getParameter("acao");
        String codigoCardapioStr =
                req.getParameter("codigo_cardapio");
        String codigoLancheriaStr =
                req.getParameter("codigo_lancheria");

        try {

            CardapioService cardapioService =
                    new CardapioService();

            if ("excluir".equals(acao) &&
                    codigoCardapioStr != null) {

                if (cardapioService.excluir(
                        Integer.parseInt(codigoCardapioStr))) {

                    req.setAttribute(
                            "retorno",
                            "ITEM REMOVIDO DO CARDÁPIO COM SUCESSO"
                    );

                } else {

                    req.setAttribute(
                            "retorno",
                            "PROBLEMAS AO REMOVER ITEM DO CARDÁPIO"
                    );
                }
            }

            if (codigoLancheriaStr != null &&
                    !codigoLancheriaStr.isEmpty()) {

                int idLancheria =
                        Integer.parseInt(codigoLancheriaStr);

                Lancheria lancheria =
                        new LancheriaService()
                                .getLancheriaPorId(idLancheria);

                req.setAttribute(
                        "lancheria",
                        lancheria
                );

                ArrayList<Cardapio> listaCardapio =
                        cardapioService
                                .getLanchesDaLancheria(idLancheria);

                req.setAttribute(
                        "listaCardapio",
                        listaCardapio
                );

                ArrayList<Lanche> todosLanches =
                        new LancheService().getLanches();

                req.setAttribute(
                        "todosLanches",
                        todosLanches
                );
            }

        } catch (Exception e) {

            e.printStackTrace();

            req.setAttribute(
                    "erro",
                    "ALGO ACONTECEU, ENTRE EM CONTATO COM O SUPORTE"
            );
        }

        return "cardapio";
    }
}