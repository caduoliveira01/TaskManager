package com.dev.backend.dto;

import com.dev.backend.entity.enums.TaskStatus;

public record TaskUpdateDto(String title, String description, TaskStatus status) {}
