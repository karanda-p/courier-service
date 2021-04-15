package ru.itfbgroup.courierservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itfbgroup.courierservice.repository.TaskRepository;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
}
