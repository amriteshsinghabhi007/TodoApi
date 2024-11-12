package com.ads.todos.todos_manager.dao;

import com.ads.todos.todos_manager.model.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class TodoDao {

    Logger logger = LoggerFactory.getLogger(TodoDao.class);

    @Autowired
    private JdbcTemplate template;

//    public TodoDao( JdbcTemplate template) {
//        this.template = template;
//
//        // Create table if not exist using JDBC
//         String createTable =" create table IF NOT EXISTS todos(id int primary key,title varchar(100) not null,content varchar(100),status varchar(100) not null,addedDate datetime,newDate datetime) ";
//         int updateTable = template.update(createTable);
//         logger.info("Table Created {}", updateTable);
//    }

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

     //Save Todo in DB using JDBC
//    public Todo saveTodo(Todo todo){
//        String insertQuery = " insert into todos(id,title,content,status,addedDate,newDate) values(?,?,?,?,?,?)";
//        int rows = template.update(insertQuery,todo.getId(),todo.getTitle(),todo.getContent(),todo.getStatus(),todo.getAddedDate(),todo.getNewDate());
//        logger.info("Mysql Operation {} row effected",rows);
//        return todo;
//    }
}
