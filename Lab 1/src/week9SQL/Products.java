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
import java.awt.Color;

public class Products {

	private JFrame frame;
	private JTextField jtxtDescription;
	private JTable table;
	private JTextField jtxtColor;
	private JTextField jtxtSize;
	private JTextField jtxtCostPrice;
	private JTextField jtxtQtyInStock;
	private JTextField jtxtTotalPrice;
	private JTextField jtxtStatus;
	private JLabel productID;
	private JLabel description;
	private JLabel status;
	private JLabel color;
	private JLabel costPrice;
	private JLabel qtyInStock;
	private JLabel totalPrice;
	private JLabel size;
	
	final String DATABASE_URL = "jdbc:mysql://localhost/customer";
	
	
	
	Connection connection = null;
	
	
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	
	DefaultTableModel model = new 	DefaultTableModel ();

	/**
	 * Launch the application.
	 */
	int i=0;
	private JTextField jtxtProductID;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Products window = new Products();
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
	public Products() {
		initialize();
		
		connection = Products.ConnectDB();
		
		Object col[] = {"ProductID", "Status", "Description", "Color", "Size", "costPrice", "QtyInStock", "TotalPrice"};
		
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
		frame.getContentPane().setBackground(new Color(138, 43, 226));
		frame.setBounds(0, 0, 1450, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		status = new JLabel("Status");
		status.setFont(new Font("Tahoma", Font.BOLD, 11));
		status.setBounds(57, 37, 113, 35);
		frame.getContentPane().add(status);
		
		description = new JLabel("Description:");
		description.setFont(new Font("Tahoma", Font.BOLD, 11));
		description.setBounds(57, 88, 113, 35);
		frame.getContentPane().add(description);
		
		jtxtDescription = new JTextField();
		jtxtDescription.setFont(new Font("Tahoma", Font.BOLD, 11));
		jtxtDescription.setBounds(253, 88, 204, 35);
		frame.getContentPane().add(jtxtDescription);
		jtxtDescription.setColumns(10);

		jtxtStatus = new JTextField();
		jtxtStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		jtxtStatus.setColumns(10);
		jtxtStatus.setBounds(253, 37, 204, 35);
		frame.getContentPane().add(jtxtStatus);
		
		productID = new JLabel("ProductID:");
		productID.setFont(new Font("Tahoma", Font.BOLD, 11));
		productID.setBounds(57, 430, 113, 35);
		frame.getContentPane().add(productID);
		
		jtxtProductID = new JTextField();
		jtxtProductID.setFont(new Font("Tahoma", Font.BOLD, 11));
		jtxtProductID.setColumns(10);
		jtxtProductID.setBounds(253, 430, 204, 35);
		frame.getContentPane().add(jtxtProductID);
		
		JButton btnInsert = new JButton("SUBMIT");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					
					connection = DriverManager.getConnection(

							DATABASE_URL, "root", "" );
					
				String sql = "INSERT INTO Products (ProductID, Status, Description, Color, Size, costPrice, QtyInStock, TotalPrice) VALUES (?,?,?,?,?,?,?,?)";
				
				
					pst = connection.prepareStatement(sql);
					
					pst. setString (1, jtxtProductID.getText()) ;
					
					pst. setString (2, jtxtStatus.getText()) ;
					
					pst. setString (3, jtxtDescription.getText()) ;

					pst. setString (4, jtxtColor.getText()) ;

					pst. setString (5, jtxtSize.getText()) ;
					
					pst. setString (6, jtxtCostPrice.getText()) ;
					
					pst. setString (7, jtxtQtyInStock.getText()) ;
					
					pst. setString (8, jtxtTotalPrice.getText()) ;
					
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
						
					jtxtProductID.getText(),
					
					jtxtStatus.getText(),
					
					jtxtDescription.getText(),

					jtxtColor.getText(),

					jtxtSize.getText(),
					
					jtxtCostPrice.getText(),
					
					jtxtQtyInStock.getText(),
					
					jtxtTotalPrice.getText(),
						
				});
				
				if(table.getSelectedRow()== -1) {
					if (table.getRowCount()==0) {
						JOptionPane.showMessageDialog(null, "Product has been registered" , "Customer Database",
						JOptionPane.OK_OPTION);
					}
				}
			}
			
			
			
		});
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInsert.setBounds(57, 512, 129, 35);
		frame.getContentPane().add(btnInsert);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(633, 11, 493, 401);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ProductID", "Status", "Description", "Color", "Size", "costPrice", "QtyInStock", "TotalPrice"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(103);
		table.getColumnModel().getColumn(1).setPreferredWidth(105);
		table.getColumnModel().getColumn(2).setPreferredWidth(191);
		table.getColumnModel().getColumn(3).setPreferredWidth(221);
		table.getColumnModel().getColumn(4).setPreferredWidth(270);
		scrollPane.setViewportView(table);
		
		color = new JLabel("Color:");
		color.setFont(new Font("Tahoma", Font.BOLD, 11));
		color.setBounds(57, 143, 113, 35);
		frame.getContentPane().add(color);
		
		jtxtColor = new JTextField();
		jtxtColor.setFont(new Font("Tahoma", Font.BOLD, 11));
		jtxtColor.setColumns(10);
		jtxtColor.setBounds(253, 143, 204, 35);
		frame.getContentPane().add(jtxtColor);
		
		size = new JLabel("Size:");
		size.setFont(new Font("Tahoma", Font.BOLD, 11));
		size.setBounds(57, 200, 113, 35);
		frame.getContentPane().add(size);
		
		jtxtSize = new JTextField();
		jtxtSize.setFont(new Font("Tahoma", Font.BOLD, 11));
		jtxtSize.setColumns(10);
		jtxtSize.setBounds(253, 200, 204, 35);
		frame.getContentPane().add(jtxtSize);
		
		costPrice = new JLabel("Cost Price:");
		costPrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		costPrice.setBounds(57, 257, 95, 35);
		frame.getContentPane().add(costPrice);
		
		jtxtCostPrice = new JTextField();
		jtxtCostPrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		jtxtCostPrice.setColumns(10);
		jtxtCostPrice.setBounds(253, 257, 204, 35);
		frame.getContentPane().add(jtxtCostPrice);
		
		qtyInStock = new JLabel("QtyInStock:");
		qtyInStock.setFont(new Font("Tahoma", Font.BOLD, 11));
		qtyInStock.setBounds(57, 317, 113, 35);
		frame.getContentPane().add(qtyInStock);
		
		jtxtQtyInStock = new JTextField();
		jtxtQtyInStock.setFont(new Font("Tahoma", Font.BOLD, 11));
		jtxtQtyInStock.setColumns(10);
		jtxtQtyInStock.setBounds(253, 317, 204, 35);
		frame.getContentPane().add(jtxtQtyInStock);
		
		totalPrice = new JLabel("TotalPrice:");
		totalPrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		totalPrice.setBounds(57, 377, 113, 35);
		frame.getContentPane().add(totalPrice);
		
		jtxtTotalPrice = new JTextField();
		jtxtTotalPrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		jtxtTotalPrice.setColumns(10);
		jtxtTotalPrice.setBounds(253, 377, 204, 35);
		frame.getContentPane().add(jtxtTotalPrice);
		
		JButton btnReset = new JButton("CLEAR");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jtxtDescription.setText(null);
				jtxtColor.setText(null);
				jtxtSize.setText(null);
				jtxtCostPrice.setText(null);
				jtxtQtyInStock.setText(null);
				jtxtTotalPrice.setText(null);
			
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReset.setBounds(237, 512, 129, 35);
		frame.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frame, "Confirm to exit", "Customer's Database",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExit.setBounds(253, 586, 129, 35);
		frame.getContentPane().add(btnExit);
		
		JLabel lblNewLabel_1 = new JLabel("Product Register");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(207, 0, 250, 32);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateData();
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdate.setBounds(68, 586, 129, 35);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				deleteData();
			}
		});
		
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDelete.setBounds(409, 512, 129, 35);
		frame.getContentPane().add(btnDelete);
		
		JButton btnRetrieve = new JButton("RETRIEVE");
		btnRetrieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RetrieveData();
			}
		});
		btnRetrieve.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRetrieve.setBounds(489, 586, 129, 35);
		frame.getContentPane().add(btnRetrieve);
		
	}
	public void updateTable() {
		connection = Products.ConnectDB();
		
		if (connection!=null) {
			
		
			String sql = "SELECT ProductID, Status, Description, Color, Size, costPrice, QtyInStock, TotalPrice";
	
	
	try {
		
		connection = DriverManager.getConnection(

				DATABASE_URL, "root", "" );

		
		pst = connection.prepareStatement(sql);
		rs = pst.executeQuery();
		Object[] columnData = new Object[6];
		
		while(rs.next()) {
			 columnData[1] = rs.getInt("ProductID");
			 columnData[1] = rs.getString("Status");
			 columnData[2] = rs.getString("Description");
			 columnData[3] = rs.getString("Color");
			 columnData[4] = rs.getString("Size");
			 columnData[5] = rs.getInt("costPrice");
			 columnData[6] = rs.getInt("QtyInStock");
			 columnData[7] = rs.getInt("TotalPrice");
			 
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
            String sqlQuery = "UPDATE Product SET ProductID= '"+productID.getText()+"',Status ='"+ status.getText()+"' ,Description='"+description.getText()+"', Color='"+color.getText()+"',  Size='"+size.getText()+"',costPrice='"+costPrice.getText()+"',  QtyInStock='"+qtyInStock.getText()+"',  totalPrice='"+totalPrice.getText()+"'where ProductID='"+productID.getText()+"'   ";
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
              String sqlQuery = "DELETE from product WHERE ProductID='"+productID.getText()+"'  ";
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
            model.addColumn("ProductID");
            model.addColumn("Status");
            model.addColumn("Description");
            model.addColumn("Color");
            model.addColumn("costPrice");
            model.addColumn("QtyInStock");
            model.addColumn("totalPrice");

            try {
                String query = "select * from customer";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    model.addRow(new Object[] {
                            rs.getInt("ProductID"),
                            rs.getString("Status"),
                            rs.getString("Description"),
                            rs.getString("Color"),
                            rs.getString("costPrice"),
                            rs.getString("QtyInStock"),
                            rs.getString("totalPrice"),

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
