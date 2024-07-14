package com.demo.chsang.TodoList.repos;

import com.demo.chsang.TodoList.entities.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

    List<TodoEntity> getByBelongTo(String belongTo);

}
