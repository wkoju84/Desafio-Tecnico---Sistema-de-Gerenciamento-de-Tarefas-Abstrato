package com.desafio_tecnico.gerenciamento_de_tarefas.controllers;

import com.desafio_tecnico.gerenciamento_de_tarefas.dtos.TarefaDTO;
import com.desafio_tecnico.gerenciamento_de_tarefas.services.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/{id}")
    public ResponseEntity<TarefaDTO> buscarTarefaPorId(@PathVariable Long id){
        TarefaDTO dto = tarefaService.buscarPorId(id);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirTarefa(@PathVariable Long id){
        tarefaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
