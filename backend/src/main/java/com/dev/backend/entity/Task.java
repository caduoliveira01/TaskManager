package com.dev.backend.entity;

import com.dev.backend.entity.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;
}
