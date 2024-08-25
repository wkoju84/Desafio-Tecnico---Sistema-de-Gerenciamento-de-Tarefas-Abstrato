package com.desafio_tecnico.gerenciamento_de_tarefas.services.exceptions;

import java.io.Serial;

public class BancoDeDadosException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public BancoDeDadosException(String msg){
        super(msg);
    }
}
