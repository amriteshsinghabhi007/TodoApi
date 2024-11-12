package com.ads.todos.todos_manager.Controller;
import com.ads.todos.todos_manager.Service.TodosService;
import com.ads.todos.todos_manager.Service.impl.TodoServiceimpl;
import com.ads.todos.todos_manager.exception.ExceptionResponse;
import com.ads.todos.todos_manager.exception.ResourceNotFoundEx;
import com.ads.todos.todos_manager.model.Todo;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.ads.todos.todos_manager.model.TodoList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/jpa/todos"})
public class TodosJpaController {
    Logger logger = LoggerFactory.getLogger(TodosJpaController.class);
    @Autowired
    private TodoServiceimpl todoServiceimpl;

    public TodosJpaController() {
    }

    @PostMapping
    public ResponseEntity<TodoList> createTodoHandler(@RequestBody TodoList todoList) {
        TodoList todoList1 = todoServiceimpl.createTodo(todoList);
        return new ResponseEntity(todoList1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TodoList>> getAllTodos() {
        List<TodoList> getall = todoServiceimpl.getAll();
        return new ResponseEntity(getall, HttpStatus.OK);
    }

    @GetMapping({"/{todoId}"})
    public ResponseEntity<TodoList> getSingleTodo(@PathVariable int todoId) {
        TodoList singletodo = todoServiceimpl.getSingle(todoId);
        return ResponseEntity.ok(singletodo);
    }

    @PutMapping({"/{todoId}"})
    public ResponseEntity<TodoList> getUpdatedTodo(@RequestBody TodoList newtodo, @PathVariable int todoId) {
        TodoList updatedTodo = todoServiceimpl.updateTodo(newtodo, todoId);
        return ResponseEntity.ok(updatedTodo);
    }

    @DeleteMapping({"/{todoId}"})
    public ResponseEntity<String> deleteTodo(@PathVariable int todoId) {
        todoServiceimpl.delete(todoId);
        return ResponseEntity.ok("Successfully Deleted");
    }

    @ExceptionHandler(ResourceNotFoundEx.class)
    public ResponseEntity<ExceptionResponse> handleResourceException(ResourceNotFoundEx ex) {
        this.logger.error("{}", ex.getMessage());
        ExceptionResponse rre = new ExceptionResponse();
        rre.setMessage(ex.getMessage());
        rre.setStatus(ex.getStatus());
        rre.setSuccess(false);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(rre);
    }
}
