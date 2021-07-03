package njk;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class afterloginoptions extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					afterloginoptions frame = new afterloginoptions();
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
	public afterloginoptions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1535, 825);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PC BUILDER APPLICATION");
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 32));
		lblNewLabel.setBounds(538, 23, 423, 94);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("BUILD A PC!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				partselect csa=new partselect();
				csa.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(170, 292, 318, 67);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("LOOK AT LAPTOPS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				laptopone lo=new laptopone();
				lo.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(1005, 293, 328, 67);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("LOG OUT");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
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
				
				
				
				
				
				secondlogin h800=new secondlogin();
				h800.setVisible(true);			}
		});
		btnNewButton_2.setBounds(1304, 53, 177, 40);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("LOOK AT CUSTOM BUILDS");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				custombuilds hgy=new custombuilds();
				hgy.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.setBounds(598, 609, 318, 67);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("FEEDBACK");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				feedbackpg hv=new feedbackpg();
				hv.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(1304, 689, 177, 41);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/dell-alienware-14-laptop-500x500.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(498, 115, 500, 486);
		contentPane.add(lblNewLabel_1);
	}
}
