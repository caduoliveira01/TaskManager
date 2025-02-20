package com.dev.backend.controller;

import com.dev.backend.dto.TaskCreateDto;
import com.dev.backend.dto.TaskDto;
import com.dev.backend.dto.TaskUpdateDto;
import com.dev.backend.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private TaskService taskService;

    @GetMapping
    public List<TaskDto> findAll(){
        return taskService.findAll();
    }

    @PostMapping
    public TaskDto create(@RequestBody TaskCreateDto taskDto){
        return taskService.createOrUpdate(taskDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> update (@PathVariable Long id, @RequestBody TaskUpdateDto taskUpdateDto){
        return ResponseEntity.ok(taskService.update(id,taskUpdateDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
