package com.gabriel.ToDoList.Controller;

import com.gabriel.ToDoList.Enum.StatusEnum;
import com.gabriel.ToDoList.Model.TarefasModel;
import com.gabriel.ToDoList.Services.TarefasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class ToDoListController {

    @Autowired
    private TarefasServices tarefas;

    @PostMapping
    @RequestMapping("/Criar")
    public void Criar(@RequestBody TarefasModel tarefa)
    {
        tarefa.id = 0;
        tarefas.Criar(tarefa);
    }

    @GetMapping("/Mostrar")
    public ArrayList<TarefasModel> mostar() {
        return tarefas.mostar();
    }

    @PutMapping("/MarcarComoFeito/{id}")
    public void marcarComoFeito(@PathVariable int id) {
        tarefas.Marcar(id);
    }

    @PutMapping("/Desmarcar/{id}")
    public void Desmarcar(@PathVariable int id) {
        tarefas.Desmarcar(id);
    }

    @DeleteMapping("/Deletar/{id}")
    public void Remover(@PathVariable int id) {
        tarefas.Apagar(id);
    }

    // fazer o metodo para fazer as buscas
    @GetMapping("/Mostrar/BuscarPorStatus")
    public List<TarefasModel> BuscarPorStatus(@RequestParam(value = "filter", defaultValue = "") StatusEnum status) {
       return tarefas.FiltrarPorStatus(status);
    }
}
