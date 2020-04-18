package com.todo.restful.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service 
public class ToDoHardcodedService {

	private static List<Todo> todos= new ArrayList<Todo>();
	
	private static long idCounter=0;
	static {
		todos.add(new Todo(++idCounter,"Varun","Get Ripped",new Date(),false));
		todos.add(new Todo(++idCounter,"Varun","Expertize Angular",new Date(),false));
		todos.add(new Todo(++idCounter,"Varun","Stop Giving a Fuck",new Date(),false));
		todos.add(new Todo(++idCounter,"Varun","Get a better job",new Date(),false));
		todos.add(new Todo(++idCounter,"Varun","QT3.14 Girlfriend",new Date(),false));
	}
	
	public List<Todo> findAll(){
		return todos;
	}
	
	public Todo deleteByID(long id) {
		Todo todo=findByID(id);
		
		if(todo == null)
			return null;
		
		if(todos.remove(todo)) {
			return todo;
		} 
		return null; 
	}

	public Todo findByID(long id) {
		 
		for(Todo todo: todos){
			if(todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
	
}
