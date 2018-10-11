package com.tt.BankFrontEnd.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tt.BankFrontEnd.entities.Todo;

@Service
public class TodoService {

	private static List<Todo> todoList = new ArrayList<Todo>();
	private static int todoCount = 4;
	static {
		todoList.add(new Todo(101, "Tushar", "A", new Date(), false));
		todoList.add(new Todo(102, "Tushar", "B", new Date(), false));
		todoList.add(new Todo(103, "Tushar", "C", new Date(), false));
		todoList.add(new Todo(104, "Mak", "D", new Date(), false));
	}

	public List<Todo> retrieveTodos(String user) {
		return todoList.stream().filter(todo -> todo.getUser().equalsIgnoreCase(user)).collect(Collectors.toList());
	}

	public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
		todoList.add(new Todo(++todoCount, name, desc, targetDate, isDone));
	}

	public void deleteTodo(int id) {
		todoList.removeIf(todo -> todo.getId() == id);
	}

	public Todo retrieveTodos(String user, int id) {
		// TODO Auto-generated method stub
		return todoList
				.stream()
				.filter(todo -> todo.getUser().equalsIgnoreCase(user) && todo.getId() == id)
				.collect(Collectors.toList()).get(0);	
	}
}
