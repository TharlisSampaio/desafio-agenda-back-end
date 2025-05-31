package com.evo.agenda.service;

import java.util.List;

import com.evo.agenda.model.Agenda;
import com.evo.agenda.model.dto.CreatedAgendaDto;
import com.evo.agenda.model.dto.UpdateAgendaDto;

public interface AgendaService {

    Agenda findById(Long id);
    Agenda createAgenda(CreatedAgendaDto createdAgendaDto);
    List<Agenda> getAll();
    void deleteAgenda(Long id);
    Agenda updateAgenda(Long id, UpdateAgendaDto updateAgendaDto);
}