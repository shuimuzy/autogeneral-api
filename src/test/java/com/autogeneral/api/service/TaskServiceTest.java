package com.autogeneral.api.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.autogeneral.api.entity.Task;

/**
 * This is to test the TaskService.
 *
 * @author Simon Tian
 */
public class TaskServiceTest {

	TaskService taskService;

	@Before
	public void setUp() throws Exception {
		taskService = new TaskService();
	}

	@Test
	public void testValidateBrackets() {

		Task task = new Task();

		task.setInput(")");
		Task validatedTask = taskService.validateBrackets(task.getInput());
		assertNotNull(validatedTask);
		assertEquals(false, validatedTask.isBalanced());

		task.setInput("[]");
		validatedTask = taskService.validateBrackets(task.getInput());
		assertNotNull(validatedTask);
		assertEquals(true, validatedTask.isBalanced());

		task.setInput("{}()");
		validatedTask = taskService.validateBrackets(task.getInput());
		assertNotNull(validatedTask);
		assertEquals(true, validatedTask.isBalanced());

		task.setInput("{}[[()");
		validatedTask = taskService.validateBrackets(task.getInput());
		assertNotNull(validatedTask);
		assertEquals(false, validatedTask.isBalanced());

		task.setInput("[]{}()(){}[]()(){{{{{{}}}}}}))))");
		validatedTask = taskService.validateBrackets(task.getInput());
		assertNotNull(validatedTask);
		assertEquals(false, validatedTask.isBalanced());

	}
}
