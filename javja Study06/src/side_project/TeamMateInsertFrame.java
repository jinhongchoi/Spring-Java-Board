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
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TeamMateInsertFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_Name;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_Age;
	private JTextField textField_height;
	private JTextField textField_position;
	private JTextField textField_BackNo;
	private JTextField textField_TeamName;
	private JRadioButton rdbtnMan;
	private JRadioButton rdbtnWoman;
	public static TeamMateDAOImple dao;
	private String[] colNames = { "팀이름", "종목", "지역", "팀정보", "id", "등록번호" };
	private Object[] records = new Object[colNames.length];
	
	private DefaultTableModel tableModel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TeamMateInsertFrame frame = new TeamMateInsertFrame();
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
	public TeamMateInsertFrame(TeamInfoVO vo) {
		dao=TeamMateDAOImple.getinstance();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 668);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("팀원 등록");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setBounds(166, 30, 227, 43);
		contentPane.add(lblNewLabel);
		
		JButton btnTeamSearch = new JButton("등록 팀 검색");
		btnTeamSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				selectAllTeamInfo();
			}
		});
		btnTeamSearch.setBounds(43, 92, 121, 23);
		contentPane.add(btnTeamSearch);
		
		lblNewLabel_1 = new JLabel(vo.getId());
		lblNewLabel_1.setBounds(12, 10, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 138, 482, 137);
		contentPane.add(scrollPane);
		
		tableModel = new DefaultTableModel(colNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {

				return false;
			}// 테이블 값 수정 불가!
		};
		
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2 = new JLabel("팀 등록번호");
		lblNewLabel_2.setBounds(43, 320, 76, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("이름");
		lblNewLabel_2_1.setBounds(43, 356, 57, 15);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("성별");
		lblNewLabel_2_2.setBounds(43, 393, 57, 15);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("나이");
		lblNewLabel_2_3.setBounds(43, 439, 57, 15);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("키");
		lblNewLabel_2_4.setBounds(43, 482, 57, 15);
		contentPane.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("포지션");
		lblNewLabel_2_5.setBounds(43, 528, 57, 15);
		contentPane.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_5_1 = new JLabel("백넘버");
		lblNewLabel_2_5_1.setBounds(355, 320, 57, 15);
		contentPane.add(lblNewLabel_2_5_1);
		
		JLabel lblNewLabel_2_5_2 = new JLabel("팀 이름");
		lblNewLabel_2_5_2.setBounds(355, 375, 57, 15);
		contentPane.add(lblNewLabel_2_5_2);
		
		JButton btnNewButton_1 = new JButton("등록");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				insertTeamMate();
			}
		});
		btnNewButton_1.setBounds(356, 520, 138, 43);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(118, 317, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_Name = new JTextField();
		textField_Name.setColumns(10);
		textField_Name.setBounds(118, 353, 116, 21);
		contentPane.add(textField_Name);
		
		rdbtnMan = new JRadioButton("남자");
		buttonGroup.add(rdbtnMan);
		rdbtnMan.setBounds(113, 389, 76, 23);
		contentPane.add(rdbtnMan);
		
		rdbtnWoman = new JRadioButton("여자");
		buttonGroup.add(rdbtnWoman);
		rdbtnWoman.setBounds(195, 389, 121, 23);
		contentPane.add(rdbtnWoman);
		
		textField_Age = new JTextField();
		textField_Age.setColumns(10);
		textField_Age.setBounds(118, 436, 116, 21);
		contentPane.add(textField_Age);
		
		textField_height = new JTextField();
		textField_height.setColumns(10);
		textField_height.setBounds(118, 479, 116, 21);
		contentPane.add(textField_height);
		
		textField_position = new JTextField();
		textField_position.setColumns(10);
		textField_position.setBounds(118, 525, 116, 21);
		contentPane.add(textField_position);
		
		textField_BackNo = new JTextField();
		textField_BackNo.setColumns(10);
		textField_BackNo.setBounds(409, 317, 116, 21);
		contentPane.add(textField_BackNo);
		
		textField_TeamName = new JTextField(vo.getTeamName());
		textField_TeamName.setColumns(10);
		textField_TeamName.setBounds(409, 372, 116, 21);
		contentPane.add(textField_TeamName);
		
		JButton btnSearchTeam = new JButton("검색");
		btnSearchTeam.setBounds(246, 316, 76, 23);
		contentPane.add(btnSearchTeam);
	}//end frame
	
	private void insertTeamMate() {
		
		String Name= textField_Name.getText();
		String gender = null;
		if (rdbtnMan.isSelected()) {
			gender = rdbtnMan.getText();
		} else if (rdbtnWoman.isSelected()) {
			gender = rdbtnWoman.getText();
		}else {
			JOptionPane.showMessageDialog(contentPane, "성별을 선택해주세요.");
			return;
		}
		int age =Integer.parseInt(textField_Age.getText());
		int height= Integer.parseInt(textField_height.getText());
		String position = textField_position.getText();
		int backNo = Integer.parseInt(textField_BackNo.getText());
		String TeamName=textField_TeamName.getText();
		
		TeamMateVO vo= new TeamMateVO(Name, gender, age, height, position, backNo, TeamName, 0);
		int result = dao.insert(vo);
		if(result==1){
			JOptionPane.showMessageDialog(contentPane, "등록 완료");
		}else {
			JOptionPane.showMessageDialog(contentPane, "등록 실패");
		}
		
	}//end insertTeamMate()
	
	private void selectAllTeamInfo() {
		ArrayList<TeamInfoVO>list = dao.selectAll();
		tableModel.setRowCount(0);
		String id= lblNewLabel_1.getText();
		for(int i=0; i<list.size(); i++) {
			records[0]=list.get(i).getTeamName();
			records[1]=list.get(i).getSport();
			records[2]=list.get(i).getLocation();
			records[3]=list.get(i).getInformation();
			records[4]=list.get(i).getId();
			records[5]=list.get(i).getContactId();
			
			if(id.equals(list.get(i).getId())) {
				tableModel.addRow(records);
			}
		}
		
	}//end selectAllTeamInfo
	
}//end TeamMateInsertFrame
