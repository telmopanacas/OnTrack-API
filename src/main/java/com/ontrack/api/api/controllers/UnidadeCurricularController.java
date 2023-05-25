package com.ontrack.api.api.controllers;

import com.ontrack.api.api.dao.Aluno;
import com.ontrack.api.api.dao.Professor;
import com.ontrack.api.api.dao.UnidadeCurricular;
import com.ontrack.api.api.services.UnidadeCurricularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/unidade_curricular")
public class UnidadeCurricularController {

    private final UnidadeCurricularService unidadeCurricularService;

    @Autowired
    public UnidadeCurricularController(UnidadeCurricularService unidadeCurricularService) {
        this.unidadeCurricularService = unidadeCurricularService;
    }

    /*
    Endpoint para obter todas as unidades curriculares
     */
    @GetMapping(path = "/list")
    public List<UnidadeCurricular> getUnidadesCurriculares() {
        return unidadeCurricularService.getUnidadesCurriculares();
    }

    /*
    Endpoint para registar uma nova unidade curricular
    - Ainda permite unidades curriculares duplicadas
     */
    @PostMapping(path = "/new")
    public void registerNewUnidadeCurricular(@RequestBody UnidadeCurricular unidadeCurricular) {
        unidadeCurricularService.addNewUnidadeCurricular(unidadeCurricular);
    }

    /*
    Endpoint para apagar uma unidade curricular
     */
    @DeleteMapping(path = "/delete/{unidadeCurricularId}")
    public void deleteUnidadeCurricular(@PathVariable Long unidadeCurricularId) {
        unidadeCurricularService.deleteUnidadeCurricular(unidadeCurricularId);
    }

    /*
    Endpoint para obter a lista de professores de uma unidade curricular
     */
    @GetMapping(path = "/{unidadeCurricularId}/professores/list")
    public List<Professor> getProfessores(@PathVariable Long unidadeCurricularId) {
        return unidadeCurricularService.getProfessores(unidadeCurricularId);
    }

    /*
    Endpoint para obter a lista de alunos de uma unidade curricular
     */
    @GetMapping(path = "/{unidadeCurricularId}/alunos/list")
    public List<Aluno> getAlunos(@PathVariable Long unidadeCurricularId) {
        return unidadeCurricularService.getAlunos(unidadeCurricularId);
    }

    @PostMapping(path = "/{unidadeCurricularId}/avaliacao/add/{avaliacaoId}")
    public void addUnidadeCurricular(@PathVariable Long unidadeCurricularId, @PathVariable Long avaliacaoId ) {
        unidadeCurricularService.addUnidadeCurricular(unidadeCurricularId, avaliacaoId);
    }

}
