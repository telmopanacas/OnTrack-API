package com.ontrack.api.api.services;

import com.ontrack.api.api.dao.Aluno;
import com.ontrack.api.api.dao.Professor;
import com.ontrack.api.api.repositories.AlunoRepository;
import com.ontrack.api.api.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            Aluno aluno = alunoRepository.findByEmail(email);
            if(aluno == null){
                throw new IllegalStateException("Aluno com email " + email + " não existe");
            }
            return aluno.getId();
        }
        else if(dados[0].charAt(0) == 'p'){
            Professor professor = professorRepository.findByEmail(email);
            if(professor == null){
                throw new IllegalStateException("Professor com email " + email + " não existe");
            }
            return professor.getId();
        }
        else{
            throw new IllegalStateException("Email inválido");
        }
    }
}
