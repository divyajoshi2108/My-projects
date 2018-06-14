package com.brainmentors.Result;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.brainmentors.Questions.QOperations;
import com.brainmentors.Questions.Questions;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class RScreen extends JFrame {

	private JPanel contentPane;
	private JTextField y1;
	private JTextField y2;
	private JTextField y3;
	private JTextField c1;
	private JTextField c2;
	private JTextField c3;
	private JTextField s1;
	private JTextField s2;
	private JTextField s3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RScreen frame = new RScreen();
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
	public RScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RESULT");
		lblNewLabel.setBounds(181, 11, 137, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblQuestions = new JLabel("QUESTIONS");
		lblQuestions.setBounds(29, 41, 58, 14);
		contentPane.add(lblQuestions);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(42, 41, 46, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(42, 41, 46, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(29, 41, 46, 14);
		contentPane.add(label_3);
		
		JLabel lblNewLabel_1 = new JLabel("     YOUR ANSWER");
		lblNewLabel_1.setBounds(97, 41, 103, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblCorrectAnswer = new JLabel("CORRECT ANSWER");
		lblCorrectAnswer.setBounds(217, 41, 110, 14);
		contentPane.add(lblCorrectAnswer);
		
		JLabel lblStatus = new JLabel("STATUS");
		lblStatus.setBounds(333, 41, 58, 14);
		contentPane.add(lblStatus);
		
		JLabel lblNewLabel_2 = new JLabel("Q1");
		lblNewLabel_2.setBounds(29, 82, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblQ = new JLabel("Q2");
		lblQ.setBounds(29, 119, 46, 14);
		contentPane.add(lblQ);
		
		JLabel lblQ_1 = new JLabel("Q3");
		lblQ_1.setBounds(29, 156, 46, 14);
		contentPane.add(lblQ_1);
		
		y1 = new JTextField();
		y1.setBounds(107, 79, 86, 20);
		contentPane.add(y1);
		y1.setColumns(10);
		
		y2 = new JTextField();
		y2.setColumns(10);
		y2.setBounds(107, 116, 86, 20);
		contentPane.add(y2);
		
		y3 = new JTextField();
		y3.setColumns(10);
		y3.setBounds(107, 153, 86, 20);
		contentPane.add(y3);
		
		c1 = new JTextField();
		c1.setColumns(10);
		c1.setBounds(218, 79, 86, 20);
		contentPane.add(c1);
		
		c2 = new JTextField();
		c2.setColumns(10);
		c2.setBounds(218, 116, 86, 20);
		contentPane.add(c2);
		
		c3 = new JTextField();
		c3.setColumns(10);
		c3.setBounds(218, 153, 86, 20);
		contentPane.add(c3);
		
		s1 = new JTextField();
		s1.setColumns(10);
		s1.setBounds(321, 79, 86, 20);
		contentPane.add(s1);
		
		s2 = new JTextField();
		s2.setColumns(10);
		s2.setBounds(321, 116, 86, 20);
		contentPane.add(s2);
		
		s3 = new JTextField();
		s3.setColumns(10);
		s3.setBounds(321, 153, 86, 20);
		contentPane.add(s3);
		setter();
	}
	private  void setter(){
		QOperations q=QOperations.getInstance();
		Questions Q1=q.getQ().get(0);
		y1.setText(Q1.getYAns());
		c1.setText(Q1.getRAns());
		if(Q1.getYAns()==Q1.getRAns())
			s1.setText("RIGHT");
		else
			s1.setText("WRONG");
		
		Questions Q2=q.getQ().get(1);
		y2.setText(Q2.getYAns());
		c2.setText(Q2.getRAns());
		if(Q2.getYAns()==Q2.getRAns())
			s2.setText("RIGHT");
		else
			s2.setText("WRONG");
		
		Questions Q3=q.getQ().get(2);
		y3.setText(Q3.getYAns());
		c3.setText(Q3.getRAns());
		if(Q3.getYAns()==Q3.getRAns())
			s3.setText("RIGHT");
		else
			s3.setText("WRONG");
		
	
	}
}
