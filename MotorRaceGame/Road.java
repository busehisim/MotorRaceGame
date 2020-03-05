import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
 
public class Road{
    private BufferedImage image;
    private BufferedImage image2;
    private BufferedImage image3;
    private BufferedImage image4;
    
 
    private int startx;
    private int starty;
    private int x;
    private int y;
    private int offroadx;
    private int offroady;
    private int offroad2x;
    private int offroad2y;
    
    public int motorx;
    int startflag=0;
  
    
 
    public Road() {
        this(200,0); 
    }
    
     public Road(int x, int y) {
    	
    	
    	offroadx = 0;
    	offroady = 0;	
    	offroad2x = 600;
        offroad2y = 0;	
    	startx = 0;
    	starty = 0;	
		this.x=x;
		this.y=y;
    	
 
        // Try to open the image file background.png
        try {
            image = ImageIO.read(new File("resource/start.png"));
            image2 = ImageIO.read(new File("resource/offroad1.png"));
            image3 = ImageIO.read(new File("resource/offroad2.png"));
            image4 = ImageIO.read(new File("resource/road4.png"));
            
            
            
        }
        catch (Exception e) { System.out.println(e); }
 
    }
 
    /**
     * Method that draws the image onto the Graphics object passed
     * @param window
     */
    public void draw(Graphics window) {
    	 
        // Draw the image onto the Graphics reference
    	 if(startflag==0) {
    		 motorx=350;
    		
        window.drawImage(image, 200, getstartY(), image.getWidth(), image.getHeight(), null);
        }
    	// window.drawImage(image5,getmotorX(), 560, image5.getWidth(), image5.getHeight(), null);
        window.drawImage(image2, getoffX(), getoffY(), image2.getWidth(), image2.getHeight(), null);
        window.drawImage(image3, getoff2X(), getoff2Y(), image3.getWidth(), image3.getHeight(), null);
        if(startflag==1) {
        
        	
        	 
        window.drawImage(image4, 200, getY(), image.getWidth(), image.getHeight(), null); 
       // window.drawImage(image5, getmotorX(), 560, image5.getWidth(), image5.getHeight(), null);
        }
        //window.draw3DRect(x, y, image.getWidth(), image.getHeight(), true);
        // Move the x position left for next time
        
      if(startflag==0)  {
        starty +=300;
       
        if ( starty >= 800 ) {
    		
        // If it has, line it back up so that its left edge is
        // lined up to the right side of the other background image
    		
    		
    		startflag=1;
    }
      }
      
      else {
        
	        this.y += 450;
	        
	        // Check to see if the image has gone off stage left
	        if (this.y >= 1 * image4.getHeight()) {
	        		
	            // If it has, line it back up so that its left edge is
	            // lined up to the right side of the other background image
	        		
	            this.y = this.y - image4.getHeight() * 2;
	        }
        
      }
        offroad2y += 25;
        offroady += 25;
        
        // Check to see if the image has gone off stage left
        if ( this.offroady  >= 1 * image2.getHeight()) {
        	
            // If it has, line it back up so that its left edge is
            // lined up to the right side of the other background image
        		
        		this.offroady = this.offroady - image2.getHeight() * 2;
        }
        if ( this.offroad2y  >= 1 * image3.getHeight()) {
    		
        // If it has, line it back up so that its left edge is
        // lined up to the right side of the other background image
    		this.offroad2y = this.offroad2y - image3.getHeight() * 2;
    		
    }
 
    }
 
    public void setX(int x) {
        this.x = x;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public int getoffX() {
        return offroadx;
    }
    public int getoffY() {
        return offroady;
    }
    
    public int getoff2X() {
        return offroad2x;
    }
    public int getoff2Y() {
        return offroad2y;
    }
    public int getstartX() {
        return startx;
    }
    public int getstartY() {
        return starty;
    }
   
    public int getImageWidth() {
        return image.getWidth();
    }
    public int getImageHeight() {
        return image.getHeight();
    }
    
 
    
 
}