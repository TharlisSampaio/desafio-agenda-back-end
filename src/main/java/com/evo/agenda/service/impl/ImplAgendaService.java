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
        var agenda = this.agendaRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return agenda;
    }

    @Override
    public Agenda createAgenda(Agenda agendaToCreate) {
        this.agendaRepository.save(agendaToCreate);
        return agendaToCreate;
    }

    @Override
    public List<Agenda> getAll() {
        List<Agenda> agendas = this.agendaRepository.findAll();
        return agendas;
    }

    @Override
    public void deleteAgenda(Long id) {
        this.agendaRepository.deleteById(id);
    }

    @Override
    public Agenda updateAgenda(Long id, Agenda agendaToUpdate) {
        var entity = this.agendaRepository.findById(id);

        if(entity.isPresent()){
            var agenda = entity.get();

            if(agendaToUpdate.getNome() != null){
                agenda.setNome(agendaToUpdate.getNome());
            }
            if(agendaToUpdate.getSobrenome() != null){
                agenda.setSobrenome(agendaToUpdate.getSobrenome());
            }
            if(agendaToUpdate.getTelefone() != null){
                agenda.setTelefone(agendaToUpdate.getTelefone());
            }
            this.agendaRepository.save(agenda);
        }
        return findById(id);
    }
    
}
