package com.ontrack.api.api.dao;

import jakarta.persistence.*;

@Entity
@Table
public class EventoDeAvaliacao {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;

    private String nome;

    private String data;

    @ManyToOne
    private UnidadeCurricular unidadeCurricular;

    public EventoDeAvaliacao(){

    }

    public EventoDeAvaliacao(long id, String nome, String data, UnidadeCurricular unidadeCurricular) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.unidadeCurricular = unidadeCurricular;
    }

    public EventoDeAvaliacao(String nome, String data, UnidadeCurricular unidadeCurricular) {
        this.nome = nome;
        this.data = data;
        this.unidadeCurricular = unidadeCurricular;
    }

    public EventoDeAvaliacao(String nome, String data) {
        this.nome = nome;
        this.data = data;
    }

}
