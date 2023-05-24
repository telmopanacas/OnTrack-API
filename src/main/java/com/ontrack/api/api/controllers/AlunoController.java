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
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    /*
    Endpoint para obter todos os alunos
     */
    @GetMapping(path = "/list")
    public List<Aluno> getAlunos() {
        return alunoService.getAlunos();
    }

    /*
    Endpoint para registar um novo aluno
     */
    @PostMapping(path = "/new")
    public void registerNewAluno(@RequestBody Aluno aluno) {
        alunoService.addNewAluno(aluno);
    }

    /*
    Endpoint para apagar um aluno
     */
    @DeleteMapping(path = "/delete/{alunoId}")
    public void deleteAluno(@PathVariable Long alunoId) {
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
    @GetMapping(path = "/{alunoId}/unidades-curriculares/list")
    public List<UnidadeCurricular> getUnidadesCurriculares(@PathVariable Long alunoId) {
        return alunoService.getUnidadesCurriculares(alunoId);
    }

    /*
    Endpoint para adicionar uma unidade curricular a um aluno
     */
    @PostMapping(path = "/{alunoId}/unidades-curriculares/add/{unidadeCurricularId}")
    public void addUnidadeCurricular(@PathVariable Long alunoId, @PathVariable Long unidadeCurricularId) {
        alunoService.addUnidadeCurricular(alunoId, unidadeCurricularId);
    }

}
