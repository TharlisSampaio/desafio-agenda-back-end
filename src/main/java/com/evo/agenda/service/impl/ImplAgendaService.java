package com.evo.agenda.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.evo.agenda.model.Agenda;
import com.evo.agenda.model.dto.CreatedAgendaDto;
import com.evo.agenda.model.dto.UpdateAgendaDto;
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
    public Agenda createAgenda(CreatedAgendaDto agendaToCreate) {

        var entity = new Agenda(
            agendaToCreate.nome(),
            agendaToCreate.sobrenome(),
            agendaToCreate.telefone()
        );

        this.agendaRepository.save(entity);
        return entity;
    }

    @Override
    public List<Agenda> getAll() {
        List<Agenda> agendas = this.agendaRepository.findAll();
        agendas.sort((a, b) -> a.getNome().compareToIgnoreCase(b.getNome()));
        return agendas;
    }

    @Override
    public void deleteAgenda(Long id) {
        this.agendaRepository.deleteById(id);
    }

    @Override
    public Agenda updateAgenda(Long id, UpdateAgendaDto updateAgendaDto) {
        var entity = this.agendaRepository.findById(id);

        if(entity.isPresent()){
            var agenda = entity.get();

            if(updateAgendaDto.nome() != null){
                agenda.setNome(updateAgendaDto.nome());
            }
            if(updateAgendaDto.sobrenome() != null){
                agenda.setSobrenome(updateAgendaDto.sobrenome());
            }
            if(updateAgendaDto.telefone() != null){
                agenda.setTelefone(updateAgendaDto.telefone());
            }
            this.agendaRepository.save(agenda);
        }
        return findById(id);
    }
    
}
