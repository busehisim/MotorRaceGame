import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ScoreTableFrame extends JFrame {

	JLabel username_score;
	String data;
	int positioner = 20;
	JButton backToMenu;

	public ScoreTableFrame() {

		setLayout(new BorderLayout());
		JLabel background = new JLabel(new ImageIcon(getClass().getResource("resource/menu.png")));
		add(background);
		this.setTitle("Score Table");
		this.setSize(800, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		backToMenu = new JButton("Back To Menu");
		background.add(backToMenu);

		
		ButtonHandler buttonHandler = new ButtonHandler();
		backToMenu.addActionListener(buttonHandler);

	}
	
	private class ButtonHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			Object source = event.getSource();

			if (source == backToMenu) {

				dispose();
				GameFrame frame = new GameFrame();
				frame.setSize(600, 600);
				frame.setVisible(true);

			}

		}

	}

}
