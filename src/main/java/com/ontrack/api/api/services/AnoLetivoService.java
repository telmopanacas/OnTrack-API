package com.ontrack.api.api.services;

import com.ontrack.api.api.dao.AnoLetivo;
import com.ontrack.api.api.dao.UnidadeCurricular;
import com.ontrack.api.api.repositories.AnoLetivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnoLetivoService {

    private final AnoLetivoRepository anoLetivoRepository;

    @Autowired
    public AnoLetivoService(AnoLetivoRepository anoLetivoRepository) {
        this.anoLetivoRepository = anoLetivoRepository;
    }

    public List<AnoLetivo> getAnoLetivos() {
        return anoLetivoRepository.findAll();
    }

    public void addNewAnoLetivo(AnoLetivo anoLetivo) {
        anoLetivoRepository.save(anoLetivo);
    }

    public void deleteAnoLetivo(Long anoLetivoId) {
        boolean exists = anoLetivoRepository.existsById(anoLetivoId);
        if (!exists) {
            throw new IllegalStateException("AnoLetivo com id " + anoLetivoId + " não existe");
        }
        anoLetivoRepository.deleteById(anoLetivoId);
    }

    public AnoLetivo getAnoLetivo(Long anoLetivoId) {
        AnoLetivo anoLetivo = anoLetivoRepository.findById(anoLetivoId).orElseThrow(null);
        if(anoLetivo == null) {
            throw new IllegalStateException("AnoLetivo com id " + anoLetivoId + " não existe");
        }
        return anoLetivo;
    }


    public List<UnidadeCurricular> getUnidadesCurriculares(Long anoLetivoId) {
        AnoLetivo anoLetivo = anoLetivoRepository.findById(anoLetivoId).orElseThrow(null);
        if(anoLetivo == null) {
            throw new IllegalStateException("AnoLetivo com id " + anoLetivoId + " não existe");
        }
        return anoLetivo.getUnidadesCurriculares();
    }
}
