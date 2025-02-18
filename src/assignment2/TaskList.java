package assignment2;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import se.his.it401g.todo.Task;

public class TaskList extends JPanel{
	ArrayList<Task> taskList;
	
	public TaskList() {
		taskList = new ArrayList<>();
	}
	
	public void addToList(Task t) {
		taskList.add(t);
	}
	
	public void removeFromList(Task t) {
		taskList.remove(t);
	}
	
	public int getArraySize() {
		return taskList.size();
	}
	
	public Task getTaskElement(int index) {
		return taskList.get(index);
	}
	
	public void sortLists(int sortNumber) {
		
		System.out.println(sortNumber + " from new class");
		
		if (sortNumber == 0) {

			Collections.sort(taskList, Comparator.comparing(Task::getText));
		}
		if (sortNumber == 1) {
			Collections.sort(taskList, Comparator.comparing(Task::isComplete));
		}
		if (sortNumber == 2) {
			Collections.sort(taskList, Comparator.comparing(Task::getTaskType));
		}
				
		}

	}

