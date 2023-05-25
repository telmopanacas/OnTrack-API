package com.ontrack.api.api.controllers;

import com.ontrack.api.api.dao.Avaliacao;
import com.ontrack.api.api.services.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/avaliacao")
public class AvaliacaoController {

    private final AvaliacaoService avaliacaoService;

    @Autowired
    public AvaliacaoController(AvaliacaoService avaliacaoService){
        this.avaliacaoService = avaliacaoService;
    }

    /*
    Endpoint para obter todas as avaliações
     */
    @GetMapping(path = "/list")
    public List<Avaliacao> getEventos(){
        return avaliacaoService.getEventosDeAvaliacao();
    }

    /*
    Endpoint para registar uma nova avaliação
     */
    @PostMapping(path = "/new")
    public void registerNewEvento(@RequestBody Avaliacao avaliacao){
        avaliacaoService.addNewEvento(avaliacao);
    }

    /*
    Endpoint para apagar uma avaliação
     */
    @DeleteMapping(path = "/delete/{evento_id}")
    public void deleteEvento(@PathVariable Long evento_id){
        avaliacaoService.deleteEvento(evento_id);
    }

    /*
    Endpoint para obter uma avaliação em específico
     */
    @GetMapping(path = "/{evento_id}")
    public Avaliacao getEvento(@PathVariable Long evento_id){
        return avaliacaoService.getEventoDeAvaliacao(evento_id);
    }

}
