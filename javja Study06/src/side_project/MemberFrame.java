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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class MemberFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_ID;
	public static MemberDAOImple dao;
	private JPasswordField passwordField;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberFrame frame = new MemberFrame();
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
	public MemberFrame() {
		dao= MemberDAOImple.getinstance();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setBounds(112, 25, 191, 46);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("id");
		lblNewLabel_1.setBounds(47, 94, 79, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("pw");
		lblNewLabel_1_1.setBounds(47, 146, 79, 32);
		contentPane.add(lblNewLabel_1_1);
		
		textField_ID = new JTextField();
		textField_ID.setBounds(149, 100, 210, 26);
		contentPane.add(textField_ID);
		textField_ID.setColumns(10);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberLogin();
				dispose();
		
			}
		});
		btnLogin.setBounds(88, 204, 105, 47);
		contentPane.add(btnLogin);
		
		JButton btnJoin = new JButton("Join");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JoinFrame Join= new JoinFrame();
				Join.setVisible(true);
			}
		});
		btnJoin.setBounds(238, 204, 105, 47);
		contentPane.add(btnJoin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(149, 152, 210, 21);
		passwordField.setEchoChar('*');
		contentPane.add(passwordField);
	}//end MemberFrame
	
	private void memberLogin() {
		
		String id= textField_ID.getText();
		String pw= passwordField.getText();
		
		MemberVO vo= new MemberVO(id, pw);
		
		int result= dao.userCheck(vo);
		
		if(result==1) {
			JOptionPane.showMessageDialog(contentPane, "로그인 성공");
			dispose();
		}
		
		MainFrame Main= new MainFrame(id);
		Main.setVisible(true);
		
		
		//이거 다음은 다음 프레임 작성 후 작성하기!
		
	}//end memberLogin()
}//end Frame
