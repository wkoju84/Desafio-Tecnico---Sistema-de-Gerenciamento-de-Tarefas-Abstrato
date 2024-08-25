package com.desafio_tecnico.gerenciamento_de_tarefas.services;

import com.desafio_tecnico.gerenciamento_de_tarefas.dtos.TarefaDTO;
import com.desafio_tecnico.gerenciamento_de_tarefas.entities.Tarefa;
import com.desafio_tecnico.gerenciamento_de_tarefas.repositories.TarefaRepository;
import com.desafio_tecnico.gerenciamento_de_tarefas.services.exceptions.EntidadeNaoEncontradaException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TarefaService {

    private TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    @Transactional(readOnly = true)
    public List<TarefaDTO> buscarTodos() {
        List<Tarefa> tarefas = tarefaRepository.findAll();
        return tarefas.stream().sorted(Comparator.comparing(Tarefa::getPrioridade)
                        .reversed() //Ordena as tarefas pela prioridade em ordem decrescente
                        .thenComparing(Tarefa::getNome))//Ordena as tarefas por nome em ordem crescente
                .map(TarefaDTO::new)//Converte as entidades
                .collect(Collectors.toList());//Coleta os resultados em uma lista
    }

    @Transactional(readOnly = true)
    public TarefaDTO buscarPorId(Long id){
        Optional<Tarefa> objeto = tarefaRepository.findById(id);
        Tarefa tarefa = objeto.orElseThrow(() -> new EntidadeNaoEncontradaException(
                "Registro " + id + " não encontrado em sua base de dados!"
        ));
        return new TarefaDTO(tarefa);
    }
}
