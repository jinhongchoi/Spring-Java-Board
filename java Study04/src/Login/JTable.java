package Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ContactVer06practice.ContactDAOImple;
import ContactVer06practice.ContactVO;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class JTable extends JFrame {

	private JPanel contentPane;
	private javax.swing.JTable table;
	public static ContactDAOImple dao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTable frame = new JTable();
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
	public JTable() {
		dao = ContactDAOImple.getInstance();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 771);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("수정/삭제");
		lblNewLabel.setBounds(171, 31, 215, 47);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("전체검색");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				selectAll();

			}
		});
		btnNewButton.setBounds(32, 140, 97, 23);
		contentPane.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 191, 326, 436);
		contentPane.add(scrollPane);

		table = new javax.swing.JTable();
		table.setModel(new DefaultTableModel());
		scrollPane.setViewportView(table);

		JButton btnNewButton_1 = new JButton("수정");
		btnNewButton_1.setBounds(399, 208, 117, 47);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("삭제");
		btnNewButton_1_1.setBounds(399, 310, 117, 47);
		contentPane.add(btnNewButton_1_1);
	}// end Jflame

	private void selectAll() {

		ArrayList<ContactVO> list = dao.select();

		StringBuffer buffer = new StringBuffer(); // 이 부분 부터 buffer로 배열하는거 익히기
		buffer.append("연락처 개수 : " + list.size() + "\n");
		for (int i = 0; i < list.size(); i++) {
			buffer.append("--- 연락처 " + i + " --- \n" + list.get(i) + "\n");
		}

		table.getRowCount();
	}// end selectAll

}
