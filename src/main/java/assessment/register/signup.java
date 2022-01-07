package assessment.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class signup
 */
@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	response.getWriter().append("Served at: ").append(request.getContextPath());
	System.out.println("test");
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	String n=request.getParameter("name");
	String c=request.getParameter("city");
	String e=request.getParameter("country");
	String b=request.getParameter("email");
	String p=request.getParameter("password");
	try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Sql#@9080");
	out.println("genpact");
	PreparedStatement ps=con.prepareStatement("insert into login.regg(name,city,country,email,password) values(?,?,?,?,?)");
	ps.setString(1,n);
	ps.setString(2,c);
	ps.setString(3,e);
	ps.setString(4,b);
	ps.setString(5,p);
	int i=ps.executeUpdate();
	if(i>0)
	out.print("You are successfully registered...");
	System.out.println("test");
	}catch (Exception e2) 
	{
		System.out.println(e2);
		}
	out.close();
	}
	
	}


