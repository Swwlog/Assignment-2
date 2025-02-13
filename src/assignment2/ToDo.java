package assignment2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import se.his.it401g.todo.HomeTask;
import se.his.it401g.todo.StudyTask;
import se.his.it401g.todo.Task;
//import se.his.it401g.todo.TaskListener;
// implement TaskListener kanske??
public class ToDo extends JFrame implements ActionListener{
	JPanel taskPanel = new JPanel();

	public ToDo() {
		super("my todo application");
		JPanel buttonMenu = new ButtonPanel(this);
		add(buttonMenu,BorderLayout.NORTH);
		JScrollPane scroller = new JScrollPane(taskPanel);
		add(scroller,BorderLayout.CENTER);
		taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));

		setBounds(400, 400, 400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void start() {
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent event){
		event.getActionCommand(); // returns string on buttons
		if(event.getActionCommand() == "button1") {
			Task task = new HomeTask();
			taskPanel.add(task.getGuiComponent());
			revalidate();
			repaint();
			
		}
		if(event.getActionCommand() == "button2") {
			Task task = new StudyTask();
			taskPanel.add(task.getGuiComponent());
			revalidate();
			repaint();
			
		}
		if(event.getActionCommand() == "button3") {
			Task task = new HomeTask();
			taskPanel.add(task.getGuiComponent());
			revalidate();
			repaint();
			
		}
		if(event.getActionCommand() == "Remove") {
		
			revalidate();
			repaint();
			
		}
	
		System.out.println(event.getActionCommand());
	}
	
	public static void main(String[] args) {

		ToDo todo = new ToDo();

		todo.start();

	}
	}
