package com.demo.chsang.TodoList.mappers;

import com.demo.chsang.TodoList.entities.TodoEntity;
import com.demo.chsang.TodoList.models.TodoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    TodoMapper INSTANCE = Mappers.getMapper(TodoMapper.class);

    @Mapping(target = "id", ignore = true) // Ignore mapping id when creating new entity
    TodoEntity toEntity(TodoDTO dto);

    TodoDTO toDTO(TodoEntity entity);
}
