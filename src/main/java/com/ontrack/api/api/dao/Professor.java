package com.ontrack.api.api.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Professor {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;
    private String nome;

    private String email;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "professor_unidade_curricular",
            joinColumns = @JoinColumn(name = "professor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "unidade_curricular_id", referencedColumnName = "id")
    )
    @JsonIgnore
    private List<UnidadeCurricular> unidadesCurriculares = new ArrayList<>();

    public Professor() {
    }

    public Professor(long id, String nome, String email, List<UnidadeCurricular> unidadesCurriculares) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.unidadesCurriculares = unidadesCurriculares;
    }

    public Professor(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Professor(String nome, String email, List<UnidadeCurricular> unidadesCurriculares) {
        this.nome = nome;
        this.email = email;
        this.unidadesCurriculares = unidadesCurriculares;
    }

    public Professor(long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
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

    public List<UnidadeCurricular> getUnidadesCurriculares() {
        return unidadesCurriculares;
    }

    public void setUnidadesCurriculares(List<UnidadeCurricular> unidadesCurriculares) {
        this.unidadesCurriculares = unidadesCurriculares;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", unidadesCurriculares=" + unidadesCurriculares +
                '}';
    }
}
