package com.ontrack.api.api.controllers;

import com.ontrack.api.api.dao.AnoLetivo;
import com.ontrack.api.api.services.AnoLetivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/anoletivo")
public class AnoLetivoController {

    private final AnoLetivoService anoLetivoService;

    @Autowired
    public AnoLetivoController(AnoLetivoService anoLetivoService) {
        this.anoLetivoService = anoLetivoService;
    }

    @GetMapping
    public List<AnoLetivo> getAnoLetivos() {
        return anoLetivoService.getAnoLetivos();
    }

    @PostMapping
    public void registerNewAnoLetivo(@RequestBody AnoLetivo anoLetivo) {
        anoLetivoService.addNewAnoLetivo(anoLetivo);
    }

    @DeleteMapping
    public void deleteAnoLetivo(Long anoLetivoId) {
        anoLetivoService.deleteAnoLetivo(anoLetivoId);
    }
}
