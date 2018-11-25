package com.autogeneral.api.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.autogeneral.api.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
