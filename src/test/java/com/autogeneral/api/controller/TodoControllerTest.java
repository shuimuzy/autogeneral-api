package com.autogeneral.api.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.autogeneral.api.entity.Todo;
import com.autogeneral.api.exception.ApiExceptionHandler;
import com.autogeneral.api.service.TodoService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This is to test the TodoController.
 *
 * @author Simon Tian
 */
public class TodoControllerTest {

	@Mock
	TodoService todoService;

	@InjectMocks
	TodoController todoController;

	MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		mockMvc = MockMvcBuilders.standaloneSetup(todoController).setControllerAdvice(new ApiExceptionHandler())
				.build();
	}

	@Test
	public void testGetTodoById() throws Exception {

		Todo todo = new Todo();
		todo.setId(1L);
		todo.setText("qwertyui");

		when(todoService.getTodoItemById(anyLong())).thenReturn(todo);

		mockMvc.perform(get("/todo/" + anyLong())
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.text", equalTo("qwertyui")));
	}

/*
	@Test
	public void testCreateTodo() throws Exception {

		Todo todo = new Todo();
		todo.setId(1L);
		todo.setText("asdfghjk");

		Todo td = new Todo();
		td.setText(todo.getText());

		when(todoService.createTodoItem(todo)).thenReturn(td);
		
		mockMvc.perform(post("/todo")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(todo)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.text", equalTo("asdfghjk")));
	}

	@Test
	public void testUpdateTodo() throws Exception {

		Todo todo = new Todo();
		todo.setId(1L);
		todo.setText("zxcvbnm");

		Todo td = new Todo();
		td.setText(todo.getText());
		td.setIsCompleted(true);

		when(todoService.updateTodoItem(1L, todo)).thenReturn(td);

		mockMvc.perform(patch("/todo/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(todo)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.text", equalTo("zxcvbnm")))
				.andExpect(jsonPath("$.isCompleted", equalTo(true)));

	}

*/
	String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
