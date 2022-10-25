/*
 * Author: Brandon Xu
 * Date: 10/25/22
 * Description: LoginPage class - creates the main login page which handles username and 
 * 				password inputs and authenticates based on the credentials hashmap that
 * 				is passed in
 */

//imports
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;

public class LoginPage implements ActionListener{
	
	//creating instances for the objects we need 
	JFrame frame = new JFrame();
	
	//button initializations
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JButton registerButton = new JButton("Register");
	
	//text field initializations
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	
	//label initializations
	JLabel title = new JLabel("Login Page");
	JLabel userIDLabel = new JLabel("Username:");
	JLabel userPasswordLabel = new JLabel("Password:");
	JLabel messageLabel = new JLabel();
	
	//new hashmap to access
	HashMap<String, String> loginInfo;
	
	// constructor
	LoginPage(HashMap<String, String> loginInfo) {
		this.loginInfo = loginInfo;
		
		title.setBounds(150, 0, 200, 25);
		
		//label config
		userIDLabel.setBounds(50, 100, 75, 25);
		userPasswordLabel.setBounds(50, 150, 75, 25);
		
		messageLabel.setBounds(125, 250, 250, 35);
		messageLabel.setFont(new Font(null, Font.ITALIC, 25));
		
		//text fields config
		userIDField.setBounds(125, 100, 200, 25);
		userIDField.addActionListener(this);
		
		userPasswordField.setBounds(125, 150, 200, 25);
		userPasswordField.addActionListener(this);
		
		//button configs
		loginButton.setBounds(100, 200, 100, 25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		resetButton.setBounds(210, 200, 100, 25); 
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		registerButton.setBounds(155, 300, 100, 25);
		registerButton.setFocusable(false);
		registerButton.addActionListener(this);
		
		//add above components to the frame
		frame.add(title);
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(loginButton);
		frame.add(resetButton);
		frame.add(registerButton);
		
		//frame configs
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    
		//resets text fields if reset button is pressed
		if(e.getSource() == resetButton) {
			userIDField.setText("");
			userPasswordField.setText("");
			
		}
		
		//creates register page when register button is pressed
		else if(e.getSource() == registerButton) {
			//JOptionPane.showMessageDialog(frame, "register button pressed");
			RegisterPage registerpage = new RegisterPage(loginInfo);
		}
		
		//handles login checks when login is pressed OR any other action listener call (pressing enter when in text fields)
		else {
			
			String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			
				//UNAUTHENTICATED: username exists
				if(loginInfo.containsKey(userID)) {
					
					//AUTHENTICATED: password corresponds to username
					if(loginInfo.get(userID).equals(password)) {
						messageLabel.setForeground(Color.green);
						messageLabel.setText("Login successful");
						frame.dispose();
						
						//welcome page created, successful login
						WelcomePage welcomePage = new WelcomePage(userID);	
						
						//UNAUTHENTICATED: password does not correspond to username
					} else {
						messageLabel.setForeground(Color.red);
						messageLabel.setText("Wrong password");
					}
					
					//UNAUTHENTICATED: username does not exist
				} else {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Username not found");
				}
			}
	}
	
	
}
