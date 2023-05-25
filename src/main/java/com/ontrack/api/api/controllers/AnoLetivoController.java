package com.ontrack.api.api.controllers;

import com.ontrack.api.api.dao.AnoLetivo;
import com.ontrack.api.api.dao.UnidadeCurricular;
import com.ontrack.api.api.services.AnoLetivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/ano_letivo")
public class AnoLetivoController {

    private final AnoLetivoService anoLetivoService;

    @Autowired
    public AnoLetivoController(AnoLetivoService anoLetivoService) {
        this.anoLetivoService = anoLetivoService;
    }

    @GetMapping(path = "/list")
    public List<AnoLetivo> getAnoLetivos() {
        return anoLetivoService.getAnoLetivos();
    }

    @PostMapping(path = "/new")
    public void registerNewAnoLetivo(@RequestBody AnoLetivo anoLetivo) {
        anoLetivoService.addNewAnoLetivo(anoLetivo);
    }

    @DeleteMapping(path = "/delete/{anoLetivoId}")
    public void deleteAnoLetivo(@PathVariable Long anoLetivoId) {
        anoLetivoService.deleteAnoLetivo(anoLetivoId);
    }

    /*
    Endpoint para obter um ano letivo específico
     */
    @GetMapping(path = "/{anoLetivoId}")
    public AnoLetivo getAnoLetivo(@PathVariable Long anoLetivoId) {
        return anoLetivoService.getAnoLetivo(anoLetivoId);
    }

    /*
    Endpoint para obter a lista unidades curriculares de um ano letivo
     */
    @GetMapping(path = "/{anoLetivoId}/unidades_curriculares/list")
    public List<UnidadeCurricular> getUnidadesCurriculares(@PathVariable Long anoLetivoId) {
        return anoLetivoService.getUnidadesCurriculares(anoLetivoId);
    }
}
