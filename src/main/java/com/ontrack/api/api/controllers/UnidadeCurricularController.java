package com.ontrack.api.api.controllers;

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

    @GetMapping
    public List<UnidadeCurricular> getUnidadesCurriculares() {
        return unidadeCurricularService.getUnidadesCurriculares();
    }

    @PostMapping
    public void registerNewUnidadeCurricular(@RequestBody UnidadeCurricular unidadeCurricular) {
        unidadeCurricularService.addNewUnidadeCurricular(unidadeCurricular);
    }

    @DeleteMapping
    public void deleteUnidadeCurricular(Long unidadeCurricularId) {
        unidadeCurricularService.deleteUnidadeCurricular(unidadeCurricularId);
    }
}
