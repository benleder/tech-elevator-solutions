package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.TaskList;

public interface TaskListDao {

	TaskList getTaskList(Long taskListId);

	List<TaskList> getAllTaskLists();

	void save(TaskList newList);

}
