package com.evo.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evo.agenda.model.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long>{

}
