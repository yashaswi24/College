package Collegeinfo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/display")
public class display extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public display() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fp="/Users/yasha/Downloads/LTI Case Study-1/share/College/students.csv";
			BufferedReader br = new BufferedReader(new FileReader(fp));
		 String line;
		 PrintWriter out = response.getWriter();  
		 String ignorefirstline=br.readLine();
		 while ( (line = br.readLine()) != null ) {
		        String[] values = line.split(",");
		        //out.println(values[0]+","+values[1]+","+values[2]+","+values[3]+","+values[4]+","+values[5]+","+values[6]+","+values[7]+","+values[8]+",");
		        out.println("<table border='1'  rules='all'><tr ><td>Student ID</td><td>"+values[0]+"</td> </tr>");
	        	out.println("<tr><td>Student Name</td><td>"+values[1]+"</td> </tr>");
	        	out.println("<tr><td>Gender</td><td>"+values[2]+"</td> </tr>");
	        	out.println("<tr><td>Date Of Birth</td><td>"+values[3]+"</td> </tr>");
	        	out.println("<tr><td>City</td><td>"+values[4]+"</td> </tr>");
	        	out.println("<tr><td>State</td><td>"+values[5]+"</td> </tr>");
	        	out.println("<tr><td>Email ID</td><td>"+values[6]+"</td> </tr>");
	        	out.println("<tr><td>Qualification</td><td>"+values[7]+"</td> </tr>");
	        	out.println("<tr><td>Stream</td><td>"+values[8]+"</td> </tr></table><br>");
		        }
		 out.println("</br></br><a href='index.html'> Index page</a>");
		//doGet(request, response);
	}

}
