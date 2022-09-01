package br.senai.oscamaradinha.controller;

import br.senai.oscamaradinha.model.Post;
import br.senai.oscamaradinha.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/post/list")
    public String findAll(Model model) {
        model.addAttribute("post", postService.findAll());
        return "post/list";
    }

    @GetMapping("/post/add")
    public String add(Model model) {
        model.addAttribute("post", new Post());
        return "post/add";
    }

    @GetMapping("/post/edit/{id}")
    public String edit(Model model, @PathVariable long id) {
        model.addAttribute("post", postService.findById(id));
        return "post/edit";
    }

    @PostMapping("/post/save")
    public String save(Post post, Model model) {
        try {
            postService.save(post);
            model.addAttribute("post", post);
            model.addAttribute("isSaved", true);
            return "post/add";
        } catch (Exception e) {
            model.addAttribute("post", post);
            model.addAttribute("isError", true);
            model.addAttribute("errorMsg", e.getMessage());
            return "post/add";
        }
    }

    @GetMapping("/pots/delete/{id}")
    public String delete(@PathVariable long id) {
        try {
            postService.deleteById(id);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return "redirect:/post/list";
    }
}

