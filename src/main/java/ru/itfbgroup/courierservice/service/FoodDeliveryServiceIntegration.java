package ru.itfbgroup.courierservice.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "foodDeliveryIntegration", url = "${app.integration.food-delivery.url}")
public interface FoodDeliveryServiceIntegration {

//    public
}
