package regForm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import First_p.First_page;
import username.SqlServerConnection;
import java.sql.Connection;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Registration {

	private JFrame frame;
	private JTextField text1;
	private JTextField text2;
	private JTextField text5;
	private JTextField text6;
	private JTextField text7;
	private JTextField text8;
	private JTextField text10;
	private JTextField text9;
	private JTextField text11;
	private JTextField text12;
	private JTextField text13;
	private JTextField text3;
	private JTextField text4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	/**
	 * Create the application.
	 */
	public Registration() {
		initialize();
		connection=SqlServerConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.setBounds(27, -39, 1368, 689);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel.setBounds(519, 37, 339, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblFirst_Name = new JLabel("First Name*");
		lblFirst_Name.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFirst_Name.setBounds(371, 112, 126, 26);
		frame.getContentPane().add(lblFirst_Name);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLastName.setBounds(371, 149, 126, 26);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblSex = new JLabel("Sex");
		lblSex.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSex.setBounds(371, 186, 51, 26);
		frame.getContentPane().add(lblSex);
		
		JLabel lblStudentId = new JLabel("Student ID*");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStudentId.setBounds(758, 112, 126, 26);
		frame.getContentPane().add(lblStudentId);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhoneNumber.setBounds(758, 153, 137, 26);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCourse.setBounds(758, 190, 100, 26);
		frame.getContentPane().add(lblCourse);
		
		JLabel lblNewLabel_2 = new JLabel("Address details");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_2.setBounds(594, 283, 198, 27);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblHouseNo = new JLabel("House No.");
		lblHouseNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHouseNo.setBounds(371, 335, 137, 26);
		frame.getContentPane().add(lblHouseNo);
		
		JLabel lblCity = new JLabel("City*");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCity.setBounds(371, 382, 91, 26);
		frame.getContentPane().add(lblCity);
		
		JLabel lblStreetName = new JLabel("Street Name*");
		lblStreetName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStreetName.setBounds(758, 336, 135, 26);
		frame.getContentPane().add(lblStreetName);
		
		JLabel lblPostalCode = new JLabel("Postal Code*");
		lblPostalCode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPostalCode.setBounds(758, 385, 126, 20);
		frame.getContentPane().add(lblPostalCode);
		
		JLabel lblSetUsernameAnd = new JLabel("Set Username And Password");
		lblSetUsernameAnd.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblSetUsernameAnd.setBounds(520, 431, 347, 27);
		frame.getContentPane().add(lblSetUsernameAnd);
		
		JLabel lblUsername = new JLabel("Username*");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(373, 478, 109, 26);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password*");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(758, 486, 162, 20);
		frame.getContentPane().add(lblPassword);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="insert into register_Form (FirstName,LastName,Sex,Car,StudentId,Phone_Number,Course,House_No,Street_Name,City,Postalcode,Username,Password) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
				    PreparedStatement pst=connection.prepareStatement(query);
				    pst.setString(1,text1.getText());
				    pst.setString(2,text2.getText());
				    pst.setString(3,text3.getText());
				    pst.setString(4,text4.getText());
				    pst.setString(5,text5.getText());
				    pst.setString(6,text6.getText());
				    pst.setString(7,text7.getText());
				    pst.setString(8,text8.getText());
				    pst.setString(9,text9.getText());
				    pst.setString(10,text10.getText());
				    pst.setString(11,text11.getText());
				    pst.setString(12,text12.getText());
				    pst.setString(13,text13.getText());
				    
				   pst.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Profile Saved");
				pst.close();
				}catch (Exception e1){
					e1.printStackTrace();
				}
				{
					
				}
				First_page info= new First_page();
				First_page.main(null);
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSubmit.setBounds(620, 584, 172, 33);
		frame.getContentPane().add(btnSubmit);
		
		text1 = new JTextField();
		text1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text1.setBounds(535, 111, 126, 26);
		frame.getContentPane().add(text1);
		text1.setColumns(10);
		
		text2 = new JTextField();
		text2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text2.setBounds(535, 152, 126, 26);
		frame.getContentPane().add(text2);
		text2.setColumns(10);
		
		text5 = new JTextField();
		text5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text5.setColumns(10);
		text5.setBounds(956, 115, 127, 26);
		frame.getContentPane().add(text5);
		
		text6 = new JTextField();
		text6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text6.setColumns(10);
		text6.setBounds(956, 153, 127, 26);
		frame.getContentPane().add(text6);
		
		text7 = new JTextField();
		text7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text7.setColumns(10);
		text7.setBounds(956, 193, 127, 26);
		frame.getContentPane().add(text7);
		
		text8 = new JTextField();
		text8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text8.setColumns(10);
		text8.setBounds(535, 335, 126, 26);
		frame.getContentPane().add(text8);
		
		text10 = new JTextField();
		text10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text10.setColumns(10);
		text10.setBounds(535, 384, 126, 26);
		frame.getContentPane().add(text10);
		
		text9 = new JTextField();
		text9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text9.setColumns(10);
		text9.setBounds(956, 330, 127, 26);
		frame.getContentPane().add(text9);
		
		text11 = new JTextField();
		text11.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text11.setColumns(10);
		text11.setBounds(956, 382, 127, 26);
		frame.getContentPane().add(text11);
		
		text12 = new JTextField();
		text12.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text12.setColumns(10);
		text12.setBounds(535, 478, 126, 26);
		frame.getContentPane().add(text12);
		
		text13 = new JTextField();
		text13.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text13.setColumns(10);
		text13.setBounds(956, 478, 127, 26);
		frame.getContentPane().add(text13);
		
		JLabel lblDoYouOwn = new JLabel("Do you Own a Car?*");
		lblDoYouOwn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDoYouOwn.setBounds(505, 230, 198, 26);
		frame.getContentPane().add(lblDoYouOwn);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Logo2.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(0, 0, 378, 127);
		frame.getContentPane().add(lblNewLabel_1);
		
		text3 = new JTextField();
		text3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text3.setBounds(535, 193, 126, 26);
		frame.getContentPane().add(text3);
		text3.setColumns(10);
		
		text4 = new JTextField();
		text4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		text4.setBounds(749, 234, 109, 26);
		frame.getContentPane().add(text4);
		text4.setColumns(10);
	}
}
