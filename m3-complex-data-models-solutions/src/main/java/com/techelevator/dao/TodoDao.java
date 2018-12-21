package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Todo;

public interface TodoDao {

	List<Todo> getTodosForList(Long id);

	void save(List<Todo> todos, Long id);

}
