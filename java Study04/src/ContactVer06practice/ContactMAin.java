package ContactVer06practice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ContactMAin {

	private JFrame frame;
	private JTextField textField_Name;
	private JTextField textField_Phone;
	private JTextField textField_Email;
	private JTextField textLog;
	private JTextArea textInfo;

	/**
	 * Launch the application.
	 * 
	 */

	public static ContactDAOImple dao;
	private JTextField textField;

	public static void main(String[] args) {
		dao = ContactDAOImple.getInstance();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactMAin window = new ContactMAin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ContactMAin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 462, 712);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("연락처 프로그램 ver6");
		lblNewLabel.setBounds(112, 29, 208, 52);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_Name = new JLabel("이름");
		lblNewLabel_Name.setBounds(38, 96, 74, 26);
		frame.getContentPane().add(lblNewLabel_Name);

		JLabel lblNewLabel_Phone = new JLabel("전화번호");
		lblNewLabel_Phone.setBounds(38, 137, 74, 26);
		frame.getContentPane().add(lblNewLabel_Phone);

		JLabel lblNewLabel_Email = new JLabel("이메일");
		lblNewLabel_Email.setBounds(38, 188, 74, 26);
		frame.getContentPane().add(lblNewLabel_Email);

		textField_Name = new JTextField();
		textField_Name.setBounds(143, 91, 227, 31);
		frame.getContentPane().add(textField_Name);
		textField_Name.setColumns(10);

		textField_Phone = new JTextField();
		textField_Phone.setColumns(10);
		textField_Phone.setBounds(143, 140, 227, 31);
		frame.getContentPane().add(textField_Phone);

		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setBounds(143, 191, 227, 31);
		frame.getContentPane().add(textField_Email);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 370, 313, 88);
		frame.getContentPane().add(scrollPane);

		textInfo = new JTextArea();
		scrollPane.setViewportView(textInfo);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(49, 490, 313, 100);
		frame.getContentPane().add(scrollPane_1);

		textLog = new JTextField();
		scrollPane_1.setViewportView(textLog);
		textLog.setColumns(10);

		JButton btnNewButton = new JButton("등록");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				insertContact();
			}
		});
		btnNewButton.setBounds(38, 256, 68, 71);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("전체검색");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				selectAll();

			}
		});
		btnNewButton_1.setBounds(120, 256, 68, 71);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("상세검색");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				selectbycontactId();
			}
		});
		btnNewButton_2.setBounds(204, 256, 68, 71);
		frame.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("수정");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				update();
			}
		});
		btnNewButton_3.setBounds(284, 256, 68, 71);
		frame.getContentPane().add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("삭제");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				delete();
			}
		});
		btnNewButton_4.setBounds(366, 256, 68, 71);
		frame.getContentPane().add(btnNewButton_4);

		textField = new JTextField();
		textField.setText("번호를 입력하세요~");
		textField.setBounds(204, 339, 116, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}

	private void insertContact() {

		// static 선언하는 원리 및 개념알기!
		String name = textField_Name.getText();
		String phone = textField_Phone.getText();
		String email = textField_Email.getText();

		ContactVO vo = new ContactVO(0, name, phone, email);
		// 배열에 저장(인덱스 0부터 순서대로)
		int result = dao.insert(vo);

		if (result == 1) {
			System.out.println("연락처 등록 완료");
			textInfo.setText("연락처 등록 완료");

		}
	}// end insert

	private void selectAll() {

		ArrayList<ContactVO> list = dao.select();
//	
		StringBuffer buffer = new StringBuffer(); // 이 부분 부터 buffer로 배열하는거 익히기
		buffer.append("연락처 개수 : " + list.size() + "\n");
		for (int i = 0; i < list.size(); i++) {
			buffer.append("--- 연락처 " + i + " --- \n" + list.get(i) + "\n");
		}

		textInfo.setText(buffer.toString());
	}// end selectAll

	private void selectbycontactId() {

		int index = Integer.parseInt(textField.getText());

		ArrayList<ContactVO> list = dao.select();
		if (index >= 0 ) {//0보다 큰 경우만 있기때문에 0보다 크게 잡는다!
			ContactVO vo = dao.select(index);
			textInfo.setText(vo.toString());
		} else {
			textInfo.setText("해당 인덱스에 연락처가 없습니다.");
			System.out.println("해당 인덱스에 연락처가 없습니다.");
		}

	}// end selectbycontactId()

	
	private void update() {

		int index = Integer.parseInt(textField.getText());

		ArrayList<ContactVO> list = dao.select();
		if (index >= 0 && index < list.size()) {//getSize대신 list.size() 사용!

			String name = textField_Name.getText();
			String phone = textField_Name.getText();
			String email = textField_Name.getText();

			ContactVO vo = new ContactVO(index, name, phone, email);

			int result = dao.update(index, vo);
			System.out.println("연락처 수정 완료!");
			textLog.setText("연락처 수정 완료!");
		} else {
			System.out.println("해당 인덱스에 연락처가 없습니다.");
			textLog.setText("해당 인덱스에 연락처가 없습니다.");
		}

	}// end update

	private void delete() {

		int contactId = Integer.parseInt(textField.getText());

		ArrayList<ContactVO> list = dao.select();
		if (contactId >= 0 && contactId < list.size()) {
			int result = dao.delete(contactId);
			if (result == 1) {
				textLog.setText("연락처 삭제 완료");
				System.out.println("연락처 삭제 완료");
			}
		} else {
			textLog.setText("해당 인덱스에 연락처가 없습니다.");
			System.out.println("해당 인덱스에 연락처가 없습니다.");
		}

	}//end delete

}
