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
    private int ects;
    private int ano;
    private int semestre;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "ano_letivo_id")
    private AnoLetivo anoLetivo;

    /*
    Para relações ManyToMany, este video pode ser útil:
    https://youtu.be/jCYonZey5dY?t=264
     */

    @ManyToMany(mappedBy = "unidadesCurriculares", fetch = FetchType.LAZY)
    private List<Professor> professores = new ArrayList<>();

    @ManyToMany(mappedBy = "unidadesCurriculares", fetch = FetchType.LAZY)
    private List<Aluno> alunos = new ArrayList<>();

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "unidade_curricular_id")
    private List<Avaliacao> avaliacoes = new ArrayList<>();


    public UnidadeCurricular() {
    }


    public UnidadeCurricular(long id, String nome, String codigo, String descricao, int ects, int ano, int semestre, Curso curso, AnoLetivo anoLetivo, List<Professor> professores, List<Aluno> alunos, List<Avaliacao> avaliacoes) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.descricao = descricao;
        this.ects = ects;
        this.ano = ano;
        this.semestre = semestre;
        this.curso = curso;
        this.anoLetivo = anoLetivo;
        this.professores = professores;
        this.alunos = alunos;
        this.avaliacoes = avaliacoes;
    }


    public UnidadeCurricular(String nome, String codigo, String descricao, int ects, int ano, int semestre, Curso curso, AnoLetivo anoLetivo) {
        this.nome = nome;
        this.codigo = codigo;
        this.descricao = descricao;
        this.ects = ects;
        this.ano = ano;
        this.semestre = semestre;
        this.curso = curso;
        this.anoLetivo = anoLetivo;
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

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
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

    public AnoLetivo getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(AnoLetivo anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
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
                ", ects=" + ects +
                ", ano=" + ano +
                ", semestre=" + semestre +
                ", curso=" + curso +
                ", anoLetivo=" + anoLetivo +
                ", professores=" + professores +
                ", alunos=" + alunos +
                ", avaliacoes=" + avaliacoes +
                '}';
    }
}
