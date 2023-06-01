package com.ontrack.api.api.services;

import com.ontrack.api.api.dao.Aluno;
import com.ontrack.api.api.dao.Professor;
import com.ontrack.api.api.repositories.AlunoRepository;
import com.ontrack.api.api.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final AlunoRepository alunoRepository;

    private final ProfessorRepository professorRepository;

    @Autowired
    public LoginService(AlunoRepository alunoRepository, ProfessorRepository professorRepository) {
        this.alunoRepository = alunoRepository;
        this.professorRepository = professorRepository;
    }

    public Long login(String email){
        String[] dados = email.split("@");
        if(dados.length != 2 || (!dados[1].equals("alunos.ulht.pt") && !dados[1].equals("ulusofona.pt"))){
            throw new IllegalStateException("Email inválido");
        }
        if(dados[0].charAt(0) == 'a'){
            Optional<Aluno> aluno = alunoRepository.findAlunoByEmail(email);
            if(aluno.isEmpty()){
                throw new IllegalStateException("Aluno com email " + email + " não existe");
            }
            return aluno.get().getId();
        }
        else if(dados[0].charAt(0) == 'p'){
            Optional<Professor> professor = professorRepository.findProfessorByEmail(email);
            if(professor.isEmpty()){
                throw new IllegalStateException("Professor com email " + email + " não existe");
            }
            return professor.get().getId();
        }
        else{
            throw new IllegalStateException("Email inválido");
        }
    }
}
