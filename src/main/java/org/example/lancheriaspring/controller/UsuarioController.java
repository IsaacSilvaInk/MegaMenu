package org.example.lancheriaspring.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.lancheriaspring.model.Usuario;
import org.example.lancheriaspring.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class UsuarioController{

    @PostMapping("/usuario")
    public String salvar(HttpServletRequest req) {

        String acao = req.getParameter("acao");
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        String ativoParam = req.getParameter("ativo");
        boolean ativo = ativoParam != null &&
                (ativoParam.equals("on") || ativoParam.equals("true"));

        Usuario u = new Usuario(nome, senha, email, ativo);

        try {

            UsuarioService service = new UsuarioService();

            if ("atualizar".equals(acao)) {

                u.setCodigo(Integer.parseInt(req.getParameter("codigo")));

                if (service.atualizar(u)) {
                    req.setAttribute("retorno", "USUÁRIO ATUALIZADO COM SUCESSO");
                } else {
                    req.setAttribute("retorno", "PROBLEMAS AO ATUALIZAR O USUÁRIO");
                }

            } else {

                u.setAtivo(true);

                if (service.inserir(u)) {
                    req.setAttribute("retorno", "USUÁRIO SALVO COM SUCESSO");
                } else {
                    req.setAttribute("retorno", "PROBLEMAS AO SALVAR O USUÁRIO");
                }
            }

            return listar(req);

        } catch (Exception e) {

            e.printStackTrace();

            req.setAttribute(
                    "erro",
                    "ALGO ACONTECEU, ENTRE EM CONTATO COM O SUPORTE"
            );

            return "usuarios";
        }
    }

    @GetMapping("/usuario")
    public String listar(HttpServletRequest req) {

        String acao = req.getParameter("acao");
        String codigoStr = req.getParameter("codigo");

        try {

            UsuarioService service = new UsuarioService();

            if ("excluir".equals(acao) && codigoStr != null) {

                Usuario usuario = new Usuario();
                usuario.setCodigo(Integer.parseInt(codigoStr));

                if (service.excluir(usuario)) {
                    req.setAttribute("retorno", "USUÁRIO EXCLUÍDO COM SUCESSO");
                } else {
                    req.setAttribute("retorno", "PROBLEMAS AO EXCLUIR O USUÁRIO");
                }

            } else if ("editar".equals(acao) && codigoStr != null) {

                Usuario usuario =
                        service.getUsuarioPorId(Integer.parseInt(codigoStr));

                req.setAttribute("usuario", usuario);

                return "editar_usuario";
            }

            ArrayList<Usuario> listaUsuarios = service.getUsuarios();

            req.setAttribute("listausuarios", listaUsuarios);

        } catch (Exception e) {

            e.printStackTrace();

            req.setAttribute(
                    "erro",
                    "ALGO ACONTECEU, ENTRE EM CONTATO COM O SUPORTE"
            );
        }

        return "usuarios";
    }

}