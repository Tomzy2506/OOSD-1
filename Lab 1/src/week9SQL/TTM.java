package week9SQL;

import java.awt.EventQueue;
import java . sql.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java . sql .Connection;

import java . sql .DriverManager;

import java . sql .PreparedStatement;

import java . sql .SQLException;
import java.awt.Color;

public class TTM {

	private JFrame frame;
	private Customers customer;
	private Products product;
	private Invoice invoice;
	
	final String DATABASE_URL = "jdbc:mysql://localhost/customer";
	
	
	
	Connection connection = null;
	
	
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	
	DefaultTableModel model = new 	DefaultTableModel ();

	/**
	 * Launch the application.
	 */
	int i=0;
	private JButton btnCustomer;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TTM window = new TTM();
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
	public TTM() {
		initialize();
		
		connection = TTM.ConnectDB();
		
		Object col[] = {"FirstName", "LastName", "PhoneNumber", "Address", "Eircode", "Gender", "Email"};
		
		model.setColumnIdentifiers(col);
		
	}

	private static Connection ConnectDB() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 255));
		frame.setBounds(0, 0, 650, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnCustomer = new JButton("Customers");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

                Object source = event.getSource();

                if (source == customer) { 
                	
                	Insert insert = new Insert();
                
                }
			}
		});
		btnCustomer.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCustomer.setBounds(28, 173, 129, 35);
		frame.getContentPane().add(btnCustomer);
		
		JButton btnProducts = new JButton("Products");
		btnProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object source = e.getSource();

                if (source == product) { 
                	
                	Insert insert = new Insert();
                	                
                }
			}
		});
		btnProducts.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnProducts.setBounds(256, 173, 129, 35);
		frame.getContentPane().add(btnProducts);
		
		JButton btnInvoice = new JButton("Invoice");
		btnInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Customer's Database",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnInvoice.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInvoice.setBounds(469, 173, 129, 35);
		frame.getContentPane().add(btnInvoice);
		
		JLabel lblNewLabel_1 = new JLabel("Tryzar Tech Management");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(198, 0, 250, 32);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
