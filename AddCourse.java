package Test;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class AddCourse extends Frame implements ActionListener {
	Label lblCode, lblName, lblCredit;
	Button btnAdd, btnClear;
	JTextField txtCode, txtName, txtCredit;
	Panel pn, pn1, pn2, pn3, pn4, pn5;
    
	
	public void GUI() {
		pn1 = new Panel(new GridLayout(1, 1));
		pn2 = new Panel(new GridLayout(1, 1));
		pn3 = new Panel(new GridLayout(1, 1));
		pn4 = new Panel(new FlowLayout());
		pn5 = new Panel(new CardLayout(this.WIDTH + 10, this.HEIGHT + 10));
		pn = new Panel(new GridLayout(4, 1));

		lblCode = new Label("Code");
		txtCode = new JTextField(20);
		pn1.add(lblCode);
		pn1.add(txtCode);

		lblName = new Label("Name");
		txtName = new JTextField();
		pn2.add(lblName);
		pn2.add(txtName);

		lblCredit = new Label("Credit");
		txtCredit = new JTextField();
		pn3.add(lblCredit);
		pn3.add(txtCredit);

		btnAdd = new Button("Add");
		btnClear = new Button("Clear");
		pn4.add(btnAdd);
		pn4.add(btnClear);

		pn.add(pn1);
		pn.add(pn2);
		pn.add(pn3);
		pn.add(pn4);
		pn5.add(pn);
		add(pn5);

		btnAdd.addActionListener(this);
		btnClear.addActionListener(this);

		setSize(400, 170);
		setVisible(true);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://127.0.0.1:3306/bai2";
				Connection con = (Connection) DriverManager.getConnection(url, "root", "");
				Statement stmt = (Statement) con.createStatement();

				String sql = "Insert into data(Code,Name,Credit) values('" + txtCode.getText() + "','"
						+ txtName.getText() + "','" + txtCredit.getText() + "')";
				stmt.executeUpdate(sql);
				stmt.close();
				con.close();
				JOptionPane.showMessageDialog(null, "Done");
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
		if (e.getSource() == btnClear) {
			txtCode.setText("");
			txtName.setText("");
			txtCredit.setText("");
		}
		
	}

}
