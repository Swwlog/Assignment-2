package assignment2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import se.his.it401g.todo.HomeTask;
import se.his.it401g.todo.Task;

public class ToDo extends JFrame implements ActionListener  {

	public ToDo() {
		super("my todo application");
		JPanel buttonMenu = new ButtonPanel(this);
		add(buttonMenu);
		
		//Task task = new HomeTask();
		//buttonMenu.add(task.getGuiComponent(), BorderLayout.CENTER);

		setBounds(100, 100, 400, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void start() {
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent event){
		event.getActionCommand(); // returns string on buttons
		if(event.getActionCommand() == "button1") {
			JPanel panel = new JPanel();
			Task task = new HomeTask();
			panel.add(task.getGuiComponent());
			add(panel);
			
		}
		//System.out.println(event.getActionCommand());
	}
	
	public static void main(String[] args) {

		ToDo todo = new ToDo();

		todo.start();

	}

}
