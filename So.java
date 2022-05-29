package Test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class So extends JFrame {

	private JPanel contentPane;
	private JTextField txtNhap;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					So frame = new So();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public So() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 739, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nh\u1EADp s\u1ED1 t\u1EF1 nhi\u00EAn n: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 41, 156, 26);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("T\u00E1ch theo chi\u1EC1u:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 82, 143, 31);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("K\u1EBFt qu\u1EA3 t\u00E1ch \u0111\u01B0\u1EE3c:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 123, 156, 26);
		contentPane.add(lblNewLabel_2);

		txtNhap = new JTextField();
		txtNhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtNhap.setBounds(201, 40, 219, 19);
		contentPane.add(txtNhap);
		txtNhap.setColumns(10);

		JComboBox cbbChieu = new JComboBox();
		cbbChieu.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbbChieu.setModel(new DefaultComboBoxModel(new String[] { "Từ trái qua phải", "Từ phải qua trái" }));
		cbbChieu.setBounds(201, 78, 219, 21);
		contentPane.add(cbbChieu);

		JTextArea txtArea = new JTextArea();
		txtArea.setFont(new Font("Monospaced", Font.BOLD, 15));
		txtArea.setBounds(201, 117, 219, 121);
		contentPane.add(txtArea);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNhap.setText(getName());
				txtArea.setText("");
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXoa.setBounds(501, 39, 117, 21);
		contentPane.add(btnXoa);

		JButton btnTach = new JButton("Tách Số");
		btnTach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbbChieu.getSelectedItem().toString() == "Từ trái qua phải") {
					int x = Integer.valueOf(txtNhap.getText());
					List<Integer> list = new ArrayList<Integer>();
					while (x != 0) {
						list.add(x % 10);
						x = x / 10;
					}
					String s = "";
					for (int i = list.size() - 1; i >= 0; i--) {
						if (i == 0) {
							s = s + list.get(i);
						} else
							s = s + list.get(i) + ",";
					}
					txtArea.setText(s);
				} else if (cbbChieu.getSelectedItem().toString() == "Từ phải qua trái") {
					int x = Integer.valueOf(txtNhap.getText());
					List<Integer> list = new ArrayList<Integer>();
					while (x != 0) {
						list.add(x % 10);
						x = x / 10;
					}
					String s = "";
					for (int i = 0; i < list.size(); i++) {
						if (i == list.size() - 1) {
							s = s + list.get(i);
						} else
							s = s + list.get(i) + ",";
					}
					txtArea.setText(s);
				}

			}
		});
		btnTach.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTach.setBounds(501, 78, 117, 21);
		contentPane.add(btnTach);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThoat.setBounds(250, 271, 85, 21);
		contentPane.add(btnThoat);
	}
}
