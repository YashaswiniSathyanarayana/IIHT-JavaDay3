import java.sql.*;
import java.util.Scanner;

public class RegistartionLogin {
	
	static final String url="jdbc:mysql://localhost:3306/shamsheer";
	static final String user="root";
	static final String pass="pass@word1";
	static final String query="select * from student";
	public static int x=0;
	
	public static void main(String[] args) {
		
		do {
			try(Connection con=DriverManager.getConnection(url,user,pass);
					PreparedStatement ps=con.prepareStatement(query);){
			   
				x=getvalues();
			    switch(x) {
			    	case 1: register(con,ps);
			    			break;
			    	case 2: login(con,ps);
			    			break;
			    	case 3: System.exit(0);
			    }
			    
			} catch(SQLException e) {
				
			}
		}while(x<4);
	}

	private static int getvalues() {
		System.out.println("\n\n 1.Register \n 2.Login \n 3.exit");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the operation number to perform");
		int x=sc.nextInt();
		return x;
	}
	
	private static void register(Connection con, PreparedStatement ps) throws SQLException{
		String query="insert into user (email,name,password) values(?,?,?);";
		ps=con.prepareStatement(query);
		Scanner sc=new Scanner(System.in);
		System.out.println("enter user email");
		String email=sc.next();
		System.out.println("enter user name");
		String name=sc.next();
		System.out.println("enter user password");
		String password=sc.next();
		
		ps.setString(1, email);
		ps.setString(2, name);
		ps.setString(3, password);
		int b=ps.executeUpdate();
		if(b==1) {
			System.out.println("User Registered successfully");
		}
	}
	
	public static void login(Connection con, PreparedStatement ps) throws SQLException {
		String query1="select * from user where email=? and password=?";
		ps=con.prepareStatement(query1);
		Scanner sc=new Scanner(System.in);
		System.out.println("enter email id");
		String email=sc.next();
		System.out.println("enter  password");
		String password=sc.next();
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet rs= ps.executeQuery();
		
		if(!rs.next()) {		
			System.out.println("Invalid Email or password!");
		}
		else {
			System.out.println("Successfully Logged in");
		}
	}
}
