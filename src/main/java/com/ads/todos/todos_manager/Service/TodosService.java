package com.ads.todos.todos_manager.Service;
import com.ads.todos.todos_manager.exception.ResourceNotFoundEx;
import com.ads.todos.todos_manager.model.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class TodosService {
    Logger logger = LoggerFactory.getLogger(TodosService.class);
    List<Todo> todos = new ArrayList();

    public TodosService() {
    }

    public Todo createTodo(Todo todo) {
        this.todos.add(todo);
        this.logger.info("Todos Request {}", this.todos);
        return todo;
    }

    public List<Todo> getAll() {
        return this.todos;
    }

    public Todo getSingle(int todoId) {
        Todo todo = (Todo)this.todos.stream().filter((t) -> {
            return todoId == t.getId();
        }).findAny().orElseThrow(() -> {
            return new ResourceNotFoundEx("Todo not found", HttpStatus.NOT_FOUND);
        });
        return todo;
    }

    public Todo UpdateTodo(Todo todo, int todoId) {
        List<Todo> newUpdateList = (List)this.todos.stream().map((t) -> {
            if (todoId == t.getId()) {
                t.setTitle(todo.getTitle());
                t.setContent(todo.getContent());
                t.setStatus(todo.getStatus());
                return t;
            } else {
                return t;
            }
        }).collect(Collectors.toList());
        this.todos = newUpdateList;
        todo.setId(todoId);
        return todo;
    }

    public void delete(int todoId) {
        List<Todo> newTodo = (List)this.todos.stream().filter((t) -> {
            return todoId != t.getId();
        }).collect(Collectors.toList());
        this.todos = newTodo;
    }
}
