package com.demo.chsang.TodoList.services;

import com.demo.chsang.TodoList.entities.TodoEntity;
import com.demo.chsang.TodoList.mappers.TodoMapper;
import com.demo.chsang.TodoList.models.TodoDTO;
import com.demo.chsang.TodoList.repos.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;

    public List<TodoDTO> getAllTodos() {
        return todoRepository.findAll().stream().map(todoMapper::toDTO).collect(Collectors.toList());
    }

    public TodoDTO getTodoById(Long id) {
        return todoRepository.findById(id).map(todoMapper::toDTO).orElseThrow();
    }

    public TodoDTO createTodo(TodoDTO todoDTO) {
        TodoEntity todoEntity = todoMapper.toEntity(todoDTO);
        return Optional.of(todoRepository.save(todoEntity)).map(todoMapper::toDTO).orElseThrow();
    }

    public TodoDTO updateTodo(Long id, TodoDTO todoDTODetails) {
        Optional<TodoEntity> todoOptional = todoRepository.findById(id);
        if (todoOptional.isPresent()) {
            TodoEntity todoEntity = todoOptional.get();
            todoEntity.setTitle(todoDTODetails.getTitle());
            todoEntity.setDescription(todoDTODetails.getDescription());
            todoEntity.setCompleted(todoDTODetails.isCompleted());
            todoEntity.setBelongTo(todoDTODetails.getBelongTo());
            return Optional.of(todoRepository.save(todoEntity)).map(todoMapper::toDTO).orElseThrow();
        }
        return null;
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    public TodoDTO changeStatus(Long id) {
        Optional<TodoEntity> todoOptional = todoRepository.findById(id);
        if (todoOptional.isPresent()) {
            TodoEntity todoEntity = todoOptional.get();
            todoEntity.setCompleted(!todoEntity.isCompleted());
            return Optional.of(todoRepository.save(todoEntity)).map(todoMapper::toDTO).orElseThrow();
        }
        return null;
    }

    public List<TodoDTO> getByBelongTo(String belongTo) {
        return todoRepository.getByBelongTo(belongTo).stream().map(todoMapper::toDTO).collect(Collectors.toList());
    }

}
