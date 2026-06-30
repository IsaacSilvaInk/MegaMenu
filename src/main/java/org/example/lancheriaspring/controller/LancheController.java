package org.example.lancheriaspring.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.lancheriaspring.model.Lanche;
import org.example.lancheriaspring.service.LancheService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class LancheController {

    @PostMapping("/lanche")
    public String salvar(HttpServletRequest req) {

        String acao = req.getParameter("acao");
        String nome = req.getParameter("nome");
        String descricao = req.getParameter("descricao");

        Lanche lanche = new Lanche(nome, descricao);

        try {

            LancheService service = new LancheService();

            if ("atualizar".equals(acao)) {

                lanche.setCodigo(Integer.parseInt(req.getParameter("codigo")));

                if (service.atualizar(lanche)) {
                    req.setAttribute("retorno", "LANCHE ATUALIZADO COM SUCESSO");
                } else {
                    req.setAttribute("retorno", "PROBLEMAS AO ATUALIZAR O LANCHE");
                }

            } else {

                if (service.inserir(lanche)) {
                    req.setAttribute("retorno", "LANCHE SALVO COM SUCESSO");
                } else {
                    req.setAttribute("retorno", "PROBLEMAS AO SALVAR O LANCHE");
                }

            }

            return listar(req);

        } catch (Exception e) {

            e.printStackTrace();

            req.setAttribute(
                    "erro",
                    "ALGO ACONTECEU, ENTRE EM CONTATO COM O SUPORTE"
            );

            return "lanches";
        }
    }

    @GetMapping("/lanche")
    public String listar(HttpServletRequest req) {

        String acao = req.getParameter("acao");
        String codigoStr = req.getParameter("codigo");

        try {

            LancheService service = new LancheService();

            if ("excluir".equals(acao) && codigoStr != null) {

                Lanche lanche = new Lanche();
                lanche.setCodigo(Integer.parseInt(codigoStr));

                if (service.excluir(lanche)) {
                    req.setAttribute("retorno", "LANCHE EXCLUÍDO COM SUCESSO");
                } else {
                    req.setAttribute("retorno", "PROBLEMAS AO EXCLUIR O LANCHE");
                }

            } else if ("editar".equals(acao) && codigoStr != null) {

                Lanche lanche =
                        service.getLanchePorId(Integer.parseInt(codigoStr));

                req.setAttribute("lanche", lanche);

                return "editar_lanche";
            }

            ArrayList<Lanche> listaLanches = service.getLanches();

            req.setAttribute("listalanches", listaLanches);

        } catch (Exception e) {

            e.printStackTrace();

            req.setAttribute(
                    "erro",
                    "ALGO ACONTECEU, ENTRE EM CONTATO COM O SUPORTE"
            );
        }

        return "lanches";
    }

}