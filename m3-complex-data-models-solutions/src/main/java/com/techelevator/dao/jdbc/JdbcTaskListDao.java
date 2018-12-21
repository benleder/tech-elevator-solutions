package com.techelevator.dao.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.dao.TaskListDao;
import com.techelevator.dao.TodoDao;
import com.techelevator.model.TaskList;

@Component
public class JdbcTaskListDao implements TaskListDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private TodoDao todoDao;
	
	@Autowired
	public JdbcTaskListDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public TaskList getTaskList(Long taskListId) {
		SqlRowSet result = jdbcTemplate.queryForRowSet("SELECT * FROM task_lists WHERE id=?", taskListId);
		if(result.next()){
			return mapRowToTaskList(result);
		} else {
			return null;
		}
	}

	@Override
	public List<TaskList> getAllTaskLists() {
		SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT * FROM task_lists");
		
		List<TaskList> allLists = new ArrayList<>();
		while(results.next()) {
			allLists.add(mapRowToTaskList(results));
		}
		
		return allLists;
	}
	
	public void save(TaskList listToSave) {
		if(listToSave.getId() == null) {
			Long id = jdbcTemplate.queryForObject("INSERT INTO task_lists (name) VALUES (?) RETURNING id",
					Long.class, listToSave.getName());
			listToSave.setId(id);
			
			todoDao.save(listToSave.getTodos(), id);
		} else {
			jdbcTemplate.update("UPDATE task_lists SET name=? WHERE id=?", listToSave.getName(), listToSave.getId());
			todoDao.save(listToSave.getTodos(), listToSave.getId());
		}
	}

	private TaskList mapRowToTaskList(SqlRowSet result) {
		TaskList currentList = new TaskList();
		currentList.setId(result.getLong("id"));
		currentList.setName(result.getString("name"));
		
		currentList.setTodos(todoDao.getTodosForList(currentList.getId()));
		
		return currentList;
	}

}
