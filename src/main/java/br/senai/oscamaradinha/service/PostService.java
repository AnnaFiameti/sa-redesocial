package br.senai.oscamaradinha.service;

import br.senai.oscamaradinha.model.Post;

import java.util.List;


public interface PostService {
    public List<Post> findAll();
    Post findById(Long id);
    Post findByNome(String nome);
    Post save(Post post);
    void deleteById(Long id);

}


