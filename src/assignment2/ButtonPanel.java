package assignment2;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {

	public ButtonPanel(ActionListener listener) {
		JButton button1 = new JButton("button1");
		button1.addActionListener(listener);
		add(button1);
		JButton button2 = new JButton("button2");
		button2.addActionListener(listener);
		add(button2);
		JButton button3 = new JButton("button3");
		button3.addActionListener(listener);
		add(button3);
		
	}
}
