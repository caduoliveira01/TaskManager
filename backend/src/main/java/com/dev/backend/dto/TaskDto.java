package com.dev.backend.dto;

import com.dev.backend.entity.enums.TaskStatus;

public record TaskDto(Long id, String title, String description, TaskStatus status) { }
