import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
 
public class Scrollroadtest extends JFrame {
	//GamePanel gamePanel = new GamePanel();
	
    public JLabel labelmotor;
    public JLabel labelmotor2;
    public int xmotor=200;
    public int ymotor=150;
    public Icon motor;
    public Icon motor2;
    public Scrollroadtest() {
        super("Scrolling Background Demo");
        setSize(800, 800);
 
     //   Scrollroad back = new Scrollroad();
     //  ((Component)back).setFocusable(true);
        ;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        motor = new ImageIcon(getClass().getResource("resource/mymotorbike.png"));
        motor2 = new ImageIcon(getClass().getResource("resource/motor.png"));
        labelmotor = new JLabel(motor); 
        labelmotor2 = new JLabel(motor2); 
        labelmotor.setBounds(xmotor, ymotor, 100, 222);
        labelmotor2.setBounds(50, 50, 100, 222);
        labelmotor.setOpaque(false);
        //this.add(labelmotor);
        //this.add(labelmotor2);
        //getContentPane().add(back);
        setVisible(true);
       // this.add(gamePanel, BorderLayout.CENTER);
        //this.add(gamePanel, BorderLayout.CENTER);
    }
 
  
 
}