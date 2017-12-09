package First_p;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import regForm.Registration;
import username.User;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class First_page {

	private JFrame frame;
	private JFrame frmFirst_page;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					First_page window = new First_page();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public First_page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1368, 689);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLambtonCarPool = new JLabel("LAMBTON CAR POOL");
		lblLambtonCarPool.setForeground(new Color(255, 69, 0));
		lblLambtonCarPool.setFont(new Font("Arial Black", Font.BOLD, 60));
		lblLambtonCarPool.setBounds(318, 159, 807, 61);
		frame.getContentPane().add(lblLambtonCarPool);
		
		JButton btnNewButton = new JButton("Sing In ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				User info = new User();
				User.main(null);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(978, 511, 210, 33);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("Register Now ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration info= new Registration();
				Registration.main(null);
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button.setBounds(616, 511, 210, 33);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Exit ");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmFirst_page = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmFirst_page, "Confirm if you want to Exit ","Lambton Car Pool System",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
			}
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button_1.setBounds(229, 511, 210, 33);
		frame.getContentPane().add(button_1);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/college3.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 1362, 650);
		frame.getContentPane().add(lblNewLabel);
	}
}
