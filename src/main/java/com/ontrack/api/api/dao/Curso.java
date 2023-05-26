package com.ontrack.api.api.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Curso {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    private String nome;

    private String codigo;

    @OneToMany
    @JoinColumn(name = "curso_id")
    @JsonIgnore
    private List<Aluno> alunos = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "curso_id")
    @JsonIgnore
    private List<UnidadeCurricular> unidadesCurriculares = new ArrayList<>();

    public Curso() {
    }

    public Curso(Long id, String nome, String codigo, List<Aluno> alunos, List<UnidadeCurricular> unidadesCurriculares) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.alunos = alunos;
        this.unidadesCurriculares = unidadesCurriculares;
    }

    public Curso(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public Curso(Long id, String nome, String codigo) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
    }

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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<UnidadeCurricular> getUnidadesCurriculares() {
        return unidadesCurriculares;
    }

    public void setUnidadesCurriculares(List<UnidadeCurricular> unidadesCurriculares) {
        this.unidadesCurriculares = unidadesCurriculares;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", codigo='" + codigo + '\'' +
                ", alunos=" + alunos +
                ", unidadesCurriculares=" + unidadesCurriculares +
                '}';
    }
}
