import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
 
public class Scrollroad extends JPanel implements Runnable{
 
	
	
    // Two copies of the background image to scroll
	
	
    public Road backOne;
    public Road backTwo;
    public Road offroadOne;
    public Road offroadTwo;
    int x=0;
    int counter=3;
    int startflag=0;
    int drawonce=0;
    int score=0;
    int outofroad=0;
    int animatecrash=0;
    int animecounter=1;
    long speed=50;
    long screenspeed;
    int timescreen;
    int time=60;
    boolean suspended=false;
    int enemyCount=4;
    int randomx;
    int randomy;
    int randomchoice;
    int random;
    int secondcounter=0;
   
    public int xmotor=250;
    public int ymotor=560;
    
    public int xenemymotor=380;
    public int yenemymotor=560;
   
   
    
    JLabel start ;
    
    private BufferedImage road;
    private BufferedImage mymotor;
    private BufferedImage enemymotor;

    private BufferedImage fakeback;
    
    private BufferedImage expo1;
    private BufferedImage expo2;
    private BufferedImage expo3;
    private BufferedImage expo4;
    private BufferedImage expo5;
    private BufferedImage expo6;
  
    Thread t;
    
	private int number;
    
    
    public Scrollroad() {
    	

        backOne = new Road();
             
         t = new Thread(this);
        t.start();
        
        setVisible(true);
        
    }
    
 
    @Override
    public void run() {
        try {
        	
        	 mymotor = ImageIO.read(new File("resource/mymotorbike.png"));
        	 enemymotor =ImageIO.read(new File("resource/mymotor.png"));
        	 fakeback = ImageIO.read(new File("resource/thebackground.png"));
        	 
        	 expo6= ImageIO.read(new File("resource/expo6.png"));
        	 expo5= ImageIO.read(new File("resource/expo5.png"));
        	 expo4= ImageIO.read(new File("resource/expo4.png"));
        	 expo3= ImageIO.read(new File("resource/expo3.png"));
        	 expo2= ImageIO.read(new File("resource/expo2.png"));
        	 expo1= ImageIO.read(new File("resource/expo1.png"));
        	 
        	 
            while(counter>0) {
            	number=counter;
            	t.sleep(1000);
            	this.repaint();
            	
            	counter--;
            	
            }
             
        	t.sleep(250);
        	drawonce=1;
        	startflag=1;
        	//repaint();
        	
            while (outofroad==0 && time>0 ) { 
            	 
            	
                t.sleep(speed);
                score++;
                if(secondcounter==25) {	//because thread sleeps for 250 ýf we enter this while loop for the 40 týmes ýt means one mýnute passed
                Time();
                secondcounter=0;
                }
                else {
                	secondcounter++;
                }
                if(score%800==0) {	//each time gets 800 score a lap complete and týme ýs reset to 60
                	time=60;
                	this.repaint();
                	t.sleep(1000);
                }
                random=moveflag();		///decýdes to move the enemy or not
                if(random >100 && random<310) { //if the random number between 0-10000 is between 100 and 310 the enemy motor is goýng to move
                	randomMove();
                	
                }
               
                this.repaint();
                if(xmotor>525 || xmotor<171 || isCollision()) //crash when 
                {
                	animatecrash=1;
                	this.repaint();
                	animecounter++;
                	t.sleep(500);
                	this.repaint();
                	animecounter++;
                	t.sleep(500);
                	this.repaint();
                	animecounter++;
                	t.sleep(500);
                	this.repaint();
                	animecounter++;
                	t.sleep(500);
                	this.repaint();
                	animecounter++;
                	t.sleep(500);
                	this.repaint();
                	animecounter++;
                	t.sleep(500);
                	outofroad=1;
                }
                
             
                
            }
        
        }
        catch (Exception e) {}
    }
 
    @Override
    public void update(Graphics window) {
       
    	paint(window);
      
        
    }
    @Override
    public void paint(Graphics window) {
    	
    	
        Graphics2D twoD = (Graphics2D)window;
        
     
     
   	if (expo6 == null)
   		expo6 = (BufferedImage)(createImage(getWidth(), getHeight()));
   
	if (expo5 == null)
   		expo5 = (BufferedImage)(createImage(getWidth(), getHeight()));
  
	if (expo4 == null)
   		expo4 = (BufferedImage)(createImage(getWidth(), getHeight()));
   
	if (expo3 == null)
   		expo3 = (BufferedImage)(createImage(getWidth(), getHeight()));
  
	if (expo2 == null)
   		expo2 = (BufferedImage)(createImage(getWidth(), getHeight()));
  
	if (expo1 == null)
   		expo1 = (BufferedImage)(createImage(getWidth(), getHeight()));
   
	
	/*if(isCollision()) {
		animatecrash=1;
		animecounter=5;
		this.repaint();
    	outofroad=1;
	}*/
    
    
   	if(drawonce==0) { 
   		
     if (fakeback == null)		//when fýrst stars ýt shows the start while counting down
         fakeback = (BufferedImage)(createImage(getWidth(), getHeight()));
     System.out.println("bunu basmadan ekrana basmýyor "+fakeback);
     twoD.drawImage(fakeback, 0, 0,fakeback.getWidth(), fakeback.getHeight()-40,  null);
     
   	}
   	 
   	 if(drawonce==1) { 
        if (road == null)
            road = (BufferedImage)(createImage(getWidth(), getHeight()));
      
      if (mymotor == null)
            mymotor = (BufferedImage)(createImage(getWidth(), getHeight()));
      if (enemymotor == null)
          enemymotor = (BufferedImage)(createImage(getWidth(), getHeight()));
 
        // Create a buffer to draw to
        Graphics buffer = road.createGraphics();
       
        // Put the two copies of the background image onto the buffer
      
		twoD.drawImage(road, x, 0, null);
		
        // Draw the image onto the window   
        
        if(animatecrash==0) {
        	
        	 backOne.draw(buffer);twoD.drawImage(road, x, 0, null);	//scroolýng road
        	twoD.drawImage(mymotor, xmotor, ymotor, mymotor.getWidth(), mymotor.getHeight(), null);
         	twoD.drawImage(enemymotor, xenemymotor, yenemymotor, enemymotor.getWidth(), enemymotor.getHeight(), null);
        	
        }
        if(animatecrash==1) {		//crashýng anýmatýon
        	if(animecounter==6){
        	twoD.drawImage(expo6, xmotor, ymotor,expo6.getWidth(),expo6.getHeight(),  null);
        	twoD.drawImage(expo6, xenemymotor, yenemymotor,expo6.getWidth(),expo6.getHeight(),  null);
        	
        	twoD.setFont(new Font("TimesRoman", Font.BOLD, 75));
            twoD.setColor(Color.RED); // draws the score board
            twoD.drawString("GAME OVER!!", 200, 400);
        	}
        	if(animecounter==5) {
            twoD.drawImage(expo5, xmotor, ymotor,expo5.getWidth(),expo5.getHeight(),  null);
            twoD.drawImage(expo5, xenemymotor, yenemymotor,expo5.getWidth(),expo5.getHeight(),  null);
            }
        	if(animecounter==4) {
            twoD.drawImage(expo4, xmotor, ymotor,expo4.getWidth(),expo4.getHeight(),  null);
            twoD.drawImage(expo4, xenemymotor, yenemymotor,expo4.getWidth(),expo4.getHeight(),  null);
        	}
            if(animecounter==3) {
            twoD.drawImage(expo3, xmotor, ymotor,expo3.getWidth(),expo3.getHeight(),  null);
            twoD.drawImage(expo3, xenemymotor, yenemymotor,expo3.getWidth(),expo3.getHeight(),  null);
            }
            if(animecounter==2) {
            twoD.drawImage(expo2, xmotor, ymotor,expo2.getWidth(),expo2.getHeight(),  null);
            twoD.drawImage(expo2, xenemymotor, yenemymotor,expo2.getWidth(),expo2.getHeight(),  null);
            }
            if(animecounter==1) {
            	twoD.drawImage(expo1, xmotor, ymotor,expo1.getWidth(),expo1.getHeight(),  null);
            	twoD.drawImage(expo1, xenemymotor, yenemymotor,expo1.getWidth(),expo1.getHeight(),  null);
           	
            	
            }
   	 
        }
        if(time <=0)
        {
        	twoD.setFont(new Font("TimesRoman", Font.BOLD, 75));
            twoD.setColor(Color.RED); // GAME OVER when the times end or crashing
            twoD.drawString("GAME OVER!!", 200, 400);
        }
        
       
        }

        if(startflag==0) {
        	
        twoD.setFont(new Font("TimesRoman", Font.BOLD, 80));
        twoD.setColor(Color.GREEN); // countdown for starting the race
        twoD.drawString(""+number, 380, 400);
        
        }
        if(score%800==0 && startflag==1) {
        	 twoD.setFont(new Font("TimesRoman", Font.BOLD, 30));
             twoD.setColor(Color.GREEN); // after gettýng 800 each lap thýs týtle comes
             twoD.drawString("LAP COMPLETED!", 250, 400);
             
        }
        twoD.setFont(new Font("TimesRoman", Font.BOLD, 20));
        twoD.setColor(Color.GREEN); // draws the score board
        twoD.drawString("Score "+score, 650, 35);
        
        twoD.setFont(new Font("TimesRoman", Font.BOLD, 20));
        twoD.setColor(Color.GREEN); // draws the speedd
        screenspeed=500-speed*4;		//thread týme ýs opposýte wýth the speed
        twoD.drawString("Speed "+screenspeed, 95, 35);
        
        twoD.setFont(new Font("TimesRoman", Font.BOLD, 20));
        twoD.setColor(Color.WHITE); // draws the time board
        timescreen=time;
        twoD.drawString("Time "+timescreen, 250, 35);
       
       
    }
    public void rightPressed() {
  		xmotor=xmotor+5; // moves the mymotor
  
  	}

  	public void leftPressed() {
  		xmotor-=5; // moves the mymotor
  	
  	}
  	public void UpPressed() {
  		if(speed>7) {
  		speed-=5; // speeds up
  		yenemymotor+=5;		//when mymotor speedup enemy motor look lýke can keep up wýth mymotor
  		}
  	}
  	public void DownPressed() {
  		if(speed<50)
  		speed+=5; // speeds up
  		yenemymotor-=5;				//when mymotor breaks enemy motor looks lýke passýng mymotor
 
  	}
  	
	public void suspend( boolean string) {
	    suspended = string;
	    
	 }
	 
	 synchronized void resume() {
	    suspended = false;
	    notify();
	 }
	 
	public void randomMove() throws InterruptedException {	//enemy motor random move
		
		randomchoice=getRandomIntegerBetweenRange(1,2);
		randomx=getRandomIntegerBetweenRange(201,399);
		randomy=getRandomIntegerBetweenRange(0,790);
		
		if(score<400) {							//until you score 400 enemy ýs not try to crash you
			if(yenemymotor>460) {
			randomx=0;
			}								//calculatýon of not hýttýng mymotor
			if(randomy>360)
			randomy=ymotor-getRandomIntegerBetweenRange(200,500);
			
		}
	
			if(randomchoice==1) {		//random choýce 1 enemy moves on the x coordýnate
				
				if(xenemymotor<randomx) {
					for(int i=0;xenemymotor<randomx;i++)
					{
						xenemymotor+=5;
						score++;
						Thread.sleep(50);		//otherwýse ýt jumps not moves
						repaint();
					}
				}
				else if(xenemymotor>=randomx && randomx!=0) {
					for(int i=0;xenemymotor>randomx;i++)
					{
						xenemymotor-=5;
						score++;
						Thread.sleep(50);
						repaint();
					}
				}
			}
			if(randomchoice==2) {			//random choýce 2 enemy moves on the y coordýnate
				
				if(yenemymotor<randomy) {
					for(int j=0;yenemymotor<randomy;j++)
					{
						yenemymotor+=5;
						score++;
						Thread.sleep(50);
						repaint();
					}
				}
				else if(yenemymotor>=randomy) {
					for(int j=0;yenemymotor>randomy;j++)
					{
						yenemymotor-=5;
						score++;
						Thread.sleep(50);
						repaint();
					}
				}
			}
		
	}
	public static int getRandomIntegerBetweenRange(int min, int max){
	    int x = (int)(Math.random()*((max-min)+1))+min;
	    return x;
	}
	
	public static int moveflag(){
	    
	    return getRandomIntegerBetweenRange(0,10000);
	}
	
	public void Time() {		//countdown 60 seconds
		time--;
	}
	public boolean isCollision()
	{
		Rectangle r1 = new Rectangle(xmotor,ymotor,mymotor.getWidth(),mymotor.getHeight());
		Rectangle r2 = new Rectangle(xenemymotor,yenemymotor,enemymotor.getWidth(),enemymotor.getHeight());
		if(r1.intersects(r2)) {
		
		return true;
		}
		else
		{
			return false;
		}
	}
	
	

	
	  
}