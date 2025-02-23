package assignment2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.TitledBorder;

import se.his.it401g.todo.Task;
import se.his.it401g.todo.TaskInputListener;
import se.his.it401g.todo.TaskListener;

/**
 * Implements a simple home task type, following the Task.java interface class.
 * 
 * This file licensed under the
 * <a href="https://creativecommons.org/licenses/by/4.0/">Creative Commons (CC)
 * BY 4.0 license</a>.
 * 
 * @author Dr. Erik Billing, University of Skovde
 *
 */
public class WorkTask extends JPanel implements Task {

	private JSpinner dueDate;

	private JLabel textLabelDueDate;
	/**
	 * The editable text field.
	 */
	private JTextField text;

	/**
	 * The non editable text label.
	 */
	private JLabel textLabel;

	/**
	 * Check box holding the completion status.
	 */
	JCheckBox completed = new JCheckBox();

	/**
	 * The task listener used for reporting changes to the main application.
	 */
	private TaskListener listener;

	/**
	 * This is the constructor for the task, initiating the GUI component for the
	 * task. Several listeners are used to react to various events in the GUI.
	 */
	public WorkTask() {
		super(new BorderLayout());
		this.text = new JTextField("New task", 20);
		this.textLabel = new JLabel();
		this.textLabel.setVisible(false);
		JPanel center = new JPanel();

		Calendar calendar = Calendar.getInstance();

		this.dueDate = new JSpinner(new SpinnerDateModel(calendar.getTime(), null, null, Calendar.DAY_OF_MONTH));
		JSpinner.DateEditor editor = new JSpinner.DateEditor(dueDate, "dd/MM/yy");
		dueDate.setEditor(editor);
		this.textLabelDueDate = new JLabel(" | Due Date:");

		center.add(text);
		center.add(textLabel);
		center.add(textLabelDueDate);
		center.add(dueDate);
		add(center);

		TaskInputListener inputListener = new TaskInputListener(this, text, textLabel);
		this.text.addKeyListener(inputListener);
		this.textLabel.addMouseListener(inputListener);

		JButton remove = new JButton("Remove");

		add(remove, BorderLayout.EAST);
		remove.addActionListener(inputListener);

		add(completed, BorderLayout.WEST);
		completed.addItemListener(inputListener);

		setMaximumSize(new Dimension(1000, 50));
		setBorder(new TitledBorder(getTaskType()));
	}

	@Override
	public String getText() {
		return text.getText();
	}

	@Override
	public String getTaskType() {
		return "Work";
	}

	@Override
	public void setTaskListener(TaskListener t) {
		listener = t;
	}

	@Override
	public TaskListener getTaskListener() {
		return listener;
	}

	@Override
	public boolean isComplete() {
		return completed.isSelected();
	}

	@Override
	public Component getGuiComponent() {
		// Since this class extends JPanel, it is itself a GUI component, and thus we
		// can return "this".
		return this;
	}

}