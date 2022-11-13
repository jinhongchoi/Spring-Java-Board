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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JoinFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_ID;
	private JTextField textField_PW;
	private JTextField textField_NAME;
	private JTextField textField_AGE;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnNewMAN;
	private JRadioButton rdbtnNewWOMAN;
	private JButton btnNewButton_Join;
	private JButton btnNewButton_Check;
	public static JoinDAOImple dao;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					JoinFrame frame = new JoinFrame();
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
	public JoinFrame() {
		dao=JoinDAOImple.getinstance();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 765);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회원 가입");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 23));
		lblNewLabel.setBounds(159, 34, 227, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_ID = new JLabel("ID");
		lblNewLabel_ID.setBounds(53, 127, 57, 15);
		contentPane.add(lblNewLabel_ID);
		
		JLabel lblNewLabel_PW = new JLabel("PW");
		lblNewLabel_PW.setBounds(53, 171, 57, 15);
		contentPane.add(lblNewLabel_PW);
		
		JLabel lblNewLabel_NAME = new JLabel("NAME");
		lblNewLabel_NAME.setBounds(53, 246, 57, 15);
		contentPane.add(lblNewLabel_NAME);
		
		JLabel lblNewLabel_GENDER = new JLabel("GENDER");
		lblNewLabel_GENDER.setBounds(53, 315, 57, 15);
		contentPane.add(lblNewLabel_GENDER);
		
		JLabel lblNewLabel_AGE = new JLabel("AGE");
		lblNewLabel_AGE.setBounds(53, 384, 57, 15);
		contentPane.add(lblNewLabel_AGE);
		
		textField_ID = new JTextField();
		textField_ID.setBounds(168, 124, 227, 18);
		contentPane.add(textField_ID);
		textField_ID.setColumns(10);
		
		textField_PW = new JTextField();
		textField_PW.setColumns(10);
		textField_PW.setBounds(168, 168, 227, 18);
		contentPane.add(textField_PW);
		
		textField_NAME = new JTextField();
		textField_NAME.setColumns(10);
		textField_NAME.setBounds(168, 243, 227, 18);
		contentPane.add(textField_NAME);
		
		textField_AGE = new JTextField();
		textField_AGE.setColumns(10);
		textField_AGE.setBounds(168, 381, 227, 18);
		contentPane.add(textField_AGE);
		
		btnNewButton_Check = new JButton("중복확인");
		btnNewButton_Check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				idCheck();
			}
		});
		btnNewButton_Check.setBounds(412, 123, 79, 23);
		contentPane.add(btnNewButton_Check);
		
		btnNewButton_Join = new JButton("등록");
		btnNewButton_Join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				insertJoin();
				
			}
		});
		btnNewButton_Join.setBounds(194, 466, 79, 23);
		contentPane.add(btnNewButton_Join);
		
		rdbtnNewMAN = new JRadioButton("남자");
		buttonGroup.add(rdbtnNewMAN);
		rdbtnNewMAN.setBounds(159, 311, 121, 23);
		contentPane.add(rdbtnNewMAN);
		
		rdbtnNewWOMAN = new JRadioButton("여자");
		buttonGroup.add(rdbtnNewWOMAN);
		rdbtnNewWOMAN.setBounds(296, 311, 121, 23);
		contentPane.add(rdbtnNewWOMAN);
		
	}//end JoinFrame
	
	private void insertJoin() {
		
		String id = textField_ID.getText();
		String pw = textField_PW.getText();
		String name= textField_NAME.getText();
		
		String gender= null;
		if(rdbtnNewMAN.isSelected()) {
			gender=rdbtnNewMAN.getText();
		}else if(rdbtnNewWOMAN.isSelected()){
			gender=rdbtnNewWOMAN.getText();
		}
		
		int age= Integer.parseInt(textField_AGE.getText());
		
		if (id.equals("")||id.contains(" ")) {
			JOptionPane.showMessageDialog(contentPane, "ID를 입력하세요");
			return;
			
		} else if (pw.equals("")||pw.contains(" ")) {
			JOptionPane.showMessageDialog(contentPane, "PW를 입력하세요");
			return;
			
		} else if (name.equals("")||name.contains(" ")) {
			JOptionPane.showMessageDialog(contentPane, "이름을 입력하세요");
			return;
			
		} else if (gender == null) {
			JOptionPane.showMessageDialog(contentPane, "성별을 선택하세요");
			return;
			
		} 
		
		JoinVO vo= new JoinVO(id, pw, name, gender, age);
		
		int result= dao.insert(vo);
		System.out.println(vo);
		
		if(result==1) {
			JOptionPane.showMessageDialog(null, "회원가입 완료");
			System.out.println("회원가입 완료");
			dispose();
		}else {
			JOptionPane.showMessageDialog(null, "회원가입 실패");
		}
		
	} //end insertJoin
	
	private void idCheck() {
		
		String id= textField_ID.getText();
		
		JoinVO vo = new JoinVO(id, null, null, null, 0);
		int result= dao.idcheck(vo);

		if (result == 1) {
			JOptionPane.showMessageDialog(null, "이미 사용중인 ID 입니다.");
			textField_ID.setText("");
		} else if (textField_ID.getText().equals("")||id.contains(" ")) {
			JOptionPane.showMessageDialog(null, "ID를 정확히 입력해주세요");
		} else {
			JOptionPane.showMessageDialog(null, "사용가능한 ID 입니다.");
			btnNewButton_Check.setEnabled(true);
			
		}
		
	}//end idCheck
	
}//end Frame
