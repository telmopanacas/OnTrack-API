package com.ontrack.api.api.controllers;

import com.ontrack.api.api.dao.Professor;
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

    @GetMapping
    public List<Professor> getProfessores() {
        return professorService.getProfessores();
    }

    @PostMapping
    public void registerNewProfessor(@RequestBody Professor professor) {
        professorService.addNewProfessor(professor);
    }

    @DeleteMapping
    public void deleteProfessor(Long professorId) {
        professorService.deleteProfessor(professorId);
    }
}
