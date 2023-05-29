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
    public List<Avaliacao> getAvaliacoes(){
        return avaliacaoService.getAvaliacoes();
    }

    /*
    Endpoint para registar uma nova avaliação
     */
    @PostMapping(path = "/new")
    public void registerNewAvaliacao(@RequestBody Avaliacao avaliacao){
        avaliacaoService.addNewAvaliacao(avaliacao);
    }

    /*
    Endpoint para apagar uma avaliação
     */
    @DeleteMapping(path = "/delete/{avaliacao_id}")
    public void deleteAvaliacao(@PathVariable Long avaliacao_id){
        avaliacaoService.deleteAvaliacao(avaliacao_id);
    }

    /*
    Endpoint para obter uma avaliação em específico
     */
    @GetMapping(path = "/{avaliacao_id}")
    public Avaliacao getAvaliacao(@PathVariable Long avaliacao_id){
        return avaliacaoService.getAvaliacao(avaliacao_id);
    }

    /*
    Endpoint para atualizar uma avaliação
     */
    @PutMapping(path = "{avaliacao_id}")
    public void updateAvaliacao(
            @PathVariable("avaliacao_id") Long avaliacao_id,
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String tipoDeAvaliacao,
            @RequestParam(required = false) String metodoDeEntrega,
            @RequestParam(required = false) String data,
            @RequestParam(required = false) String descricao,
            @RequestParam(required = false) Long unidadeCurricularId
    ) {
        avaliacaoService.updateAvaliacao(avaliacao_id, nome, tipoDeAvaliacao, metodoDeEntrega, data, descricao, unidadeCurricularId);
    }

}
