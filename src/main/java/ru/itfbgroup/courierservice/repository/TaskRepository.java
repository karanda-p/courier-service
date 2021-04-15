package ru.itfbgroup.courierservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itfbgroup.courierservice.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
