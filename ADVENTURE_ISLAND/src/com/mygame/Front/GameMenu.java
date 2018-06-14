package com.mygame.Front;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mygame.gui.Frame;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JProgressBar;
import java.awt.Color;



public class GameMenu extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameMenu frame = new GameMenu();
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
	boolean visible=true;
	public GameMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 494);
		
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 742, 494));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel = new JLabel("New label");
		
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_SPACE){
					//if(visible==true)
					{	Islander();
					contentPane.setVisible(false);
					//visible=false;
					GameMenu.this.dispose();
					}	}
			}
		});
		lblNewLabel.setIcon(new ImageIcon(GameMenu.class.getResource("GameMenu.png")));
		lblNewLabel.setBounds(0, 0, 722, 494);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setVisible(false);
		btnNewButton.setBounds(302, 386, 161, 59);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Islander();
					contentPane.setVisible(false);
					visible=false;
					}
				});
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		/*private int  currentProgress;
		private void doAnimation(){
			 timer = new Timer(10,(e)->{
				 textField.setText(currentProgress);
				currentProgress++;
				if(currentProgress>4){
					timer.stop();
		
	}*/
	}
public void Islander(){
	Frame gameframe= new Frame();
}
	}


