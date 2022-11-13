package Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class LoginMain extends JFrame {

	private JPanel contentPane;
	private JTextField textField_ID;
	private JTextField textField_PW;
	private JButton btnLogin;
	private JButton btnjoin;
	private JLabel lblID;
	private JLabel lblPw;

	public static JoinDAOImple dao;
	public static LoginDAOImple dao2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		dao = JoinDAOImple.getInstance();
		dao2=LoginDAOImple.getinstance();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginMain frame = new LoginMain();
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
	public LoginMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblID = new JLabel("ID");
		lblID.setBounds(38, 60, 99, 43);
		contentPane.add(lblID);

		lblPw = new JLabel("PW");
		lblPw.setBounds(38, 120, 99, 43);
		contentPane.add(lblPw);

		textField_ID = new JTextField();
		textField_ID.setBounds(120, 71, 267, 21);
		contentPane.add(textField_ID);
		textField_ID.setColumns(10);

		textField_PW = new JTextField();
		textField_PW.setColumns(10);
		textField_PW.setBounds(120, 131, 267, 21);
		contentPane.add(textField_PW);

		btnLogin = new JButton("로그인");
		btnLogin.setBounds(83, 191, 97, 23);
		contentPane.add(btnLogin);

		btnjoin = new JButton("회원가입");
		btnjoin.setBounds(256, 191, 97, 23);
		contentPane.add(btnjoin);

		setVisible(true);
		// 회원가입 액션
		btnjoin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JoinMain frame = new JoinMain();

			}
		});// end 회원가입

		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = textField_ID.getText();
				String pw = textField_PW.getText();
				
				LoginVO vo2= new LoginVO(id, pw);
				
				int result = dao2.userCheck(vo2);
				if (result == 1) {
					// 로그인 성공 메시지
					JOptionPane.showMessageDialog(null, "로그인 성공");
					// 회원 정보 리스트 화면 이동과 동시에 username 세션값으로 넘김.
					
					// 현재 화면 종료
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "로그인 실패");
				}

			}
		});

	}// end LogMain

//	private void insertLogin() {

//		String id = textField_ID.getText();
//		String pw = textField_PW.getText();

//		LoginVO vo = new LoginVO(id, pw);

//	}

}
