package njk;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.Color;

public class laptopone extends JFrame {

	private JPanel contentPane;
	private JTable table;
	String gtt6="",hsql="";int prv7=0,lut=0;
private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					laptopone frame = new laptopone();
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
	public laptopone() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1535, 825);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(144, 238, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(308, 170, 80, 37);
		contentPane.add(comboBox);
		comboBox.addItem("");
		comboBox.addItem("Dell");
		comboBox.addItem("Asus");
		comboBox.addItem("Apple");
		comboBox.addItem("Lenovo");
		comboBox.addItem("HP");
		comboBox.addItem("Acer");
		comboBox.addItem("MSI");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(308, 217, 847, 351);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(445, 170, 80, 37);
		contentPane.add(comboBox_1);
		comboBox_1.addItem("");
		comboBox_1.addItem("Business");
		comboBox_1.addItem("Gaming");
		comboBox_1.addItem("Ultrabook");
		comboBox_1.addItem("Home and Office");
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(564, 170, 80, 37);
		contentPane.add(comboBox_2);
		comboBox_2.addItem("");
		comboBox_2.addItem("4 GB");
		comboBox_2.addItem("8 GB");
		comboBox_2.addItem("16 GB");
		
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(691, 170, 80, 37);
		contentPane.add(comboBox_3);
		comboBox_3.addItem("");
		comboBox_3.addItem("Intel");
		comboBox_3.addItem("AMD");
		
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(808, 170, 80, 37);
		contentPane.add(comboBox_4);
		comboBox_4.addItem("");
		comboBox_4.addItem("NVIDIA");
		comboBox_4.addItem("AMD");
		comboBox_4.addItem("Intel");
		
		
		
		
		JLabel lblNewLabel = new JLabel("BRAND");
		lblNewLabel.setBounds(308, 142, 87, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CATEGORY");
		lblNewLabel_1.setBounds(445, 139, 80, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("RAM");
		lblNewLabel_2.setBounds(564, 142, 87, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("PROCESSOR");
		lblNewLabel_4.setBounds(691, 147, 80, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("GPU");
		lblNewLabel_5.setBounds(808, 147, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("PRICE < ");
		lblNewLabel_6.setBounds(920, 147, 63, 13);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("APPLY");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lut=0;
				String gtt1=(comboBox.getSelectedItem().toString())+"%";
				String gtt2=(comboBox_1.getSelectedItem().toString())+"%";
				String gtt3=(comboBox_2.getSelectedItem().toString())+"%";
				String gtt4=(comboBox_3.getSelectedItem().toString())+"%";
				String gtt5=(comboBox_4.getSelectedItem().toString())+"%";
				
				if(((textField.getText()).length())==0)
				{
					lut=1000000;
				}
				else
				{
					lut=Integer.parseInt(textField.getText());
				}
				
				
				hsql="select * from laptop where Name like '"+gtt1+"' and Category like '"+gtt2+"' and RAM like '"+gtt3+"' and Processor like '"+gtt4+"' and Graphics like '"+gtt5+"' and Price < '"+lut+"' ";
				
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
		btnNewButton.setBounds(1035, 170, 120, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afterloginoptions bpu=new afterloginoptions();
				bpu.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(22, 23, 120, 37);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("LAPTOPS");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblNewLabel_3.setBounds(583, 23, 168, 55);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(918, 170, 96, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/iconfinder_laptop-with-code_4417093.png")).getImage();
		lblNewLabel_7.setIcon(new ImageIcon(img));
		lblNewLabel_7.setBounds(10, 258, 259, 256);
		contentPane.add(lblNewLabel_7);
		
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
