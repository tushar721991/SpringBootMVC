package com.tt.BankFrontEnd.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tt.BankFrontEnd.entities.Todo;
import com.tt.BankFrontEnd.service.TodoService;

@Controller
public class TodoController {

	@Autowired
	private TodoService todoService;

	public void InitBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));
	}
	
	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showTodos(HttpServletRequest request, ModelMap model) {
		String name = (String) request.getSession().getAttribute("username");
		model.put("name", name);
		model.put("todos", todoService.retrieveTodos(name));
		return "list-todos";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showTodoPage(HttpServletRequest request, ModelMap model) {
		Todo todo = new Todo();
		todo.setUser((String) request.getSession().getAttribute("username"));
		model.addAttribute("todo", todo);
		return "todo";
	}

	
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(HttpServletRequest request, 
			ModelMap model, 
			@Valid Todo todo, 
			BindingResult result, 
			@RequestParam String desc) {

		if (result.hasErrors()) {
			return "todo";
		}
		String name = (String) request.getSession().getAttribute("username");
		todo.setUser(name);
		todoService.addTodo(todo.getUser(), desc, todo.getTargetDate(), false);
		return "redirect:/list-todos";
	}

	
	@RequestMapping(value="/update-todo", method=RequestMethod.GET)
	public String showUpdateTodoPage(ModelMap model, @RequestParam int id) {
		Todo todo = todoService.retrieveTodos("Tushar", id);
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="/update-todo", method=RequestMethod.POST) 
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result, HttpServletRequest request) {

		if(result.hasErrors()) {
			return "todo";			
		}
		String user = (String) request.getSession().getAttribute("username");
		
		todo.setUser(user);
		todoService.updateTodo(todo);
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteTodo(id);
		return "redirect:/list-todos";
	}


}
