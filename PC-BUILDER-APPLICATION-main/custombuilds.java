package njk;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class custombuilds extends JFrame {
	int pjk=0;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					custombuilds frame = new custombuilds();
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
	public custombuilds() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1535, 825);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 160, 122));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea("CPU - Ryzen 5 3600                                   16550\n"
										 + "GPU - Nvidia 1650EX                                  15150\n"
										 + "Motherboard - ASUS A320M-X                      8490\n"
										 + "RAM - Corasair Vengeance LPX 19200        2800\n"
										 + "Storage - Kingston A400 SSD (240 GB)x 2  5476\n"
										 + "Cabinet - Cooler Master Q300L (mini)        10789\n"
										 + "                                              \n"
										 + "________________________________________________\n"
										 + "                    TOTAL ---                               59255 \n"
										 + "                 SHIPPING  --                               1000 \n"
										 + "_________________________________________________\n"
										 + "              FINAL PRICE ---                           60255"); 		
		textArea.setBounds(214, 189, 254, 390);
		contentPane.add(textArea);
		
		
		JTextArea textArea_1 = new JTextArea("CPU - Intel i5-10400                                  18490\n"
				 							+ "GPU - Nvidia RTX 2060 Super                  34510\n"
				 							+ "Motherboard - ASUS B450F                      17399\n"
				 							+ "RAM - Corasair Vengeance LPX C16         5395\n"
				 							+ "Storage - Samsung QVO 860 1TB SSD    9999\n"
				 							+ "Cabinet - Corsair 275R (mid)                    16047\n"
				 							+ "                                              \n"
				 							+ "________________________________________________\n"
				 							+ "                    TOTAL ---                            101840 \n"
				 							+ "                 SHIPPING  --                              1000 \n"
				 							+ "_________________________________________________\n"
				 							+ "              FINAL PRICE ---                       102840"); 	
		textArea_1.setBounds(659, 189, 249, 390);
		contentPane.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea("CPU - Intel i7-9700                                      30000\n"
					+ "GPU - Nvidia RTX 2080 Super                    69199\n"
					+ "Motherboard - ASUS B450F                        17399\n"
					+ "RAM - Corasair Vengeance LPX C16x2     10790\n"
					+ "Storage - Samsung QVO 860 1TB SSDx2 20000\n"
					+ "Cabinet - Lian-Li PC-O11 (full)                    23133\n"
					+ "                                              \n"
					+ "________________________________________________\n"
					+ "                    TOTAL ---                               170521 \n"
					+ "                 SHIPPING  --                                       0 \n"
					+ "_________________________________________________\n"
					+ "              FINAL PRICE ---                          170521");
		textArea_2.setBounds(1099, 189, 254, 390);
		contentPane.add(textArea_2);
		
		JLabel lblNewLabel = new JLabel("CUSTOM BUILDS");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblNewLabel.setBounds(635, 38, 291, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("AURA");
		lblNewLabel_1.setBounds(314, 146, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("BREACH\r\n");
		lblNewLabel_2.setBounds(759, 146, 66, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("TURBOTRIX");
		lblNewLabel_3.setBounds(1188, 146, 81, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("(ENTRY LEVEL GAMING)");
		lblNewLabel_4.setBounds(270, 166, 183, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("(GAMING+STREAMING)");
		lblNewLabel_5.setBounds(722, 166, 148, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("(HEAVY GAMING)");
		lblNewLabel_6.setBounds(1179, 166, 148, 13);
		contentPane.add(lblNewLabel_6);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(214, 668, 139, 21);
		contentPane.add(comboBox);
		comboBox.addItem("");
		comboBox.addItem("AURA");
		comboBox.addItem("BREACH");
		comboBox.addItem("TURBOTRIX");
		
		JLabel lblNewLabel_7 = new JLabel("SELECT :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(112, 656, 81, 36);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("CONFIRM");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String hhl=comboBox.getSelectedItem().toString();
				
				try
				{
					String url="jdbc:mysql://localhost:3306/pc?autoReconnect=true&useSSL=false";
					String uname="root";
					String pword="root";
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection(url,uname,pword);
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from custombuilds");
					while(rs.next()) 
					{
						String xxp=rs.getString("Name");
						if(hhl.equals(xxp)==true)
						{
							pjk=rs.getInt("Price");
						}
					}
					st.close();
					con.close();
				}
				catch(Exception p)
				{
					System.out.println(" ");
				}
				
			    if(hhl!="")				
				
			    	{try
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
				
				
			}
		});
		btnNewButton.setBounds(426, 668, 117, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afterloginoptions kkoo=new afterloginoptions();
				kkoo.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 14, 85, 21);
		contentPane.add(btnNewButton_1);
	}
}
