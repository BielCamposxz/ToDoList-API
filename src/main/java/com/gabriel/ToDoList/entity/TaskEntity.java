package com.gabriel.ToDoList.entity;

import com.gabriel.ToDoList.objectvalue.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TaskEntity {
    private Integer id;
    private String title;
    private StatusEnum status;

    public void toggleStatus() {
        this.setStatus(getStatus() == StatusEnum.Aberto ? StatusEnum.Feito : StatusEnum.Aberto);
    }

}
