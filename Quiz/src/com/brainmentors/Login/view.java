package com.brainmentors.Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.brainmentors.Questions.MainScreen;
import com.brainmentors.Result.RScreen;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class view extends JFrame {

	private JPanel contentPane;
	private JTextField UserId1;
	private JTextField UserPwd1;
	private JTextField UserId2;
	private JTextField UserPwd2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view frame = new view();
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
	public view() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRATION");
		lblNewLabel.setBounds(177, 11, 108, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("UserId");
		lblNewLabel_1.setBounds(115, 47, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblUserpassword = new JLabel("UserPassword");
		lblUserpassword.setBounds(115, 77, 102, 14);
		contentPane.add(lblUserpassword);
		
		UserId1 = new JTextField();
		UserId1.setBounds(222, 48, 86, 20);
		contentPane.add(UserId1);
		UserId1.setColumns(10);
		
		UserPwd1 = new JTextField();
		UserPwd1.setColumns(10);
		UserPwd1.setBounds(222, 74, 86, 20);
		contentPane.add(UserPwd1);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserAdd();
			}
		});
		
		
		btnNewButton.setBounds(128, 105, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setBounds(177, 148, 108, 26);
		contentPane.add(lblLogin);
		
		JLabel lblUserid = new JLabel("UserId");
		lblUserid.setBounds(109, 174, 108, 26);
		contentPane.add(lblUserid);
		
		JLabel lblUserpasword = new JLabel("UserPasword");
		lblUserpasword.setBounds(109, 200, 108, 26);
		contentPane.add(lblUserpasword);
		
		UserId2 = new JTextField();
		UserId2.setColumns(10);
		UserId2.setBounds(222, 177, 86, 20);
		contentPane.add(UserId2);
		
		UserPwd2 = new JTextField();
		UserPwd2.setColumns(10);
		UserPwd2.setBounds(222, 203, 86, 20);
		contentPane.add(UserPwd2);
		
		JButton btnNewButton_1 = new JButton("LOGIN");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
             Login();
       }
		});
		btnNewButton_1.setBounds(115, 228, 89, 23);
		contentPane.add(btnNewButton_1);
	}
	UserInfo user;
	private void UserAdd(){
		int UserId=Integer.parseInt(UserId1.getText());
		String UserPwd=UserPwd1.getText();
		 user=new UserInfo(UserId ,UserPwd);
		UserOperations u=UserOperations.getInstance() ;
		String result =u.AddUser(user);
		//user.setRegflag(true);
		JOptionPane.showMessageDialog(this, result);
		
		}
	private void Login(){
		
	String result = UserOperations.
							getInstance().
							RegCheck(Integer.parseInt(UserId2.getText()),UserPwd2.getText())>=0?"LOGGED IN":"REGISTER FIRST";
				JOptionPane.showMessageDialog(this, result);
if(result=="LOGGED IN"){
				view.this.setVisible(false);
				view.this.dispose();
				MainScreen m=new MainScreen();
				m.setVisible(true);
				System.out.println("DONE.....");
}
	}
	
}
