package njk;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class partselect extends JFrame {

	private JPanel contentPane;
	int y66=0,yqx=0;String gpa="";
private JTextField textField;
private JTable table;
private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					partselect frame = new partselect();
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
	public partselect() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1535, 825);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SELECT A PART\r\n");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblNewLabel.setBounds(487, -7, 295, 84);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("VIEW OR SELECT CPU");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cpuselect cslt=new cpuselect();
				cslt.setVisible(true);
			}
		});
		btnNewButton.setBounds(497, 87, 232, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("VIEW OR SELECT GPU");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gpuselect frt=new gpuselect();
				frt.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(497, 133, 232, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("VIEW OR SELECT RAM");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ramselect fg33=new ramselect();
				fg33.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(497, 177, 232, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("VIEW OR SELECT STORAGE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				storageselect yjh=new storageselect();
				yjh.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(497, 216, 232, 29);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("VIEW OR SELECT MOTHERBOARD");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				motherboardselect mbb=new motherboardselect();
				mbb.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(497, 255, 232, 29);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("VIEW OR SELECT CASE");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caseselect cslt=new caseselect();
				cslt.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(497, 294, 232, 29);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("VIEW OR SELECT COOLER");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coolerselect coopu=new coolerselect();
				coopu.setVisible(true);
			}
		});
		btnNewButton_6.setBounds(497, 333, 232, 36);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("VIEW OR SELECT PSU");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				psuselect huu=new psuselect();
				huu.setVisible(true);
			}
		});
		btnNewButton_7.setBounds(497, 379, 232, 29);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("BACK");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afterloginoptions up=new afterloginoptions();
				up.setVisible(true);
			}
		});
		btnNewButton_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_8.setBounds(10, 10, 106, 43);
		contentPane.add(btnNewButton_8);
		
		textField = new JTextField();
		textField.setBounds(1397, 107, 114, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1168, 183, 343, 339);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				String textF = (String) model.getValueAt(table.getSelectedRow(),0);
				gpa=textF;
				textField_1.setText(textF);

			}
		});
		
		JButton btnNewButton_9 = new JButton("LOAD");
		btnNewButton_9.addActionListener(new ActionListener() {
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
					textField.setText(hn);
					yqx=Integer.parseInt(hn);
				}
				catch(Exception p)
				{
					System.out.println(" ");
				}

			}
		});
		btnNewButton_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_9.setBounds(1426, 548, 85, 29);
		contentPane.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("DELETE");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String url="jdbc:mysql://localhost:3306/pc?autoReconnect=true&useSSL=false";
					String uname="root";
					String pword="root";
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection(url,uname,pword);
					String olol="delete from interit where Name='"+(textField_1.getText())+"'";
					Statement st=con.createStatement();
					st.executeUpdate(olol);
					st.close();
					con.close();
					y66=0;
					textField_1.setText("");
				}
				catch(Exception p)
				{
					System.out.println(" ");
				}
			}
		});
		btnNewButton_10.setBounds(1426, 615, 85, 32);
		contentPane.add(btnNewButton_10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(1168, 614, 218, 36);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("SELECTED PARTS :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(1169, 149, 114, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Rs.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(1372, 117, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_11 = new JButton("BUY");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(yqx>0)
				{
					orderpage opy=new orderpage();
					opy.setVisible(true);
				}
			}
		});
		btnNewButton_11.setBounds(1426, 681, 85, 29);
		contentPane.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("VIEW OR SELECT DISPLAY");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayselect dsf=new displayselect();
				dsf.setVisible(true);
			}
		});
		btnNewButton_12.setBounds(497, 425, 232, 29);
		contentPane.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("VIEW OR SELECT KEYBOARD");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				keyboardselect ksr=new keyboardselect();
				ksr.setVisible(true);
			}
		});
		btnNewButton_13.setBounds(497, 464, 232, 36);
		contentPane.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("VIEW OR SELECT MOUSE");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mouseselect msj=new mouseselect();
				msj.setVisible(true);
			}
		});
		btnNewButton_14.setBounds(497, 510, 232, 29);
		contentPane.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("VIEW OR SELECT HEADPHONE");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				headphoneselect hqa=new headphoneselect();
				hqa.setVisible(true);
			}
		});
		btnNewButton_15.setBounds(497, 549, 232, 29);
		contentPane.add(btnNewButton_15);
	}
}
