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

	JPanel taskPanel = new JPanel();
	ArrayList<Task> taskList = new ArrayList<>();
	ButtonPanel buttonMenu;
	JPanel countCompletedPanel;

	public ToDo() {
		super("my todo application");
		buttonMenu = new ButtonPanel(this);
		add(buttonMenu, BorderLayout.NORTH);
		JScrollPane scroller = new JScrollPane(taskPanel);
		add(scroller, BorderLayout.CENTER);
		taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));
		
		
		//Ny panel prov
		countCompletedPanel = new JPanel ();
		//JLabel count = new JLabel();
		//count.add(taskList.stream().filter(Task::isComplete).count(),"of"+ taskList.size());
		add(countCompletedPanel,BorderLayout.SOUTH);

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
			taskList.add(task); // Daniel nytt: Lägger in i ArreyList först sen in i JPanel(för att kunna
								// sortera)
			taskPanel.removeAll();
			sortAndUppdateList();

			for (int i = 0; i < taskList.size(); i++) {
				taskPanel.add(taskList.get(i).getGuiComponent());
			}
			revalidate();
			repaint();
			System.out.println(taskList.size()); // test ta bort sen
		}
		if (event.getActionCommand() == "New StudyTask") {
			Task task = new StudyTask();

			task.setTaskListener(this);

			taskList.add(task);// Daniel nytt: Lägger in i ArreyList först sen in i JPanel(för att kunna
								// sortera)
			taskPanel.removeAll();
			for (int i = 0; i < taskList.size(); i++) {
				taskPanel.add(taskList.get(i).getGuiComponent());
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
		if (buttonMenu.getSortType() == 0) {

			Collections.sort(taskList, Comparator.comparing(Task::getText));
		}
		if (buttonMenu.getSortType() == 1) {
			Collections.sort(taskList, Comparator.comparing(Task::isComplete));
			System.out.print(taskList.stream().filter(Task::isComplete).count());// Daniel Prov för räcknare ta bort!
		}
		if (buttonMenu.getSortType() == 2) {
			Collections.sort(taskList, Comparator.comparing(Task::getTaskType));
		}
		taskPanel.removeAll();
		for (int i = 0; i < taskList.size(); i++) {
			taskPanel.add(taskList.get(i).getGuiComponent());
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
	}

	@Override
	public void taskChanged(Task t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void taskCompleted(Task t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void taskUncompleted(Task t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void taskCreated(Task t) {
		// TODO Auto-generated method stub

	}
}
