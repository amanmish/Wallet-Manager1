import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class window extends JFrame implements ActionListener
{
	static String []rst=new  String[100];
	static String []pst=new  String[100];
	String aa;
	JTextField f1;
	JPasswordField f2;
	JFrame p=new JFrame();
	JButton login,signup;
	JLabel l1,l2;
	Container cn;
	
	window()
	{
		cn=p.getContentPane();
		f1=new JTextField();
		f2=new JPasswordField();
		l1=new JLabel("username");
		l2=new JLabel("password");
		l1.setBounds(10,60,150,35);
		l2.setBounds(10,100,150,35);
		login=new JButton("login");
		signup=new JButton("signup");
		p.setLayout(null);
		f1.setBounds(80,60,150,25);
		f2.setBounds(80,100,150,25);
		login.setBounds(70,140,75,20);
		signup.setBounds(130,140,75,20);
		cn.add(login);
		cn.add(signup);
		cn.add(f1);
		cn.add(l1);
		
		cn.setBackground(Color.orange);
		
		login.addActionListener(this);
		signup.addActionListener(this);
		/*l1.setOpaque(true);
		l2.setOpaque(true);*/
		cn.add(l2);
		cn.add(f2);
		p.setVisible(true);
		p.setSize(350,350);
	}
	void window1()
	{
		try
		{
			
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mishra101");
		Statement st=conn.createStatement();
		char []s2=f2.getPassword();
		if(s2!=null)
		{
		String pass=new String(s2);
		String user=f1.getText();
		
		String sql="select password from facebook where username =? and password=?";
		 PreparedStatement ps=conn.prepareStatement(sql);
		 ps.setString(1,user);
		 ps.setString(2,pass);
		 ResultSet rs=ps.executeQuery();
		 if(rs.next())
		 {
			mainn n=new mainn();
			p.setVisible(false);
			
		}
		else
		{
			JOptionPane.showMessageDialog(p,"invalid username or password");
		}
		}
		}
		
		catch(Exception e)
		{}	
		
	}
	void window2()
	{
		try
		{
				Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mishra101");
		Statement st=conn.createStatement();
		st.execute("insert into facebook values('"+f1.getText()+"','"+f2.getText()+"')");
		JOptionPane.showMessageDialog(p," username and password are added");
		}
		catch(Exception aaa)
		{}
	}
	public void actionPerformed(ActionEvent ae)
	{	
		if(ae.getSource()==login)
		{
			window1();
			
		}
		if(ae.getSource()==signup)
		{
			window2();
		}
	}
	
}
