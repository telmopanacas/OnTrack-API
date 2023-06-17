package com.ontrack.api.api.services;

import com.ontrack.api.api.dao.Aluno;
import com.ontrack.api.api.dao.CredenciaisUser;
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

    /*
    Função encarregue de fazer login
    De momento a API não utiliza a password pois era suposto fazer a parte da autencicação com o DEISI Auth e depois
    aqui apenas verificar se o utilizador existe na base de dados a partir do email e devolver o id.

    1 - Verificar se o email é válido
    2 - Ver se o email é de aluno ou professor
    3 - Verificar se o utilizador existe na base de dados através do email
    4 - Devolver o id do utilizador

     */
    public Long login(CredenciaisUser credenciaisUser){
        String[] dados = credenciaisUser.getEmail().split("@");
        if(dados.length != 2 || (!dados[1].equals("alunos.ulht.pt") && !dados[1].equals("ulusofona.pt"))){
            throw new IllegalStateException("Email inválido");
        }
        if(dados[0].charAt(0) == 'a'){
            Optional<Aluno> aluno = alunoRepository.findAlunoByEmail(credenciaisUser.getEmail());
            if(aluno.isEmpty()){
                throw new IllegalStateException("Aluno com email " + credenciaisUser.getEmail() + " não existe");
            }
            return aluno.get().getId();
        }
        else if(dados[0].charAt(0) == 'p'){
            Optional<Professor> professor = professorRepository.findProfessorByEmail(credenciaisUser.getEmail());
            if(professor.isEmpty()){
                throw new IllegalStateException("Professor com email " + credenciaisUser.getEmail() + " não existe");
            }
            return professor.get().getId();
        }
        else{
            throw new IllegalStateException("Email inválido");
        }
    }
}
