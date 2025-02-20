package com.dev.backend.service;

import com.dev.backend.dto.TaskCreateDto;
import com.dev.backend.dto.TaskDto;
import com.dev.backend.dto.TaskUpdateDto;
import com.dev.backend.entity.Task;
import com.dev.backend.mapper.TaskMapper;
import com.dev.backend.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private TaskRepository taskRepository;
    private TaskMapper taskMapper;

    public List<TaskDto> findAll(){
        return taskMapper.taskDtoList(taskRepository.findAll());
    }

    public TaskDto findById(Long id){
        Task task = taskRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Task not found:"));
        return taskMapper.taskDto(task);
    }

    public TaskDto createOrUpdate(TaskCreateDto taskDto){
        Task task = taskMapper.toEntity(taskDto);
        return taskMapper.taskDto(taskRepository.save(task));
    }

    public TaskDto update(Long id, TaskUpdateDto taskDto){
        return taskRepository.findById(id)
                .map(task ->{
                        if (taskDto.title()!=null) task.setTitle(taskDto.title());
                        if (taskDto.description()!=null) task.setDescription(taskDto.description());
                        if (taskDto.status()!=null) task.setStatus(taskDto.status());
                        return taskMapper.taskDto(taskRepository.save(task));
                }).orElseThrow(()-> new RuntimeException("Task not found"));
    }

    public void delete(Long id){
       taskRepository.deleteById(id);
    }
}
