package Login;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

public class JoinMain extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnMAN;
	private JRadioButton rdbtnWOMAN;
	private Component frame;
	private String gender1;

	/**
	 * Launch the application.
	 */

	public static JoinDAOImple dao;

	public static void main(String[] args) {

		dao = JoinDAOImple.getInstance();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JoinMain frame = new JoinMain();
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
	public JoinMain() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 662);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("회원가입");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setBounds(129, 21, 160, 47);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_ID = new JLabel("ID");
		lblNewLabel_ID.setBounds(32, 114, 85, 21);
		contentPane.add(lblNewLabel_ID);

		JLabel lblNewLabel_PW = new JLabel("PW");
		lblNewLabel_PW.setBounds(32, 158, 85, 21);
		contentPane.add(lblNewLabel_PW);

		JLabel lblNewLabel_NAME = new JLabel("NAME");
		lblNewLabel_NAME.setBounds(32, 205, 85, 21);
		contentPane.add(lblNewLabel_NAME);

		JLabel lblNewLabel_GENDER = new JLabel("GENDER");
		lblNewLabel_GENDER.setBounds(32, 252, 85, 21);
		contentPane.add(lblNewLabel_GENDER);

		JLabel lblNewLabel_AGE = new JLabel("AGE");
		lblNewLabel_AGE.setBounds(32, 304, 85, 21);
		contentPane.add(lblNewLabel_AGE);

		textField = new JTextField();
		textField.setBounds(141, 114, 237, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(141, 158, 237, 21);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(141, 205, 237, 21);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(141, 304, 237, 21);
		contentPane.add(textField_3);

		rdbtnMAN = new JRadioButton("남자");
		buttonGroup.add(rdbtnMAN);
		rdbtnMAN.setBounds(140, 251, 121, 23);
		contentPane.add(rdbtnMAN);

		rdbtnWOMAN = new JRadioButton("여자");
		buttonGroup.add(rdbtnWOMAN);
		rdbtnWOMAN.setBounds(265, 251, 121, 23);
		contentPane.add(rdbtnWOMAN);

		JButton btnNewButton = new JButton("회원가입 완료");
		btnNewButton.setBounds(141, 428, 131, 72);
		contentPane.add(btnNewButton);

		setVisible(true);
		// 회원가입완료 액션
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				insertJoin();

				dispose();

			}
		});

		
	}// end Join Main

	private void insertJoin() {

		String id = textField.getText();
		String pw = textField_1.getText();
		String name = textField_2.getText();
		
		String gender=rdbtnMAN.getText();//이부분 해결하기!
				
		String age = textField_3.getText();

		if (id.equals("") || pw.equals("") || name.equals("")|| gender.equals("")|| age.equals("")) {
			JOptionPane.showMessageDialog(frame, "연락처 정보를 입력하세요");
			// 코드로 ui적인 부분을 불러내고 기능을 줄수도 있다!
			return;
			// 함수 자체를 그냥 밑에서 끝내게함! void여도 사용가능!(끝내지않으면 밑으로 진행되서 알람뜨고 등록완료됨)
		}

		JoinVO vo = new JoinVO(id, pw, name, gender, age);

		int result = dao.insert(vo);

		if (result == 1) {
			JOptionPane.showMessageDialog(null, "회원가입 완료");
			System.out.println("회원가입 완료");
		} else {
			JOptionPane.showMessageDialog(null, "회원가입 실패");
		}

	}// end insert
}
