package com.ads.todos.todos_manager.dao;

import com.ads.todos.todos_manager.model.Todo;
import com.ads.todos.todos_manager.model.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepo extends JpaRepository<TodoList,Integer> {
}
