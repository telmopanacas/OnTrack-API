package com.ontrack.api.api.controllers;

import com.ontrack.api.api.dao.Avaliacao;
import com.ontrack.api.api.services.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/evento_de_avaliacao")
public class AvaliacaoController {

    private final AvaliacaoService avaliacaoService;

    @Autowired
    public AvaliacaoController(AvaliacaoService avaliacaoService){
        this.avaliacaoService = avaliacaoService;
    }

    /*
    Endpoint para obter todos os eventos de avaliação
     */
    @GetMapping(path = "/list")
    public List<Avaliacao> getEventos(){
        return avaliacaoService.getEventosDeAvaliacao();
    }

    /*
    Endpoint para registar um novo evento de avaliação
     */
    @PostMapping(path = "/new")
    public void registerNewEvento(@RequestBody Avaliacao avaliacao){
        avaliacaoService.addNewEvento(avaliacao);
    }

    /*
    Endpoint para apagar um evento
     */
    @DeleteMapping(path = "/delete/{evento_id}")
    public void deleteEvento(@PathVariable Long evento_id){
        avaliacaoService.deleteEvento(evento_id);
    }

    /*
    Endpoint para obter um aluno especifico
     */
    @GetMapping(path = "/{evento_id}")
    public Avaliacao getEvento(@PathVariable Long evento_id){
        return avaliacaoService.getEventoDeAvaliacao(evento_id);
    }

}
