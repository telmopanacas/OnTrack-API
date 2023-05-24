package com.ontrack.api.api.controllers;

import com.ontrack.api.api.dao.Aluno;
import com.ontrack.api.api.dao.UnidadeCurricular;
import com.ontrack.api.api.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/aluno")
public class AlunoController {

    private final AlunoService alunoService;

    @Autowired
    public AlunoController(AlunoService alunoService){this.alunoService = alunoService;}

    /*
    Endpoint para obter todos os alunos
     */
    @GetMapping
    public List<Aluno> getAluno(){
        return alunoService.getAlunos();
    }

    /*
    Endpoint para registrar um novo aluno
     */
    @PostMapping
    public void registerNewAluno(@RequestBody Aluno aluno) {
        alunoService.addNewAluno(aluno);
    }

    /*
    Endpoint para apagar um aluno
     */
    @DeleteMapping
    public void deleteAluno(Long alunoId) {
        alunoService.deleteAluno(alunoId);
    }

    /*
    Endpoint para obter um aluno
     */
    @GetMapping(path = "/{alunoId}")
    public Aluno getAluno(@PathVariable Long alunoId) {
        return alunoService.getAluno(alunoId);
    }

    /*
    Endpoint para obter todas as unidades curriculares de um aluno
     */
    @GetMapping(path = "/{alunoId}/unidades-curriculares")
    public List<UnidadeCurricular> getUnidadesCurriculares(@PathVariable Long alunoId) {
        return alunoService.getUnidadesCurriculares(alunoId);
    }

    /*
    Endpoint para registar uma nova unidade curricular para um aluno
     */
    @PostMapping(path = "/{alunoId}/unidades-curriculares/new")
    public void registerNewUnidadeCurricular(@PathVariable Long alunoId, @RequestBody UnidadeCurricular unidadeCurricular) {
        alunoService.addNewUnidadeCurricular(alunoId, unidadeCurricular);
    }
}
