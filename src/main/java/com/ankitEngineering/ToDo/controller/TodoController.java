package com.ankitEngineering.ToDo.controller;


import com.ankitEngineering.ToDo.entity.Todo;
import com.ankitEngineering.ToDo.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private TodoService todoService;

    @PostMapping("/")
    public ResponseEntity<Todo> addNewTodo(@RequestBody Todo todo){
        return ResponseEntity.ok(todoService.createTodo(todo));
    }

    @GetMapping("/")
    public ResponseEntity<List<Todo>> getAllTodo(){
        List<Todo> getTodo = todoService.getAll();
        return ResponseEntity.ok(getTodo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Todo>> getTodoById(@PathVariable Long id){
        return ResponseEntity.ok(todoService.getTodoById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo updatedTodo){
        return ResponseEntity.ok(todoService.updateTodo(id, updatedTodo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodoById(@PathVariable Long id){
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }
}
