package com.techelevator.dao.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.dao.TodoDao;
import com.techelevator.model.Todo;

@Component
public class JdbcTodoDao implements TodoDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcTodoDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Todo> getTodosForList(Long listId) {
		SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT * FROM todos WHERE task_list_id=?", listId);
		
		List<Todo> todos = new ArrayList<>();
		while(results.next()){
			todos.add(mapRowToTodo(results));
		}
		
		return todos;
	}
	
	public void save(List<Todo> todos, Long listId) {
		for(Todo todo : todos) {
			if(todo.getId() == null) {
				if(! todo.getTask().equals("")) {
					Long id = jdbcTemplate.queryForObject("INSERT INTO todos (task, task_list_id) VALUES (?,?) RETURNING id",
						Long.class, todo.getTask(), listId);
					todo.setId(id);
				}
			} else {
				jdbcTemplate.update("UPDATE todos SET task=? WHERE id=?", todo.getTask(), todo.getId());
			}
		}
	}

	private Todo mapRowToTodo(SqlRowSet result) {
		Todo currentTodo = new Todo();
		currentTodo.setId(result.getLong("id"));
		currentTodo.setListId(result.getLong("task_list_id"));
		currentTodo.setTask(result.getString("task"));
		
		return currentTodo;
	}

}
