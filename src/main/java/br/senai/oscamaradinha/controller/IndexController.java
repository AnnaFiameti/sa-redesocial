package br.senai.oscamaradinha.controller;

import antlr.ASTFactory;
import br.senai.oscamaradinha.model.Usuario;
import br.senai.oscamaradinha.service.PostService;
import br.senai.oscamaradinha.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/sobre")
    public String sobre(){
        return "sobre";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/cadastrar")
    public String cadastrar() {
        return "cadastrar";
    }

    @PostMapping("/cadastrar")
    public String save(Usuario usuario, Model model) {
        UsuarioService.create(usuario);
        model.addAttribute("usuario", usuario);
        model.addAttribute("isSaved", true);
        return "login";
    }
}

