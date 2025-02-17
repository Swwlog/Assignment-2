package assignment2;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
	JComboBox sort;

	public ButtonPanel(ActionListener listener) {
		JButton button1 = new JButton("New HomeTask");
		button1.addActionListener(listener);
		add(button1);
		JButton button2 = new JButton("New StudyTask");
		button2.addActionListener(listener);
		add(button2);
		JButton button3 = new JButton("New CostomTask"); //daniel ändra namn sen 
		button3.addActionListener(listener);
		add(button3);
		
		//sort button prov daniel
	
		String [] options = {"  Name  ","  Completion  ","  Task type  "};
		sort = new JComboBox(options);
		sort.addActionListener(listener);
		add(sort);
		
	}
	
	public int getSortType() {
		int value = (sort.getSelectedIndex());
		return value;
	}
	
}
