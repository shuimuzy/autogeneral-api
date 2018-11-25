package com.autogeneral.api.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.autogeneral.api.entity.Task;
import com.autogeneral.api.exception.ApiExceptionHandler;
import com.autogeneral.api.service.TaskService;

/**
 * This is to test the TaskController.
 *
 * @author Simon Tian
 */
public class TaskControllerTest {

	@Mock
	TaskService taskService;

	@InjectMocks
	TaskController taskController;

	@Rule
	public ExpectedException thrown;

	MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);

		mockMvc = MockMvcBuilders.standaloneSetup(taskController).setControllerAdvice(new ApiExceptionHandler())
				.build();

		thrown = ExpectedException.none();
	}

	@Test
	public void testValidateBrackets() throws Exception {

		Task task = new Task();
		task.setInput("(){}");
		task.setIsBalanced(true);

		when(taskService.validateBrackets(task.getInput())).thenReturn(task);

		mockMvc.perform(get("/tasks/validateBrackets?input=(){}")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.input", equalTo("(){}")));

		verify(taskService, times(1)).validateBrackets(task.getInput());
	}

}
