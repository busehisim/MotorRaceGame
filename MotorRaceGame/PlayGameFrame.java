import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.SynchronousQueue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class PlayGameFrame extends GameFrame implements KeyListener {

	Scrollroad back = new Scrollroad();
		
	  
	    private int xmotor=200;
	    private int ymotor=150;
	    private Icon motor;
	    private JPanel panel;
	    private JFrame frame;

	int score;


	public boolean suspended=false;

	public PlayGameFrame() {
		
		 super();
		setLayout(new BorderLayout());
			
        this.add(back);
            
		this.setTitle("Play Game");
		 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addKeyListener(this);
		this.setSize(800, 800);
		this.setVisible(true);
			
	}
	

		@Override
		public void keyPressed(KeyEvent event) {// listens the key events and calls the function accordingly

			String whichKey=KeyEvent.getKeyText(event.getKeyCode());
			
			
			if(whichKey.compareTo("Left")==0)
			{	
					back.leftPressed();
				
			}else if(whichKey.compareTo("Right")==0){	

					back.rightPressed();	
			}
			else if(whichKey.compareTo("Up")==0){
				
				back.UpPressed();
			
			}
			else if(whichKey.compareTo("Down")==0){
							
				back.DownPressed();		
			
			}
			
		}

public int getpause()
{
	return pausedpressed;
}


@Override
public void keyTyped(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}




@Override
public void keyReleased(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}

		
}

