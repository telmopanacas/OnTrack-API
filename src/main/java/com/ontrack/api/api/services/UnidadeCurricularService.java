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

    public void addUnidadeCurricular(Long unidadeCurricularId, Long avaliacaoId) {
        UnidadeCurricular unidadeCurricular = unidadeCurricularRepository.findById(unidadeCurricularId).orElseThrow(null);
        if(unidadeCurricular == null) {
            throw new IllegalStateException("Unidade curricular com id " + unidadeCurricularId + " não existe");
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
            throw new IllegalStateException("Unidade curricular com id " + unidadeCurricular + " já tem a avaliacao com id " + avaliacaoId);
        }
    }
}
