package assignment2;

import java.util.Comparator;

import se.his.it401g.todo.Task;

public class MyComparatorIsComplete implements Comparator<Task> {

	@Override
	public int compare(Task o1, Task o2) {
		Boolean a= o1.isComplete();
		Boolean b= o2.isComplete();
		return a.compareTo(b);
	}

}
