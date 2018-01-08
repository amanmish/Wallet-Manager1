import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class aman1 extends JFrame implements ActionListener
{
	JButton b1,b2;
	JLabel l1;
	JFrame p=new JFrame();
	
aman1()
	{
		Container cn=p.getContentPane();
		p.setLayout(null);
		l1=new JLabel("!! WELOCOME TO WALLET MANAGER !!");
		l1.setFont(new Font("Serif", Font.BOLD, 24));
        l1.setForeground(Color.BLACK);
		l1.setBounds(75,50,500,75);
		cn.add(l1);
		//b1=new JButton("SignUp/Register");
		b2=new JButton("Login");
		b2.setBounds(100,125,200,50);
		cn.add(b2);
		//b1.setBounds(320,125,200,50);
		//cn.add(b1);
		b2.addActionListener(this);
		
		p.setSize(600, 300);
		
	cn.setBackground(Color.orange);	
		p.setVisible(true);
	}
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==b2)
			{
				window w=new window();
				p.setVisible(false);
			}
				
		}
	
}