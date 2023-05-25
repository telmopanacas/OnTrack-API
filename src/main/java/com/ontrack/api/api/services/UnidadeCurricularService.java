package com.ontrack.api.api.services;

import com.ontrack.api.api.dao.Aluno;
import com.ontrack.api.api.dao.Avaliacao;
import com.ontrack.api.api.dao.Professor;
import com.ontrack.api.api.dao.UnidadeCurricular;
import com.ontrack.api.api.repositories.AvaliacaoRepository;
import com.ontrack.api.api.repositories.UnidadeCurricularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeCurricularService {

    private final UnidadeCurricularRepository unidadeCurricularRepository;
    private final AvaliacaoRepository avaliacaoRepository;


    @Autowired
    public UnidadeCurricularService(UnidadeCurricularRepository unidadeCurricularRepository, AvaliacaoRepository avaliacaoRepository) {
        this.unidadeCurricularRepository = unidadeCurricularRepository;
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public List<UnidadeCurricular> getUnidadesCurriculares() {
        return unidadeCurricularRepository.findAll();
    }

    public void addNewUnidadeCurricular(UnidadeCurricular unidadeCurricular) {
        unidadeCurricularRepository.save(unidadeCurricular);
    }

    public void deleteUnidadeCurricular(Long unidadeCurricularId) {
        boolean exists = unidadeCurricularRepository.existsById(unidadeCurricularId);
        if (!exists) {
            throw new IllegalStateException("Unidade Curricular com id " + unidadeCurricularId + " não existe");
        }
        unidadeCurricularRepository.deleteById(unidadeCurricularId);
    }


    public UnidadeCurricular getUnidadeCurricular(Long unidadeCurricularId) {
        UnidadeCurricular unidadeCurricular = unidadeCurricularRepository.findById(unidadeCurricularId).orElseThrow(null);
        if(unidadeCurricular == null) {
            throw new IllegalStateException("Unidade Curricular com id " + unidadeCurricularId + " não existe");
        }
        return unidadeCurricular;
    }

    public List<Professor> getProfessores(Long unidadeCurricularId) {
        UnidadeCurricular unidadeCurricular = unidadeCurricularRepository.findById(unidadeCurricularId).orElseThrow(null);
        if(unidadeCurricular == null) {
            throw new IllegalStateException("Unidade Curricular com id " + unidadeCurricularId + " não existe");
        } else {
            return unidadeCurricular.getProfessores();
        }
    }

    public List<Aluno> getAlunos(Long unidadeCurricularId) {
        UnidadeCurricular unidadeCurricular = unidadeCurricularRepository.findById(unidadeCurricularId).orElseThrow(null);
        if(unidadeCurricular == null) {
            throw new IllegalStateException("Unidade Curricular com id " + unidadeCurricularId + " não existe");
        }
        return unidadeCurricular.getAlunos();
    }


    /*
    Função para adicionar uma avaliação a uma unidade curricular
    - É feita a verificação se a unidade curricular existe
    - É feita a verificação se a avaliação existe
    - É feita a verificação se a unidade curricular já tem a avaliação
    - Se tudo estiver bem, a avaliação é adicionada à unidade curricular
     */
    public void addAvaliacao(Long unidadeCurricularId, Long avaliacaoId) {
        UnidadeCurricular unidadeCurricular = unidadeCurricularRepository.findById(unidadeCurricularId).orElseThrow(null);
        if(unidadeCurricular == null) {
            throw new IllegalStateException("Unidade Curricular com id " + unidadeCurricularId + " não existe");
        }

        Avaliacao avaliacao = avaliacaoRepository.findById(avaliacaoId).orElseThrow(null);
        if(avaliacao == null) {
            throw new IllegalStateException("Avaliação com id " + avaliacaoId + " não existe");
        }

        if(!unidadeCurricular.getAvaliacoes().contains(avaliacao)) {
            unidadeCurricular.getAvaliacoes().add(avaliacao);
            unidadeCurricularRepository.save(unidadeCurricular);
        }
        else {
            throw new IllegalStateException("Unidade Curricular com id " + unidadeCurricular + " já tem a avaliação com id " + avaliacaoId);
        }
    }

    /*
    Função para obter as avaliações de uma unidade curricular
    - É feita a verificação se a unidade curricular existe com o id fornecido
    - Se tudo estiver bem, é retornado a lista de avaliações da unidade curricular
     */
    public List<Avaliacao> getAvaliacoes(Long unidadeCurricularId) {
        UnidadeCurricular unidadeCurricular = unidadeCurricularRepository.findById(unidadeCurricularId).orElseThrow(null);
        if(unidadeCurricular == null) {
            throw new IllegalStateException("Unidade Curricular com id " + unidadeCurricularId + " não existe");
        }
        return unidadeCurricular.getAvaliacoes();
    }
}
