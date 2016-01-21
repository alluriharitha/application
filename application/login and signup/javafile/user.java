import java.io.*;
import javax.servlet.http.*;

import java.sql.*;
import javax.servlet.*;

public class user extends HttpServlet {


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub


            response.setContentType("text/html");  
            PrintWriter pw = response.getWriter(); 
            Connection conn=null;
            String url="jdbc:mysql://localhost:3306/";
            String driver="com.mysql.jdbc.Driver";
	    ResultSet rs;	         
         	
	  String Emailid = request.getParameter("email");  
          String Password1 = request.getParameter("pass");  
           
	try{	
          Class.forName(driver);  
          conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogindb","root", "manager");
          PreparedStatement pst =(PreparedStatement) conn.prepareStatement("select email,pass from subscribe where email=? and pass=?");//try2 is the name of the table  

          pst.setString(1,Emailid);  
          pst.setString(2,Password1);        
	          

	  rs= pst.executeQuery();
	  String msg=" ";
	  if(rs.next()){
		RequestDispatcher rd1=request.getRequestDispatcher("blog.html");
		rd1.forward(request,response);
		 //msg="valid user";
            //pw.println("<font size='6' color=blue>" + msg + "</font>");
	  }
	  else{
		RequestDispatcher rd2=request.getRequestDispatcher("login.html");
		rd2.include(request,response);
		// msg="invalid user";
          //  pw.println("<font size='6' color=blue>" + msg + "</font>");
	  }	
         /* //conn.commit(); 
          String msg=" ";
          if(i!=0){  
            msg="Record has been inserted";
            pw.println("<font size='6' color=blue>" + msg + "</font>");  


          }  
          else{  
            msg="failed to insert the data";
            pw.println("<font size='6' color=blue>" + msg + "</font>");
           }*/  
          pst.close();
        }  
        catch (Exception e){  
          pw.println(e);
	  pw.close();  
        }  

}

}