package Test;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Course extends Frame implements ActionListener {
	JLabel lblTitle;
	JButton btnAdd, btnDisplay, btnSearch, btnExit;
	JPanel pn, pn1, pn2, pn3, pn4, pn5;
	
	public void GUI() {
		pn1 = new JPanel(new FlowLayout());
		pn2 = new JPanel(new FlowLayout());
		pn3 = new JPanel(new FlowLayout());
		pn4 = new JPanel(new FlowLayout());
		pn5 = new JPanel(new FlowLayout());
		pn = new JPanel(new GridLayout(5, 1));

		lblTitle = new JLabel("Courses Management");
		pn1.add(lblTitle);
		btnAdd = new JButton("Add a new Course");
		pn2.add(btnAdd);
		btnDisplay = new JButton("Display all Courses");
		pn3.add(btnDisplay);
		btnSearch = new JButton("Search Course by Course Code");
		pn4.add(btnSearch);
		btnExit = new JButton("Exit Application");
		pn5.add(btnExit);
		pn.add(pn1);
		pn.add(pn2);
		pn.add(pn3);
		pn.add(pn4);
		pn.add(pn5);
		add(pn);

		btnAdd.setPreferredSize(new Dimension(300, 30));
		btnDisplay.setPreferredSize(new Dimension(300, 30));
		btnSearch.setPreferredSize(new Dimension(300, 30));
		btnExit.setPreferredSize(new Dimension(300, 30));

		btnAdd.addActionListener(this);
		btnDisplay.addActionListener(this);
		btnSearch.addActionListener(this);
		btnExit.addActionListener(this);

		setSize(400, 300);
		setVisible(true);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				System.exit(0);
			}
		});

	}
	public static void main(String[] args) {
		Course a = new Course();
		a.GUI();

	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAdd) {
			AddCourse obj = new AddCourse();
			obj.GUI();
		}
		if (e.getSource() == btnDisplay) {
			DisplayCourse obj = new DisplayCourse();
			obj.GUI();
		}
		if (e.getSource() == btnSearch) {
			Search obj = new Search();
			obj.GUI();
		}
		if(e.getSource() == btnExit) {
			System.exit(0);
		}
		
		
	}

}
