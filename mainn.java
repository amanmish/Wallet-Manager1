import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class mainn extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,lo,l6,t4,t5;
	JButton b1,b2,b3,b4,b5;
	JFrame p=new JFrame();
	JTextField t1,t2,t3;
	public static void main(String ar[]) throws Exception
	{
		mainn m=new mainn();
	}
	mainn()
	{
		Container cn=getContentPane();
		lo=new JLabel("!!Welcome to WalletManager!!");
		
		lo.setFont(new Font("Serif", Font.BOLD, 50));
		lo.setForeground(Color.RED);
		lo.setBounds(300,10,1000,60);
		cn.add(lo);
		l1=new JLabel("View Detail");
		l1.setBounds(500,85,200,60);
		l1.setFont(new Font("Serif", Font.BOLD, 40));
		setLayout(null);  
		cn.add(l1);
		l6=new JLabel("enter the name");
		l6.setBounds(200,177,200,25);
		l6.setFont(new Font("Serif", Font.BOLD, 25));
		cn.add(l6);
		t1=new JTextField();
		t1.setBounds(420,177,240,25);
		t4=new JLabel("PAY");
		t4.setBounds(670,177,117,25);
		t5=new JLabel("RECEIVE");
		t5.setBounds(795,177,117,25);
		b1=new JButton("ok");
		b1.setBounds(930,177,55,25);
		b1.setFont(new Font("Serif", Font.BOLD, 16));
		cn.add(b1);
		cn.add(t1);
		
		l3=new JLabel("Transaction");
		l3.setFont(new Font("Serif", Font.BOLD, 40));
		l3.setBounds(500,230,500,60);
		cn.add(l3);
		l4=new JLabel("To whom");
		l4.setBounds(200,320,200,25);
		l4.setFont(new Font("Serif", Font.BOLD, 25));
		t2=new JTextField();
		t2.setBounds(420,320,500,25);
		cn.add(t2);
		cn.add(l4);
		l5=new JLabel("enter the amount");
		l5.setFont(new Font("Serif", Font.BOLD, 25));
		l5.setBounds(200,360,200,25);
		t3=new JTextField();
		t3.setBounds(420,360,500,25);
		b2=new JButton("Proceed");
		b2.setBounds(930,360,120,25);
		b2.setFont(new Font("Serif", Font.BOLD, 15));
		cn.add(l5);
		cn.add(t3);
		cn.add(b2);
		cn.add(t4);
		cn.add(t5);
		b1.addActionListener(this);
		cn.setBackground(Color.green);
		setSize(1350,766);
		setVisible(true);
		b2.addActionListener(this);
		
	}
	void window3()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mishra101");
		Statement st=conn.createStatement();
		System.out.println("aman");
		String user=t1.getText();
		System.out.println("aman");
		
		 ResultSet rs=st.executeQuery("select * from detail1 where name='"+user+"'");
		  int count=0;
           while(rs.next()){
           count++;
          }
          if(count>0){
			  window4();
		  }
		else
		{
			JOptionPane.showMessageDialog(p,"invalid name");
		}
		}
		
		catch(Exception e)
		{}
	}
public void actionPerformed(ActionEvent ae)
	{	
		if(ae.getSource()==b1)
		{
			
			window3();
		}
		if(ae.getSource()==b2)
		{
			
			window5();
		}
	}
void window4()
	{
		try
		{
			 
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mishra101");
		Statement st=conn.createStatement();
		String user=t1.getText();
		String s1="select * from detail1 where name='"+user+"'";
		ResultSet rs = st.executeQuery(s1);
		
		 while(rs.next()){
            t4.setText(rs.getString("PAY"));

        }
		
		String s2="select * from detail1 where name='"+user+"'";
		rs = st.executeQuery(s2);
		 while(rs.next()){
            t5.setText(rs.getString("receive"));

        }
		}
		catch(Exception e)
		{}
	}
	void window5()
	{
		try
		{
		String s1=t3.getText();
		int a=Integer.parseInt(s1);
		String user=t2.getText();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mishra101");
		Statement st=conn.createStatement();
		String s2="select * from detail1 where name='"+user+"'";
		ResultSet rs = st.executeQuery(s2);
		
		String s3="";
		 while(rs.next()){
            s3=(rs.getString("pay"));
        }
		int b=Integer.parseInt(s3);
		int ans=b-a;
		System.out.println(ans);
		if(ans>0)
		{
			String s4=Integer.toString(ans);
			
		String sql=("UPDATE detail1 SET pay = ? WHERE Name ='"+user+"'" );
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,s4);
		JOptionPane.showMessageDialog(p,"successfully");
		pstmt.executeUpdate();
		}
		else
			JOptionPane.showMessageDialog(p,"insert correct amount");
		}
		catch(Exception e)
		{}
	}		
	
		
		
		
}