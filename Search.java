package Test;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;

public class Search extends Frame implements ActionListener {

	JButton btnSearch;
	JTextField txtCode, txtName, txtCredit;
	JPanel pn, pn1, pn2, pn3, pn4;
	JLabel lblSearch, lblName, lblCredit;
	JComboBox cbbSearch;

	public void GUI() {
		lblSearch = new JLabel("Search");
		lblName = new JLabel("Name/Code");
		lblCredit = new JLabel("Credit/Name");

		btnSearch = new JButton("Search");
		txtCode = new JTextField(6);
		txtName = new JTextField(25);
		txtName.setEditable(false);
		txtCredit = new JTextField(7);
		txtCredit.setEditable(false);

		cbbSearch = new JComboBox();
		cbbSearch.setModel(new DefaultComboBoxModel(new String[] { "Code", "Name", "Credit" }));

		pn = new JPanel(new CardLayout(this.WIDTH + 10, this.HEIGHT + 25));
		pn1 = new JPanel(new GridLayout(4, 1, 0, 8));
		pn2 = new JPanel();
		pn3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 35, 0));
		pn4 = new JPanel(new FlowLayout(FlowLayout.LEFT, 35, 0));

		btnSearch.addActionListener(this);
		pn4.add(lblCredit);
		pn4.add(txtCredit);

		pn3.add(lblName);
		pn3.add(txtName);

		pn2.add(lblSearch);
		pn2.add(txtCode);
		pn2.add(cbbSearch);
		pn2.add(btnSearch);

		pn1.add(pn2);
		pn1.add(pn3);
		pn1.add(pn4);

		pn.add(pn1);
		add(pn);
		setSize(600, 250);
		setLocation(this.WIDTH + 30, this.HEIGHT + 30);
		show();

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
		if (e.getSource() == btnSearch) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String s = "jdbc:mysql://localhost:3306/bai2";
				Connection con = (Connection) DriverManager.getConnection(s, "root", "");
				java.sql.Statement stmt = con.createStatement();
				if (cbbSearch.getSelectedItem() == "Code") {
					String sql = "SELECT * FROM data where Code = '" + txtCode.getText() + "'";
					ResultSet rs = stmt.executeQuery(sql);
					java.sql.ResultSetMetaData rsmd = rs.getMetaData();
					while (rs.next()) {
						txtName.setText(rs.getObject(2) + "");
						txtCredit.setText(rs.getObject(3) + "");
					}
					rs.close();
					stmt.close();
				}
				if (cbbSearch.getSelectedItem() == "Name") {

					String sql = "SELECT * FROM data where Name = '" + txtCode.getText() + "'";
					ResultSet rs = stmt.executeQuery(sql);
					java.sql.ResultSetMetaData rsmd = rs.getMetaData();
					while (rs.next()) {
						txtName.setText(rs.getObject(1) + "");
						txtCredit.setText(rs.getObject(3) + "");
					}
					rs.close();
					stmt.close();
				}
				if (cbbSearch.getSelectedItem() == "Credit") {
					String sql = "SELECT * FROM data where Credit = '" + txtCode.getText() + "'";
					ResultSet rs = stmt.executeQuery(sql);
					java.sql.ResultSetMetaData rsmd = rs.getMetaData();
					while (rs.next()) {
						txtName.setText(rs.getObject(1) + "");
						txtCredit.setText(rs.getObject(2) + "");
					}
					rs.close();
					stmt.close();
				}

			} catch (Exception e2) {
				// TODO: handle exception
			}

		}

	}
}
