package side_project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeamInfoFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_teamName;
	private JTextField textField_information;
	private JTextField textField_contactID;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnNewSoccer;
	private JRadioButton rdbtnNewBasketBall;
	private JRadioButton rdbtnNewBaseBall;
	private JComboBox comboBox_location;
	public static TeamInfoDAOImple dao;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TeamInfoFrame frame = new TeamInfoFrame();
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
	public TeamInfoFrame(String id) {
		dao=TeamInfoDAOImple.getinstance();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 517, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("팀 등록");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setBounds(173, 28, 210, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("팀 이름");
		lblNewLabel_1.setBounds(50, 122, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("스포츠");
		lblNewLabel_1_1.setBounds(50, 177, 57, 15);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("지역");
		lblNewLabel_1_2.setBounds(50, 239, 57, 15);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("팀 소개");
		lblNewLabel_1_2_1.setBounds(50, 286, 57, 15);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("등록자 ID");
		lblNewLabel_1_2_2.setBounds(50, 367, 57, 15);
		contentPane.add(lblNewLabel_1_2_2);
		
		JButton btnNewButton = new JButton("등록");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				insertTeamInfo();
				
			}
		});
		btnNewButton.setBounds(72, 416, 417, 51);
		contentPane.add(btnNewButton);
		
		textField_teamName = new JTextField();
		textField_teamName.setBounds(150, 119, 275, 18);
		contentPane.add(textField_teamName);
		textField_teamName.setColumns(10);
		
		rdbtnNewSoccer = new JRadioButton("축구");
		buttonGroup.add(rdbtnNewSoccer);
		rdbtnNewSoccer.setBounds(150, 173, 121, 23);
		contentPane.add(rdbtnNewSoccer);
		
		rdbtnNewBasketBall = new JRadioButton("농구");
		buttonGroup.add(rdbtnNewBasketBall);
		rdbtnNewBasketBall.setBounds(272, 173, 121, 23);
		contentPane.add(rdbtnNewBasketBall);
		
		rdbtnNewBaseBall = new JRadioButton("야구");
		buttonGroup.add(rdbtnNewBaseBall);
		rdbtnNewBaseBall.setBounds(150, 199, 121, 23);
		contentPane.add(rdbtnNewBaseBall);
		
		String CBLocation[]= {"-선택-", "서울", "부산", "대구", "인천", "광주", "대전", "울산", "세종", "경기", "강원", "충북", "충남", "전북",
				"전남", "경북", "경남", "제주" };
		comboBox_location = new JComboBox(CBLocation);
		comboBox_location.setBounds(150, 235, 121, 23);
		contentPane.add(comboBox_location);
		
		textField_information = new JTextField();
		textField_information.setBounds(149, 286, 255, 60);
		contentPane.add(textField_information);
		textField_information.setColumns(10);
		
		textField_contactID = new JTextField(id);
		textField_contactID.setEnabled(false);
		textField_contactID.setBounds(155, 364, 116, 21);
		contentPane.add(textField_contactID);
		textField_contactID.setColumns(10);
	}//end frame
	
	private void insertTeamInfo() {
		String teamName = textField_teamName.getText();
		String sport= null;
		if (rdbtnNewSoccer.isSelected()) {
			sport = rdbtnNewSoccer.getText();
		} else if (rdbtnNewBasketBall.isSelected()) {
			sport = rdbtnNewBasketBall.getText();
		} else if (rdbtnNewBaseBall.isSelected()) {
			sport = rdbtnNewBaseBall.getText();
		}
		
		String location= comboBox_location.getSelectedItem().toString();
		String information= textField_information.getText();
		String id = textField_contactID.getText();
		
		TeamInfoVO vo = new TeamInfoVO(teamName, sport, location, information, id, 0);
		
		int result = dao.insert(vo);
		
		if(result==1) {
			JOptionPane.showMessageDialog(contentPane, "팀 등록 완료");
			dispose();
		}else {
			JOptionPane.showConfirmDialog(contentPane, "팀 등록 실패");
		}
		
	}//end insert
	
}//end TeamInfoFrame
