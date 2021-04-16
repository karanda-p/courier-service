package ru.itfbgroup.courierservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itfbgroup.courierservice.model.Order;
import ru.itfbgroup.courierservice.model.Status;
import ru.itfbgroup.courierservice.model.Task;
import ru.itfbgroup.courierservice.repository.TaskRepository;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    @Transactional
    public Task createNewTask(Order order){
        Task task = new Task();
        task.setAddress(order.getAddress());
        task.setStatus(Status.ACCEPTED);
        return taskRepository.save(task);
    }
}
