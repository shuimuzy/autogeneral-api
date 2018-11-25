package com.autogeneral.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.autogeneral.api.entity.Task;
import com.autogeneral.api.exception.ValidationException;
import com.autogeneral.api.service.TaskService;

/**
 * It is a controller for task which is to check if given bracket string is balanced or not.
 *
 * @author Simon Tian
 */

@RestController
@RequestMapping("/")
public class TaskController {

	@Autowired
	TaskService taskService;

	@GetMapping("/tasks/validateBrackets")
	public Task validateBrackets(@RequestParam(required = true) String input) throws ValidationException {

		if (input.isEmpty() || input.length() == 0 || input.length() > 50)
			throw new ValidationException("ValidationError");
		
		return taskService.validateBrackets(input);

	}
}
