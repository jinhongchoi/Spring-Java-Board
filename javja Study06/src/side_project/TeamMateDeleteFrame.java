package side_project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeamMateDeleteFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	public static TeamMateDAOImple dao;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TeamMateDeleteFrame frame = new TeamMateDeleteFrame();
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
	public TeamMateDeleteFrame(int cid) {
		dao=TeamMateDAOImple.getinstance();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("삭제");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteTeamMate();
			}
		});
		btnNewButton.setBounds(58, 114, 261, 97);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel(String.valueOf(cid) );
		lblNewLabel.setBounds(130, 25, 57, 15);
		contentPane.add(lblNewLabel);
	}//end frame
	
	private void deleteTeamMate() {
		int cid = Integer.parseInt(lblNewLabel.getText());
		
		int result= dao.delete(cid);
		
		if(result ==1) {
			JOptionPane.showMessageDialog(contentPane, "삭제완료");
		}else {
			JOptionPane.showMessageDialog(contentPane, "삭제실패");
		}
		
	}

}
