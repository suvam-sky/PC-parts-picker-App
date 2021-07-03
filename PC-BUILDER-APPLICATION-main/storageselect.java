package njk;
import java.sql.*;
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
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.Color;
public class storageselect extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	String hhl="",hsql="";
	int pjk=0;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					storageselect frame = new storageselect();
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
	public storageselect() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds( 0, 0, 1535, 825);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VIEW OR SELECT STORAGE");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblNewLabel.setBounds(470, 10, 461, 74);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("LOAD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String url="jdbc:mysql://localhost:3306/pc?autoReconnect=true&useSSL=false";
					String uname="root";
					String pword="root";
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection(url,uname,pword);
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from storage");
					table.setModel(DbUtils.resultSetToTableModel(rs));
					st.close();
					con.close();
				}
				catch(Exception p)
				{
					System.out.println(" ");
				}
			}
		});
		btnNewButton.setBounds(1130, 157, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				partselect ffbb=new partselect();
				ffbb.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 10, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(343, 188, 872, 329);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				String textF = (String) model.getValueAt(table.getSelectedRow(),0);
				hhl=textF;
				int poloy=(int) model.getValueAt(table.getSelectedRow(),3);
				pjk=poloy;
				textField.setText(textF);
			}
		});
		
		textField = new JTextField();
		textField.setBounds(823, 550, 228, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("RESET");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		btnNewButton_2.setBounds(1108, 610, 107, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("CONFIRM");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String url="jdbc:mysql://localhost:3306/pc?autoReconnect=true&useSSL=false";
					String uname="root";
					String pword="root";
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection(url,uname,pword);
					Statement st=con.createStatement();
					st.execute("insert into interit value('"+hhl+"','"+pjk+"')");
					st.close();
					con.close();
				}
				catch(Exception p)
				{
					System.out.println(" ");
				}
			}
		});
		btnNewButton_3.setBounds(1108, 555, 108, 31);
		contentPane.add(btnNewButton_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(343, 157, 96, 21);
		contentPane.add(comboBox);
		comboBox.addItem("");
		comboBox.addItem("Samsung");
		comboBox.addItem("Seagate");
		comboBox.addItem("Kingston");
		comboBox.addItem("WD");
		comboBox.addItem("Toshiba");
		
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(526, 157, 85, 21);
		contentPane.add(comboBox_1);
		comboBox_1.addItem("");
		comboBox_1.addItem("HDD");
		comboBox_1.addItem("SSD");
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(691, 157, 77, 21);
		contentPane.add(comboBox_2);
		comboBox_2.addItem("");
		comboBox_2.addItem("<1 TB");
		comboBox_2.addItem(">1 TB");
			
		JLabel lblNewLabel_1 = new JLabel("BRAND");
		lblNewLabel_1.setBounds(343, 128, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("TYPE");
		lblNewLabel_2.setBounds(531, 128, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CAPACITY");
		lblNewLabel_3.setBounds(691, 128, 77, 13);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_4 = new JButton("APPLY");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String gtt1="%"+(comboBox.getSelectedItem().toString())+"%";
				String gtt2=comboBox_1.getSelectedItem().toString()+"%";
				String gtt3=comboBox_2.getSelectedItem().toString();
				
				
				if(gtt3.equals("")==true)
				{
					hsql="select * from storage where Name like '"+gtt1+"' and Type like '"+gtt2+"' and Capacity like '%'";
				}
				else if(gtt3.equals("<1 TB")==true)
				{
					hsql="select * from storage where Name like '"+gtt1+"' and Type like '"+gtt2+"' and Capacity like '%GB%'";
				}
				else
				{
					hsql="select * from storage where Name like '"+gtt1+"' and Type like '"+gtt2+"' and Capacity like '%TB%'";
				}
				try
				{
					String url="jdbc:mysql://localhost:3306/pc?autoReconnect=true&useSSL=false";
					String uname="root";
					String pword="root";
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection(url,uname,pword);
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(hsql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					st.close();
					con.close();
				}
				catch(Exception p)
				{
					System.out.println(" ");
				}
				
				
				
			}
		});
		btnNewButton_4.setBounds(1130, 126, 85, 21);
		contentPane.add(btnNewButton_4);
	}
}
