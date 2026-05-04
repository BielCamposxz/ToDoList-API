package com.gabriel.ToDoList.Services;

import com.gabriel.ToDoList.Enum.StatusEnum;
import com.gabriel.ToDoList.Model.TarefasModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TarefasServices {
    public ArrayList<TarefasModel> tarefas = new ArrayList<>();

    private void mudarStatus(int id, StatusEnum status) {
        this.tarefas.stream().filter(x -> x.id == id).findFirst().ifPresent(x -> x.setStatus(status));
    }


    public void Criar(TarefasModel tarefa) {
        int id;
        try {
            id = this.tarefas.getLast().id;
        }
        catch (NoSuchElementException err) {
            id = 0;
        }

        TarefasModel tarefaInstacia = new TarefasModel(
                id + 1,
                tarefa.tarefaName,
                tarefa.Status
        );

        this.tarefas.add(tarefaInstacia);
    }

    public ArrayList<TarefasModel> mostar() {
        return this.tarefas;
    }



    public void Marcar(int id) {
        mudarStatus(id, StatusEnum.Feito);
    }

    public void Desmarcar(int id) {
        mudarStatus(id, StatusEnum.Aberto);
    }

    public void Apagar(int id) {
        this.tarefas.removeIf(s -> s.id == id);
    }

    public List<TarefasModel> FiltrarPorStatus(StatusEnum status) {
        return  this.tarefas.stream().filter(x -> x.Status == status).toList();
    }
}
