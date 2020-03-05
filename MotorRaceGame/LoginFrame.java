import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.*;

public class LoginFrame extends JFrame {

	JLabel passwordLabel;
	JLabel usernameLabel;
	JTextField usernameTextField;
	JTextField passwordTextField;
	
	int login=0;
	

	public static String user_name;
	private String pass_word;
	private JButton Login;
	private JButton cancel;
	private String userData;
	private String fileData;

	public LoginFrame() {

		super("Login");
		setLayout(new BorderLayout());
		super.setSize(100,80);

		JLabel background = new JLabel();
		this.add(background);
		background.setLayout(null);

		Login = new JButton("Login");
		cancel = new JButton("Cancel");
		
		background.setBounds(100,30,500,300);

		usernameLabel = new JLabel("Username: ");
		passwordLabel = new JLabel("Password: ");

		usernameLabel.setFont(new Font("Times Roman", Font.BOLD, 16));
		usernameLabel.setForeground(Color.BLACK);

		passwordLabel.setFont(new Font("Times Roman", Font.BOLD, 16));
		passwordLabel.setForeground(Color.BLACK);

		background.add(usernameLabel); // label
		background.add(passwordLabel); // label

		usernameTextField = new JTextField(10);
		background.add(usernameTextField);

		passwordTextField = new JPasswordField();
		background.add(passwordTextField);

		 Login.setBounds(100, 300, 70, 30);
		 cancel.setBounds(200, 300, 80, 30);
		background.add(Login);
		background.add(cancel);
		;

		usernameLabel.setBounds(80, 30, 200, 30);
		passwordLabel.setBounds(80, 90, 200, 30);
		usernameTextField.setBounds(200, 30, 150, 30);
		passwordTextField.setBounds(200, 90, 150, 30);

		ButtonHandler buttonHandler = new ButtonHandler();
		Login.addActionListener((ActionListener) buttonHandler);
		cancel.addActionListener(buttonHandler);

	}

	private class ButtonHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			Object source = event.getSource();

			if (source == cancel) {
				dispose();
				/*GameFrame frame = new GameFrame();
				frame.setSize(800, 800);
				frame.setVisible(true);*/
			} else if (source == Login) {

				user_name = usernameTextField.getText(); //gets the user's user name info
				pass_word = passwordTextField.getText(); //gets the user's password info
				userData = user_name + pass_word; //merges the userData

				
					try {
						fileData = FileOperation.readFile(); //reads the file
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(fileData);
					
					if(fileData.toLowerCase().contains(userData.toLowerCase())) { //checks if the userData is a subString of the FileData
						JOptionPane.showMessageDialog(null,"Login Succesfull","Informantion",JOptionPane.PLAIN_MESSAGE);
						login=1;
						dispose();
						/*GameFrame frame = new GameFrame();
						frame.setSize(800,800);
						frame.setVisible(true);*/
					}
					else {
						JOptionPane.showMessageDialog(null,"No User Found","Informantion",JOptionPane.PLAIN_MESSAGE);
					}

				

			}

		}

	}

}
