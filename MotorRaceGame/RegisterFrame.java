import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.print.DocFlavor.URL;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;



public class RegisterFrame extends JFrame{
	
	private String data;
	private String user_name;
	private String pass_word;
	private JButton Register;
	private JButton cancel;
	JLabel passwordLabel;
	JLabel usernameLabel;
	JTextField usernameTextField;
	JTextField passwordTextField;
	

	
	
	
	
	
	public RegisterFrame() {
		
			super("Register");
			setLayout(new BorderLayout());
			super.setSize(400,400);
			
			
			JLabel background = new JLabel();
			add(background);
			background.setLayout(null);
			
			Register = new JButton("Register");
			cancel = new JButton("Cancel");
			
			usernameLabel = new JLabel("Username: ");
			passwordLabel = new JLabel("Password: ");
			
			usernameLabel.setFont(new Font("Times Roman", Font.BOLD,16));
			usernameLabel.setForeground(Color.BLACK);
			
			passwordLabel.setFont(new Font("Times Roman", Font.BOLD,16));
			passwordLabel.setForeground(Color.BLACK);
			
			background.add(usernameLabel, BorderLayout.NORTH); //label
			background.add(passwordLabel, BorderLayout.CENTER); //label
			
			
			usernameTextField = new JTextField(15);
	        background.add(usernameTextField, BorderLayout.NORTH);
	        
	        
	        passwordTextField = new JTextField(15);
			background.add(passwordTextField, BorderLayout.CENTER);
			
			
			Register.setBounds(100, 300, 90, 30);
			cancel.setBounds(210, 300, 80, 30);
			background.add(Register);
			background.add(cancel);
			
		
			usernameLabel.setBounds(80, 30, 200, 30);
			passwordLabel.setBounds(80, 90, 200, 30);
			usernameTextField.setBounds(200, 30, 150, 30);
			passwordTextField.setBounds(200, 90, 150, 30);
			//register.setBounds(150, 160, 100, 30);
			 
			
			
			
			ButtonHandler buttonHandler = new ButtonHandler();
			Register.addActionListener((ActionListener) buttonHandler);
			cancel.addActionListener(buttonHandler);
	}
	
	private class ButtonHandler implements ActionListener{
		
		
		public void actionPerformed(ActionEvent event) {
			
			Object source = event.getSource();
			
			if(cancel == source) {
				
				dispose();
				GameFrame frame = new GameFrame();
				frame.setSize(800,800);
				frame.setVisible(true);
				
			}
			else if (Register == source) {
				
				pass_word = passwordTextField.getText(); //gets the user name info
				user_name = usernameTextField.getText(); //gets the password info
				data = user_name + pass_word; // merges the user data
				
	
				FileOperation.writeFile(data); //writes to a file
				
				JOptionPane.showMessageDialog(null,"Data Saved","Informantion",JOptionPane.PLAIN_MESSAGE);
				dispose();
				GameFrame frame = new GameFrame();
				frame.setSize(800,800);
				frame.setVisible(true);
				
				
				
			}
			
			
		}
		
	}
	

}
