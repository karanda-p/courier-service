package ru.itfbgroup.courierservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itfbgroup.courierservice.model.Order;
import ru.itfbgroup.courierservice.model.Task;
import ru.itfbgroup.courierservice.service.TaskService;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public Task createNewTask(@RequestBody Order order){
        return taskService.createNewTask(order);
    }
}
