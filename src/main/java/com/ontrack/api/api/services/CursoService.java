package com.ontrack.api.api.services;

import com.ontrack.api.api.dao.Aluno;
import com.ontrack.api.api.dao.Curso;
import com.ontrack.api.api.dao.UnidadeCurricular;
import com.ontrack.api.api.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    @Autowired
    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }


    public List<Curso> getCursos() {
        return cursoRepository.findAll();
    }

    public Curso getCurso(Long cursoId) {
        Curso curso = cursoRepository.findById(cursoId).orElseThrow(null);
        if(curso == null) {
            throw new IllegalStateException("Curso com id " + cursoId + " não existe");
        }
        return curso;
    }

    public void addNewCurso(Curso curso) {
        cursoRepository.save(curso);
    }

    public void deleteCurso(Long cursoId) {
        boolean exists = cursoRepository.existsById(cursoId);
        if(!exists) {
            throw new IllegalStateException("Curso com id " + cursoId + " não existe");
        }
        cursoRepository.deleteById(cursoId);
    }

    /*
    Função para obter todos os alunos de um curso
    - É feita a verificação se o curso com o id fornecido existe
    - Se existir, é retornado a lista de alunos
     */
    public List<Aluno> getAlunos(Long cursoId) {
        Curso curso = cursoRepository.findById(cursoId).orElseThrow(null);
        if(curso == null) {
            throw new IllegalStateException("Curso com id " + cursoId + " não existe");
        }
        return curso.getAlunos();
    }

    /*
    Função para obter todas as unidades curriculares de um curso
    - É feita a verificação se o curso com o id fornecido existe
    - Se existir, é retornado a lista de unidades curriculares
     */
    public List<UnidadeCurricular> getUnidadesCurriculares(Long cursoId) {
        Curso curso = cursoRepository.findById(cursoId).orElseThrow(null);
        if(curso == null) {
            throw new IllegalStateException("Curso com id " + cursoId + " não existe");
        }
        return curso.getUnidadesCurriculares();
    }
}
