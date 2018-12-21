package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.dao.TaskListDao;
import com.techelevator.model.TaskList;

@Controller
public class TodoController {
	
	@Autowired
	TaskListDao taskListDao;
	
	@RequestMapping(path={"/"}, method=RequestMethod.GET)
	public String showTaskLists(Model modelHolder) {
		List<TaskList> lists = taskListDao.getAllTaskLists();
		modelHolder.addAttribute("lists", lists);
		
		return "all";
	}
	
	@RequestMapping(path="/detail", method=RequestMethod.GET)
	public String showTaskListDetail(Model modelHolder, @RequestParam Long taskListId) {
		TaskList listToView = taskListDao.getTaskList(taskListId);
		if(listToView != null) {
			modelHolder.addAttribute("list", listToView);
		} else {
			throw new ResourceNotFoundException();
		}
		
		return "detail";
	}
	
	@RequestMapping(path="/new", method=RequestMethod.GET)
	public String newTaskListForm(Model modelHolder) {
		//DONE: is there anything you need to do before showing this form?
		if( ! modelHolder.containsAttribute("taskList")) {
			modelHolder.addAttribute("taskList", new TaskList());
		}
		return "new";
	}
	
	@RequestMapping(path="/new", method=RequestMethod.POST)
	public String saveNewTaskList(@ModelAttribute("taskList") TaskList newList) {
		taskListDao.save(newList);

				
		return "redirect:/";
	}
	
	@RequestMapping(path="/edit", method=RequestMethod.GET)
	public String editTaskList(Model modelHolder, @RequestParam Long taskListId) {
		TaskList listToEdit = taskListDao.getTaskList(taskListId);
		if(listToEdit != null) {
			modelHolder.addAttribute("taskList", listToEdit);
		} else {
			throw new ResourceNotFoundException();
		}
		
		return "edit";
	}
	
	@RequestMapping(path="/edit", method=RequestMethod.POST)
	public String saveEditTaskList(@ModelAttribute TaskList edittedList) {
		taskListDao.save(edittedList);

		
		return "redirect:/detail?listId=" + edittedList.getId();
	}
}
