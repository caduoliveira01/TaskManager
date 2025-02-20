package com.dev.backend.mapper;

import com.dev.backend.dto.TaskCreateDto;
import com.dev.backend.dto.TaskDto;
import com.dev.backend.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel ="spring")
public interface TaskMapper {
    TaskDto taskDto(Task task);
    List<TaskDto> taskDtoList(List<Task> task);

    @Mapping(target = "id",ignore=true)
    Task toEntity(TaskCreateDto dto);
}
