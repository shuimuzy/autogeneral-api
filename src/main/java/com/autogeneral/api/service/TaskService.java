package com.autogeneral.api.service;

import java.util.ArrayDeque;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autogeneral.api.entity.Task;
import com.autogeneral.api.respository.TaskRepository;

/**
 * This is the business service for task which is to check if given bracket string is balanced or not.
 *
 * @author Simon Tian
 */
@Service
public class TaskService {

	@Autowired
	TaskRepository taskRepository;

	public Task validateBrackets(String inputStr) {
		Task task = new Task();
		task.setInput(inputStr);
		task.setIsBalanced(isBalanced(inputStr));
		return task;
	}

	/**
	 * This is to check if given bracket string is balanced or not.
	 * @param expression the give bracket string
	 * @return true if it is balanced or else false
	 */
	private static boolean isBalanced(String expression) {

		// Create HashMap to match opening brackets with closing brackets
		HashMap<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');

		if ((expression.length() % 2) != 0) {
			return false;
		}
		ArrayDeque<Character> deque = new ArrayDeque<>();
		for (int i = 0; i < expression.length(); i++) {
			Character ch = expression.charAt(i);
			if (map.containsKey(ch)) {
				deque.push(ch);
			} else if (deque.isEmpty() || ch != map.get(deque.pop())) {
				return false;
			}
		}
		return deque.isEmpty();
	}

}
