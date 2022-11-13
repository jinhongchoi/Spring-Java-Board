package side_project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainFrame frame = new MainFrame();
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
	public MainFrame(String id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Main");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setBounds(93, 10, 239, 37);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("팀 등록");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TeamInfoFrame TeamInfo = new TeamInfoFrame(id);
				TeamInfo.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(52, 56, 120, 65);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("팀 정보 수정");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TeamInfoUpdateFrame TeamInfoUpdate = new TeamInfoUpdateFrame(id);
				TeamInfoUpdate.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(52, 156, 120, 65);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("팀원 등록");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeamInfoVO vo= new TeamInfoVO();
				TeamMateInsertFrame TeamMateInsert = new TeamMateInsertFrame(vo);
				TeamMateInsert.setVisible(true);
				
			}
		});
		btnNewButton_2.setBounds(268, 56, 97, 65);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("팀원 수정");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeamMateVO vo= new TeamMateVO();
				TeamMateDeleteFrame TeamMateDelete= new TeamMateDeleteFrame(vo.getCid());
				TeamMateDelete.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(268, 156, 97, 65);
		contentPane.add(btnNewButton_3);
				
		lblNewLabel_1 = new JLabel(id +"님 안녕하세요");
		lblNewLabel_1.setBounds(12, 10, 57, 15);
		contentPane.add(lblNewLabel_1);
	}//end frame
}//end MainFrame
