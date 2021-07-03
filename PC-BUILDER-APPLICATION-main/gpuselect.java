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
public class gpuselect extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	String hhl="",hsql="";
	int pjk=0,lut=0;
	private JTextField textField_1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gpuselect frame = new gpuselect();
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
	public gpuselect() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1535, 825);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VIEW OR SELECT GPU\r\n");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 31));
		lblNewLabel.setBounds(502, 10, 346, 74);
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
					ResultSet rs=st.executeQuery("select * from gpu");
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
		btnNewButton.setBounds(1206, 180, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				partselect ffbb=new partselect();
				ffbb.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 15, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(437, 224, 856, 329);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				String textF = (String) model.getValueAt(table.getSelectedRow(),0);
				hhl=textF;
				int poloy=(int) model.getValueAt(table.getSelectedRow(),2);
				pjk=poloy;
				textField.setText(textF);
			}
		});
		
		textField = new JTextField();
		textField.setBounds(921, 607, 228, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("RESET");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		btnNewButton_2.setBounds(1183, 666, 108, 31);
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
		btnNewButton_3.setBounds(1183, 612, 108, 31);
		contentPane.add(btnNewButton_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(437, 177, 101, 27);
		contentPane.add(comboBox);
		comboBox.addItem("");
		comboBox.addItem("GeForce");
		comboBox.addItem("Radeon");
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(622, 177, 85, 27);
		contentPane.add(comboBox_1);
		comboBox_1.addItem("");
		comboBox_1.addItem("2 GB");
		comboBox_1.addItem("4 GB");
		comboBox_1.addItem("6 GB");
		comboBox_1.addItem("8 GB");
		
		JButton btnNewButton_4 = new JButton("APPLY");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lut=0;
				String gtt1="%"+(comboBox.getSelectedItem().toString())+"%";
				String gtt2="%"+(comboBox_1.getSelectedItem().toString())+"%";
				
				if((textField_1.getText()).length()==0)
				{
					lut=1000000;
				}
				else
				{
					lut=Integer.parseInt(textField_1.getText());
				}
				
				hsql="select * from gpu where Name like '"+gtt1+"' and Memory like '"+gtt2+"' and Price <'"+lut+"'";
				
				
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
		btnNewButton_4.setBounds(1206, 149, 85, 21);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_1 = new JLabel("BRAND");
		lblNewLabel_1.setBounds(437, 154, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("MEMORY");
		lblNewLabel_2.setBounds(622, 154, 68, 13);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(786, 177, 108, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("PRICE <");
		lblNewLabel_3.setBounds(785, 153, 73, 13);
		contentPane.add(lblNewLabel_3);
	}
}
