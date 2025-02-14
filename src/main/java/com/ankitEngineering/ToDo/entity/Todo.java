package com.ankitEngineering.ToDo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
//import lombok.Setter;

@Entity
//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "todos")
public class Todo {

    @Id //Marks this as primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment Id
    private Long id;
    @Column(nullable = false) //This field cannot be empty
    private String taskTitle;
    private String description;
    private boolean completedStatus;

    public Todo(Long id, String taskTitle, String description, boolean completedStatus) {
        this.id = id;
        this.taskTitle = taskTitle;
        this.description = description;
        this.completedStatus = completedStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompletedStatus() {
        return completedStatus;
    }

    public void setCompletedStatus(boolean completedStatus) {
        this.completedStatus = completedStatus;
    }
}
