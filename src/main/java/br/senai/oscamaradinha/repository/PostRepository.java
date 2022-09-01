package br.senai.oscamaradinha.repository;

import br.senai.oscamaradinha.model.Post;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

@Registered
public interface PostRepository extends JpaRepository<Post, Long> {
    public Post findByProfessor(String professor);
    public Post findByNome (String nome);
    public Post findByDataAtividade(Date dataAtividade);
    public Post findByDescricao (String descricao);
}
