	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ItemEvent;
	import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
	


	public class BookTicket {
		

		private JFrame frmBookTicket;
		private JTextField adults;
		private JTextField childs;
		private JTextField price;
		private JTextField amount;
		private JTextField date;
		private JTable table;
		DefaultTableModel model;
		private JTextField number;
		JComboBox first, from,to;
		Connection con;
		PreparedStatement st;
		ResultSet rs;
		
			
		public BookTicket() {
			frmBookTicket = new JFrame();
			frmBookTicket.setTitle("Book Ticket");
			frmBookTicket.setBounds(100, 100, 1159, 710);
			frmBookTicket.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frmBookTicket.getContentPane().setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(176, 196, 222));
			panel.setBounds(10, 10, 1145, 673);
			frmBookTicket.getContentPane().add(panel);
			panel.setLayout(null);
			
			
			
			JLabel lblFrom = new JLabel("From");
			lblFrom.setBounds(50, 100, 45, 13);
			lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel.add(lblFrom);
			
			JLabel lblNewLabel = new JLabel("To");
			lblNewLabel.setBounds(50, 150, 45, 13);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Date");
			lblNewLabel_1.setBounds(50, 200, 45, 13);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("No.of Adults");
			lblNewLabel_2.setBounds(50, 250, 92, 13);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("No.of Childs");
			lblNewLabel_3.setBounds(50, 300, 92, 13);
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("Class");
			lblNewLabel_4.setBounds(50, 350, 45, 13);
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel.add(lblNewLabel_4);
			
			JLabel lblNewLabel_5 = new JLabel("Price");
			lblNewLabel_5.setBounds(50, 400, 45, 13);
			lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel.add(lblNewLabel_5);
			
			JLabel lblNewLabel_6 = new JLabel("Total Amount");
			lblNewLabel_6.setBounds(50, 450, 92, 13);
			lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel.add(lblNewLabel_6);
			
			adults = new JTextField();
			adults.setFont(new Font("Tahoma", Font.PLAIN, 14));
			adults.setBounds(223, 248, 111, 19);
			panel.add(adults);
			adults.setColumns(10);
			
			childs = new JTextField();
			childs.setFont(new Font("Tahoma", Font.PLAIN, 14));
			childs.setBounds(223, 298, 111, 19);
			panel.add(childs);
			childs.setColumns(10);
			
			price = new JTextField();
			price.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(first.getSelectedIndex()==0) {
						if(from.getSelectedIndex()==0 && to.getSelectedIndex()==1)
						{ 
							price.setText("100");
						}
						else if(from.getSelectedIndex()==0 && to.getSelectedIndex()==2)
						{
							price.setText("500");
						}
						else if(from.getSelectedIndex()==0 && to.getSelectedIndex()==3)
						{
							price.setText("300");
						}
						else if(from.getSelectedIndex()==1 && to.getSelectedIndex()==0)
						{
							price.setText("100");
						}
						else if(from.getSelectedIndex()==1 && to.getSelectedIndex()==2)
						{
							price.setText("400");
						}
						else if(from.getSelectedIndex()==1 && to.getSelectedIndex()==3)
						{
							price.setText("200");
						}
						else if(from.getSelectedIndex()==2 && to.getSelectedIndex()==0)
						{
							price.setText("500");
						}
						else if(from.getSelectedIndex()==2 && to.getSelectedIndex()==1)
						{
							price.setText("400");
						}
						else if(from.getSelectedIndex()==2 && to.getSelectedIndex()==3)
						{
							price.setText("600");
						}
						else if(from.getSelectedIndex()==3 && to.getSelectedIndex()==0)
						{
							price.setText("300");
						}
						else if(from.getSelectedIndex()==3 && to.getSelectedIndex()==1)
						{
							price.setText("200");
						}
						else if(from.getSelectedIndex()==0 && to.getSelectedIndex()==0)
						{
							price.setText("0");
							JOptionPane.showMessageDialog(null, "Sorry You cannot book ticket for this");
						}
						else if(from.getSelectedIndex()==1 && to.getSelectedIndex()==1)
						{
							price.setText("0");
							JOptionPane.showMessageDialog(null, "Sorry You cannot book ticket for this");

						}
						else if(from.getSelectedIndex()==2 && to.getSelectedIndex()==2)
						{
							price.setText("0");
							JOptionPane.showMessageDialog(null, "Sorry You cannot book ticket for this");

						}
						else if(from.getSelectedIndex()==3 && to.getSelectedIndex()==3)
						{
							price.setText("0");
							JOptionPane.showMessageDialog(null, "Sorry You cannot book ticket for this");

						}}
						else {
							if(from.getSelectedIndex()==0 && to.getSelectedIndex()==1)
							{ 
								price.setText("200");
							}
							else if(from.getSelectedIndex()==0 && to.getSelectedIndex()==2)
							{
								price.setText("1000");
							}
							else if(from.getSelectedIndex()==0 && to.getSelectedIndex()==3)
							{
								price.setText("600");
							}
							else if(from.getSelectedIndex()==1 && to.getSelectedIndex()==0)
							{
								price.setText("200");
							}
							else if(from.getSelectedIndex()==1 && to.getSelectedIndex()==2)
							{
								price.setText("800");
							}
							else if(from.getSelectedIndex()==1 && to.getSelectedIndex()==3)
							{
								price.setText("400");
							}
							else if(from.getSelectedIndex()==2 && to.getSelectedIndex()==0)
							{
								price.setText("1000");
							}
							else if(from.getSelectedIndex()==2 && to.getSelectedIndex()==1)
							{
								price.setText("800");
							}
							else if(from.getSelectedIndex()==2 && to.getSelectedIndex()==3)
							{
								price.setText("1200");
							}
							else if(from.getSelectedIndex()==3 && to.getSelectedIndex()==0)
							{
								price.setText("600");
							}
							else if(from.getSelectedIndex()==3 && to.getSelectedIndex()==1)
							{
								price.setText("400");
							}
							else if(from.getSelectedIndex()==3 && to.getSelectedIndex()==2)
							{
								price.setText("1200");
							}
								}
						
				
				}
			});
			price.setFont(new Font("Tahoma", Font.PLAIN, 14));
			price.setBounds(223, 398, 111, 19);
			panel.add(price);
			price.setColumns(10);
			
			amount = new JTextField();
			amount.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(first.getSelectedIndex()==0) {

					int p,amount1 ;
					
					int adu,adu2,child2,child,total;
					
					adu=Integer.parseInt(adults.getText());
					
					child=Integer.parseInt(childs.getText());
					
					p=Integer.parseInt(price.getText());
					adu2 = (p*adu);
					child2 = ((p/2)*child);
					
					amount1= (adu2+child2);
					
						amount.setText(" "+amount1);
					}
					
					else {
						int p,amount1 ;
						
						int adu,adu2,child2,child,total;
						
						adu=Integer.parseInt(adults.getText());
						
						child=Integer.parseInt(childs.getText());
						
						p=Integer.parseInt(price.getText());
						adu2 = (p*adu);
						child2 = ((p/2)*child);
						
						amount1= (adu2+child2);
						
							amount.setText(" "+amount1);
					}
				}
			});
			amount.setFont(new Font("Tahoma", Font.PLAIN, 14));
			amount.setBounds(223, 448, 111, 19);
			panel.add(amount);
			amount.setColumns(10);
			
			date = new JTextField();
			date.setFont(new Font("Tahoma", Font.PLAIN, 14));
			date.setBounds(223, 198, 111, 19);
			panel.add(date);
			date.setColumns(10);
			
			
			
			String city[]= {"Mumbai","Pune","Sindhudurg","Nashik"};
			 from = new JComboBox(city);
			from.setFont(new Font("Tahoma", Font.PLAIN, 14));
			from.setBounds(223, 98, 111, 21);
			panel.add(from);
			
			String city1[]= {"Mumbai","Pune","Sindhudurg","Nashik"};
	         to = new JComboBox(city1);
	        to.setFont(new Font("Tahoma", Font.PLAIN, 14));
			to.setBounds(223, 148, 111, 21);
			panel.add(to);
			
			String cla[]= {"Second Class","First Class"};
			first = new JComboBox(cla);
			first.setFont(new Font("Tahoma", Font.PLAIN, 14));
			first.setBounds(223, 348, 111, 21);
			panel.add(first);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(413, 10, 692, 556);
			panel.add(scrollPane);
			
		
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int i = table.getSelectedRow();
				    number.setText(model.getValueAt(i, 0).toString());
					from.setSelectedItem(model.getValueAt(i, 1).toString());
					to.setSelectedItem(model.getValueAt(i, 2).toString());
					date.setText(model.getValueAt(i,3).toString());
					adults.setText(model.getValueAt(i,4).toString());
					childs.setText(model.getValueAt(i,5).toString());
					first.setSelectedItem(model.getValueAt(i, 6).toString());
					price.setText(model.getValueAt(i,7).toString());
					amount.setText(model.getValueAt(i,8).toString());

					
				}
			});
			table.setBackground(new Color(240, 248, 255));
			model=new DefaultTableModel();
			Object[] column = {"TicketNo","From","To","Date","Adults","Childs","Class","Price","Amount"};
			final Object[] row = new Object[9];
			model.setColumnIdentifiers(column);
			table.setModel(model);	
			table.setFont(new Font("Tahoma", Font.PLAIN, 14));
			scrollPane.setViewportView(table);
			
			JButton btnBook = new JButton("Book Ticket");
			btnBook.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
			
					String url = "jdbc:mysql://localhost:3306/";
					String db = "ticket";
					String driver = "com.mysql.jdbc.Driver";
					String user = "root";
					String pass = "Shruti@1234567";
					if(from.getSelectedItem().equals(null) || to.getSelectedItem().equals(null) || date.getText().equals("") || adults.getText().equals("") || childs.getText().equals("") || first.getSelectedItem().equals(null) || price.getText().equals("") || amount.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null,"Please Fill Complete Information");
					}
					else 
					{
						 String tno,fr,too,da,ad,ch,cl,pr,am;
						 
						   tno = number.getText().toString();
						   fr = from.getSelectedItem().toString();
						   too = to.getSelectedItem().toString();
		                   da = date.getText();
						   ad = adults.getText();
						   ch = childs.getText();
						   cl = first.getSelectedItem().toString();
						   pr = price.getText();
						   am = amount.getText(); 

		                  
						   row[0]=number.getText();
							row[1]=from.getSelectedItem();
							row[2]=to.getSelectedItem();
							row[3]=date.getText();
							row[4]=adults.getText();
							row[5]=childs.getText();
							row[6]=first.getSelectedItem();
							row[7]=price.getText();
							row[8]=amount.getText();
							model.addRow(row);
							
							number.setText("");
							from.setSelectedItem(null);
							to.setSelectedItem(null);
	                        date.setText("");
							adults.setText("");
							childs.setText("");
							first.setSelectedItem(null);
							price.setText("");
							amount.setText("");
						
						System.out.println(tno+fr+too+da+ad+ch+cl+pr+am);
						try{
						Class.forName(driver);
						con = DriverManager.getConnection(url+db, user, pass);
						PreparedStatement st=con.prepareStatement("insert into final values(?,?,?,?,?,?,?,?,?)");
						st.setString(1, tno);
						st.setString(2,fr);					
						st.setString(3,too);
						st.setString(4,da);
		       		    st.setString(5,ad);
						st.setString(6,ch);
						st.setString(7,cl);
						st.setString(8,pr);
						st.setString(9,am);
						st.executeUpdate();
						
							    	
								
			                    	number.setText("");
									from.setSelectedItem(null);
									to.setSelectedItem(null);
			                        date.setText("");
									adults.setText("");
									childs.setText("");
									first.setSelectedItem(null);
									price.setText("");
									amount.setText("");
									JOptionPane.showMessageDialog(null,"Ticket Booked Successfully");
									JOptionPane.showMessageDialog(null,"Refresh Data");

									System.out.println("Your ticket ");
									System.out.println("Your Ticket No " +tno);
									System.out.println("Your Source " +fr);
									System.out.println("Your Destination " +too);
									System.out.println("Date " +da);
									System.out.println("No.of Adults " +ad);
									System.out.println("No.of Childs" +ch);
									System.out.println("Your Class" +cl);
									System.out.println("Price" +pr);
									System.out.println("Total Amount" +am);

									
									

										    	
						}
						catch(Exception e){
						//	System.out.println(e);
						JOptionPane.showMessageDialog(null,"Same Ticket No already exist");
	       				JOptionPane.showMessageDialog(null,"Please Refresh Data");

						}
									
						
					}
					
					//train();
				}
			});
			btnBook.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnBook.setBounds(25, 540, 129, 21);
			panel.add(btnBook);
			
			JButton btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				if(table.getSelectedRowCount()==1) {
					
				model.removeRow(table.getSelectedRow());
				try {
					String tno,fr,too,da,ad,ch,cl,pr,am;
					tno = number.getText();
					st=con.prepareStatement("delete  from final where ticket_no='"+tno+"'");
					st.executeUpdate();
					st.setString(1,tno);


					JOptionPane.showMessageDialog(null,"Successfully Delete your Ticket");
       				JOptionPane.showMessageDialog(null,"Please Refresh Data");

						}
					catch(Exception e){
						JOptionPane.showMessageDialog(null," Successfully Delete your Ticket");
	       				JOptionPane.showMessageDialog(null,"Please Refresh Data");


					}}
					
				else
				{
					if(table.getRowCount()==0) {
					JOptionPane.showMessageDialog(null,"Table is Empty");
					}
					else {
						JOptionPane.showMessageDialog(null,"Please Select Row");

					}
				}
				number.setText("");
				from.setSelectedItem(null);
				to.setSelectedItem(null);
		        date.setText("");
				adults.setText("");
				childs.setText("");
				first.setSelectedItem(null);
				price.setText("");
				amount.setText("");
				number.requestFocus();
			//	train();
   		//		JOptionPane.showMessageDialog(null,"Please Refresh Data");


	            }
			});
			btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnDelete.setBounds(25, 610, 129, 21);
			panel.add(btnDelete);
			
			JButton btnUpdate = new JButton("Update");
			btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String url = "jdbc:mysql://localhost:3306/";
					String db = "ticket";
					String driver = "com.mysql.jdbc.Driver";
					String user = "root";
					String pass = "Shruti@1234567";
					int i =table.getSelectedRow();
				
					if(i>=0)
					{
						String tno,fr,too,da,ad,ch,cl,pr,am;

						   tno = number.getText();
						   fr = from.getSelectedItem().toString();
						   too = to.getSelectedItem().toString();
		                   da = date.getText();
						   ad = adults.getText();
						   ch = childs.getText();
						   cl = first.getSelectedItem().toString();
						   pr = price.getText();
						   am = amount.getText(); 
						   
						   model.setValueAt(number.getText(), i, 0);
						   model.setValueAt(from.getSelectedItem(),i,1);
						   model.setValueAt(to.getSelectedItem(), i, 2);
						   model.setValueAt(date.getText(), i, 3);
						   model.setValueAt(adults.getText(), i, 4);
						   model.setValueAt(childs.getText(), i, 5);
						   model.setValueAt(first.getSelectedItem(),i,6);
	                	   model.setValueAt(price.getText(), i, 7);
						   model.setValueAt(amount.getText(), i, 8);
	        				JOptionPane.showMessageDialog(null,"Successfully Updated in table !");



						   
					try
					{
					st=con.prepareStatement("update final set from='"+fr+"', to='"+too+"', date='"+da+"' , adults='"+ad+"', childs='"+ch+"', class='"+cl+"', price='"+pr+"',  amount='"+am+"'where ticket_no='"+tno+"'");
	                  st.setString(1,fr);
	                    st.setString(2,too);
	                    st.setString(3,da);
	                    st.setString(4,ad);
	                    st.setString(5,ch);
	                    st.setString(6,cl);
	                    st.setString(7,pr);
	                    st.setString(8,am);
	                    st.setString(1,tno);
						
	               
	                    int k = st.executeUpdate();
	                    if (k==1) 
	                    {
		       				JOptionPane.showMessageDialog(null,"Oops! But You Cannot Directly Update the data");

	                    }
	                    else 
	                    {
	        				JOptionPane.showMessageDialog(null,"Refresh Data");

	                    }
	                	number.setText("");
						from.setSelectedItem(null);
						to.setSelectedItem(null);
				        date.setText("");
						adults.setText("");
						childs.setText("");
						first.setSelectedItem(null);
						price.setText("");
						amount.setText("");
						number.requestFocus();
			//			train();

					

					}
					catch(Exception e) 
					{

        				JOptionPane.showMessageDialog(null,"Sorry ! You cannot directly Update the details");
	       				JOptionPane.showMessageDialog(null,"Refresh the Data again");

					}}
					else 
					{
	    				JOptionPane.showMessageDialog(null,"Please Select a Ticket which you wanted to Update");

					}
				
					}
					});
						
			btnUpdate.setBounds(223, 540, 120, 21);
			panel.add(btnUpdate);
			
			JButton btnClear = new JButton("Clear");
			btnClear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					number.setText("");
					from.setSelectedItem(null);
					to.setSelectedItem(null);
					date.setText("");
					adults.setText("");
					childs.setText("");
					first.setSelectedItem(null);
					price.setText("");
					amount.setText("");
					number.requestFocus();
				}
			});
			btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnClear.setBounds(223, 610, 120, 21);
			panel.add(btnClear);
			
			JLabel lblNewLabel_7 = new JLabel("Ticket No.");
			lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_7.setBounds(50, 50, 92, 13);
			panel.add(lblNewLabel_7);
			
			number = new JTextField();
			number.setFont(new Font("Tahoma", Font.PLAIN, 14));
			number.setBounds(223, 48, 111, 19);
			panel.add(number);
			number.setColumns(10);
			
			 try

		     {

		         Class.forName("com.mysql.jdbc.Driver");

		         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticket","root","Shruti@1234567");
		     }
		        

		     catch (Exception ex)

		     {

		         System.out.println(ex);

		     }
			 
			JButton btnFetch = new JButton("Refresh Data");
			btnFetch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				//	train();
					try {
						PreparedStatement st=con.prepareStatement("select * from final");
		                rs = st.executeQuery();
		                ResultSetMetaData rsd = rs.getMetaData();
		                int c;
		                c = rsd.getColumnCount();
		                model = (DefaultTableModel)table.getModel();
		                model.setRowCount(0);
		                while(rs.next()) {
		                	Vector v = new Vector();
		                	for(int i=0;i<=c;i++) {
		                		v.add(rs.getString("ticket_no"));
		                		v.add(rs.getString("from"));
		                		v.add(rs.getString("to"));
		                		v.add(rs.getString("date"));
		                		v.add(rs.getString("adults"));
		                		v.add(rs.getString("childs"));
		                		v.add(rs.getString("class"));
		                		v.add(rs.getString("price"));
		                        v.add(rs.getString("amount"));

		                	}
		                	model.addRow(v);
		                }
						

					}
					catch(Exception e)
					{
						System.out.println(e);
						JOptionPane.showMessageDialog(null,"Sorry");
					}
			}
				
			});
			btnFetch.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnFetch.setBounds(710, 598, 129, 21);
			panel.add(btnFetch);
			frmBookTicket.setVisible(true);		

			
		}
		 
	
			
			public static void main(String[] args) {
				/*EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							BookTicket window = new BookTicket();
								
						} catch(Exception e) {
							e.printStackTrace();
						}
					}
				});*/
				BookTicket b = new BookTicket();
				
			}

			
	}
		
