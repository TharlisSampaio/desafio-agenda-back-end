package com.evo.agenda.service;

import java.util.List;

import com.evo.agenda.model.Agenda;

public interface AgendaService {

    Agenda findById(Long id);
    Agenda createAgenda(Agenda agenda);
    List<Agenda> getAll();
    Agenda deleteAgenda(Long id);
    Agenda updateAgenda(Long id, Agenda agenda);
}