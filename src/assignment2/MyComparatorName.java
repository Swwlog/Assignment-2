package assignment2;

import java.util.Comparator;

import se.his.it401g.todo.Task;

public class MyComparatorName implements Comparator<Task> {

	@Override
	public int compare(Task o1, Task o2) {

		return o1.getText().compareTo(o2.getText());
	}

}
