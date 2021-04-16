package ru.itfbgroup.courierservice.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "task")
@Data
public class Task {

    @Id
    @SequenceGenerator(sequenceName = "task_seq", name = "task_id_gen")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_id_gen")
    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "info")
    private String info;

    @Column(name = "status")
    private Status status;

    @Column(name = "address")
    private String address;
}
