package username;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.Connection;
import First_p.First_page;
import Main_P.Main_page;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class User {

	private JFrame frame;
	private JTextField txtusername;
	private JPasswordField txtpassword;
	private JFrame frmUserName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					User window = new User();
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
	public User() {
		initialize();
		connection=SqlServerConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(00, 00, 1368, 689);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblUsername.setBounds(546, 315, 146, 35);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblPassword.setBounds(546, 379, 138, 35);
		frame.getContentPane().add(lblPassword);
		
		txtusername = new JTextField();
		txtusername.setFont(new Font("Tahoma", Font.PLAIN, 28));
		txtusername.setBounds(768, 314, 188, 36);
		frame.getContentPane().add(txtusername);
		txtusername.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		   		   
				try {
					String Query="Select* from register_Form where username=? and  password=?";
		    	       PreparedStatement pst= connection.prepareStatement(Query);
		 
		    	       pst.setString(1, txtusername.getText());
		    	       pst.setString(2, txtpassword.getText());
		    	       
		    	       ResultSet rs= pst.executeQuery();
		    	       int count=0;
		    	       while(rs.next()) {
		    	    	   count=count+1;
				  }
		    	       if(count==1)
		    	       {
		    	    	   txtpassword.setText(null);
							txtusername.setText(null);
							//System.out.println(""+password);
							Main_page info = new Main_page();
							Main_page.main(null);
		    	       }
		    	       else if (count>1)
		    	       {
		    	    	   JOptionPane.showMessageDialog(null, "Duplicate Username and Password");
		    	       }
		    	       else {
		    	    	   JOptionPane.showMessageDialog(null, "Invalid Login Details","Login Error", JOptionPane.ERROR_MESSAGE);
							txtpassword.setText(null);
							txtusername.setText(null);
		    	       }
		    	       rs.close();
		    	       pst.close();
				  }catch (Exception e1)
		    	   {
		    		   JOptionPane.showMessageDialog(null, e1);
		    	   }
			}
		}
				  
	);
		btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnEnter.setBounds(537, 512, 147, 35);
		frame.getContentPane().add(btnEnter);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmUserName = new JFrame("Cancel");
				if(JOptionPane.showConfirmDialog(frmUserName, "Confirm if you want to Cancel ","Login System",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					First_page info= new First_page();
					First_page.main(null);
				}
				}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnCancel.setBounds(819, 512, 147, 35);
		frame.getContentPane().add(btnCancel);
		
		txtpassword = new JPasswordField();
		txtpassword.setFont(new Font("Tahoma", Font.PLAIN, 28));
		txtpassword.setBounds(768, 378, 188, 35);
		frame.getContentPane().add(txtpassword);
		
		JLabel lblSignin = new JLabel("Sign In !!");
		lblSignin.setFont(new Font("Tahoma", Font.BOLD, 55));
		lblSignin.setBounds(614, 42, 268, 112);
		frame.getContentPane().add(lblSignin);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/users.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 1352, 650);
		frame.getContentPane().add(lblNewLabel);
	}
}
