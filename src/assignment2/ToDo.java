package assignment2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import se.his.it401g.todo.HomeTask;
import se.his.it401g.todo.StudyTask;
import se.his.it401g.todo.Task;

import se.his.it401g.todo.TaskListener;

// implement TaskListener kanske??

public class ToDo extends JFrame implements ActionListener, TaskListener {
	private JPanel taskPanel;
	private TaskList taskList = new TaskList();
	private ButtonPanel buttonMenu;
	private JPanel countCompletedPanel;
	private int counter = 0;

	public ToDo() {
		super("my todo application");
		buttonMenu = new ButtonPanel(this);
		add(buttonMenu, BorderLayout.NORTH);
		taskPanel = new TaskList();
		add(taskPanel, BorderLayout.CENTER);
		JScrollPane scroller = new JScrollPane(taskPanel);
		add(scroller, BorderLayout.CENTER);
		taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));
		
		
		countCompletedPanel = new JPanel();
		JLabel count = new JLabel("" + counter + " of " + taskList.getArraySize());
		countCompletedPanel.add(count);
		add(countCompletedPanel, BorderLayout.SOUTH);

		setBounds(400, 400, 600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	void start() {
		setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		event.getActionCommand(); // returns string on buttons

		switch (event.getActionCommand()) {

		case "New HomeTask":
			Task task = new HomeTask();
			task.setTaskListener(this);
			taskList.addToList(task);
			updateGUI();

			break;

		case "New StudyTask":
			task = new StudyTask();
			task.setTaskListener(this);
			taskList.addToList(task);
									
			updateGUI();

			break;

		case "New WorkTask":
			task = new WorkTask();
			task.setTaskListener(this);
			taskList.addToList(task); 
									
			updateGUI();

			break;

		case "comboBoxChanged":
			updateGUI();
			break;

		}

		/*
		 * Keep in case something breaks if (event.getActionCommand() == "New HomeTask")
		 * { Task task = new HomeTask(); task.setTaskListener(this);
		 * lista.addToList(task); // Daniel nytt: Lägger in i ArreyList först sen in i
		 * JPanel(för att kunna
		 * 
		 * updateGUI();
		 * 
		 * } if (event.getActionCommand() == "New StudyTask") { Task task = new
		 * StudyTask(); task.setTaskListener(this); lista.addToList(task); // Daniel
		 * nytt: Lägger in i ArreyList först sen in i JPanel(för att kunna // sortera)
		 * updateGUI();
		 * 
		 * }
		 * 
		 * if (event.getActionCommand() == "New WorkTask") { Task task = new WorkTask();
		 * task.setTaskListener(this); lista.addToList(task); // Daniel nytt: Lägger in
		 * i ArreyList först sen in i JPanel(för att kunna // sortera) updateGUI();
		 * 
		 * }
		 * 
		 * if (event.getActionCommand() == "comboBoxChanged") { // When the JComboBox
		 * chages, this picks it upp and calls // the sort method. updateGUI();
		 * 
		 * }
		 */

	}

	// Sorting metod that sort the list in 3 difrent ways and uppdate the new list
	// to panel
	public void updateGUI() {

		taskList.sortLists(buttonMenu.getSortType());
		taskPanel.removeAll();

		for (int i = 0; i < taskList.getArraySize(); i++) {
			taskPanel.add(taskList.getTaskElement(i).getGuiComponent());
		}

		JLabel count = new JLabel("" + counter + " of " + taskList.getArraySize() + " complited");
		countCompletedPanel.removeAll();
		countCompletedPanel.add(count);

		revalidate();
		repaint();
	}

	public static void main(String[] args) {

		ToDo todo = new ToDo();

		todo.start();

	}

	@Override
	public void taskRemoved(Task t) {

		if (t.isComplete()) {
			counter--;
		}
		taskList.removeFromList(t);
		updateGUI();
	}

	@Override
	public void taskChanged(Task t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void taskCompleted(Task t) {
		// TODO Auto-generated method stub
		counter++;
		updateGUI();
	}

	@Override
	public void taskUncompleted(Task t) {
		// TODO Auto-generated method stub
		counter--;
		updateGUI();
	}

	@Override
	public void taskCreated(Task t) {
		// TODO Auto-generated method stub
	}
}
