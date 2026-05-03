package com.gabriel.ToDoList.Model;

import com.gabriel.ToDoList.Enum.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TarefasModel {
    public Integer id;
    public String tarefaName;
    public StatusEnum Status;

}
