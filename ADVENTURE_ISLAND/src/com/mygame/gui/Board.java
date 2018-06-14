package com.mygame.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;





public class Board extends JPanel implements GameConstant {
	Timer timer;
	Camera camera;
	Enemy enemies;	
	Player player;
	static int count=1;
 ArrayList<Enemy> EList=new ArrayList<>(MAX_ENEMY);
 
CommonUtil c=new CommonUtil();
Fruit fruit[] =new Fruit[MAX_FRUIT];
Egg egg=new Egg();
public static boolean PlayerMove;
//holes hole=new holes();

	public Board(){
		setSize(Gwidth,Gheight);
		
		camera=new Camera();
		player=new Player ();
		
		setFocusable(true);
		bindEvents();
		prepareEnemy();
		prepareFruit();
		gameLoop();
		
	
	}
	
	
	public void prepareEnemy(){
		int gap = 0;
		
		for(int i = 0 ; i<MAX_ENEMY; i++){
			int q=c.GetRandom(3);
			
		EList.add(new Enemy( ENEMY_INI,i,q));
	}
		}

		
		
	private void drawEnemies(Graphics g){
		for(Enemy enemies : EList){
			
				if(PlayerMove){
					
					enemies.move();
							}
			if(enemies.IsVisible==true){
			enemies.drawEnemyDefault(g);
	}
			}
			
			}

		
	
	private void gameLoop(){
		
		timer = new Timer(GAME_SPEED,(ee)->{
			
			
		repaint();
		
	player.fall();
	checkCollisionEnemy();
	checkCollisionFruit();
checkCollisionHammer();
//checkHoleCollision();
checkCollisionEgg();

		count++;
		
		
		});
		timer.start();
	}
	
	private void bindEvents(){
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e){
				
				if(e.getKeyCode()==KeyEvent.VK_RIGHT){
				
					camera.right();
					egg.move();
					if(camera.getX()==1000){
						player.SkateMode=false;
					}
					//hole.move();
					
					//System.out.println(hole.getX());

					
				//	if(camera.getX()>=3990-GAME_WIDTH ||camera.getX()<=GAME_WIDTH/2)
					//{
						//player.setSpeed(10);
					
					//	player.move();
					//}
					PlayerMove=true;
				
				//System.out.println(camera.getX());
				
				
				}
			
	
					
				if(e.getKeyCode()==KeyEvent.VK_LEFT){
					player.reverse=true;
					
					camera.left();
				}
				if(e.getKeyCode()==KeyEvent.VK_UP){
					player.jump();
					
				}
				if(e.getKeyCode()==KeyEvent.VK_SPACE){
					player.fire();
					
				}
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					Evisible=false;
					isGameOver=false;
					
					j=10;
				
			
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyReleased(e);
				if(e.getKeyCode()==KeyEvent.VK_RIGHT){
					
				PlayerMove=false;
				}
				if(e.getKeyCode()==KeyEvent.VK_RIGHT){
				player.reverse=false;
				}
					
			}
		
			});
		}
	
	public void drawHammers(Graphics g){
				for(Hammer hammer : player.getHammerlist()){
	if(hammer.isVisible()==true){
					hammer.drawHammer(g);
					
					hammer.outOfScreen();
					}
				}
			}
			

	@Override
public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		camera.drawBG(g);
		
		
		if(isGameOver){
			
			
			if(Evisible==true){
				End(g);
			}
			ender();
		
				gameOver(g);
				return;
				
				}
		if(Svisible==false){
	player. drawaPlayerDefault(g);
		}
		drawHammers(g);
	
        drawEnemies(g);
        
	
        
        drawFruits(g);
        
        g.setColor(Color.RED);
        g.setFont(new Font("Arial",Font.BOLD,30));
		g.drawString("Score "+counter, GAME_WIDTH-200, 70);
				
		if(Svisible==true){
			Start(g);
			
		}

			starter();
		if(egg.isVisible()==true){
egg.drawEgg(g);
		}
//hole.drawholes(g);
}
	
	
	public void prepareFruit(){
		int gap=0;
		Image img = null;
		for(int i=0;i<MAX_FRUIT;i++){
			
			if(i%2==0){
				try {
					img=ImageIO.read(Board.class.getResource(FRUIT_IMG)).getSubimage(69, 4, 14, 14);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				else{
					try {
						img=ImageIO.read(Board.class.getResource(FRUIT_IMG)).getSubimage(114, 4, 16, 14);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		fruit[i]=new Fruit(100+gap,img);
				gap+=300;
				}
		}
	
		
	public void drawFruits(Graphics g){
		for(Fruit  fruits :fruit){
			if(fruits.isVisible()==true){
	fruits.drawFruit(g);
	if(PlayerMove){
		fruits.move();
	}
		}
	}
	}
	
	public boolean IsCollisionHammer(Hammer hammer, Enemy enemy){
		if(hammer.isVisible()==true &&  enemy.IsVisible==true){
		Rectangle one = new Rectangle( hammer.getX(),  hammer.getY(),  hammer.getW(),  hammer.getH());
			Rectangle two = new Rectangle(enemy.getX(), enemy.getY(), enemy.getW(), enemy.getH());
			return one.intersects(two);
		}
		return false;
	}

	public void checkCollisionHammer(){
		for(Enemy enemy: EList){
			for(Hammer hammer:player.getHammerlist()){
			if(IsCollisionHammer(hammer , enemy)){
					enemy.setIsVisible(false);
				hammer.setVisible(false);
							System.out.println("collosion done");
				}
			
		}}
}
		
public boolean IsCollisionEnemy(Player player, Enemy enemy){
	if(enemy.IsVisible==true){
			Rectangle one = new Rectangle(player.getX(), player.getY(), player.getW(), player.getH());
				Rectangle two = new Rectangle(enemy.getX(), enemy.getY(), enemy.getW(),enemy.getH());
				
				return one.intersects(two);
			}
	return false;
			}


boolean isGameOver = false;
	

public void checkCollisionEnemy(){
				for(Enemy enemy:EList){
					if(IsCollisionEnemy(player, enemy)){
									isGameOver = true;
									enemy.IsVisible=false;
									Evisible=true;
								
						
			
					}}
				}
		


		public boolean IsCollisionFruit(Player player, Fruit fruit){
			if(fruit.isVisible()==true){
			Rectangle one = new Rectangle(player.getX(), player.getY(), player.getW(), player.getH());
				Rectangle two = new Rectangle(fruit.getX(),fruit.getY(),fruit.getW(), fruit.getH());
				return one.intersects(two);
			}
			return false;
			}
		public void checkCollisionFruit(){
			
			for(Fruit fruit:fruit){
				if(IsCollisionFruit(player, fruit)){
						score();
						fruit.Visible=false;
				}
			}
	}

		public boolean IsCollisionEgg(Player player, Egg egg){
			
			Rectangle one = new Rectangle(player.getX(), player.getY(), player.getW(), player.getH());
				Rectangle two = new Rectangle(egg.getX(),egg.getY(),egg.getW(), egg.getH());
				return one.intersects(two);
			
			}
		public void checkCollisionEgg(){
			
			
				if(IsCollisionEgg(player, egg)){
					egg.Visible=false;	
				player.SkateMode=true;
				
				
			}
	}
		public boolean isHoleCollision(Player player, holes hole){
					int xDistance = Math.abs(player.getX()- hole.getX());
			
			int yDistance = Math.abs(player.getY()-hole.getY());
				int width = Math.max(player.getW(), hole.getW());
				int height = Math.max(player.getH(),hole.getH());
					//return xDistance<=enemy.getW()-40 && yDistance<=enemy.getH()-40;
					return xDistance<=width && yDistance<=height;
				
				}
	/*	
		public void checkHoleCollision(){
			//for(holes hole:hole)
				if(isHoleCollision(player, hole)){
									}
				System.out.println("fall.....");
				player.Visible=false;
				System.out.println(hole.getX());
			}*/
		
		int counter;
			private void score(){
				counter+=10;
			
			}
			
			public void gameOver(Graphics g){
					g.setColor(Color.RED);
						g.setFont(new Font("Arial",Font.BOLD,60));
						g.drawString("GAME OVER",170 , 450);
					}

			public void Start(Graphics g){
				g.setColor(Color.RED);
					g.setFont(new Font("Arial",Font.BOLD,200));
					g.drawString(""+i, 300, GAME_HEIGHT/2);
					g.setColor(Color.BLUE);
					g.setFont(new Font("Arial",Font.BOLD,50));
					g.drawString("START", 250, 400);
					
				}
		int i=1;
		boolean  Svisible=true;	
			private void starter(){
				if(count%10==0 ){
				
			i++;
				}
			if(i>3){
				Svisible=false;
			}
			}
			
			public void End(Graphics g){
				g.setColor(Color.RED);
					g.setFont(new Font("Arial",Font.BOLD,200));
					g.drawString(""+j, 300, GAME_HEIGHT/2);
					g.setColor(Color.BLUE);
					g.setFont(new Font("Arial",Font.BOLD,30));
					g.drawString("PRESS ENTER FOR CONTINUE", 100, 350);
				}
		int j=10;
		boolean  Evisible=false;
		
			private void ender(){
			if(Evisible==true){
				if(count%10==0 ){
			j--;
			if(j<1){
				Evisible=false;
				repaint();
				timer.stop();
			}
			}}
			
			}
}