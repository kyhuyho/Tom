package Test;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class SearchCourse extends Frame implements ActionListener {

	Label lblCode, lblName, lblCredit;
	JTextField txtCode, txtName, txtCredit;
	Button btnSearch;
	JPanel pn, pn1, pn2, pn3;

	public void GUI() {
		pn1 = new JPanel(new FlowLayout());
		pn2 = new JPanel(new GridLayout(2, 2));
		pn3 = new JPanel(new CardLayout(this.WIDTH + 10, this.HEIGHT + 10));
		pn = new JPanel(new GridLayout(3, 1));

		lblCode = new Label("Code");
		txtCode = new JTextField(15);
		btnSearch = new Button("Search");
		pn1.add(lblCode);
		pn1.add(txtCode);
		pn1.add(btnSearch);

		lblName = new Label("Name");
		txtName = new JTextField();
		lblCredit = new Label("Credit");
		txtCredit = new JTextField();
		pn2.add(lblName);
		pn2.add(txtName);
		pn2.add(lblCredit);
		pn2.add(txtCredit);

		pn.add(pn1);
		pn.add(pn2);
		pn3.add(pn);
		add(pn3);

		btnSearch.addActionListener(this);

		setSize(300, 200);
		setVisible(true);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {

	}

	public void Show() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bai2", "root", "");
			Statement stmt = (Statement) con.createStatement();
			String sql = "select * from data where Code = '" + txtCode.getText() + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				txtCredit.setText(rs.getObject(3).toString());
				txtName.setText(rs.getObject(2).toString());
			}
			txtName.enable(false);
			txtCredit.enable(false);
			rs.close();
			stmt.close();

		} catch (Exception e) {
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			Show();
		}

	}

}
