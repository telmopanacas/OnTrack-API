package com.ontrack.api.api.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class AnoLetivo {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    private String ano;

    @OneToMany
    @JoinColumn(name = "ano_letivo_id")
    @JsonIgnore
    private List<UnidadeCurricular> unidadesCurriculares = new ArrayList<>();

    public AnoLetivo() {
    }


    public AnoLetivo(Long id, String ano, List<UnidadeCurricular> unidadesCurriculares) {
        this.id = id;
        this.ano = ano;
        this.unidadesCurriculares = unidadesCurriculares;
    }

    public AnoLetivo(Long id, String ano) {
        this.id = id;
        this.ano = ano;
    }

    public AnoLetivo(String ano) {
        this.ano = ano;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public List<UnidadeCurricular> getUnidadesCurriculares() {
        return unidadesCurriculares;
    }

    public void setUnidadesCurriculares(List<UnidadeCurricular> unidadesCurriculares) {
        this.unidadesCurriculares = unidadesCurriculares;
    }

    @Override
    public String toString() {
        return "AnoLetivo{" +
                "id=" + id +
                ", ano='" + ano + '\'' +
                ", unidadesCurriculares=" + unidadesCurriculares +
                '}';
    }
}
