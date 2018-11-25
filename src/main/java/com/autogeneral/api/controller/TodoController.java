package com.autogeneral.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autogeneral.api.entity.Todo;
import com.autogeneral.api.exception.ValidationException;
import com.autogeneral.api.service.TodoService;

/**
 * It is a controller for Todo which is to get, create or update Todo items.
 *
 * @author Simon Tian
 */

@RestController
@RequestMapping("/")
public class TodoController {

	@Autowired
	TodoService todoSerice;

	@GetMapping("/todo/{id}")
	public Todo getTodoById(@PathVariable(value = "id") Long id) {
		return todoSerice.getTodoItemById(id);
	}

	@PostMapping("/todo")
	public Todo createTodo(@Valid @RequestBody Todo item) throws ValidationException {
		String text = item.getText();
		if (text.isEmpty() || text.length() == 0 || text.length() > 50)
			throw new ValidationException("ValidationError");
		
		return todoSerice.createTodoItem(item);
	}

	@PatchMapping("/todo/{id}")
	public Todo updateTodo(@PathVariable(value = "id") Long id, @Valid @RequestBody Todo item) throws ValidationException {
		String text = item.getText();
		if (text.isEmpty() || text.length() == 0 || text.length() > 50)
			throw new ValidationException("ValidationError");
		
		return todoSerice.updateTodoItem(id, item);
	}
}
