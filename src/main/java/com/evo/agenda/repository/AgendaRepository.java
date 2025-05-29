package com.evo.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evo.agenda.model.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long>{

}
