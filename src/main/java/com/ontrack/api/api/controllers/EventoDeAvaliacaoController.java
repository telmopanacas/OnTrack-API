package com.ontrack.api.api.controllers;

import com.ontrack.api.api.dao.EventoDeAvaliacao;
import com.ontrack.api.api.services.EventoDeAvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/evento_de_avaliacao")
public class EventoDeAvaliacaoController {

    private final EventoDeAvaliacaoService eventoDeAvaliacaoService;

    @Autowired
    public EventoDeAvaliacaoController(EventoDeAvaliacaoService eventoDeAvaliacaoService){
        this.eventoDeAvaliacaoService = eventoDeAvaliacaoService;
    }

    /*
    Endpoint para obter todos os eventos de avaliação
     */
    @GetMapping(path = "/list")
    public List<EventoDeAvaliacao> getEventos(){
        return eventoDeAvaliacaoService.getEventosDeAvaliacao();
    }

    /*
    Endpoint para registar um novo evento de avaliação
     */
    @PostMapping(path = "/new")
    public void registerNewEvento(@RequestBody EventoDeAvaliacao eventoDeAvaliacao){
        eventoDeAvaliacaoService.addNewEvento(eventoDeAvaliacao);
    }

    /*
    Endpoint para apagar um evento
     */
    @DeleteMapping(path = "/delete/{evento_id}")
    public void deleteEvento(@PathVariable Long evento_id){
        eventoDeAvaliacaoService.deleteEvento(evento_id);
    }

    /*
    Endpoint para obter um aluno especifico
     */
    @GetMapping(path = "/{evento_id}")
    public EventoDeAvaliacao getEvento(@PathVariable Long evento_id){
        return eventoDeAvaliacaoService.getEventoDeAvaliacao(evento_id);
    }

}
