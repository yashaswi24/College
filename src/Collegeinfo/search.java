package Collegeinfo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public search() {
        super();
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
		String fp="/Users/yasha/Downloads/LTI Case Study-1/share/College/students.csv";
	int k=searchCSV(sid,fp,out);
		if(k==0)
		{
			request.setAttribute("error", "Student Id not Found.. Try Again");
			request.getRequestDispatcher("search-student.jsp").forward(request, response);
		}
		//doGet(request, response);
	}

	public static int searchCSV(String sid, String fp,PrintWriter out) throws IOException {
		
	    BufferedReader br = new BufferedReader(new FileReader(fp));
	    String line;
	    int f=0;
	    String ignorefirstline=br.readLine();
	    while ( (line = br.readLine()) != null ) {
	        String[] values = line.split(",");
	        if(values[0].equalsIgnoreCase((sid))) {
	        	f=1;
	        	out.println("<table border='1'  rules='all'><tr ><td><b>Student ID</b></td><td>"+values[0]+"</td> </tr>");
	        	out.println("<tr><td><b>Student Name</b></td><td>"+values[1]+"</td> </tr>");
	        	out.println("<tr><td><b>Gender</b></td><td>"+values[2]+"</td> </tr>");
	        	out.println("<tr><td><b>Date Of Birth</b></td><td>"+values[3]+"</td> </tr>");
	        	out.println("<tr><td><b>City</b></td><td>"+values[4]+"</td> </tr>");
	        	out.println("<tr><td><b>State</b></td><td>"+values[5]+"</td> </tr>");
	        	out.println("<tr><td><b>Email ID</b></td><td>"+values[6]+"</td> </tr>");
	        	out.println("<tr><td><b>Qualification</b></td><td>"+values[7]+"</td> </tr>");
	        	out.println("<tr><td><b>Stream</b></td><td>"+values[8]+"</td> </tr></table>");
	
	        	out.println("</br></br><a href='index.html'> Index page</a>");
	        	
		            break;
		        }
	        	
	            
	        }
	    br.close(); 
	    return f;
	    }
	  

}
