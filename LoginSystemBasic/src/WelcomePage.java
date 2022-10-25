/*
 * Author: Brandon Xu
 * Date: 10/25/22
 * Description: Creates a simple page that welcomes the user by username. 
 * 				This page is purely a demonstration of a successful 
 * 				login, no further functionality or purpose is intended.
 */

//library imports
import java.awt.*;
import javax.swing.*;

public class WelcomePage {
	
		//initialization of GUI components
		JFrame frame = new JFrame();
		JLabel welcomeLabel = new JLabel();
		
		//constructor
		WelcomePage(String userID) {
			
			//welcomeLabel config
			welcomeLabel.setPreferredSize(new Dimension(150, 100));
			welcomeLabel.setFont(new Font(null, Font.PLAIN, 15));
			welcomeLabel.setText("Welcome " + userID + "!");
			welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
			welcomeLabel.setVerticalAlignment(JLabel.CENTER);
			
			//frame config
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLayout(new FlowLayout());
			frame.setSize(420, 420);
			frame.add(welcomeLabel);
			frame.setVisible(true);
		}
}
