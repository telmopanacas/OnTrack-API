package com.ontrack.api.api.services;

import com.ontrack.api.api.dao.Aluno;
import com.ontrack.api.api.dao.EventoDeAvaliacao;
import com.ontrack.api.api.dao.UnidadeCurricular;
import com.ontrack.api.api.repositories.EventoDeAvaliacaoRepository;
import com.ontrack.api.api.repositories.UnidadeCurricularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoDeAvaliacaoService {

    private final EventoDeAvaliacaoRepository eventoDeAvaliacaoRepository;


    @Autowired
    public EventoDeAvaliacaoService(EventoDeAvaliacaoRepository eventoDeAvaliacaoRepository){
        this.eventoDeAvaliacaoRepository = eventoDeAvaliacaoRepository;
    }

    public List<EventoDeAvaliacao> getEventosDeAvaliacao(){
        return eventoDeAvaliacaoRepository.findAll();
    }

    public void addNewEvento(EventoDeAvaliacao eventoDeAvaliacao){
        eventoDeAvaliacaoRepository.save(eventoDeAvaliacao);
    }

    public void deleteEvento(Long eventoId){
        boolean exists = eventoDeAvaliacaoRepository.existsById(eventoId);
        if (!exists){
            throw new IllegalStateException("Evento de avaliação "+ eventoId + " não existe");
        }
        eventoDeAvaliacaoRepository.deleteById(eventoId);
    }


    public EventoDeAvaliacao getEventoDeAvaliacao(Long eventoId){
        EventoDeAvaliacao eventoDeAvaliacao = eventoDeAvaliacaoRepository.findById(eventoId).orElseThrow(null);
        if (eventoDeAvaliacao == null){
            throw new IllegalStateException("Evento de avaliação com id " + eventoId + " não existe");
        }
        return eventoDeAvaliacao;
    }


}
