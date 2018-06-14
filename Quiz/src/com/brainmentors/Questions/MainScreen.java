package com.brainmentors.Questions;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.brainmentors.Result.RScreen;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainScreen extends JFrame {

	private JPanel contentPane;
	private JTextField Q1;
	private JTextField opA;
	private JTextField opC;
	private JTextField opB;
	private JTextField opD;
	private JRadioButton op1;
	private JRadioButton op2;
	private JRadioButton op3;
	private JRadioButton op4;
	QOperations q=QOperations.getInstance();
	boolean Nflag;
	//int Pcount=0;
	int index=0;
	JLabel Q1lbl ;
	JLabel Q2lbl ;
	JLabel Q3lbl; 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
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
	public MainScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JLabel lblNewLabel = new JLabel("QUESTIONS");
		lblNewLabel.setBounds(185, 25, 108, 14);
		contentPane.add(lblNewLabel);
		
		Q1 = new JTextField();
		Q1.setBounds(10, 56, 414, 20);
		contentPane.add(Q1);
		Q1.setColumns(10);
		
	 op1 = new JRadioButton("A");
		op1.setBounds(28, 96, 41, 23);
		contentPane.add(op1);
		op1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            Answered();
	           q.getQ().get(index).setYAns(op1.getText());
	           q.getQ().get(index).setAnswered(true);

	        }
	    });
	
	
		 op3 = new JRadioButton("C");
		op3.setBounds(28, 132, 41, 23);
		contentPane.add(op3);
		op3.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            Answered();
	            q.getQ().get(index).setYAns(op3.getText());
	            q.getQ().get(index).setAnswered(true);


	        }
	    });
	
		
		 op2 = new JRadioButton("B");
		op2.setBounds(224, 96, 41, 23);
		contentPane.add(op2);
		op2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            Answered();
	            q.getQ().get(index).setYAns(op2.getText());
	            q.getQ().get(index).setAnswered(true);

	        }
	    });
	
		 op4 = new JRadioButton("D");
	     op4.setBounds(224, 132, 41, 23);
		contentPane.add(op4);
		op4.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            Answered();
	            q.getQ().get(index).setYAns(op4.getText());
	            q.getQ().get(index).setAnswered(true);


	        }
	    });
	
		opA = new JTextField();
		opA.setBounds(59, 97, 86, 20);
		contentPane.add(opA);
		opA.setColumns(10);
		
		opC = new JTextField();
		opC.setColumns(10);
		opC.setBounds(69, 126, 86, 20);
		contentPane.add(opC);
		
		opB = new JTextField();
		opB.setColumns(10);
		opB.setBounds(261, 97, 86, 20);
		contentPane.add(opB);
		
		opD = new JTextField();
		opD.setColumns(10);
		opD.setBounds(261, 133, 86, 20);
		contentPane.add(opD);
		
		JButton Pbtn = new JButton("Previous");
		Pbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Nflag &&  index>0 ){
					if(index==2)
						index--;
					else
					index--;
					prevoiusQ();
				
				}
			}
		});
		Pbtn.setBounds(10, 184, 89, 23);
		contentPane.add(Pbtn);
		
		JButton Nbtn = new JButton("Next");
		Nbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( index<2){
					index++;
				nextQ();
				}	
			}
		});
		Nbtn.setBounds(144, 184, 89, 23);
		contentPane.add(Nbtn);
		
		JButton Sbtn = new JButton("Submit");
		Sbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainScreen.this.setVisible(false);
					MainScreen.this.dispose();
				RScreen r=new RScreen();
				r.setVisible(true);
				System.out.println("DONE.....");
			}
		});
		Sbtn.setBounds(282, 184, 89, 23);
		contentPane.add(Sbtn);
		
		 Q1lbl = new JLabel("RED");
		Q1lbl.setBounds(40, 237, 46, 14);
		contentPane.add(Q1lbl);
		
		 Q2lbl = new JLabel("RED");
		Q2lbl.setBounds(153, 237, 46, 14);
		contentPane.add(Q2lbl);
		
		 Q3lbl = new JLabel("RED");
		Q3lbl.setBounds(286, 237, 46, 14);
		contentPane.add(Q3lbl);
		currentQ();
		/*Board b=new Board();
		add(b);*/
		makeGroup();
	}

private void setQ(){
	
	
		Questions qu=q.getQ().get(index);
	/*	Questions qu1=q.getQ().get(1);
		Questions qu2=q.getQ().get(2);*/
		StringBuffer q1=new StringBuffer("Q"+(index+1)+" " +qu.getQuestion());
		/*String q2=qu1.getQuestion();
		String q3=qu2.getQuestion();*/
		Q1.setText(q1.toString());
		String a1[]=qu.getAnswer();
		opA.setText(a1[0]);
		opB.setText(a1[1]);
		opC.setText(a1[2]);
		opD.setText(a1[3]);
		System.out.println(index);
		/*System.out.println(q1);
		System.out.println(q2);
		System.out.println(q3);
		*/
		//qu.setView(true);
		if(!(qu.isAnswered()))
	viewed();
		if(qu.isAnswered()){
			if(qu.getYAns()==op1.getText())
				op1.setSelected(true);
			
			else if(qu.getYAns()==op2.getText())
				op2.setSelected(true);
			
			else if(qu.getYAns()==op3.getText())
				op3.setSelected(true);
			
			else if(qu.getYAns()==op4.getText())
				op4.setSelected(true);
		}
		else{
			
		clearAnswers();
		}
		
}
ButtonGroup bg = new ButtonGroup();
	private void makeGroup(){
		
		bg.add(op1);
		bg.add(op2);
		bg.add(op3);
		bg.add(op4);
	}
	private void clearAnswers(){
				bg.clearSelection();
			}
	
	private void currentQ(){
		
		q.AddQ();
			setQ();
		
	}
	
	private void nextQ(){
		
		setQ();
		Nflag=true;
		
	}
		private void prevoiusQ(){
		setQ();
	
	}
		private boolean StatusA(){
		
			return(op1.isSelected() || op2.isSelected() ||op3.isSelected() ||op4.isSelected());
			
				
		}
		private void viewed(){
			if(index==0){
				Q1lbl.setText("YELLOW");
				
			}
			if(index==1){
				Q2lbl.setText("YELLOW");
				
			}
			if(index==2){
				Q3lbl.setText("YELLOW");
				
			}
		}
			private void Answered(){
				if(StatusA()){
					
				if(index==0){
					Q1lbl.setText("GREEN");
					
					
				}
				if(index==1){
					Q2lbl.setText("GREEN");
					
				}
				if(index==2){
					Q3lbl.setText("GREEN");
					
				}
				}				
				
			
		}
}
