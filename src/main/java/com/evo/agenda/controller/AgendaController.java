package com.evo.agenda.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
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
import com.evo.agenda.model.dto.CreatedAgendaDto;
import com.evo.agenda.model.dto.UpdateAgendaDto;
import com.evo.agenda.service.AgendaService;

@RestController
@RequestMapping("/api/agenda")
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
        try {
            var agenda = this.agendaService.findById(id);
            return ResponseEntity.ok().body(agenda);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Agenda> createAgenda(@RequestBody CreatedAgendaDto createdAgendaDto){
        try {
            var agenda = this.agendaService.createAgenda(createdAgendaDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(agenda);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agenda> updateAgenda(@PathVariable("id") Long id, @RequestBody UpdateAgendaDto updateAgendaDto){
        try {
            var agendaUpdate = this.agendaService.updateAgenda(id, updateAgendaDto);
            return ResponseEntity.ok().body(agendaUpdate);

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") Long id){
        try {
            this.agendaService.deleteAgenda(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
