package com.desafio_tecnico.gerenciamento_de_tarefas.repositories;

import com.desafio_tecnico.gerenciamento_de_tarefas.entities.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
