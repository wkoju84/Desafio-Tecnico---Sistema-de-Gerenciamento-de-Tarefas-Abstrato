package com.desafio_tecnico.gerenciamento_de_tarefas.tests;

import com.desafio_tecnico.gerenciamento_de_tarefas.dtos.TarefaDTO;
import com.desafio_tecnico.gerenciamento_de_tarefas.entities.Tarefa;

public class Factory {

    public static Tarefa criarTarefa(){
        return new Tarefa(null,"Entregar trabalho", "Trabalho escolar", false, 3);
    }

    public static TarefaDTO criarTarefaDTO(){
        Tarefa tarefa = criarTarefa();
        return new TarefaDTO(tarefa);
    }
}
