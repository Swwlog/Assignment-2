package assignment2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

	JPanel taskPanel;// = new JPanel();
	ArrayList<Task> taskList = new ArrayList<>();
	TaskList lista = new TaskList();
	ButtonPanel buttonMenu;
	JPanel countCompletedPanel;
	long Counter = 0;

	public ToDo() {
		super("my todo application");
		buttonMenu = new ButtonPanel(this);
		add(buttonMenu, BorderLayout.NORTH);
		taskPanel = new TaskList();
		add(taskPanel, BorderLayout.CENTER);
		JScrollPane scroller = new JScrollPane(taskPanel);
		add(scroller, BorderLayout.CENTER);
		taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));

		// Ny panel för att räkna complited
		countCompletedPanel = new JPanel();
		JLabel count = new JLabel("" + Counter + " of " + taskList.size());
		countCompletedPanel.add(count);
		add(countCompletedPanel, BorderLayout.SOUTH);

		setBounds(400, 400, 400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	void start() {
		setVisible(true);

	}

	public void actionPerformed(ActionEvent event) {
		event.getActionCommand(); // returns string on buttons
		if (event.getActionCommand() == "New HomeTask") {
			Task task = new HomeTask();
			task.setTaskListener(this);
			lista.addToList(task); // Daniel nytt: Lägger in i ArreyList först sen in i JPanel(för att kunna
									// sortera)
			taskPanel.removeAll();
			sortAndUppdateList();

			for (int i = 0; i < lista.getArraySize(); i++) {
				taskPanel.add(lista.getTaskElement(i).getGuiComponent());
			}
			revalidate();
			repaint();
			System.out.println(taskList.size()); // test ta bort sen
		}
		if (event.getActionCommand() == "New StudyTask") {
			Task task = new StudyTask();
			task.setTaskListener(this);

			lista.addToList(task); // Daniel nytt: Lägger in i ArreyList först sen in i JPanel(för att kunna
									// sortera)
			taskPanel.removeAll();
			sortAndUppdateList();

			for (int i = 0; i < lista.getArraySize(); i++) {
				taskPanel.add(lista.getTaskElement(i).getGuiComponent());
			}
			revalidate();
			repaint();
			System.out.println(taskList.size()); // test ta bort sen

		}
		if (event.getActionCommand() == "New CostomTask") {
			Task task = new HomeTask();

			task.setTaskListener(this);

			taskList.add(task);// Daniel nytt: Lägger in i ArreyList först sen in i JPanel(för att kunna
								// sortera)
			taskPanel.removeAll();
			for (int i = 0; i < taskList.size(); i++) {
				taskPanel.add(taskList.get(i).getGuiComponent());
			}

			JLabel count = new JLabel("" + Counter + " of " + taskList.size() + " complited");
			countCompletedPanel.removeAll();
			countCompletedPanel.add(count);
			revalidate();
			repaint();

			System.out.println(taskList.size());// Test ta bort sen

		}
		if (event.getActionCommand() == "comboBoxChanged") { // When the JComboBox chages, this picks it upp and calls
																// the sort method.
			sortAndUppdateList();

		}

		System.out.println(event.getActionCommand());
	}

	// Sorting metod that sort the list in 3 difrent ways and uppdate the new list
	// to panel
	public void sortAndUppdateList() {

		lista.sortLists(buttonMenu.getSortType());

		taskPanel.removeAll();
		
		for (int i = 0; i < lista.getArraySize(); i++) {
			taskPanel.add(lista.getTaskElement(i).getGuiComponent());
		}
		revalidate();
		repaint();
	}

	public static void main(String[] args) {

		ToDo todo = new ToDo();

		todo.start();

	}

	@Override
	public void taskRemoved(Task t) {
		taskList.remove(t);
		sortAndUppdateList();
		Counter = taskList.stream().filter(Task::isComplete).count();
		JLabel count = new JLabel("" + Counter + " of " + taskList.size() + " complited");
		countCompletedPanel.removeAll();
		countCompletedPanel.add(count);
		revalidate();
		repaint();
	}

	@Override
	public void taskChanged(Task t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void taskCompleted(Task t) {
		// TODO Auto-generated method stub
		Counter = taskList.stream().filter(Task::isComplete).count();
		JLabel count = new JLabel("" + Counter + " of " + taskList.size() + " complited");
		countCompletedPanel.removeAll();
		countCompletedPanel.add(count);
		revalidate();
		repaint();
	}

	@Override
	public void taskUncompleted(Task t) {
		// TODO Auto-generated method stub
		Counter = taskList.stream().filter(Task::isComplete).count();
		JLabel count = new JLabel("" + Counter + " of " + taskList.size() + " complited");
		countCompletedPanel.removeAll();
		countCompletedPanel.add(count);
		revalidate();
		repaint();
	}

	@Override
	public void taskCreated(Task t) {
		// TODO Auto-generated method stub

	}
}
