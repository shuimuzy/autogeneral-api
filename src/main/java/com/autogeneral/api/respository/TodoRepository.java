package com.autogeneral.api.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.autogeneral.api.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
