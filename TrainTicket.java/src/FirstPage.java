import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.*;

public class FirstPage implements ActionListener  {

	 JFrame f ;
		JLabel l1,l2,l3,l4,l5,l6;
		JTextField t1,t2,t3,t4;
		
		JButton b1,b2,b3,b4, sub;
		Connection con;
		PreparedStatement st;
		ResultSet rs;
		
		FirstPage(){
			f=new JFrame("Welcome");
			f.setContentPane(new JLabel(new ImageIcon("railway2.png")));
			f.getContentPane().setBounds(2000,100,600,100);
	        f.setBackground(Color.cyan);
		   
		    Font font1 = new Font("Alegrian",Font.BOLD,25);
		    Font font2 = new Font("Algerian",Font.BOLD,60);
		  
		    l2 = new JLabel("WELCOME To INDIAN RAILWAY ");
			l2.setFont(font2);
			l2.setBackground(Color.red);
			l2.setBounds(400,100,1000,200);
			f.add(l2);
			
		    
		    
			b1=new JButton("BOOK YOUR TICKET");
			b1.setBounds(650,650,300,80);
			b1.setFont(font1);
			f.add(b1);
			b1.addActionListener(this);
			b1.setFont(font1);
			b1.setBackground(Color.white);
			
			/*b2=new JButton("Check Your Ticket");
			b2.setBounds(120,250,400,80);
			b2.setFont(font);
			f.add(b2);
			b2.addActionListener(this);
			b2.setFont(font1);
			b2.setBackground(Color.white);
			
			b3=new JButton("Check PNR Status");
			b3.setBounds(1070,50,400,80);
			b3.setFont(font);
			f.add(b3);
			b3.addActionListener(this);
			b3.setFont(font1);
			b3.setBackground(Color.white);
			
			b4 = new JButton("Cancel Ticket");
			b4.setBounds(1070,250,400,80);
			f.add(b4);
			b4.setFont(font);
			b4.addActionListener(this);
			b4.setFont(font1);
			b4.setBackground(Color.white);*/
		
			f.setLayout(null);
			f.setVisible(true);
			f.setSize(600,600);
			
}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==b1)
			{
			f.dispose();
			new BookTicket();
			JOptionPane.showMessageDialog(null,"Refresh Data");

		

			}
			
			
		}
		public static void main(String args[]) {
			new FirstPage();
	//		Book1 b = new Book1();
      
}
}