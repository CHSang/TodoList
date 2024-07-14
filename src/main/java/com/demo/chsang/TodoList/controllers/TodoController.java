package com.demo.chsang.TodoList.controllers;

import com.demo.chsang.TodoList.models.TodoDTO;
import com.demo.chsang.TodoList.services.TodoService;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping
    public ResponseEntity<List<TodoDTO>> getAllTodos(@RequestParam(name = "user", required = false) String belongTo) {
        if (StringUtils.hasText(belongTo)) {
            return new ResponseEntity<>(todoService.getByBelongTo(belongTo), HttpStatus.OK);
        }
        return new ResponseEntity<>(todoService.getAllTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDTO> getTodoById(@PathVariable("id") Long id) {
        TodoDTO todo = todoService.getTodoById(id);
        return Objects.nonNull(todo) ? ResponseEntity.ok(todo) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TodoDTO> createTodo(@RequestBody TodoDTO todoDTO) {
        TodoDTO createdTodoEntity = todoService.createTodo(todoDTO);
        return new ResponseEntity<>(createdTodoEntity, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoDTO> updateTodo(@PathVariable("id") Long id, @RequestBody TodoDTO todoDtoDetails) {
        TodoDTO updatedTodoEntity = todoService.updateTodo(id, todoDtoDetails);
        return updatedTodoEntity != null ? ResponseEntity.ok(updatedTodoEntity) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/changeStatus")
    public ResponseEntity<TodoDTO> changeStatus(@PathVariable("id") Long id) {
        TodoDTO updatedTodoEntity = todoService.changeStatus(id);
        return updatedTodoEntity != null ? ResponseEntity.ok(updatedTodoEntity) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable("id") Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }
}
