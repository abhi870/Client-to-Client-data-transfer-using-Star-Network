import SendFile1.*;
import ReceiveFile1.*; 
import audioplay.*;
import audioip.*;
import playAudiopkg.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.awt.SystemColor;

public class ClientGui extends JFrame {
	DefaultListModel m1,m2;
	static String name="";
	static Socket s;
	static String st  = "",str="";
	JButton btnNewButton;
	JTextArea txtrTx;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	int flag = 0;
	public ClientGui(String name) throws IOException {
		
		
		getContentPane().setLayout(null);
		JTextArea mess = new JTextArea();
		mess.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		mess.setEditable(false);
		mess.setForeground(Color.BLUE);
		this.name = name;
		JScrollPane scrollPane = new JScrollPane(mess);
		scrollPane.setBounds(39, 96, 412, 341);
		getContentPane().add(scrollPane);
		scrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
			
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				e.getAdjustable().setValue(e.getAdjustable().getMaximum());
			}
		});
		
		btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		Image img = new ImageIcon(this.getClass().getResource("msg.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		//btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBounds(444, 472, 65, 42);
		getContentPane().add(btnNewButton);
		
		txtrTx = new JTextArea();
		txtrTx.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtrTx.setBounds(58, 462, 369, 56);
		getContentPane().add(txtrTx);
		
		getContentPane().setBackground(new Color(51, 204, 153));
		
		JLabel lblChatCorner = new JLabel("Chat Window");
		lblChatCorner.setForeground(new Color(139, 0, 139));
		lblChatCorner.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		lblChatCorner.setHorizontalAlignment(SwingConstants.CENTER);
		lblChatCorner.setBounds(493, 16, 250, 44);
		getContentPane().add(lblChatCorner);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));
		textField.setBounds(987, 108, 143, 32);
		getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText(name);
		textField.setEditable(false);
		
		
		JLabel lblLoggedInAs = new JLabel("Logged In As");
		lblLoggedInAs.setForeground(new Color(204, 255, 51));
		lblLoggedInAs.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoggedInAs.setFont(new Font("Lucida Calligraphy", Font.BOLD, 16));
		lblLoggedInAs.setBounds(977, 65, 155, 32);
		getContentPane().add(lblLoggedInAs);
		
		JLabel lblChatWith = new JLabel("Chat With: ");
		lblChatWith.setForeground(new Color(0, 0, 0));
		lblChatWith.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 15));
		lblChatWith.setHorizontalAlignment(SwingConstants.CENTER);
		lblChatWith.setBounds(987, 187, 155, 23);
		getContentPane().add(lblChatWith);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_1.setBounds(993, 221, 137, 32);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnStart = new JButton("Start");
		btnStart.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btnStart.setBounds(1016, 266, 89, 23);
		getContentPane().add(btnStart);
		
		textField_2 = new JTextField();
		textField_2.setBounds(618, 402, 333, 32);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSendFile = new JButton("Send");
		btnSendFile.setBackground(SystemColor.menu);
		btnSendFile.setFont(new Font("Tahoma", Font.BOLD, 12));
		Image img4 = new ImageIcon(this.getClass().getResource("filesend.png")).getImage();
		btnSendFile.setIcon(null);
		btnSendFile.setBounds(786, 457, 73, 32);
		getContentPane().add(btnSendFile);
		
		JButton btnCall = new JButton("");
		btnCall.setBackground(Color.BLACK);
		btnCall.setBounds(618, 187, 73, 56);
		Image img2 = new ImageIcon(this.getClass().getResource("mic2.png")).getImage();
		btnCall.setIcon(new ImageIcon(img2));
		getContentPane().add(btnCall);
		
		JButton btnStop = new JButton("");
		btnStop.setBackground(Color.BLACK);
		btnStop.setBounds(767, 187, 65, 56);
		Image img3 = new ImageIcon(this.getClass().getResource("stop.png")).getImage();
		btnStop.setIcon(new ImageIcon(img3));
		getContentPane().add(btnStop);
		
		JLabel lblVoice = new JLabel("Voice");
		lblVoice.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVoice.setHorizontalAlignment(SwingConstants.CENTER);
		lblVoice.setBounds(628, 254, 46, 14);
		getContentPane().add(lblVoice);
		
		JLabel lblStop = new JLabel("Stop");
		lblStop.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStop.setHorizontalAlignment(SwingConstants.CENTER);
		lblStop.setBounds(777, 254, 46, 14);
		getContentPane().add(lblStop);
		
		JLabel lblEnterFileName = new JLabel("Select File: ");
		lblEnterFileName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEnterFileName.setBounds(618, 377, 125, 14);
		getContentPane().add(lblEnterFileName);
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMessage.setBounds(450, 521, 59, 14);
		getContentPane().add(lblMessage);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser filechooser = new JFileChooser();
				filechooser.showOpenDialog(btnBrowse);
				String fpath = filechooser.getSelectedFile().getAbsolutePath();
				textField_2.setText(fpath);
				
			}
		});
		btnBrowse.setBounds(961, 407, 89, 23);
		getContentPane().add(btnBrowse);
		//setLocation(375,100);
		setTitle("Chat Window");
		setSize(1200, 650);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
			
		try
		{
			
			//System.out.println(name);

			s= new Socket("localhost",1234);
			//System.out.println(s.getPort());
			
			SendFile1 se = new SendFile1();
			se.SendMessege(s,name);
			
			
			Thread t2 = new Thread(new Runnable()
			{
				public void run()
				{
					btnStart.addActionListener(new ActionListener()
					{
						
						public void actionPerformed(ActionEvent arg0) {
														
						Scanner sc = new Scanner(textField_1.getText());
						str = sc.nextLine();
						
						se.SendMessege(s,str);
						}
					});
					
				
					btnNewButton.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent e) 
						{
						
							SendFile1 sf= new SendFile1();
							sf.SendMessege(s,"1");
							Scanner textScan = new Scanner(txtrTx.getText());
							txtrTx.setText("");
							
							if(textScan.hasNextLine())
							{
								st = textScan.nextLine();
								System.out.println(st);
								mess.append("ME : ");
								mess.append(st);
								mess.append("\n");
								
								SendFile1 se = new SendFile1();
								se.SendMessege(s,st);
								
							}		
						}
													
					});
					btnSendFile.addActionListener(new ActionListener() 
					{
				
						public void actionPerformed(ActionEvent e) 
						{
							SendFile1 sf1 = new SendFile1();
							sf1.SendMessege(s, "2");  
							Scanner f = new Scanner(textField_2.getText()); 
					
							if(f.hasNextLine())
							{
								String s1 = f.nextLine();
								System.out.println(s1);
								textField_2.setText("");
								SendFile1 se = new SendFile1();
								se.SendMessege(s, s1);
								se.SendFile(s, s1);
								
								JOptionPane.showMessageDialog(null, "File Sent Successfully");
						
							}
						}
					});
					
					btnCall.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							SendFile1 sf2= new SendFile1();
							sf2.SendMessege(s, "3");
							audT nt=new audT();
							System.out.println("talk...");
							System.out.println("hit enter to stop recording...");	
							nt.start();
							//Scanner sc=new Scanner(System.in);
							//sc.nextLine();
							btnStop.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									
									byte[] k=nt.shutdown();
									sf2.SendBytes(s, k);
								}
							});
							
							
						}
					});
			
			
					
				}
			});
			
			
			
			Thread t1=new Thread(new Runnable(){
				public void run(){
					String str1="";
					ReceiveFile1 rf = new ReceiveFile1();
					
					
						while(!str1.equals("stop"))
						{
							String st1 =  rf.ReceiveMsg(s);
							//String kk = rf.ReceiveMsg(s);
							if(st1.equals("1"))
							{
							ReceiveFile1 re = new ReceiveFile1();
							
							str1 = re.ReceiveMsg(s);
							
							AudioPlayerExample1 ape = new AudioPlayerExample1();
							ape.play("notify.wav");
							
							mess.append(str+" : ");
							mess.append(str1);
							mess.append("\n");
							
							System.out.println(str1);
													
							}
							else if (st1.equals("2"))
							{
								ReceiveFile1 re = new ReceiveFile1();
								String fname = re.ReceiveMsg(s);
								re.ReceiveFile(s, fname);
								AudioPlayerExample1 ap=new AudioPlayerExample1();
								ap.play("notify.wav");
								JOptionPane.showMessageDialog(null, "File Received Successfully"); 
							}
							
							else if (st1.equals("3"))
							{
								ReceiveFile1 re = new ReceiveFile1();
								byte[] k =re.ReceiveBytes(s);
								//AudioPlayerExample1 ap=new AudioPlayerExample1();
								//ap.play("notify.wav");
								System.out.println("playing  audio...");
								playAudio t2 = new playAudio(k);
								t2.play();
								
							}
						}
						
						
						
				}
			});
			
			
			t1.start();
			t2.start();
			//t3.start();
			//t4.start();
			try
			{
				Thread.sleep(500);
			}catch(Exception e){System.out.println(e.getMessage());}
		
		}
		catch(Exception e){System.out.println(e.getMessage());}
		
			
	}
	
		
	
	public static void main(String[] args) throws IOException{

		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				
				ClientGui cg = null;
				try {
					cg = new ClientGui(name);
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				cg.setVisible(true);
			}
			
		});
		
		
	}
}
