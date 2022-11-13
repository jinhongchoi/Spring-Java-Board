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
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TeamInfoUpdateFrame2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField_TeamName;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_TeamInfo;
	private JTextField textField_Id;
	private JTextField textField_ContactID;
	private JRadioButton rdbtnSoccer;
	private JRadioButton rdbtnBasketBall;
	private JRadioButton rdbtnBaseBall;
	private JComboBox comboBox;
	public static TeamInfoDAOImple dao;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TeamInfoUpdateFrame2 frame = new TeamInfoUpdateFrame2();
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
	public TeamInfoUpdateFrame2(TeamInfoVO vo){
		dao=TeamInfoDAOImple.getinstance();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("팀 정보 수정");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setBounds(111, 31, 201, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("팀 이름");
		lblNewLabel_1.setBounds(36, 124, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("스포츠");
		lblNewLabel_1_1.setBounds(36, 197, 57, 15);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("지역");
		lblNewLabel_1_2.setBounds(36, 262, 57, 15);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("팀 소개");
		lblNewLabel_1_3.setBounds(36, 344, 57, 15);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("등록자 ID");
		lblNewLabel_1_4.setBounds(36, 418, 57, 15);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("등록 번호");
		lblNewLabel_1_5.setBounds(36, 460, 57, 15);
		contentPane.add(lblNewLabel_1_5);
		
		JButton btnNewButton = new JButton("수정 완료");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				update();
			}
		});
		btnNewButton.setBounds(68, 512, 292, 43);
		contentPane.add(btnNewButton);
		
		textField_TeamName = new JTextField(vo.getTeamName());
		textField_TeamName.setBounds(111, 121, 249, 18);
		contentPane.add(textField_TeamName);
		textField_TeamName.setColumns(10);
		
		rdbtnSoccer = new JRadioButton("축구");
		rdbtnSoccer.setSelected(vo.getSport().equals("축구"));
		buttonGroup.add(rdbtnSoccer);
		rdbtnSoccer.setBounds(110, 177, 102, 23);
		contentPane.add(rdbtnSoccer);
		
		rdbtnBasketBall = new JRadioButton("농구");
		rdbtnSoccer.setSelected(vo.getSport().equals("농구"));
		buttonGroup.add(rdbtnBasketBall);
		rdbtnBasketBall.setBounds(224, 177, 102, 23);
		contentPane.add(rdbtnBasketBall);
		
		rdbtnBaseBall = new JRadioButton("야구");
		rdbtnSoccer.setSelected(vo.getSport().equals("야구"));
		buttonGroup.add(rdbtnBaseBall);
		rdbtnBaseBall.setBounds(110, 208, 102, 23);
		contentPane.add(rdbtnBaseBall);
		
		String CBLocation[]={ "-선택-", "서울", "부산", "대구", "인천", "광주", "대전", "울산", "세종", "경기", "강원", "충북", "충남", "전북",
				"전남", "경북", "경남", "제주" };
		comboBox = new JComboBox(CBLocation);
		comboBox.setBounds(111, 258, 101, 23);
		contentPane.add(comboBox);
		
		textField_TeamInfo = new JTextField(vo.getInformation());
		textField_TeamInfo.setBounds(111, 341, 241, 43);
		contentPane.add(textField_TeamInfo);
		textField_TeamInfo.setColumns(10);
		
		textField_Id = new JTextField(vo.getId());
		textField_Id.setEditable(false);
		textField_Id.setBounds(111, 415, 116, 21);
		contentPane.add(textField_Id);
		textField_Id.setColumns(10);
		
		textField_ContactID = new JTextField(String.valueOf(vo.getContactId()));
		//textField 안에는 String 타입으로 입력되어야 하는데 
		//vo.getContactId는 int타입이므로 String타입으로 변환이 필요함(String.valueOf)
		
		textField_ContactID.setEditable(false);
		textField_ContactID.setColumns(10);
		textField_ContactID.setBounds(111, 457, 116, 21);
		contentPane.add(textField_ContactID);
	}//end frame
	
	private void update() {
		
		String teamName= textField_TeamName.getText();
		String sport = null;
		if (rdbtnSoccer.isSelected()) {
			sport = rdbtnSoccer.getText();
		} else if (rdbtnBasketBall.isSelected()) {
			sport = rdbtnBasketBall.getText();
		} else if (rdbtnBaseBall.isSelected()) {
			sport = rdbtnBaseBall.getText();
		}
		String location = comboBox.getSelectedItem().toString();
		String information= textField_TeamInfo.getText();
		String id= textField_Id.getText();
		int contactid=Integer.parseInt(textField_ContactID.getText());
		
		TeamInfoVO vo= new TeamInfoVO(teamName, sport, location, information, id, contactid);
		int result = dao.update(vo);
		
		if(result==1) {
			JOptionPane.showMessageDialog(contentPane, "수정 완료");
			dispose();
		}else {
			JOptionPane.showMessageDialog(contentPane, "수정 실패");
		}
		
		
	}//end update
	
}//end TeamInfoUpdateFrame2
