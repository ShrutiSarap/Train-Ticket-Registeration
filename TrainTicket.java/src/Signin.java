import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.*;
public class Signin implements ActionListener{
	


	     JFrame f ;
		JLabel l1,l2,l3,l4;
		JTextField t1;
		JPasswordField p1;
		JButton sub,b1;
		
		Signin(){
			f=new JFrame("Sign in ");
			f.setContentPane(new JLabel(new ImageIcon("railway2.png")));
		   	f.getContentPane().setBounds(700, 60, 500, 400);
		   	f.setBackground(Color.cyan);
			Font font = new Font("Roman",Font.BOLD,20);
			Font font1 = new Font("Alegrian",Font.BOLD,30);
			
			l1=new JLabel("Username/Email Id");
			l1.setBounds(50,150,250,80);
			l1.setFont(font);
			f.add(l1);
			  
			t1 = new JTextField(40);
			t1.setBounds(250,150,250,80);
			t1.setFont(font);
			f.add(t1);
			
			l2=new JLabel("Password");
			l2.setBounds(1000,150,250,80);
			l2.setFont(font);
			f.add(l2);
			
			p1 = new JPasswordField(40);
			p1.setBounds(1200,150,250,80);
			p1.setFont(font);
			f.add(p1);
			
		    sub = new JButton("SUBMIT");
		    sub.setBounds(650,650,250,80);
			f.add(sub);
			sub.setFont(font1);
			sub.addActionListener(this);
			
			b1 = new JButton("Forget Password?");
			b1.setBounds(1230,250,200,25);
			f.add(b1);
		    b1.setBackground(Color.cyan);
		    b1.setBorder(null);
		    b1.addActionListener(this);
			f.setLayout(null);
			f.setVisible(true);
			f.setSize(645, 325);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==sub) {
			
				showData();
			}
			else if(e.getSource()==b1){
				f.dispose();
				new ResetPass();
			}
			}
			public void showData()
			{   

			 

			        String str1 = t1.getText();

			        char[] p = p1.getPassword();

			        String str2 = new String(p);

			
				 try

			     {

			         Class.forName("com.mysql.jdbc.Driver");

			         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticket","root","Shruti@1234567");

			         PreparedStatement ps = con.prepareStatement("select * from new_table where email=? and pass=?");

			         ps.setString(1, str1);

			         ps.setString(2, str2);

			         ResultSet rs = ps.executeQuery();

			         if (rs.next())

			         {

			        	 JOptionPane.showMessageDialog(null,

					                "Successfully Login");
                         f.dispose();
                         new FirstPage();

			         } else

			         {

			             JOptionPane.showMessageDialog(null,

			                "Incorrect email-Id or password..Try Again with correct detail");

			         }

			     }

			     catch (Exception ex)

			     {

			         System.out.println(ex);

			     }

			 }

		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Signin sg = new Signin();
	}

}
