package com.ankitEngineering.ToDo.service;


import com.ankitEngineering.ToDo.entity.Todo;
import com.ankitEngineering.ToDo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAll(){
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodoById(Long id){
        return todoRepository.findById(id);
    }

    public Todo createTodo(Todo todo){
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Long id, Todo updatedTodo){
        Optional<Todo> existingTodo = todoRepository.findById(id);
        if(existingTodo.isPresent()){
            Todo todo = existingTodo.get();
            todo.setTaskTitle(updatedTodo.getTaskTitle());
            todo.setDescription(updatedTodo.getDescription());
            todo.setCompletedStatus(updatedTodo.isCompletedStatus());
            return todoRepository.save(todo);
        }
        return  null;
    }

    public void deleteTodo(Long id){
        todoRepository.deleteById(id);
    }
}
