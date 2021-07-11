import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.*;

public class ResetPass implements ActionListener {

	 JFrame f ;
		JLabel l1,l2,l3,l4,l5,l6;
		JTextField t1,t2;
		JPasswordField p1,p2,p3;
		JButton sub;
		Connection con;
		PreparedStatement st;
		ResultSet rs;
		
		ResetPass(){
			f=new JFrame("Reset Password ");
			f.setContentPane(new JLabel(new ImageIcon("railway2.png")));
			f.getContentPane().setBounds(2000,100,600,100);
	        f.setBackground(Color.cyan);
		    Font font = new Font("Roman",Font.BOLD,20);
		    Font font1 = new Font("Alegrian",Font.BOLD,30);
		    
			l1=new JLabel("Email Id");
			l1.setBounds(50,50,250,80);
			l1.setFont(font);
			f.add(l1);
			
			t1=new JTextField(40);
			t1.setBounds(230,50,250,80);
			t1.setFont(font);
			f.add(t1);
			
			l2=new JLabel("Old Password");
			l2.setBounds(50,250,250,80);
			l2.setFont(font);
			f.add(l2);
			
			p1 = new JPasswordField(40);
			p1.setBounds(230,250,250,80);
			p1.setFont(font);
			f.add(p1);
			
			l3=new JLabel("New Password");
			l3.setBounds(1000,50,250,80);
			l3.setFont(font);
			f.add(l3);
			
			p2 = new JPasswordField(40);
			p2.setBounds(1180,50,250,80);
			p2.setFont(font);
			f.add(p2);
			
			l4 = new JLabel("Confirm Password");
			l4.setBounds(1000,250,250,80);
			f.add(l4);
			l4.setFont(font);
			
			p3 = new JPasswordField(40);
			p3.setBounds(1180,250,250,80);
			p3.setFont(font);
			f.add(p3);
			
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
			   un = t1.getText();
		//	   op =p1.getText();
			   np=p2.getText();
			   cp=p3.getText();
			if(np.equals(cp))   
			{   
				try {
	//			st = con.prepareStatement("select count(*) from new_table where email=? and pass=?");
				st = con.prepareStatement("select count(*) from new_table where email=? ");

				st.setString(1,un);
	//		    st.setString(2,np);
				rs=st.executeQuery();
				rs.next();
				int c=rs.getInt(1);
				
				if(c>0)
				{
					st = con.prepareStatement("update new_table set pass=?  where email=?");
					st.setString(1, np);
					st.setString(2, un);
					st.executeUpdate();
					JOptionPane.showMessageDialog(null,"Password Changed Successfully");
					t1.setText("");
					p1.setText("");
					p2.setText("");
					p3.setText("");
					f.dispose();
					new Signin();
				}
				else
					JOptionPane.showMessageDialog(null,"Invalid Emai Id/Password");
				}   
				catch(Exception exp) {
					System.out.println(exp);
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
     new ResetPass();
	}

}



	
