package com.ontrack.api.api.services;

import com.ontrack.api.api.dao.Aluno;
import com.ontrack.api.api.dao.UnidadeCurricular;
import com.ontrack.api.api.repositories.AlunoRepository;
import com.ontrack.api.api.repositories.UnidadeCurricularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final UnidadeCurricularRepository unidadeCurricularRepository;

    @Autowired
    public AlunoService(AlunoRepository alunoRepository, UnidadeCurricularRepository unidadeCurricularRepository) {
        this.alunoRepository = alunoRepository;
        this.unidadeCurricularRepository = unidadeCurricularRepository;
    }

    public List<Aluno> getAlunos() {
        return alunoRepository.findAll();
    }

    public void addNewAluno(Aluno aluno) {
        Optional<Aluno> alunoOptional = alunoRepository.findAlunoByEmail(aluno.getEmail());
        if(alunoOptional.isPresent()) {
            throw new IllegalStateException("Email usado já se encontra registado");
        }
        alunoRepository.save(aluno);
    }

    public void deleteAluno(Long alunoId) {
        boolean exists = alunoRepository.existsById(alunoId);
        if (!exists) {
            throw new IllegalStateException("Aluno com id " + alunoId + " não existe");
        }
        alunoRepository.deleteById(alunoId);
    }

    public Aluno getAluno(Long alunoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(null);
        if(aluno == null){
            throw new IllegalStateException("Aluno com id " + alunoId + " não existe");
        }
        return aluno;
    }

    public List<UnidadeCurricular> getUnidadesCurriculares(Long alunoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(null);
        if(aluno == null){
            throw new IllegalStateException("Aluno com id " + alunoId + " não existe");
        }
        return aluno.getUnidadesCurriculares();
    }

    /*
    Função para adicionar uma nova unidade curricular a um aluno
    - É feita a verificação se o aluno existe pelo id fornecido
    - É feita a verificação se a unidade curricular existe pelo id do objeto fornecido;
    - É feita a verificação se o aluno já tem a unidade curricular fornecida;
    - Se tudo estiver ok, a unidade curricular é adicionada ao aluno e o aluno é guardado na base de dados
     */
    public void addUnidadeCurricular(Long alunoId, Long unidadeCurricularId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(null);
        if(aluno == null) {
            throw new IllegalStateException("Aluno com id " + alunoId + " não existe");
        }

        UnidadeCurricular unidadeCurricular = unidadeCurricularRepository.findById(unidadeCurricularId).orElseThrow(null);
        if(unidadeCurricular == null) {
            throw new IllegalStateException("Unidade Curricular com id " + unidadeCurricularId + " não existe");
        }

        if(!aluno.getUnidadesCurriculares().contains(unidadeCurricular)) {
            aluno.getUnidadesCurriculares().add(unidadeCurricular);
            alunoRepository.save(aluno);
        }
        else {
            throw new IllegalStateException("Aluno com id " + alunoId + " já tem a unidade curricular com id " + unidadeCurricularId);
        }
    }
}
