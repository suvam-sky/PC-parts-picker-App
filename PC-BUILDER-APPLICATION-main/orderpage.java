package njk;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;

public class orderpage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	int y66=0,sch=0,fpr=0,cvn=0;String u7b="";
private JTextField textField_2;
private JTextField textField_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					orderpage frame = new orderpage();
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
	public orderpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1535, 825);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PLACE YOUR ORDER");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblNewLabel.setBounds(467, 10, 360, 43);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(192, 77, 832, 411);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setBounds(192, 585, 417, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		try
		{
			String url="jdbc:mysql://localhost:3306/pc?autoReconnect=true&useSSL=false";
			String uname="root";
			String pword="root";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,pword);
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from useraddr");
			while(rs.next())
			{
				u7b=rs.getString("Address");
			}
			textField.setText(u7b);
		}
		catch(Exception p)
		{
			System.out.println(" ");
		}

		
		
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				partselect rq=new partselect();
				rq.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 10, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("PLACE ORDER");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(contentPane,"ORDER CONFIRMED. Confirmation sent to e-mail.");
				afterloginoptions apo=new afterloginoptions();
				apo.setVisible(true);
				sch=0;
				fpr=0;
				
				
				
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
		});
		btnNewButton_1.setBounds(891, 646, 133, 32);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("ADDRESS :");
		lblNewLabel_1.setBounds(192, 538, 133, 26);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("LOAD");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				y66=0;
				try
				{
					String url="jdbc:mysql://localhost:3306/pc?autoReconnect=true&useSSL=false";
					String uname="root";
					String pword="root";
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection(url,uname,pword);
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from interit");
					table.setModel(DbUtils.resultSetToTableModel(rs));
					ResultSet uq=st.executeQuery("select * from interit");
					while(uq.next())
					{
						 y66=y66+uq.getInt("Price");
					}
					st.close();
					con.close();
					String hn=Integer.toString(y66);
					textField_1.setText(hn);
					cvn=Integer.parseInt(hn);
					if(cvn<=30000)
					{
						sch=990;
					}
					else if(cvn>30000 && cvn<=60000)
					{
						sch=750;
					}
					fpr=cvn+sch;
					textField_2.setText(Integer.toString(sch));
					textField_3.setText(Integer.toString(fpr));
					sch=0;
					fpr=0;
					
				}
				catch(Exception p)
				{
					System.out.println(" ");
				}

			}
		});
		btnNewButton_2.setBounds(939, 47, 85, 21);
		contentPane.add(btnNewButton_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(878, 506, 146, 32);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("GROSS AMOUNT");
		lblNewLabel_2.setBounds(742, 504, 101, 35);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(928, 558, 96, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(878, 590, 146, 34);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Shipping Charge");
		lblNewLabel_3.setBounds(742, 549, 101, 28);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("FINAL PRICE");
		lblNewLabel_4.setBounds(742, 601, 85, 23);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/cash-on-delivery-icon-12.jpg")).getImage();
		lblNewLabel_5.setIcon(new ImageIcon(img));
		lblNewLabel_5.setBounds(1178, 134, 266, 131);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/card-icon-19.jpg")).getImage();
		lblNewLabel_6.setIcon(new ImageIcon(img1));
		lblNewLabel_6.setBounds(1203, 293, 228, 165);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/iconfinder_paytm_1220356.png")).getImage();
		lblNewLabel_7.setIcon(new ImageIcon(img2));
		lblNewLabel_7.setBounds(1203, 490, 266, 105);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("WE ACCEPT : ");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_8.setBounds(1240, 80, 162, 32);
		contentPane.add(lblNewLabel_8);
	}
}
