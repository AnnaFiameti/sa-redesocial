package br.senai.oscamaradinha.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity (name = "post")
public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    @Size(max = 100)
    @NotNull
    private String nome;
    @Size(max = 15)
    private String professor;
    @Size(max = 100)
    private Date dataAtividade;
    @Size(max = 30)
    private String descricao;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getProfessor() {
        return professor;
    }
    public void setProfessor(String professor) {
        this.professor = professor;
    }
    public Date getDataAtividade() {
        return dataAtividade;
    }
    public void setDataAtividade(Date dataAtividade) {
        this.dataAtividade = dataAtividade;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Post:" +
                "Id: " + id +
                "Nome: " + nome +
                "Professor: " + professor +
                "DataAtividade: " + dataAtividade +
                "Descricao: " + descricao;
    }
}