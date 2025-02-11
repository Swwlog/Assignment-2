package assignment2;

import javax.swing.JFrame;

//import se.his.it401g.todo.TaskListener;
import se.his.it401g.todo.HomeTask;
import se.his.it401g.todo.Task;

public class ToDo {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		//knapp för lägga till HomeTask
		Task task = new HomeTask();
		frame.add(task.getGuiComponent());
		
		
		frame.setBounds(100, 100, 400, 100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
