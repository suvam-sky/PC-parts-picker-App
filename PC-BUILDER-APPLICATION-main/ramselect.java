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
public class ramselect extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	String hhl="";
	int pjk=0;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ramselect frame = new ramselect();
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
	public ramselect() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1535, 825);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VIEW OR SELECT RAM");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblNewLabel.setBounds(486, 10, 389, 74);
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
					ResultSet rs=st.executeQuery("select * from ram");
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
		btnNewButton.setBounds(1167, 150, 85, 21);
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
		scrollPane.setBounds(446, 181, 806, 329);
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
		textField.setBounds(808, 573, 228, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("RESET");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		btnNewButton_2.setBounds(1144, 632, 108, 21);
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
		btnNewButton_3.setBounds(1144, 580, 108, 27);
		contentPane.add(btnNewButton_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(445, 131, 85, 27);
		contentPane.add(comboBox);
		comboBox.addItem("");
		comboBox.addItem("ADATA");
		comboBox.addItem("HyperX");
		comboBox.addItem("Corsair");
		
		JLabel lblNewLabel_1 = new JLabel("BRAND");
		lblNewLabel_1.setBounds(446, 98, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(620, 131, 85, 27);
		contentPane.add(comboBox_1);
		comboBox_1.addItem("");
		comboBox_1.addItem("2400 MHz");
		comboBox_1.addItem("2666 MHz");
		comboBox_1.addItem("3000 MHz");
		comboBox_1.addItem("3200 MHz");
		
		JLabel lblNewLabel_2 = new JLabel("FREQUENCY");
		lblNewLabel_2.setBounds(620, 98, 78, 13);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_4 = new JButton("APPLY");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String gtt1="%"+(comboBox.getSelectedItem().toString())+"%";
				String gtt2=comboBox_1.getSelectedItem().toString()+"%";
				String hsql="select * from ram where Name like '"+gtt1+"' and Frequency like '"+gtt2+"'";
				
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
		btnNewButton_4.setBounds(1167, 119, 85, 21);
		contentPane.add(btnNewButton_4);
	}
}
