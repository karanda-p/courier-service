package ru.itfbgroup.courierservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ru.itfbgroup.courierservice.model.Order;
import ru.itfbgroup.courierservice.model.Status;
import ru.itfbgroup.courierservice.model.Task;
import ru.itfbgroup.courierservice.repository.TaskRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class ListenerService {

    private final TaskRepository taskRepository;
    private final TaskService taskService;

    @RabbitListener(queues = "${message.courier-queue}")
    public void receive(Order order){
        Task task = new Task();
        task.setOrderId(order.getId());
        task.setAddress(order.getAddress());
        task.setStatus(Status.ACCEPTED);
        taskService.sendTask(taskRepository.save(task));
        log.info("!!!");
    }
}
