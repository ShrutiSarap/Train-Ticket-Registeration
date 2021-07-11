import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.*;
public class Signup implements ActionListener{
	


	     JFrame f ;
		JLabel l1,l2,l3,l4,l5,l6;
		JTextField t1,t2,t3,t4,t5,t6;
		JPasswordField p1,p2;
		JButton sub;
		Connection con;
		PreparedStatement st;
		ResultSet rs;
		
		Signup(){
			f=new JFrame("Sign up ");
			f.setContentPane(new JLabel(new ImageIcon("railway2.png")));
			f.getContentPane().setBounds(2000,100,600,100);
	        f.setBackground(Color.cyan);
		    Font font = new Font("Roman",Font.BOLD,20);
		    Font font1 = new Font("Alegrian",Font.BOLD,30);
		    
			l1=new JLabel("Enter Name");
			l1.setBounds(50,50,250,80);
			l1.setFont(font);
			f.add(l1);
			
			t1=new JTextField(40);
			t1.setBounds(230,50,250,80);
			t1.setFont(font);
			f.add(t1);
			
			l2=new JLabel("New Password");
			l2.setBounds(50,250,250,80);
			l2.setFont(font);
			f.add(l2);
			
			p2 = new JPasswordField(40);
			p2.setBounds(230,250,250,80);
			p2.setFont(font);
			f.add(p2);
			
			l3=new JLabel("Confirm Password");
			l3.setBounds(50,450,250,80);
			l3.setFont(font);
			f.add(l3);
			
			p1 = new JPasswordField(40);
			p1.setBounds(230,450,250,80);
			p1.setFont(font);
			f.add(p1);
			
			l4 = new JLabel("Email Id");
			l4.setBounds(1000,50,250,80);
			f.add(l4);
			l4.setFont(font);
			
			t4 = new JTextField(40);
			t4.setBounds(1180,50,250,80);
			t4.setFont(font);
			f.add(t4);
			
			l5 = new JLabel("Mobile Number");
			l5.setBounds(1000,250,250,80);
			l5.setFont(font);
			f.add(l5);
			
			t5 = new JTextField(40);
			t5.setBounds(1180,250,250,80);
			t5.setFont(font);
			f.add(t5);
			
			l6= new JLabel("Verification Code");
			l6.setBounds(1000,450,250,80);
			l6.setFont(font);
			f.add(l6);
			
			t6 = new JTextField(40);
			t6.setBounds(1180,450,250,80);
			t6.setFont(font);
			f.add(t6);
			
			
			sub = new JButton("SUBMIT");
		    sub.setBounds(650,650,250,80);
			f.add(sub);
			sub.setBackground(Color.white);
			sub.setFont(font1);
			sub.addActionListener(this);
			
			f.setLayout(null);
			f.setVisible(true);
			f.setSize(600,600);
			try

		     {

		         Class.forName("com.mysql.jdbc.Driver");

		         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticket","root","Shruti@1234567");
		     }
		        

		     catch (Exception ex)

		     {

		         System.out.println(ex);

		     }
	       
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==sub) {
				   String un,op,np,cp;
				   op=t1.getText();
				   un = t4.getText();
				   np =p2.getText();
				   cp=p1.getText();
				   
				if(cp.equals(np))   
				{ 
			    
					try {
						st = con.prepareStatement("insert into new_table values(?,?,?)");
						st.setString(1,op);
						st.setString(2, un);
						st.setString(3, cp);
						st.executeUpdate();
						JOptionPane.showMessageDialog(null,"Sign up Successfully");
						t1.setText("");
						t4.setText("");
						p1.setText("");
						p2.setText("");
						f.dispose();
						new Signin();
						
						
						
						st = con.prepareStatement("select count(*) from new_table where email=? and pass=?");
						st.setString(1,op);
						st.setString(2,un);
						st.setString(2,cp);
						rs=st.executeQuery();
				         
					

					}
					
					catch(Exception exp) {
						System.out.println(exp);
						JOptionPane.showMessageDialog(null,"Email Id already exist.");

					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"New Password & Confirm Password does not match");
				}
				}

				
					
				 }


		public static void main(String[] args) {
			// TODO Auto-generated method stub
	     new Signup();
		}

	}

	
	