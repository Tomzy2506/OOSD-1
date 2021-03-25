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

public class Invoice {

	private JFrame frame;
	private JTextField jtxtDescription;
	private JTextField jtxtUnitPrice;
	private JTextField jtxtQuantity;
	private JTextField jtxtTotalAmount;
	int InvoiceID = 6;
	
	final String DATABASE_URL = "jdbc:mysql://localhost/customer";
	
	
	
	Connection connection = null;
	
	
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	
	DefaultTableModel model = new 	DefaultTableModel ();

	/**
	 * Launch the application.
	 */
	int i=0;
	private JTextField textField;
	public void updateTable() {
		connection = Invoice.ConnectDB();
		
		if (connection!=null) {
			
		
			String con = "SELECT InvoiceID, Description, Unit_Price, Quantity, totalAmount";
	
	
	try {
		
		connection = DriverManager.getConnection(

				DATABASE_URL, "root", "" );

		
		pst = connection.prepareStatement(con);
		rs = pst.executeQuery();
		
			}
	
		catch(Exception e)
	{
				JOptionPane.showMessageDialog(null, e);
	}
		}
		}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Invoice window = new Invoice();
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
	public Invoice() {
		initialize();
		
		connection = Invoice.ConnectDB();
		
		Object col[] = {"InvoiceID", "Description", "Unit_Price", "Quantity", "totalAmount"};
		
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
		frame.getContentPane().setBackground(new Color(173, 255, 47));
		frame.setBounds(0, 0, 1450, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel description = new JLabel("Description:");
		description.setFont(new Font("Tahoma", Font.BOLD, 11));
		description.setBounds(57, 88, 113, 35);
		frame.getContentPane().add(description);
		
		jtxtDescription = new JTextField();
		jtxtDescription.setFont(new Font("Tahoma", Font.BOLD, 11));
		jtxtDescription.setBounds(253, 88, 204, 35);
		frame.getContentPane().add(jtxtDescription);
		jtxtDescription.setColumns(10);
		
		JButton btnInsert = new JButton("SUBMIT");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					
					connection = DriverManager.getConnection(

							DATABASE_URL, "root", "" );
					
				String con = "INSERT INTO Invoice (InvoiceID, Description, Unit_Price, Quantity, totalAmount) VALUES (?,?,?,?,?)";
				
				
					pst = connection.prepareStatement(con);
					
					pst. setString (1, jtxtInvoiceID.getText()) ;
					
					pst. setString (2, jtxtDescription.getText()) ;

					pst. setString (3, jtxtUnitPrice.getText()) ;

					pst. setString (4, jtxtQuantity.getText()) ;
					
					pst. setString (5, jtxtTotalAmount.getText()) ;
					
					pst.execute();
					
					rs.close();
					pst.close();
					
					i = pst.executeUpdate();

				}
				catch(Exception ev)
				{
					JOptionPane.showMessageDialog(null, "Record has successfully been added");
					
				}
			}
			
			
			
		});
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInsert.setBounds(57, 512, 129, 35);
		frame.getContentPane().add(btnInsert);
		
		JLabel unitPrice = new JLabel("Unit Price:");
		unitPrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		unitPrice.setBounds(57, 143, 113, 35);
		frame.getContentPane().add(unitPrice);
		
		jtxtUnitPrice = new JTextField();
		jtxtUnitPrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		jtxtUnitPrice.setColumns(10);
		jtxtUnitPrice.setBounds(253, 143, 204, 35);
		frame.getContentPane().add(jtxtUnitPrice);
		
		JLabel quantity = new JLabel("Quantity:");
		quantity.setFont(new Font("Tahoma", Font.BOLD, 11));
		quantity.setBounds(57, 200, 113, 35);
		frame.getContentPane().add(quantity);
		
		jtxtQuantity = new JTextField();
		jtxtQuantity.setFont(new Font("Tahoma", Font.BOLD, 11));
		jtxtQuantity.setColumns(10);
		jtxtQuantity.setBounds(253, 200, 204, 35);
		frame.getContentPane().add(jtxtQuantity);
		
		JLabel totalAmount = new JLabel("Total Amount:");
		totalAmount.setFont(new Font("Tahoma", Font.BOLD, 11));
		totalAmount.setBounds(57, 257, 113, 35);
		frame.getContentPane().add(totalAmount);
		
		jtxtTotalAmount = new JTextField();
		jtxtTotalAmount.setFont(new Font("Tahoma", Font.BOLD, 11));
		jtxtTotalAmount.setColumns(10);
		jtxtTotalAmount.setBounds(253, 257, 204, 35);
		frame.getContentPane().add(jtxtTotalAmount);
		
		JButton btnReset = new JButton("CLEAR");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jtxtDescription.setText(null);
				jtxtUnitPrice.setText(null);
				jtxtQuantity.setText(null);
				jtxtTotalAmount.setText(null);
			
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReset.setBounds(237, 512, 129, 35);
		frame.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Customer's Database",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExit.setBounds(328, 586, 129, 35);
		frame.getContentPane().add(btnExit);
		
		JLabel lblNewLabel_1 = new JLabel("Invoice Records");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(207, 0, 250, 32);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try 
				{
					
					connection = DriverManager.getConnection(

							DATABASE_URL, "root", "" );
					
				String con = "UPDATE invoices SET totalAmount=? Where InvoiceID= 3";
				
				
					pst = connection.prepareStatement(con);
					
					pst. setString (1, jtxtDescription.getText()) ;

					pst. setString (2, jtxtUnitPrice.getText()) ;

					pst. setString (3, jtxtQuantity.getText()) ;
					
					pst. setString (4, jtxtTotalAmount.getText()) ;
					pst.execute();
					
					rs.close();
					pst.close();
					
					i = pst.executeUpdate();

				}
				catch(Exception ev)
				{
					JOptionPane.showMessageDialog(null, "Record has successfully been updated");
					
				}
				
				
				
				
				
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdate.setBounds(146, 586, 129, 35);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDelete.setBounds(409, 512, 129, 35);
		frame.getContentPane().add(btnDelete);
		
		JLabel lblInvoiceId = new JLabel("Invoice ID:");
		lblInvoiceId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInvoiceId.setBounds(57, 42, 113, 35);
		frame.getContentPane().add(lblInvoiceId);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField.setColumns(10);
		textField.setBounds(253, 43, 204, 35);
		frame.getContentPane().add(textField);
		Connection connection = null;
		PreparedStatement pstat = null;
		int i = 0;
		
		
		try{
			
			// establish connection to database
			connection = DriverManager.getConnection(
			DATABASE_URL, "root", "password" );
			// create Statement for deleting from table
			pstat= connection.prepareStatement("DELETE FROM invoices WHERE InvoiceID =?");
			pstat.setInt(1, InvoiceID); 
			
			// Delete the data in the database
			i = pstat.executeUpdate();
			System.out.println (i + "record successfully removed in the database.");
		 }
		catch(SQLException sqlException ) {
			sqlException.printStackTrace();
		 }
		finally{
			try{
				pstat.close();
				connection.close();
			}
			catch ( Exception exception ){
				exception.printStackTrace();
			}
	}
	}
}
