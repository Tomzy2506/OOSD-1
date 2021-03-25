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

public class Customers {

	private JFrame frame;
	private JTextField jtxtFirstname;
	private JTable table;
	private JTextField jtxtLastname;
	private JTextField jtxtPhoneNumber;
	private JTextField jtxtAddress;
	private JTextField jtxtEircode;
	private JTextField jtxtGender;
	private JTextField jtxtEmail;
	private JTextField jtxtCustomerID;
	private JLabel gender;
	private JLabel customerID;
	private JLabel firstname;
	private JLabel lastname;
	private JLabel username;
	private JLabel address;
	private JLabel phoneNum;
	private JLabel eircode;
	private JLabel email;
	
	final String DATABASE_URL = "jdbc:mysql://localhost/customer";
	
	
	
	Connection connection = null;
	
	
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	
	DefaultTableModel model = new 	DefaultTableModel ();

	/**
	 * Launch the application.
	 */
	int i=0;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customers window = new Customers();
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
	public Customers() {
		initialize();
		
		connection = Customers.ConnectDB();
		
		Object col[] = {"CustomerID", "FirstName", "LastName", "PhoneNumber", "Address", "Eircode", "Gender", "Email"};
		
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
		frame.setBounds(0, 0, 1450, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Customer Sign Up");
		label.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(207, 0, 250, 32);
		frame.getContentPane().add(label);
		
		customerID = new JLabel("Customer ID:");
		customerID.setFont(new Font("Tahoma", Font.BOLD, 11));
		customerID.setBounds(57, 37, 113, 35);
		frame.getContentPane().add(customerID);
		
		jtxtCustomerID = new JTextField(5);
		jtxtCustomerID.setFont(new Font("Tahoma", Font.BOLD, 11));
		jtxtCustomerID.setColumns(10);
		jtxtCustomerID.setBounds(253, 37, 204, 35);
		frame.getContentPane().add(jtxtCustomerID);
		
		firstname = new JLabel("Firstname:");
		firstname.setFont(new Font("Tahoma", Font.BOLD, 11));
		firstname.setBounds(57, 88, 113, 35);
		frame.getContentPane().add(firstname);
		
		jtxtFirstname = new JTextField(25);
		jtxtFirstname.setFont(new Font("Tahoma", Font.BOLD, 11));
		jtxtFirstname.setBounds(253, 88, 204, 35);
		frame.getContentPane().add(jtxtFirstname);
		jtxtFirstname.setColumns(10);
		
		lastname = new JLabel("Lastname:");
		lastname.setFont(new Font("Tahoma", Font.BOLD, 11));
		lastname.setBounds(57, 143, 113, 35);
		frame.getContentPane().add(lastname);
		
		jtxtLastname = new JTextField(25);
		jtxtLastname.setFont(new Font("Tahoma", Font.BOLD, 11));
		jtxtLastname.setColumns(10);
		jtxtLastname.setBounds(253, 143, 204, 35);
		frame.getContentPane().add(jtxtLastname);
		
		phoneNum = new JLabel("Phone Number:");
		phoneNum.setFont(new Font("Tahoma", Font.BOLD, 11));
		phoneNum.setBounds(57, 200, 113, 35);
		frame.getContentPane().add(phoneNum);
		
		jtxtPhoneNumber = new JTextField(11);
		jtxtPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
		jtxtPhoneNumber.setColumns(10);
		jtxtPhoneNumber.setBounds(253, 200, 204, 35);
		frame.getContentPane().add(jtxtPhoneNumber);
		
		address = new JLabel("Address");
		address.setFont(new Font("Tahoma", Font.BOLD, 11));
		address.setBounds(57, 257, 113, 35);
		frame.getContentPane().add(address);
		
		jtxtAddress = new JTextField(50);
		jtxtAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		jtxtAddress.setColumns(10);
		jtxtAddress.setBounds(253, 257, 204, 35);
		frame.getContentPane().add(jtxtAddress);
		
		eircode = new JLabel("Eircode");
		eircode.setFont(new Font("Tahoma", Font.BOLD, 11));
		eircode.setBounds(57, 317, 113, 35);
		frame.getContentPane().add(eircode);
		
		jtxtEircode = new JTextField(12);
		jtxtEircode.setFont(new Font("Tahoma", Font.BOLD, 11));
		jtxtEircode.setColumns(10);
		jtxtEircode.setBounds(253, 317, 204, 35);
		frame.getContentPane().add(jtxtEircode);
		
		JLabel email = new JLabel("Email");
		email.setFont(new Font("Tahoma", Font.BOLD, 11));
		email.setBounds(57, 430, 113, 35);
		frame.getContentPane().add(email);
		
		jtxtGender = new JTextField(6);
		jtxtGender.setFont(new Font("Tahoma", Font.BOLD, 11));
		jtxtGender.setColumns(10);
		jtxtGender.setBounds(253, 377, 204, 35);
		frame.getContentPane().add(jtxtGender);
		
		JButton btnInsert = new JButton("SUBMIT");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					
					connection = DriverManager.getConnection(

							DATABASE_URL, "root", "" );
					
				String con = "INSERT INTO customer (FirstName, LastName, PhoneNumber, Address, Eircode, Gender, Email) VALUES (?,?,?,?,?,?,?)";
				
				
					pst = connection.prepareStatement(con);
					
					pst. setString (1, jtxtFirstname.getText()) ;

					pst. setString (2, jtxtLastname.getText()) ;

					pst. setString (3, jtxtPhoneNumber.getText()) ;
					
					pst. setString (4, jtxtAddress.getText()) ;
					
					pst. setString (5, jtxtEircode.getText()) ;
					
					pst. setString (6, jtxtGender.getText()) ;
					
					pst. setString (7, jtxtEmail.getToolTipText() );
					
					pst.execute();
					
					rs.close();
					pst.close();
					
					i = pst.executeUpdate();

				}
				catch(Exception ev)
				{
					JOptionPane.showMessageDialog(null, "Record has successfully been Inserted");
					
				}
				
				
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model .addRow(new Object[] {
						
						
					jtxtFirstname.getText(),

					jtxtLastname.getText(),

					jtxtPhoneNumber.getText(),
					
					jtxtAddress.getText(),
					
					jtxtEircode.getText(),
					
					jtxtGender.getText(),
					
					jtxtEmail.getText(),
						
				});
				
				if(table.getSelectedRow()== -1) {
					if (table.getRowCount()==0) {
						JOptionPane.showMessageDialog(null, "New Customer Has been Added" , "Customer Database",
						JOptionPane.OK_OPTION);
					}
				}
			}
			
			
			
		});
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInsert.setBounds(69, 586, 129, 35);
		frame.getContentPane().add(btnInsert);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(699, 11, 661, 401);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CustomerID", "Firstname", "Lastname", "Phone Number", "Address", "Eircode", "Gender", "Email"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(95);
		table.getColumnModel().getColumn(1).setPreferredWidth(115);
		table.getColumnModel().getColumn(2).setPreferredWidth(160);
		table.getColumnModel().getColumn(3).setPreferredWidth(221);
		table.getColumnModel().getColumn(4).setPreferredWidth(270);
		table.getColumnModel().getColumn(5).setPreferredWidth(350);
		table.getColumnModel().getColumn(6).setPreferredWidth(380);
		table.getColumnModel().getColumn(7).setPreferredWidth(410);
		scrollPane.setViewportView(table);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				updateData();

		}});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdate.setBounds(69, 639, 129, 35);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jtxtFirstname.setText(null);
				jtxtLastname.setText(null);
				jtxtPhoneNumber.setText(null);
				jtxtAddress.setText(null);
				jtxtEircode.setText(null);
				jtxtGender.setText(null);
			
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnClear.setBounds(237, 586, 129, 35);
		frame.getContentPane().add(btnClear);
		
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
		btnExit.setBounds(237, 639, 129, 35);
		frame.getContentPane().add(btnExit);
			
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteData();
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDelete.setBounds(400, 639, 129, 35);
		frame.getContentPane().add(btnDelete);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("T&Cs");
		chckbxNewCheckBox.setBounds(253, 472, 113, 22);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JLabel lblAgreeToTcs = new JLabel("Agree to T&Cs");
		lblAgreeToTcs.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAgreeToTcs.setBounds(57, 466, 113, 35);
		frame.getContentPane().add(lblAgreeToTcs);
		
		gender = new JLabel("Gender");
		gender.setFont(new Font("Tahoma", Font.BOLD, 11));
		gender.setBounds(57, 377, 113, 35);
		frame.getContentPane().add(gender);
		
		jtxtEmail = new JTextField();
		jtxtEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		jtxtEmail.setColumns(10);
		jtxtEmail.setBounds(253, 430, 204, 35);
		frame.getContentPane().add(jtxtEmail);
		
			
		JButton btnRetrieve = new JButton("RETRIEVE");
		btnRetrieve.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRetrieve.setBounds(400, 586, 129, 35);
		frame.getContentPane().add(btnRetrieve);
		btnRetrieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RetrieveData();
			}
		});
	}
	
	public void updateTable() {
		connection = Customers.ConnectDB();
		
		if (connection!=null) {
			
		
			String sql = "Select CustomerID, FirstName, LastName, PhoneNumber, Address, Eircode, Gender, Email";
	
	
	try {
		
		connection = DriverManager.getConnection(

				DATABASE_URL, "root", "" );

		
		pst = connection.prepareStatement(sql);
		rs = pst.executeQuery();
		Object[] columnData = new Object[6];
		
		while(rs.next()) {
			 columnData[0] = rs.getString("CustomerID");
			 columnData[1] = rs.getString("FirstName");
			 columnData[2] = rs.getString("LastName");
			 columnData[3] = rs.getString("PhoneNumber");
			 columnData[4] = rs.getString("Address");
			 columnData[5] = rs.getString("Eircode");
			 columnData[6] = rs.getString("Gender");
			 columnData[7] = rs.getString("Email");
			 
			 model.addRow(columnData);
		}
			}
	
		catch(Exception e)
	{
				JOptionPane.showMessageDialog(null, e);
	}
		}
		}
	
	public void updateData() {

        Connection con = con();
        try {
            String sqlQuery = "UPDATE customer SET CustomerID= '"+customerID.getText()+"',FirstName ='"+ firstname.getText()+"' ,LastName='"+lastname.getText()+"', Address='"+address.getText()+"',  PhoneNumber='"+phoneNum.getText()+"',Email='"+email.getText()+"'where CustomerID='"+customerID.getText()+"'   ";
            PreparedStatement ps = con.prepareStatement(sqlQuery);

            ps.execute();

            JOptionPane.showMessageDialog(null, "Updated An Existing Customer Record!");
        } 
        catch (Exception e) {
            System.out.println("Error: " + e);
        }



    }
	
	public void deleteData() {
		  Connection con = con();
          try {
              String sqlQuery = "DELETE from customer WHERE CustomerID='"+customerID.getText()+"'  ";
              PreparedStatement ps = con.prepareStatement(sqlQuery);

              ps.execute();

              JOptionPane.showMessageDialog(null, "Deleted the Customer Record");

              ps.close();

              } 
          catch (Exception e) {
              e.printStackTrace();

          }
	}
	
	public void RetrieveData() {
            Connection con = con();
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("CustomerID");
            model.addColumn("FirstName");
            model.addColumn("LastName");
            model.addColumn("Username");
            model.addColumn("PhoneNumber");
            model.addColumn("Address");
            model.addColumn("Gender");
            model.addColumn("Email");

            try {
                String query = "select * from customer";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    model.addRow(new Object[] {
                            rs.getString("CustomerID"),
                            rs.getString("FirstName"),
                            rs.getString("LastName"),
                            rs.getString("Username"),
                            rs.getString("PhoneNumber"),
                            rs.getString("Address"),
                            rs.getString("Gender"),
                            rs.getString("Email"),

                    });
                }

                rs.close();
                st.close();
                con.close();
	}
            catch (Exception e) {
                System.out.println("Error: " + e);
            }
	}

		private Connection con() {
			// TODO Auto-generated method stub
			return null;
		}
		
	
}
