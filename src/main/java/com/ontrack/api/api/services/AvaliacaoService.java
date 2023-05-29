package com.ontrack.api.api.services;

import com.ontrack.api.api.dao.Avaliacao;
import com.ontrack.api.api.dao.UnidadeCurricular;
import com.ontrack.api.api.repositories.AvaliacaoRepository;
import com.ontrack.api.api.repositories.UnidadeCurricularRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;

    private final UnidadeCurricularRepository unidadeCurricularRepository;


    @Autowired
    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository, UnidadeCurricularRepository unidadeCurricularRepository){
        this.avaliacaoRepository = avaliacaoRepository;
        this.unidadeCurricularRepository = unidadeCurricularRepository;
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

    /*
    Função para atualizar um evento de avaliação
    Usa o identificador @Transactional para podermos usar os getters e setters do objeto
     */
    @Transactional
    public void updateAvaliacao(Long avaliacaoId, String nome, String tipoDeAvaliacao, String metodoDeEntrega, String data, String descricao, Long unidadeCurricularId) {
        Avaliacao avaliacao = avaliacaoRepository.findById(avaliacaoId).orElseThrow(null);
        if(avaliacao == null) {
            throw new IllegalStateException("Avaliação com id " + avaliacaoId + " não existe");
        }

        if (nome != null && nome.length() > 0 && !nome.equals(avaliacao.getNome())){
            avaliacao.setNome(nome);
        }

        if (tipoDeAvaliacao != null && tipoDeAvaliacao.length() > 0 && !tipoDeAvaliacao.equals(avaliacao.getTipoDeAvaliacao())){
            avaliacao.setTipoDeAvaliacao(tipoDeAvaliacao);
        }

        if (metodoDeEntrega != null && metodoDeEntrega.length() > 0 && !metodoDeEntrega.equals(avaliacao.getMetodoDeEntrega())){
            avaliacao.setMetodoDeEntrega(metodoDeEntrega);
        }

        if (data != null && data.length() > 0 && !data.equals(avaliacao.getData())){
            avaliacao.setData(data);
        }

        if (descricao != null && descricao.length() > 0 && !descricao.equals(avaliacao.getDescricao())){
            avaliacao.setDescricao(descricao);
        }

        if (unidadeCurricularId != null && unidadeCurricularId != avaliacao.getUnidadeCurricular().getId()){
            UnidadeCurricular unidadeCurricular = unidadeCurricularRepository.findById(unidadeCurricularId).orElseThrow(null);
            if (unidadeCurricular == null){
                throw new IllegalStateException("Unidade curricular com id " + unidadeCurricularId + " não existe");
            }
            avaliacao.setUnidadeCurricular(unidadeCurricular);
        }

        avaliacaoRepository.save(avaliacao);
    }
}
