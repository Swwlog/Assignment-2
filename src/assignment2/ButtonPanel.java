package assignment2;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
	private JComboBox<?> sortMenu;

	public ButtonPanel(ActionListener listener) {
		JButton button1 = new JButton("New HomeTask");
		button1.addActionListener(listener);
		add(button1);
		JButton button2 = new JButton("New StudyTask");
		button2.addActionListener(listener);
		add(button2);
		JButton button3 = new JButton("New WorkTask");  
		button3.addActionListener(listener);
		add(button3);
		
	
		String [] options = {"  Name  ","  Completion  ","  Task type  "};
		sortMenu = new JComboBox(options);
		sortMenu.addActionListener(listener);
		JLabel sortBy = new JLabel("Sort by:");
		add(sortBy);
		add(sortMenu);
		
	}
	
	public int getSortType() {
		int value = (sortMenu.getSelectedIndex());
		return value;
	}
	
}
