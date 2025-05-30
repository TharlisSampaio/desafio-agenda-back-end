package com.evo.agenda.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.evo.agenda.model.Agenda;
import com.evo.agenda.repository.AgendaRepository;
import com.evo.agenda.service.AgendaService;

@Service
public class ImplAgendaService implements AgendaService {
    private final AgendaRepository agendaRepository;

    public ImplAgendaService(AgendaRepository repository){
        this.agendaRepository = repository;
    }

    @Override
    public Agenda findById(Long id) {
        // TODO Auto-generated method stub
        var agenda = this.agendaRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return agenda;
    }

    @Override
    public Agenda createAgenda(Agenda agenda) {
        // TODO Auto-generated method stub
        this.agendaRepository.save(agenda);
        return agenda;
    }

    @Override
    public List<Agenda> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Agenda deleteAgenda(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAgenda'");
    }

    @Override
    public Agenda updateAgenda(Long id, Agenda agenda) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateAgenda'");
    }
    
}
