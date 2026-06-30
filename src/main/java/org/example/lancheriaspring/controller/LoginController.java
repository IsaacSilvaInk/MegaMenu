package org.example.lancheriaspring.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.lancheriaspring.model.Usuario;
import org.example.lancheriaspring.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final LoginService loginService = new LoginService();

    @GetMapping("/")
    public String index() {

        return "index";

    }

    @GetMapping("/login")
    public String login() {

        return "index";

    }

    @PostMapping("/login")
    public String autenticar(HttpServletRequest req) {

        String nome = req.getParameter("nome");
        String senha = req.getParameter("senha");

        try {

            Usuario usuario = loginService.autenticar(nome, senha);

            if (usuario != null) {

                req.setAttribute("usuario", usuario);

                return "dashboard";

            } else {

                req.setAttribute(
                        "erro",
                        "USUÁRIO OU SENHA INCORRETOS"
                );

                return "index";
            }

        } catch (Exception e) {

            req.setAttribute(
                    "erro",
                    e.getMessage()
            );

            return "index";
        }
    }

}