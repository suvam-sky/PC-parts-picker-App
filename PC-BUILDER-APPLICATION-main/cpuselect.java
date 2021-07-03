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
public class cpuselect extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	String hhl="",hsql="";
	int pjk=0,lut=0;
	int lo=0;
	private JTextField textField_1;
	private JTextField textField_2;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cpuselect frame = new cpuselect();
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
	public cpuselect() {
		


		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1535, 825);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VIEW OR SELECT CPU\r\n");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblNewLabel.setBounds(516, 10, 387, 74);
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
					ResultSet rs=st.executeQuery("select * from cpu");
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
		btnNewButton.setBounds(1226, 155, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				partselect ffbb=new partselect();
				ffbb.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 10, 113, 41);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(384, 206, 927, 329);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				String textF = (String) model.getValueAt(table.getSelectedRow(),0);
				hhl=textF;
				int poloy=(int) model.getValueAt(table.getSelectedRow(),4);
				pjk=poloy;
				textField.setText(textF);
			}
		});
		
		textField = new JTextField();
		textField.setBounds(914, 606, 228, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("RESET");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		btnNewButton_2.setBounds(1203, 672, 108, 31);
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
		btnNewButton_3.setBounds(1203, 616, 108, 31);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("BRAND");
		lblNewLabel_1.setBounds(383, 133, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("No. of Cores");
		lblNewLabel_2.setBounds(575, 133, 88, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Price <");
		lblNewLabel_3.setBounds(782, 133, 72, 13);
		contentPane.add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(384, 155, 72, 21);
		contentPane.add(comboBox);
		comboBox.addItem("");
		comboBox.addItem("Intel");
		comboBox.addItem("AMD");
		
		JButton btnNewButton_4 = new JButton("APPLY");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lut=0;
				String gtt1="%"+(comboBox.getSelectedItem().toString())+"%";
				lut=((textField_1.getText()).length()==0)?1000000:Integer.parseInt(textField_1.getText());
				lo=((textField_2.getText()).length()==0)?100:Integer.parseInt(textField_2.getText());
				
				hsql="select * from cpu where Name like '"+gtt1+"' and Price<'"+lut+"' and No_ofCores<='"+lo+"'";
				
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
		btnNewButton_4.setBounds(1226, 124, 85, 21);
		contentPane.add(btnNewButton_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(782, 156, 108, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(575, 156, 113, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	}
}
