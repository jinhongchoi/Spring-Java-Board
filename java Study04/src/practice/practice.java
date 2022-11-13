package practice;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class practice extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	private String header[]={"이름", "1", "2", "3"};
	private String content[][]= {
			{"1", "2", "2", "2"},
			{"1", "2", "2", "2"},
			{"1", "3", "2", "2"},
			{"1", "2", "2", "2"},
	};
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					practice frame = new practice();
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
	public practice() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 689);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 180, 266, 373);
		contentPane.add(scrollPane);
		
		DefaultTableModel model= new DefaultTableModel(content, header);
		
		table = new JTable(model);		
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("수정");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table.getSelectedRow()==1) {
					return;
				}else {
					model.setRowCount(3);
				}
				
			}
		});
		btnNewButton.setBounds(41, 86, 97, 50);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("삭제");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()==-1) {
					return;
				}else {
					model.removeRow(table.getSelectedRow());
				}
				
			}
		});
		btnNewButton_1.setBounds(189, 86, 97, 50);
		contentPane.add(btnNewButton_1);
	}

}
