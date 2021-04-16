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
    private final FoodDeliveryServiceIntegration foodDeliveryServiceIntegration;

    @Transactional
    public Task createNewTask(Order order){
        Task task = new Task();
        task.setOrderId(order.getId());
        task.setAddress(order.getAddress());
        task.setStatus(Status.ACCEPTED);
        Task savedTask = taskRepository.save(task);
//        foodDeliveryServiceIntegration.sendTaskToFoodDeliveryService(savedTask);
        return savedTask;
    }
}
