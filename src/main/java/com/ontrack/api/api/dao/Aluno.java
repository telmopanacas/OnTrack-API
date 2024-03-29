package com.ontrack.api.api.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Aluno {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;

    private String nome;

    private String email;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "aluno_unidade_curricular",
            joinColumns = @JoinColumn(name = "aluno_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "unidade_curricular_id", referencedColumnName = "id")
    )
    @JsonIgnore
    private List<UnidadeCurricular> unidadesCurriculares = new ArrayList<>();

    public Aluno() {
    }

    public Aluno(long id, String nome, String email, Curso curso, List<UnidadeCurricular> unidadesCurriculares) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.curso = curso;
        this.unidadesCurriculares = unidadesCurriculares;
    }

    public Aluno(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Aluno(String nome, String email, Curso curso) {
        this.nome = nome;
        this.email = email;
        this.curso = curso;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<UnidadeCurricular> getUnidadesCurriculares() {
        return unidadesCurriculares;
    }

    public void setUnidadesCurriculares(List<UnidadeCurricular> unidadesCurriculares) {
        this.unidadesCurriculares = unidadesCurriculares;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", curso=" + curso +
                ", unidadesCurriculares=" + unidadesCurriculares +
                '}';
    }
}
