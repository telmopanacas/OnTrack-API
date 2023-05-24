package com.ontrack.api.api.services;

import com.ontrack.api.api.dao.Aluno;
import com.ontrack.api.api.dao.Professor;
import com.ontrack.api.api.dao.UnidadeCurricular;
import com.ontrack.api.api.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    @Autowired
    public AlunoService(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> getAlunos(){
        return alunoRepository.findAll();
    }

    public void addNewAluno(Aluno aluno){
        alunoRepository.save(aluno);
    }
    public void deleteAluno(Long alunoId) {
        boolean exists = alunoRepository.existsById(alunoId);
        if (!exists) {
            throw new IllegalStateException("Professor com id " + alunoId + " não existe");
        }
        alunoRepository.deleteById(alunoId);
    }

    public List<UnidadeCurricular> getUnidadesCurriculares(Long alunoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(null);
        if(aluno == null){
            throw new IllegalStateException("Professor com id " + alunoId + " não existe");
        }
        return aluno.getUnidadesCurriculares();
    }

    public void addNewUnidadeCurricular(Long alunoId, UnidadeCurricular unidadeCurricular) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(null);
        if(aluno == null){
            throw new IllegalStateException("Professor com id " + alunoId + " não existe");
        }
        aluno.addUnidadeCurricular(unidadeCurricular);
        alunoRepository.save(aluno);
    }

    public Aluno getAluno(Long alunoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(null);
        if(aluno == null){
            throw new IllegalStateException("Professor com id " + alunoId + " não existe");
        }
        return aluno;
    }
}
