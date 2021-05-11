package ru.itfbgroup.courierservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ListenerService {

    @RabbitListener(queues = "${message.courier-queue}")
    public void receive(){
        log.info("!!!");
    }
}
