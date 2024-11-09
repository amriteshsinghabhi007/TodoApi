package com.ads.todos.todos_manager.Controller;
import com.ads.todos.todos_manager.Service.TodosService;
import com.ads.todos.todos_manager.exception.ExceptionResponse;
import com.ads.todos.todos_manager.exception.ResourceNotFoundEx;
import com.ads.todos.todos_manager.model.Todo;
import java.util.Date;
import java.util.List;
import java.util.Random;
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
@RequestMapping({"/todos"})
public class TodosController {
    Logger logger = LoggerFactory.getLogger(TodosController.class);
    @Autowired
    private TodosService todoService;
    Random random = new Random();

    public TodosController() {
    }

    @PostMapping
    public ResponseEntity<Todo> createTodoHandler(@RequestBody Todo todo) {
        int id = random.nextInt(10);
        todo.setId(id);
        Date currentDate = new Date();
        logger.info("currentDate:- " + String.valueOf(currentDate));
        todo.setAddedDate(currentDate);
        logger.info("newDate:- " + String.valueOf(todo.getNewDate()));
        logger.info("Inside createTodoHandler");
        Todo todo1 = todoService.createTodo(todo);
        return new ResponseEntity(todo1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> getall = todoService.getAll();
        return new ResponseEntity(getall, HttpStatus.OK);
    }

    @GetMapping({"/{todoId}"})
    public ResponseEntity<Todo> getSingleTodo(@PathVariable int todoId) {
        Todo singletodo = todoService.getSingle(todoId);
        return ResponseEntity.ok(singletodo);
    }

    @PutMapping({"/{todoId}"})
    public ResponseEntity<Todo> getUpdatedTodo(@RequestBody Todo newtodo, @PathVariable int todoId) {
        Todo updatedTodo = todoService.UpdateTodo(newtodo, todoId);
        return ResponseEntity.ok(updatedTodo);
    }

    @DeleteMapping({"/{todoId}"})
    public ResponseEntity<String> deleteTodo(@PathVariable int todoId) {
        todoService.delete(todoId);
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
