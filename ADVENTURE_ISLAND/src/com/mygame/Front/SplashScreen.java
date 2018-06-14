package com.mygame.Front;



import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
//import javax.swing.SwingCostants;
import javax.swing.Timer;
import javax.swing.UIManager;
//import javax.swing.borderEmptyBorder;
//import javax.swing.borderLineBorder;

public class SplashScreen extends JWindow {
	private JProgressBar progressBar = new JProgressBar();
//private JLabel lblNewLabel = new JLabel("Game-2017");
private JPanel contentPane;
	private Timer timer;
	private boolean isVisible;
	private int currentProgress;
	private void doAnimation(){
		timer = new Timer(10,(e)->{
			progressBar.setValue(currentProgress);
			currentProgress++;
			if(currentProgress>100){
				timer.stop();
			SplashScreen.this.setVisible(false);
				SplashScreen.this.dispose();
				GameMenu mainMenu = new GameMenu();
				mainMenu.setVisible(true);
			}
			//lblNewLabel.setVisible(isVisible);
			isVisible = !isVisible;
		});
		timer.start();
	}
		
	
	public static void main(String[] args) {
		
					SplashScreen frame = new SplashScreen();
					frame.setVisible(true);
					UIManager.put("ProgressBar.background", Color.ORANGE);
					UIManager.put("ProgressBar.foreground", Color.RED);
					UIManager.put("ProgressBar.selectionBackground", Color.RED);
					UIManager.put("ProgressBar.selectionForeground", Color.GREEN);
					frame.doAnimation();
				
	}

	public SplashScreen() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize( 793, 585);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
        contentPane.setLayout(null);			
		//lblNewLabel.setForeground(Color.RED);
		//lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		//lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		//lblNewLabel.setBounds(84, 288, 249, 31);
		//contentPane.add(lblNewLabel);
		
		JLabel gametitlelbl = new JLabel("");
	//	gametitlelbl.setBorder(new LineBorder(Color.MAGENTA, 3));
		gametitlelbl.setIcon(new ImageIcon(SplashScreen.class.getResource("SplashScreen.png")));
				
		gametitlelbl.setBounds(0, 0, 793, 585);
		contentPane.add(gametitlelbl);
		progressBar.setBackground(Color.GREEN);
		progressBar.setForeground(Color.RED);
		
		
		progressBar.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		progressBar.setStringPainted(true);
		progressBar.setBounds(276, 388, 438, 20);
		contentPane.add(progressBar);
		
		
	}
}

