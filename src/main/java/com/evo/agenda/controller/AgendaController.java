package com.evo.agenda.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evo.agenda.model.Agenda;
import com.evo.agenda.service.AgendaService;

@RestController
@RequestMapping("/agenda")
public class AgendaController {
    private final AgendaService agendaService;

    public AgendaController(AgendaService agendaService){
        this.agendaService = agendaService;
    }

    @GetMapping
    public ResponseEntity<List<Agenda>> getAllAgenda(){
        var agendas = this.agendaService.getAll();
        return ResponseEntity.ok().body(agendas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agenda> getAgendaById(@PathVariable("id") Long id){
        var agenda = this.agendaService.findById(id);
        return ResponseEntity.ok(agenda);
    }

    @PostMapping
    public ResponseEntity<Agenda> createAgenda(@RequestBody Agenda agendaToCreate){
        var agenda = this.agendaService.createAgenda(agendaToCreate);
        return ResponseEntity.ok().body(agenda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agenda> updateAgenda(@PathVariable("id") Long id, @RequestBody Agenda agendaToUpdate){
        var agendaUpdate = this.agendaService.updateAgenda(id, agendaToUpdate);
        return ResponseEntity.ok().body(agendaUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        this.agendaService.deleteAgenda(id);
    }
}
