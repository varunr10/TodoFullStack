package com.todo.restful.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TodoController{

	@Autowired
	private ToDoHardcodedService hardCodedService;
	
	@GetMapping(path="/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username){
		return hardCodedService.findAll();
	}
	
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodoById(
			@PathVariable String username, @PathVariable long id)
	{
		System.out.println("DeleteMapping ----> Reached here");
		Todo todo = hardCodedService.deleteByID(id);
		
		if(todo!=null)
			return ResponseEntity.noContent().build();
		else
			return ResponseEntity.notFound().build();
	}
}
