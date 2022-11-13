package side_project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TeamInfoUpdateFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private String[] colNames= { "팀이름", "종목", "지역", "팀정보", "등록 id","등록 번호"};
	private Object[] records = new Object[colNames.length];
	private DefaultTableModel tableModel;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_1_1;
	public static TeamInfoDAOImple dao;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TeamInfoUpdateFrame frame = new TeamInfoUpdateFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public TeamInfoUpdateFrame(String id) {
		dao= TeamInfoDAOImple.getinstance();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 566, 656);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel(id);
		lblNewLabel.setBounds(12, 10, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("팀 정보 수정/삭제");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(135, 49, 250, 57);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				
//				int row = table.getSelectedRow();
//				String id= (String)tableModel.getValueAt(row, 0);
//				
//			}
//		});
	
		scrollPane.setBounds(25, 149, 360, 408);
		contentPane.add(scrollPane);
		
		tableModel= new DefaultTableModel(colNames,0) {
			@Override
			public boolean isCellEditable(int row, int column) {

				return false;
			}// 테이블 값 수정 불가!
			
		};
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("검색");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				selectAll(id);
			}
		});
		btnNewButton.setBounds(25, 116, 97, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("수정");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				int contactId = (int)tableModel.getValueAt(row, 5);
				String id= (String)tableModel.getValueAt(row, 4);
								
				TeamInfoVO vo= dao.select(contactId, id);
				TeamInfoUpdateFrame2 TeamInfoUpdate2= new TeamInfoUpdateFrame2(vo);
				TeamInfoUpdate2.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(425, 173, 97, 48);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1_1 = new JButton("삭제");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				delete();
				textField.setText("");
			}
		});
		btnNewButton_1_1.setBounds(425, 358, 97, 48);
		contentPane.add(btnNewButton_1_1);
		
		textField = new JTextField();
		textField.setBounds(411, 323, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
	}//end frame
	
	private void selectAll(String id) {
		ArrayList<TeamInfoVO>list = dao.select(id);
		
		tableModel.setRowCount(0);
		
		id=lblNewLabel.getText();
		
		for(int i=0; i<list.size();i++) {
			
			records[0]=list.get(i).getTeamName();
			records[1]=list.get(i).getSport();
			records[2]=list.get(i).getLocation();
			records[3]=list.get(i).getInformation();
			records[4]=list.get(i).getId();
			records[5]=list.get(i).getContactId();
			
			tableModel.addRow(records);
			
		}
		
		
	}//end selectAll()
	
	private void delete() {
		String teamName=textField.getText();
		String id = lblNewLabel.getText();
		
		
		int result = dao.delete(teamName, id);
		
		if(result==1) {
			JOptionPane.showMessageDialog(contentPane, "삭제 완료");
			selectAll(id);
			
		}else {
			JOptionPane.showMessageDialog(contentPane, "삭제 실패");
		}
		
	}//end delete
	
	
}//end TeamInfoupdateFrame
