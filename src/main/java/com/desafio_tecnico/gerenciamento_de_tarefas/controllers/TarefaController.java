package com.desafio_tecnico.gerenciamento_de_tarefas.controllers;

import com.desafio_tecnico.gerenciamento_de_tarefas.dtos.TarefaDTO;
import com.desafio_tecnico.gerenciamento_de_tarefas.services.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/tarefas")
public class TarefaController {

    private TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public ResponseEntity<List<TarefaDTO>> buscarTodasAsTarefas(){
        List<TarefaDTO> tarefaDTOS = tarefaService.buscarTodos();
        return ResponseEntity.ok().body(tarefaDTOS);
    }
}
