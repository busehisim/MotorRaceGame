import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.*;


public class GameFrame extends JFrame {
	
		
		//private static JButton register;
		
		int pausedpressed=0;
		private String username;
		private String password;
		private JMenu game,user,quit;  
	    private JMenuItem login, highscore, start;
		JMenuItem pause;
		private JMenuItem restart;
		private JMenuItem exit; 
	    private static JMenuItem register;
	    Object source;
	    
		public GameFrame() {

			super("Moto Racer");
			
			setLayout(new FlowLayout());
			
			JLabel background = new JLabel(new ImageIcon(getClass().getResource("resource/menu.png")));
			add(background);
			background.setLayout(new FlowLayout());
			
			 
			
			JMenuBar mb=new JMenuBar();  
	          game=new JMenu("Game");  
	          user=new JMenu("User"); 
	          quit=new JMenu("Quit"); 
	          
	          register=new JMenuItem("Register");  
	          login=new JMenuItem("Login");  
	          highscore=new JMenuItem("HighScore");  
	          start=new JMenuItem("Start");  
	          pause=new JMenuItem("Pause");  
	          restart=new JMenuItem("Restart");
	          exit = new JMenuItem("Exit");
	          
	          user.add(register); user.add(login); user.add(highscore);  
	          game.add(start); game.add(restart); game.add(pause);
	          quit.add(exit);
	           
	           
	          mb.add(game);  
	          mb.add(user);
	          mb.add(quit); 
	          
	          this.setJMenuBar(mb);  
			
			MenuBarHandler handler = new MenuBarHandler();
			
			start.addActionListener(handler);
			restart.addActionListener(handler);
			pause.addActionListener(handler);
			register.addActionListener(handler);
			login.addActionListener(handler);
			highscore.addActionListener(handler);
			exit.addActionListener(handler);
			 
			
		}
		
		public  class MenuBarHandler implements ActionListener
		{
			
			public void actionPerformed(ActionEvent event) {
				
				 source = event.getSource(); 
				
				if(source == register) {
					
					dispose();
					RegisterFrame registerwindow = new RegisterFrame();
					registerwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					registerwindow.setSize(400,400);
					registerwindow.setVisible(true);
				
					

				}
				else if(source == start) {
					
					dispose();
					PlayGameFrame myframe = new PlayGameFrame();
					myframe.setFocusable(true);
					
					
					
				}
				else if(source == login) {
					
					dispose();
					LoginFrame login = new LoginFrame();
					login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					login.setSize(400,400);
					login.setVisible(true);
					
					
				}
				
				else if(source == highscore) {
					
					dispose();
					ScoreTableFrame scoreTable = new ScoreTableFrame();
					scoreTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					scoreTable.setSize(400,400);
					scoreTable.setVisible(true);
					
					
								
					
				}
				else if(source == restart) { 	
					
					dispose();
					PlayGameFrame myframe = new PlayGameFrame();
					myframe.setFocusable(true);
					
					
				}
				else if(source == pause) {		
					
				
					JOptionPane.showMessageDialog(null,"Pause","Informantion",JOptionPane.PLAIN_MESSAGE);
					pausedpressed=1;       
					
					
				}
				
				else if(source == exit) {		
					
					System.exit(1);
							
				}
				
			}
		
			 
		}
}


		
		


	
	


