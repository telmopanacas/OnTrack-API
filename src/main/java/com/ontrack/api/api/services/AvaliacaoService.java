package com.ontrack.api.api.services;

import com.ontrack.api.api.dao.Avaliacao;
import com.ontrack.api.api.repositories.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;


    @Autowired
    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository){
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public List<Avaliacao> getAvaliacoes(){
        return avaliacaoRepository.findAll();
    }

    public void addNewAvaliacao(Avaliacao avaliacao){
        avaliacaoRepository.save(avaliacao);
    }

    public void deleteAvaliacao(Long eventoId){
        boolean exists = avaliacaoRepository.existsById(eventoId);
        if (!exists){
            throw new IllegalStateException("Evento de avaliação "+ eventoId + " não existe");
        }
        avaliacaoRepository.deleteById(eventoId);
    }


    public Avaliacao getAvaliacao(Long eventoId){
        Avaliacao avaliacao = avaliacaoRepository.findById(eventoId).orElseThrow(null);
        if (avaliacao == null){
            throw new IllegalStateException("Evento de avaliação com id " + eventoId + " não existe");
        }
        return avaliacao;
    }


}
