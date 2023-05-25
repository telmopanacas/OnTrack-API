package com.ontrack.api.api.repositories;

import com.ontrack.api.api.dao.EventoDeAvaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoDeAvaliacaoRepository extends JpaRepository<EventoDeAvaliacao, Long> {
}
