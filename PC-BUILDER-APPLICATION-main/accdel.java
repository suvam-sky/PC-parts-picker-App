package njk;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class accdel extends JFrame {

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
					accdel frame = new accdel();
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
				{	hmv=rf.getString("Name");
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
	
	
	
	
	
	
	
	
	
	
	
	
	public accdel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1535, 825);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ACCOUNT DELETE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(628, 10, 217, 56);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(698, 95, 283, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter email of acc. to be deleted");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(390, 98, 234, 23);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(698, 193, 283, 34);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("Enter password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(390, 194, 143, 26);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("DELETE");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				if(connREG()==false)
				{
					JOptionPane.showMessageDialog(contentPane,"DELETED SUCCESSFUL.");
					secondlogin apo=new secondlogin();
					apo.setVisible(true);
					
					try {
						String url="jdbc:mysql://localhost:3306/pc?autoReconnect=true&useSSL=false";
						String uname="root";
						String pword="root";
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection(url,uname,pword);
						Statement st=con.createStatement();
						String lklp = "delete from reguser where Name='"+hmv+"'";
						st.executeUpdate(lklp);
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
			}
		});
		btnNewButton.setBounds(851, 334, 130, 45);
		contentPane.add(btnNewButton);
	}
}
