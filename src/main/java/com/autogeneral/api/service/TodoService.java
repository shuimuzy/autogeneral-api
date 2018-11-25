package com.autogeneral.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autogeneral.api.entity.Todo;
import com.autogeneral.api.exception.ResourceNotFoundException;
import com.autogeneral.api.respository.TodoRepository;

/**
 * This is the business service to process Todo items. It includes query by given Id, create a Todo item and update a Todo item by given Id.
 *
 * @author Simon Tian
 */

@Service
public class TodoService {

	@Autowired
	TodoRepository todoRepository;
	
	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	/**
	 * This is to query a Todo item from database by a given Id.
	 * @param id the given Id
	 * @return a Todo item
	 */
	public Todo getTodoItemById(Long id) {
		
		Optional<Todo> todo = todoRepository.findById(id);
		if(!todo.isPresent()) {
			throw new ResourceNotFoundException(id.toString(), "NotFoundError");
		}
		return todo.get();
	}
	
	/**
	 * This is to save a Todo item into database.
	 * @param item the Todo item to be saved.
	 * @return a Todo item
	 */

	public Todo createTodoItem(Todo item) {
		return todoRepository.save(item);
	}

	/**
	 * This is to update a Todo item in database by a given Id.
	 * @param id the given Id
	 * @param item the Todo item to be updated.
	 * @return a Todo item
	 */
	public Todo updateTodoItem(Long id, Todo item) {

		Optional<Todo> todo = todoRepository.findById(id);
		if(!todo.isPresent()) {
			throw new ResourceNotFoundException(id.toString(), "NotFoundError");
		}
		
		todo.get().setText(item.getText());
		todo.get().setIsCompleted(item.getIsCompleted());

		return todoRepository.save(todo.get());
	}

}
