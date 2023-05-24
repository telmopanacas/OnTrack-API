package com.ontrack.api.api.controllers;

import com.ontrack.api.api.dao.Professor;
import com.ontrack.api.api.dao.UnidadeCurricular;
import com.ontrack.api.api.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/professor")
public class ProfessorController {

    private final ProfessorService professorService;

    @Autowired
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    /*
    Endpoint para obter todos os professores
     */
    @GetMapping(path = "/list")
    public List<Professor> getProfessores() {
        return professorService.getProfessores();
    }

    /*
    Endpoint para registar um novo professor
    - Ainda permite utilizadores duplicados
     */
    @PostMapping(path = "/new")
    public void registerNewProfessor(@RequestBody Professor professor) {
        professorService.addNewProfessor(professor);
    }

    /*
    Endpoint para apagar um professor
     */
    @DeleteMapping(path = "/delete/{professorId}")
    public void deleteProfessor(@PathVariable Long professorId) {
        professorService.deleteProfessor(professorId);
    }

    /*
    Endpoint para obter um professor
     */
    @GetMapping(path = "/{professorId}")
    public Professor getProfessor(@PathVariable Long professorId) {
        return professorService.getProfessor(professorId);
    }

    /*
    Endpoint para obter todas as unidades curriculares de um professor
     */
    @GetMapping(path = "/{professorId}/unidades-curriculares/list")
    public List<UnidadeCurricular> getUnidadesCurriculares(@PathVariable Long professorId) {
        return professorService.getUnidadesCurriculares(professorId);
    }

    /*
    Endpoint para adicionar uma nova unidade curricular a um professor
     */
    @PostMapping(path = "/{professorId}/unidades-curriculares/add/{unidadeCurricularId}")
    public void addNewUnidadeCurricular(@PathVariable Long professorId, @PathVariable Long unidadeCurricularId) {
        professorService.addNewUnidadeCurricular(professorId, unidadeCurricularId);
    }
}
