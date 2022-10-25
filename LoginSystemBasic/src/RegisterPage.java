/*
 * Author: Brandon Xu
 * Date: 10/25/22
 * Description: RegisterPage - creates the registration page when the register button is pressed in LoginPage.
 * 				This page handles username and password field inputs and adds them to the user info hashmap.
 */

//imports
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;


public class RegisterPage implements ActionListener {
	HashMap <String, String> loginInfo;
	
	JFrame frame = new JFrame();

	JLabel title = new JLabel("Registration Page");
	JLabel userIDLabel = new JLabel("Username");
	JLabel passwordLabel = new JLabel("Password");
	
	JTextField userIDField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	
	JButton registerButton = new JButton("Register");
	
	
	RegisterPage(HashMap <String, String> loginInfo) {
		this.loginInfo = loginInfo;
		
		title.setBounds(150, 0, 200, 25);
		
		userIDLabel.setBounds(50, 100, 75, 25);
		passwordLabel.setBounds(50, 150, 75, 25);
		
		userIDField.setBounds(125, 100, 200, 25);
		userIDField.addActionListener(this);
		
		passwordField.setBounds(125, 150, 200, 25);
		passwordField.addActionListener(this);
		
		registerButton.setBounds(155, 300, 100, 25);
		registerButton.setFocusable(false);
		registerButton.addActionListener(this);
		
		
		frame.add(title);
		frame.add(userIDLabel);
		frame.add(userIDField);
		frame.add(passwordLabel);
		frame.add(passwordField);
		frame.add(registerButton);
		
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		
		
		frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String userID = userIDField.getText();
		String password = String.valueOf(passwordField.getPassword());
		
		loginInfo.put(userID, password);
		
		JOptionPane.showMessageDialog(frame, "You have successfully registered. Welcome " + userID + "!");
		frame.dispose();
		
	}
	
	
}
