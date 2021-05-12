package ru.itfbgroup.courierservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
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
    private final RabbitTemplate rabbitTemplate;
    private final TopicExchange exchange;

    @Value("${message.food-delivery-routing-key}")
    private String routingKey;

    @Transactional
    public Task createNewTask(Order order){
        Task task = new Task();
        task.setOrderId(order.getId());
        task.setAddress(order.getAddress());
        task.setStatus(Status.ACCEPTED);
        Task savedTask = taskRepository.save(task);
        return savedTask;
    }

    public void sendTask(Task task){
        rabbitTemplate.convertAndSend(exchange.getName(), routingKey, task);
    }
}
