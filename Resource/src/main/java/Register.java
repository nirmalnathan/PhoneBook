/**
 * 
 */
package main.java;

/**
 * @author DELL
 *
 */
import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class Register extends HttpServlet {  
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String n=request.getParameter("userName");  
String p=request.getParameter("userPhone");  
  
          
try{  
	
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	String connectionUrl="jdbc:sqlserver://pbookserver.database.windows.net:1433;database=PhoneBook;user=nirmal@pbookserver;password=Root123#;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30";
	/*
	 * String connectionUrl =
	 * "jdbc:sqlserver://pbookserver.database.windows.net;database=PhoneBook;integratedSecurity=true;Trusted_Connection=False;Encrypt=True;trustServerCertificate = false;username=nirmal@pbookserver;password=Root123#"
	 * ;
	 */  
	Connection con = DriverManager.getConnection(connectionUrl); 
	
	
	
PreparedStatement ps=con.prepareStatement("insert into pbook values(?,?)");  
ps.setString(1,n);  
ps.setString(2,p);            
int i=ps.executeUpdate();  
if(i>=0)  
out.print("Hello" +"  "+ n  +"  " + "\n" );
System.getProperty("line.separator"); 	
out.print("Your phone number is added to the phone book successfully..");  
     
          
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}  
  
}  
