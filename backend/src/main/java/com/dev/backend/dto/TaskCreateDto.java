package com.dev.backend.dto;

import com.dev.backend.entity.enums.TaskStatus;
import jakarta.validation.constraints.NotBlank;

public record TaskCreateDto(
        @NotBlank(message = "Titulo é obrigatorio")
        String title,
        String description,
        TaskStatus status
        ){}
