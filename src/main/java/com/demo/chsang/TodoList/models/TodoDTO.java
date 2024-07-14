package com.demo.chsang.TodoList.models;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TodoDTO {
    private Long id;

    @NotBlank
    private String title;
    private String description;
    private boolean completed;

    @NotBlank
    private String belongTo;
}
