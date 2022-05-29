package Test;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DisplayCourse extends Frame implements ActionListener {

	JTable jTable;
	DefaultTableModel dtm;
	JPanel pn, pn1, pn2;
	JButton btnFirst, btnPre, btnNext, btnLast;

	Connection cnn = null;
	Statement stmt = null;

	public void GUI() {
		pn1 = new JPanel(new GridLayout(1, 1));
		pn2 = new JPanel(new FlowLayout());
		pn = new JPanel(new GridLayout(2, 1));

		dtm = new DefaultTableModel();
		dtm.addColumn("Code");
		dtm.addColumn("Name");
		dtm.addColumn("Credit");
		jTable = new JTable(dtm);

		JScrollPane scTable = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pn1.add(scTable);

		btnFirst = new JButton("Move First");
		btnPre = new JButton("Move Previous");
		btnNext = new JButton("Move Next");
		btnLast = new JButton("Move Last");
		btnFirst.addActionListener(this);
		btnPre.addActionListener(this);
		btnNext.addActionListener(this);
		btnLast.addActionListener(this);
		pn2.add(btnFirst);
		pn2.add(btnPre);
		pn2.add(btnNext);
		pn2.add(btnLast);
		pn.add(pn1);
		pn.add(pn2);
		add(pn);

		setSize(500, 400);
		setVisible(true);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				System.exit(0);
			}
		});

		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bai2", "root", "");
			stmt = (Statement) cnn.createStatement();
			String sql = "select * from data";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Vector<Object> v = new Vector<Object>();
				v.add(rs.getInt(1));
				v.add(rs.getString(2));
				v.add(rs.getInt(3));

				dtm.addRow(v);
			}

			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println("Error: " + e);

		}
	}

	public static void main(String[] args) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnFirst) {
			jTable.setRowSelectionInterval(0, 0);
		}
		else if (e.getSource() == btnLast) {
			int n = jTable.getRowCount();
			jTable.setRowSelectionInterval(n - 1, n - 1);
		}
		else if (e.getSource() == btnNext) {
			int n = jTable.getSelectedRow();
			if (n + 1 == jTable.getRowCount()) {
				jTable.setRowSelectionInterval(0, 0);
			} else {
				jTable.setRowSelectionInterval(n + 1, n + 1);
			}
		}
		else if (e.getSource() == btnPre) {
			int n = jTable.getSelectedRow();
			if (n - 1 == -1) {
				jTable.setRowSelectionInterval(jTable.getRowCount() - 1, jTable.getRowCount() - 1);
			} else {
				jTable.setRowSelectionInterval(n - 1, n - 1);
			}
		}

	}

}
