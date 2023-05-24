package com.ontrack.api.api.services;

import com.ontrack.api.api.dao.Professor;
import com.ontrack.api.api.dao.UnidadeCurricular;
import com.ontrack.api.api.repositories.ProfessorRepository;
import com.ontrack.api.api.repositories.UnidadeCurricularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final UnidadeCurricularRepository unidadeCurricularRepository;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository, UnidadeCurricularService unidadeCurricularService, UnidadeCurricularRepository unidadeCurricularRepository) {
        this.professorRepository = professorRepository;
        this.unidadeCurricularRepository = unidadeCurricularRepository;
    }

    public List<Professor> getProfessores() {
        return professorRepository.findAll();
    }

    public void addNewProfessor(Professor professor) {
        professorRepository.save(professor);
    }

    public void deleteProfessor(Long professorId) {
        boolean exists = professorRepository.existsById(professorId);
        if (!exists) {
            throw new IllegalStateException("Professor com id " + professorId + " não existe");
        }
        professorRepository.deleteById(professorId);
    }

    public List<UnidadeCurricular> getUnidadesCurriculares(Long professorId) {
        Professor professor = professorRepository.findById(professorId).orElseThrow(null);
        if(professor == null){
            throw new IllegalStateException("Professor com id " + professorId + " não existe");
        }
        return professor.getUnidadesCurriculares();
    }


    /*
    Função para adicionar uma nova unidade curricular a um professor
    - É feita a verificação se o professor existe pelo id fornecido
    - É feita a verificação se a unidade curricular existe pelo id do objeto fornecido;
    - É feita a verificação se o professor já tem a unidade curricular fornecida;
    - Se tudo estiver ok, a unidade curricular é adicionada ao professor e o professor é guardado na base de dados
     */
    public void addNewUnidadeCurricular(Long professorId, Long unidadeCurricularId) {
        //Ver se o professor existe pelo id
        Professor professor = professorRepository.findById(professorId).orElseThrow(null);
        if(professor == null){
            throw new IllegalStateException("Professor com id " + professorId + " não existe");
        }

        UnidadeCurricular unidadeCurricular = unidadeCurricularRepository.findById(unidadeCurricularId).orElseThrow(null);
        if(unidadeCurricular == null) {
            throw new IllegalStateException("Unidade Curricular com id " + unidadeCurricularId + " não existe");

        }

        if(!professor.getUnidadesCurriculares().contains(unidadeCurricular)){
            professor.getUnidadesCurriculares().add(unidadeCurricular);
            professorRepository.save(professor);
        }
        else {
            throw new IllegalStateException("Unidade Curricular com id " + unidadeCurricularId + " já existe no professor com id " + professorId);
        }
    }

    public Professor getProfessor(Long professorId) {
        Professor professor = professorRepository.findById(professorId).orElseThrow(null);
        if(professor == null){
            throw new IllegalStateException("Professor com id " + professorId + " não existe");
        }
        return professor;
    }
}
