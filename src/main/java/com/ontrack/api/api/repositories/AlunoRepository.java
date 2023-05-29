package com.ontrack.api.api.repositories;

import com.ontrack.api.api.dao.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Aluno findByEmail(String email);

}
