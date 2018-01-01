import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.io.*;
public class LoginWindow extends JFrame  implements ActionListener{
	
	JTextField textField;
	JButton btnLogIn;
	public LoginWindow() {
		getContentPane().setForeground(Color.RED);
		getContentPane().setLayout(null);
		//JFrame f = new JFrame();
		
		JLabel lblChatZone = new JLabel("SNAPSTER");
		lblChatZone.setForeground(Color.RED);
		lblChatZone.setHorizontalAlignment(SwingConstants.CENTER);
		lblChatZone.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 32));
		lblChatZone.setBounds(265, 40, 317, 50);
		getContentPane().add(lblChatZone);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(281, 173, 124, 34);
		getContentPane().add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(486, 175, 205, 34);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnLogIn.setBounds(428, 291, 117, 42);
		getContentPane().add(btnLogIn);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 784, 21);
		getContentPane().add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mnFile);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mnFile.add(mntmQuit);
		mntmQuit.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("icon-group-chat.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(26, 129, 227, 250);
		getContentPane().add(lblNewLabel);
		
		//this.setVisible(true);
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(375,100);
		
		btnLogIn.addActionListener(this);
		
		
	}
	public void actionPerformed(ActionEvent e) {
		
		String st = textField.getText();
		
		//System.out.println("hii");
		dispose();
		try{
			ClientGui cg = new ClientGui(st);
			cg.setVisible(true);
		}
		catch(Exception ex){};
		
		
	}
	
	public static void main(String[] args) throws IOException{
		SwingUtilities.invokeLater(new Runnable(){

			
			public void run() {
				
				LoginWindow lw =new LoginWindow();
				lw.setVisible(true);
			}
			
		});
		
	} 


	
}
