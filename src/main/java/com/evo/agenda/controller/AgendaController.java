package com.evo.agenda.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping
    public ResponseEntity<Agenda> createAgenda(@RequestBody Agenda agendaToCreate){
        var agenda = this.agendaService.createAgenda(agendaToCreate);
        return ResponseEntity.ok().body(agenda);
    }
}
