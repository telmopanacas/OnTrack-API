package com.ontrack.api.api.repositories;

import com.ontrack.api.api.dao.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Optional<Aluno> findAlunoByEmail(String email);

}
