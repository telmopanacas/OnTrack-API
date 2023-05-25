package com.ontrack.api.api.dao;

import jakarta.persistence.*;

@Entity
@Table
public class Avaliacao {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;

    private String nome;

    private String data;

    @ManyToOne
    @JoinColumn(name = "unidade_curricular_id")
    private UnidadeCurricular unidadeCurricular;

    public Avaliacao(){

    }

    public Avaliacao(long id, String nome, String data, UnidadeCurricular unidadeCurricular) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.unidadeCurricular = unidadeCurricular;
    }

    public Avaliacao(String nome, String data, UnidadeCurricular unidadeCurricular) {
        this.nome = nome;
        this.data = data;
        this.unidadeCurricular = unidadeCurricular;
    }

    public Avaliacao(String nome, String data) {
        this.nome = nome;
        this.data = data;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public UnidadeCurricular getUnidadeCurricular() {
        return unidadeCurricular;
    }

    public void setUnidadeCurricular(UnidadeCurricular unidadeCurricular) {
        this.unidadeCurricular = unidadeCurricular;
    }

    @Override
    public String toString() {
        return "Avaliacao{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", data='" + data + '\'' +
                ", unidadeCurricular=" + unidadeCurricular +
                '}';
    }
}
