package com.ontrack.api.api.controllers;

import com.ontrack.api.api.dao.Aluno;
import com.ontrack.api.api.dao.Curso;
import com.ontrack.api.api.dao.UnidadeCurricular;
import com.ontrack.api.api.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/curso")
public class CursoController {

    private final CursoService cursoService;

    @Autowired
    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    /*
    Endpoint para obter todos os cursos
     */
    @GetMapping(path = "/list")
    public List<Curso> getCursos() {
        return cursoService.getCursos();
    }

    /*
    Endpoint para obter um curso
     */
    @GetMapping(path = "/{cursoId}")
    public Curso getCurso(@PathVariable Long cursoId) {
        return cursoService.getCurso(cursoId);
    }

    /*
    Endpoint para criar um novo curso
     */
    @PostMapping(path = "/new")
    public void registerNewCurso(@RequestBody Curso curso) {
        cursoService.addNewCurso(curso);
    }

    /*
    Endpoint para apagar um curso
     */
    @DeleteMapping(path = "/delete/{cursoId}")
    public void deleteCurso(@PathVariable Long cursoId) {
        cursoService.deleteCurso(cursoId);
    }

    /*
    Endpoint para obter todos os alunos de um curso
     */
    @GetMapping(path = "/{cursoId}/alunos/list")
    public List<Aluno> getAlunos(@PathVariable Long cursoId) {
        return cursoService.getAlunos(cursoId);
    }

    /*
    Endpoint para obter todas as unidades curriculares de um curso
     */
    @GetMapping(path = "/{cursoId}/unidades-curriculares/list")
    public List<UnidadeCurricular> getUnidadesCurriculares(@PathVariable Long cursoId) {
        return cursoService.getUnidadesCurriculares(cursoId);
    }


}
