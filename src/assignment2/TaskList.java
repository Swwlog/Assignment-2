package assignment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JPanel;
import se.his.it401g.todo.Task;

public class TaskList extends JPanel {
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

	public ArrayList getList() {
		return taskList;
	}

	public void sortLists(int sortNumber) {

		if (sortNumber == 0) {
			Comparator comparator = new MyComparatorName();
			Collections.sort(taskList, comparator);

		}
		if (sortNumber == 1) {
			Comparator comparator = new MyComparatorIsComplete();
			Collections.sort(taskList, comparator);

		}
		if (sortNumber == 2) {
			Comparator comparator = new MyComparatorTaskType();
			Collections.sort(taskList, comparator);
		}

	}

}
