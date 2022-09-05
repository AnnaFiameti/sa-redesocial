package br.senai.oscamaradinha.service;

import br.senai.oscamaradinha.model.Post;
import br.senai.oscamaradinha.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostServiceimpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public Post findByNome(String nome){
        return null;
    }

    @Override
    public List<Post> findAll() {
        return null;
    }

    @Override
    public Post findById(Long id){
        Post post = postRepository.findById(id).get();
        return post!= null ? post : new Post();
    }

    @Override
    public Post save(Post post){
        try{
            return postRepository.save(post);
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public void deleteById(Long id){
        try{
            postRepository.deleteById(id);
        } catch(Exception e){
            throw  e;
        }
    }
}