package assignment2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
	ArrayList<Task>taskList=new ArrayList<>();

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
		setVisible(true);//vrf kan jag inte commita!!!
		
	}
	
	public void actionPerformed(ActionEvent event){
		event.getActionCommand(); // returns string on buttons
		if(event.getActionCommand() == "button1") {
			Task task = new HomeTask();
			taskList.add(task); // Daniel nytt: Lägger in i ArreyList först sen in i JPanel(för att kunna sortera)
			 taskPanel.removeAll();
			for(int i=0; i<taskList.size();i++) {
				taskPanel.add(taskList.get(i).getGuiComponent());
			}
			revalidate();
			repaint();
			System.out.println(taskList.size()); // test ta bort sen
		}
		if(event.getActionCommand() == "button2") {
			Task task = new StudyTask();
			taskList.add(task);// Daniel nytt: Lägger in i ArreyList först sen in i JPanel(för att kunna sortera)
			 taskPanel.removeAll();
			for(int i=0; i<taskList.size();i++) {
				taskPanel.add(taskList.get(i).getGuiComponent());
			}
			revalidate();
			repaint();
			System.out.println(taskList.size()); // test ta bort sen
			
		}
		if(event.getActionCommand() == "button3") {
			Task task = new HomeTask();
			taskList.add(task);// Daniel nytt: Lägger in i ArreyList först sen in i JPanel(för att kunna sortera)
			 taskPanel.removeAll();
			 Collections.sort(taskList, Comparator.comparing(Task::getText));//test för sortering ska vara på annan plats senare
			// Collections.sort(taskList, Comparator.comparing(Task::isComplete));
			// Collections.sort(taskList, Comparator.comparing(Task::getTaskType));
			for(int i=0; i<taskList.size();i++) {
				taskPanel.add(taskList.get(i).getGuiComponent());
			}
			revalidate();
			repaint();
			System.out.println(taskList.size());// Test ta bort sen
			System.out.println(taskList.getFirst().getText()); // test ta bort sen
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
