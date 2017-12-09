package Main_P;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPanel;

import First_p.First_page;
import net.proteanit.sql.DbUtils;
import username.SqlServerConnection;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Main_page {

	private JFrame frame;
	private JFrame frmMain;
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_page window = new Main_page();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	private JTextField textsearch;
	private JTable table;
	/**
	 * Create the application.
	 */
	public Main_page() {
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
		
		JLabel lblNewLabel = new JLabel("Find Someone");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setBounds(551, 11, 370, 117);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMain = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmMain, "Confirm if you want to Exit ","Lambton Car Pool System",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					First_page info= new First_page();
					First_page.main(null);
				}
			}
		});
		btnNewButton.setBounds(624, 581, 222, 38);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblPersonYouCan = new JLabel("Persons You Can Contact");
		lblPersonYouCan.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPersonYouCan.setBounds(596, 179, 246, 38);
		frame.getContentPane().add(lblPersonYouCan);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Logo2.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(10, 11, 360, 140);
		frame.getContentPane().add(lblNewLabel_1);
		
		textsearch = new JTextField();
		textsearch.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textsearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					String selection=(String)comboBox.getSelectedItem();
					String query="select*from register_Form where "+selection+"=?";
				PreparedStatement pst=connection.prepareStatement(query);
				pst.setString(1, textsearch.getText());
				ResultSet rs=pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		textsearch.setBounds(858, 263, 190, 41);
		frame.getContentPane().add(textsearch);
		textsearch.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(231, 333, 977, 195);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		 comboBox = new JComboBox();
		 comboBox.setFont(new Font("Tahoma", Font.PLAIN, 22));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"StudentID", "FirstName", "City", "StreetName", "Course"}));
		comboBox.setBounds(389, 263, 190, 41);
		frame.getContentPane().add(comboBox);
	}
}
