package com.autogeneral.api.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.autogeneral.api.entity.Todo;
import com.autogeneral.api.respository.TodoRepository;

/**
 * This is to test the TodoService.
 *
 * @author Simon Tian
 */
public class TodoServiceTest {

	TodoService todoService;

	@Mock
	TodoRepository todoRepository;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		todoService = new TodoService(todoRepository);
	}

	@Test
	public void testGetTodoItemById() {

		Todo todo = new Todo();
		todo.setId(1L);
		todo.setText("qwertyuiop");

		Optional<Todo> optionalTD = Optional.of(todo);
		when(todoRepository.findById(anyLong())).thenReturn(optionalTD);

		Todo td = todoService.getTodoItemById(1L);
		assertNotNull(td);
		verify(todoRepository, times(1)).findById(anyLong());
		verify(todoRepository, never()).findAll();
	}

	@Test
	public void testCreateTodoItem() {

		Todo todo = new Todo();
		todo.setId(1L);
		todo.setText("qwertyuiop");

		when(todoRepository.save(todo)).thenReturn(todo);
		
		Todo td = todoService.createTodoItem(todo);

		assertEquals(td.getText(), todo.getText());
		verify(todoRepository, times(1)).save(todo);
	}

	@Test
	public void testUpdateTodoItem() {

		Todo todo = new Todo();
		todo.setId(1L);
		todo.setText("qwertyuiop");

		Optional<Todo> optionalTD = Optional.of(todo);

		when(todoRepository.findById(anyLong())).thenReturn(optionalTD);
		when(todoRepository.save(todo)).thenReturn(todo);

		Todo td = todoService.updateTodoItem(1L, todo);

		assertNotNull(td);
		verify(todoRepository, never()).findAll();
	}

}
