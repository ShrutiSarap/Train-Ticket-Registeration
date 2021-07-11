import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.*;
public class TrainTicket implements ActionListener {
	 JButton in,up;
	  JFrame f;
	 
	  
	 
	public TrainTicket() {
		f = new JFrame ("Registration");
		in = new JButton ("Sign In");
		up = new JButton ("Sign Up");
		f.setContentPane(new JLabel(new ImageIcon("railway2.png")));
		f.getContentPane().setBounds(600,100,300,100);
        f.setBackground(Color.cyan);
      
        Font font = new Font("Algerian",Font.BOLD,30);
		in.setBounds(610,130,300,80);
		up.setBounds(610,600,300,80);
		in.setFont(font);
		up.setFont(font);
		in.setBackground(Color.white);
		up.setBackground(Color.white);
		f.add(in);
		f.add(up);
		in.addActionListener(this);
		up.addActionListener(this);
		f.setSize(600,550);
		f.setLayout(null);
		f.setVisible(true);
	}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
	    new TrainTicket();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==in) {
				f.dispose();
				new Signin();
			
			}
			else if(e.getSource()==up){
				f.dispose();
				new Signup();
			}
		}

	}



	
