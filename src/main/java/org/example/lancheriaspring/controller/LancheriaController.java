package org.example.lancheriaspring.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.lancheriaspring.model.Lancheria;
import org.example.lancheriaspring.service.LancheriaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class LancheriaController {

    @PostMapping("/lancheria")
    public String salvar(HttpServletRequest req) {

        String acao = req.getParameter("acao");
        String endereco = req.getParameter("endereco");
        String nome = req.getParameter("nome");

        Lancheria lancheria = new Lancheria(endereco, nome);

        try {

            LancheriaService service = new LancheriaService();

            if ("atualizar".equals(acao)) {

                lancheria.setCodigo(Integer.parseInt(req.getParameter("codigo")));

                if (service.atualizar(lancheria)) {
                    req.setAttribute("retorno", "LANCHERIA ATUALIZADA COM SUCESSO");
                } else {
                    req.setAttribute("retorno", "PROBLEMAS AO ATUALIZAR A LANCHERIA");
                }

            } else {

                if (service.inserir(lancheria)) {
                    req.setAttribute("retorno", "LANCHERIA SALVA COM SUCESSO");
                } else {
                    req.setAttribute("retorno", "PROBLEMAS AO SALVAR A LANCHERIA");
                }

            }

            return listar(req);

        } catch (Exception e) {

            e.printStackTrace();

            req.setAttribute(
                    "erro",
                    "ALGO ACONTECEU, ENTRE EM CONTATO COM O SUPORTE"
            );

            return "lancherias";
        }
    }

    @GetMapping("/lancheria")
    public String listar(HttpServletRequest req) {

        String acao = req.getParameter("acao");
        String codigoStr = req.getParameter("codigo");

        try {

            LancheriaService service = new LancheriaService();

            if ("excluir".equals(acao) && codigoStr != null) {

                Lancheria lancheria = new Lancheria();
                lancheria.setCodigo(Integer.parseInt(codigoStr));

                if (service.excluir(lancheria)) {
                    req.setAttribute("retorno", "LANCHERIA EXCLUÍDA COM SUCESSO");
                } else {
                    req.setAttribute("retorno", "PROBLEMAS AO EXCLUIR A LANCHERIA");
                }

            } else if ("editar".equals(acao) && codigoStr != null) {

                Lancheria lancheria =
                        service.getLancheriaPorId(Integer.parseInt(codigoStr));

                req.setAttribute("lancheria", lancheria);

                return "editar_lancheria";
            }

            ArrayList<Lancheria> listaLancherias = service.getLancherias();

            req.setAttribute("listalancherias", listaLancherias);

        } catch (Exception e) {

            e.printStackTrace();

            req.setAttribute(
                    "erro",
                    "ALGO ACONTECEU, ENTRE EM CONTATO COM O SUPORTE"
            );
        }

        return "lancherias";
    }
}