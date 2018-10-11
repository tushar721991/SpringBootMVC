package com.tt.BankFrontEnd.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tt.BankFrontEnd.entities.Todo;
import com.tt.BankFrontEnd.service.TodoService;

@Controller
public class TodoController {

	@Autowired
	private TodoService todoService;

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showTodos(HttpServletRequest request, ModelMap model) {
		String name = (String) request.getSession().getAttribute("username");
		model.put("name", name);
		model.put("todos", todoService.retrieveTodos(name));
		return "list-todos";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showTodoPage(ModelMap model) {
		model.addAttribute("desc", "");
		return "todo";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, 
			@Valid Todo todo, 
			BindingResult result, 
			@RequestParam String desc) {

		if (result.hasErrors()) {
			return "todo";
		}
//		String desc = (String) model.get("desc");
//		String name = (String) (String) request.getSession().getAttribute("username");
		todoService.addTodo("Tushar", desc, new Date(), false);
		return "redirect:/list-todos";
	}

	
	@RequestMapping(value="/update-todo", method=RequestMethod.GET)
	public String showUpdateTodoPage(ModelMap model, @RequestParam int id) {
		Todo todo = todoService.retrieveTodos("Tushar", id);
		model.addAttribute("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteTodo(id);
		return "redirect:/list-todos";
	}


}
