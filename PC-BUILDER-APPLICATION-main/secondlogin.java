package njk;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class secondlogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	String hmv="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					secondlogin frame = new secondlogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public boolean connREG() 
	{	boolean k=true;
		try {
		String url="jdbc:mysql://localhost:3306/pc?autoReconnect=true&useSSL=false";
		String uname="root";
		String pword="root";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,uname,pword);
		Statement st=con.createStatement();
		String gj1=textField.getText();
		String gj2=passwordField.getText();
		ResultSet rf=st.executeQuery("select * from reguser");
		while(rf.next())
		{
			String huy=rf.getString("Email");
			if(gj1.equals(huy)==true)
			{	String yy=rf.getString("Password");
				if(gj2.equals(yy)==true)
				{	hmv=rf.getString("Address");
					k=false;
				}
			}
		}
		st.close();
		con.close();
		}
		catch(Exception e)
		{
			System.out.println(" ");
		}
		return k;
		
	}
	
	
	public secondlogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1535, 825);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN PAGE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(586, 10, 266, 67);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("EMAIL");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(532, 139, 102, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(532, 219, 78, 19);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(684, 143, 173, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(684, 216, 173, 30);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(connREG()==false)
				{
					JOptionPane.showMessageDialog(contentPane,"Successfully LOGGED IN.");
					afterloginoptions apo=new afterloginoptions();
					apo.setVisible(true);
					
					try {
						String url="jdbc:mysql://localhost:3306/pc?autoReconnect=true&useSSL=false";
						String uname="root";
						String pword="root";
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection(url,uname,pword);
						Statement st=con.createStatement();
						st.executeUpdate("delete from useraddr");
						st.execute("insert into useraddr value('"+hmv+"')");
						st.close();
						con.close();
					}
					catch(Exception p)
					{
						System.out.println(" ");
					}
					
					
					
					//to clear CART
					
					try {
						String url="jdbc:mysql://localhost:3306/pc?autoReconnect=true&useSSL=false";
						String uname="root";
						String pword="root";
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection(url,uname,pword);
						Statement st=con.createStatement();
						st.executeUpdate("delete from interit");
						st.close();
						con.close();
					}
					catch(Exception p)
					{
						System.out.println(" ");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(contentPane,"Invalid Details.");
					secondlogin jjkk=new secondlogin();
					jjkk.setVisible(true);
				}
				
		}});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(1127, 297, 165, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(1127, 471, 165, 30);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("REGISTER");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secondregister q344=new secondregister();
				q344.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(1127, 356, 165, 30);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("REMOVE ACC.");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accdel delo=new accdel();
				delo.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(1127, 417, 165, 30);
		contentPane.add(btnNewButton_3);
		}
}

