package ru.itfbgroup.courierservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.itfbgroup.courierservice.config.FeignClientConfig;
import ru.itfbgroup.courierservice.model.Task;

@FeignClient(name = "foodDeliveryIntegration"
        , url = "${app.integration.food-delivery.url}"
        , configuration = FeignClientConfig.class)
public interface FoodDeliveryServiceIntegration {

    @PostMapping("/task")
    public void sendTaskToFoodDeliveryService(@RequestBody Task task);
}
