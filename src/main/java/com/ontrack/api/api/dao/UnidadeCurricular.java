package com.ontrack.api.api.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class UnidadeCurricular {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;
    private String nome;
    private String codigo;
    private String descricao;

    private int ano;

    private int semestre;

    /*
    Para relações ManyToMany, este video pode ser útil:
    https://youtu.be/jCYonZey5dY?t=264
     */
    @JsonBackReference
    @ManyToMany(mappedBy = "unidadesCurriculares", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Professor> professores = new ArrayList<>();

    @ManyToMany(mappedBy = "unidadesCurriculares", fetch = FetchType.LAZY)
    @JsonBackReference
    @JsonIgnore
    private List<Aluno> alunos = new ArrayList<>();

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "unidade_curricular_id")
    private List<Avaliacao> avaliacoes = new ArrayList<>();


    public UnidadeCurricular() {
    }

    public UnidadeCurricular(long id, String nome, String codigo, String descricao, int ano, int semestre, List<Professor> professores, List<Aluno> alunos, List<Avaliacao> avaliacoes) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.descricao = descricao;
        this.ano = ano;
        this.semestre = semestre;
        this.professores = professores;
        this.alunos = alunos;
        this.avaliacoes = avaliacoes;
    }


    public UnidadeCurricular(String nome, String codigo, String descricao, int ano, int semestre) {
        this.nome = nome;
        this.codigo = codigo;
        this.descricao = descricao;
        this.ano = ano;
        this.semestre = semestre;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    @Override
    public String toString() {
        return "UnidadeCurricular{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", codigo='" + codigo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", ano=" + ano +
                ", semestre=" + semestre +
                ", professores=" + professores +
                ", alunos=" + alunos +
                ", avaliacoes=" + avaliacoes +
                '}';
    }
}
