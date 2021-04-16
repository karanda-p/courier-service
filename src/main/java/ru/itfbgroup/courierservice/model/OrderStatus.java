package ru.itfbgroup.courierservice.model;

public enum OrderStatus {

    DONE("Выполнен"),
    CANCELED("Отменен"),
    CREATED("Выполняется");

    private String value;

    OrderStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
