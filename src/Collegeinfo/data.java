package Collegeinfo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/data")
public class data extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public data() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		          
		String sid=request.getParameter("sid");  
		String sname=request.getParameter("sname");  
		String gender=request.getParameter("gender");  
		String dob=request.getParameter("dob");  
		String city=request.getParameter("city");  
		String state=request.getParameter("state");  
		String emailid=request.getParameter("emailid");  
		String quali=request.getParameter("quali");  
		String stream=request.getParameter("stream");  
		          
		String fp="/Users/yasha/Downloads/LTI Case Study-1/share/College/students.csv";

		saveRecord(sid,sname,gender,dob,city,state,emailid,quali,stream,fp,out);
		out.println("<h2 align=center>You are successfully registered...</h2>"); 
		out.println("</br></br><a href='index.html'> Index page</a>");
    	
		
		//out.println(sid+","+sname+","+gender+","+dob+","+city+","+state+","+emailid+","+quali+","+stream);
		
		//doGet(request, response);
	}


	public static void saveRecord(String sid, String sname, String gender, String dob, String city, String state,
			String emailid, String quali, String stream, String fp,PrintWriter out) {
		try{
			FileWriter fw=new FileWriter(fp,true);
			BufferedWriter bw=new BufferedWriter(fw);
			PrintWriter pw=new PrintWriter(bw);
			//out.println(sid+","+sname+","+gender+","+dob+","+city+","+state+","+emailid+","+quali+","+stream);
			
			pw.println(sid+","+sname+","+gender+","+dob+","+city+","+state+","+emailid+","+quali+","+stream);
			pw.flush();
			pw.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
