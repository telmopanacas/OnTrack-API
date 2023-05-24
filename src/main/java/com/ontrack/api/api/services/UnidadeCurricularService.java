package com.ontrack.api.api.services;

import com.ontrack.api.api.dao.Professor;
import com.ontrack.api.api.dao.UnidadeCurricular;
import com.ontrack.api.api.repositories.ProfessorRepository;
import com.ontrack.api.api.repositories.UnidadeCurricularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeCurricularService {

    private final UnidadeCurricularRepository unidadeCurricularRepository;

    private final ProfessorRepository professorRepository;

    @Autowired
    public UnidadeCurricularService(UnidadeCurricularRepository unidadeCurricularRepository, ProfessorRepository professorRepository) {
        this.unidadeCurricularRepository = unidadeCurricularRepository;
        this.professorRepository = professorRepository;
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

}
