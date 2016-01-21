import java.io.*;
import javax.servlet.http.*;

import java.sql.*;
import javax.servlet.*;

public class subscribe extends HttpServlet {


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub


            response.setContentType("text/html");  
            PrintWriter pw = response.getWriter(); 
            Connection conn=null;
            String url="jdbc:mysql://localhost:3306/";
            String driver="com.mysql.jdbc.Driver";
         
          String Fname = request.getParameter("fname");  
          String Lname = request.getParameter("lname");  
          String gender = request.getParameter("g");  
	  String Password1 = request.getParameter("pass");  
          String Password2 = request.getParameter("pass1");
	  String Emailid = request.getParameter("email");
	  String Country= request.getParameter("country");    
	try{	
          Class.forName(driver);  
          conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogindb","root", "manager");
          PreparedStatement pst =(PreparedStatement) conn.prepareStatement("insert into subscribe(fname,lname,g,pass,pass1,email,country) values(?,?,?,?,?,?,?)");//try2 is the name of the table  

          pst.setString(1,Fname);  
          pst.setString(2,Lname);        
          pst.setString(3,gender);
          
          pst.setString(4,Password1);
          pst.setString(5,Password2);
	  pst.setString(6,Emailid);
	  pst.setString(7,Country);
          int i = pst.executeUpdate();
          //conn.commit(); 
          String msg=" ";
          if(i!=0){  
            RequestDispatcher rd1=request.getRequestDispatcher("login.html");
		rd1.forward(request,response);
	   // msg="Record has been inserted";
           // pw.println("<font size='6' color=blue>" + msg + "</font>");  


          }  
          else{
		RequestDispatcher rd1=request.getRequestDispatcher("subscribe.html");
		rd1.include(request,response);  
            //msg="failed to insert the data";
            //pw.println("<font size='6' color=blue>" + msg + "</font>");
           }  
          pst.close();
        }  
        catch (Exception e){  
          pw.println(e);
	  pw.close();  
        }  

}

}