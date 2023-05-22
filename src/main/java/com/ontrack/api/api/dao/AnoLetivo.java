package com.ontrack.api.api.dao;

import jakarta.persistence.*;

@Entity
@Table
public class AnoLetivo {
    @Id
    @SequenceGenerator(
            name = "ano_letivo_sequence",
            sequenceName = "ano_letivo_sequence",
            allocationSize = 1 // increment by 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ano_letivo_sequence"
    )
    private Long id;

    private String ano;

    public AnoLetivo() {
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

    @Override
    public String toString() {
        return "AnoLetivo{" +
                "id=" + id +
                ", ano='" + ano + '\'' +
                '}';
    }
}
