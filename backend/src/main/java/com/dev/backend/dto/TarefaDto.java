package com.dev.backend.dto;

import com.dev.backend.entity.enums.TaskStatus;

public record TarefaDto(Long id, String title, String description, TaskStatus status) { }
