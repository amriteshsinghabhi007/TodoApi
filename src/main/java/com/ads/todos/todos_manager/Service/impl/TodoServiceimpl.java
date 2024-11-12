package com.ads.todos.todos_manager.Service.impl;

import com.ads.todos.todos_manager.Service.TodoServiceJpa;
import com.ads.todos.todos_manager.dao.TodoRepo;
import com.ads.todos.todos_manager.model.Todo;
import com.ads.todos.todos_manager.model.TodoList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class TodoServiceimpl implements TodoServiceJpa {

    Logger logger = LoggerFactory.getLogger(TodoServiceimpl.class);
    @Autowired
    private TodoRepo todoRepo;


    @Override
    public TodoList createTodo(TodoList todoList) {
        Date currentDate = new Date();
        todoList.setAddedDate(currentDate);
        TodoList saveTodo = todoRepo.save(todoList);
        logger.info("save Data into DB {} {}",saveTodo,saveTodo.getId());
        return saveTodo;
    }

    @Override
    public TodoList getSingle(int todoId) {
        Optional<TodoList> optionalUser= todoRepo.findById(todoId);
        TodoList getTodoList = optionalUser.orElseThrow(()->new RuntimeException("Given User not found"));
        return getTodoList;
    }

    @Override
    public List<TodoList> getAll() {
        List<TodoList> getTodoAll=todoRepo.findAll();
        logger.info("get All Todo {}",getTodoAll);
        return getTodoAll;
    }

    @Override
    public TodoList updateTodo(TodoList todoList, int todoId) {
        TodoList updateTodo = todoRepo.findById(todoId).orElseThrow(()->new RuntimeException("Given id is not present in DB"));
        updateTodo.setTitle(todoList.getTitle());
        updateTodo.setContent(todoList.getContent());
        updateTodo.setStatus(todoList.getStatus());
        Date currentDate = new Date();
        updateTodo.setAddedDate(currentDate);
        updateTodo.setNewDate(todoList.getNewDate());
        logger.info("Updated Todo {}",updateTodo);
        TodoList updatedTodo = todoRepo.save(updateTodo);
        return updatedTodo;
    }

    @Override
    public void delete(int todoId) {
        TodoList deleteTodo = todoRepo.findById(todoId).orElseThrow(()->new RuntimeException("Given todoId is not present"));
        todoRepo.delete(deleteTodo);
    }
}
