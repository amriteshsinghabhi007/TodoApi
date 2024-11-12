package com.ads.todos.todos_manager.Service;

import com.ads.todos.todos_manager.model.Todo;
import com.ads.todos.todos_manager.model.TodoList;

import java.util.List;

public interface TodoServiceJpa {
    public TodoList createTodo(TodoList todoList);
    public TodoList getSingle(int todoId);
    public List<TodoList> getAll();
    public TodoList updateTodo(TodoList todoList, int todoId);
    public void delete(int todoId);

}
