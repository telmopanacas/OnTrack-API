package com.ontrack.api.api.services;

import com.ontrack.api.api.dao.Professor;
import com.ontrack.api.api.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<Professor> getProfessores() {
        return professorRepository.findAll();
    }

    public void addNewProfessor(Professor professor) {
        professorRepository.save(professor);
    }

    public void deleteProfessor(Long professorId) {
        boolean exists = professorRepository.existsById(professorId);
        if (!exists) {
            throw new IllegalStateException("Professor com id " + professorId + " não existe");
        }
        professorRepository.deleteById(professorId);
    }
}
