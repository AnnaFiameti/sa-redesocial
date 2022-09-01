package br.senai.oscamaradinha.service;

import br.senai.oscamaradinha.model.Post;


public interface PostService {
    Post findById(Long id);
    Post findByNome(String nome);
    Post save(Post post);
    void deleteById(Long id);
}

