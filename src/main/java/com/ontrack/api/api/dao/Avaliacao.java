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

    private String tipoDeAvaliacao;

    private String metodoDeEntrega;
    private String data;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "unidade_curricular_id")
    private UnidadeCurricular unidadeCurricular;

    public Avaliacao(){

    }

    public Avaliacao(long id, String nome, String tipoDeAvaliacao, String metodoDeEntrega, String data, String descricao, UnidadeCurricular unidadeCurricular) {
        this.id = id;
        this.nome = nome;
        this.tipoDeAvaliacao = tipoDeAvaliacao;
        this.metodoDeEntrega = metodoDeEntrega;
        this.data = data;
        this.descricao = descricao;
        this.unidadeCurricular = unidadeCurricular;
    }

    public Avaliacao(String nome, String tipoDeAvaliacao, String metodoDeEntrega, String data, String descricao, UnidadeCurricular unidadeCurricular) {
        this.nome = nome;
        this.tipoDeAvaliacao = tipoDeAvaliacao;
        this.metodoDeEntrega = metodoDeEntrega;
        this.data = data;
        this.descricao = descricao;
        this.unidadeCurricular = unidadeCurricular;
    }

    public Avaliacao(String nome, String tipoDeAvaliacao, String metodoDeEntrega, String data) {
        this.nome = nome;
        this.tipoDeAvaliacao = tipoDeAvaliacao;
        this.metodoDeEntrega = metodoDeEntrega;
        this.data = data;
    }

    public Avaliacao(String nome, String tipoDeAvaliacao, String metodoDeEntrega, String data, UnidadeCurricular unidadeCurricular) {
        this.nome = nome;
        this.tipoDeAvaliacao = tipoDeAvaliacao;
        this.metodoDeEntrega = metodoDeEntrega;
        this.data = data;
        this.unidadeCurricular = unidadeCurricular;
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

    public String getTipoDeAvaliacao() {
        return tipoDeAvaliacao;
    }

    public void setTipoDeAvaliacao(String tipoDeAvaliacao) {
        this.tipoDeAvaliacao = tipoDeAvaliacao;
    }

    public String getMetodoDeEntrega() {
        return metodoDeEntrega;
    }

    public void setMetodoDeEntrega(String metodoDeEntrega) {
        this.metodoDeEntrega = metodoDeEntrega;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Avaliacao{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipoDeAvaliacao='" + tipoDeAvaliacao + '\'' +
                ", metodoDeEntrega='" + metodoDeEntrega + '\'' +
                ", data='" + data + '\'' +
                ", descricao='" + descricao + '\'' +
                ", unidadeCurricular=" + unidadeCurricular +
                '}';
    }
}
