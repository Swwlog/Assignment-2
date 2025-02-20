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
// add fixed screen		

		setBounds(400, 400, 600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	void start() {
		setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {

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

	}

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
		counter++;
		updateGUI();
	}

	@Override
	public void taskUncompleted(Task t) {
		counter--;
		updateGUI();
	}

	@Override
	public void taskCreated(Task t) {
		// TODO Auto-generated method stub
	}

	public static void main(String[] args) {

		ToDo todo = new ToDo();

		todo.start();

	}
}
