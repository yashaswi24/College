package Collegeinfo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class COllege {
	
	

	public static void main(String args[]) throws IOException
	{
		System.out.println("Need to Register a College?  y/n:");
		BufferedReader s =
                new BufferedReader(new InputStreamReader(System.in));
		String c=s.readLine();
		String fp="f1.csv";
		if(c.equalsIgnoreCase("y"))
		{
			
		String cid,cname,ctype,city,cfees,cpin;
		System.out.println("College ID: ");
		cid= s.readLine();
		System.out.println("College Name: ");
		cname= s.readLine();
		System.out.println("Course Type: ");
		ctype= s.readLine();
		System.out.println("City : ");
		city= s.readLine();
		System.out.println("Fees: ");
		cfees= s.readLine();
		System.out.println("pinCode : ");
		cpin= s.readLine();
		
		saveRecord(cid,cname,ctype,city,cfees,cpin,fp);
		}
		System.out.println("Colleges in mumbai who teches engineering are:");
		int co=searchCsv(fp,3,"mumbai");
		System.out.print(co);
		
		System.out.println("Want to delete any row ? y/n: ");
		if(s.readLine().equals("y"))
		{
		System.out.println("Remove College of Id if present: ");
		String id=s.readLine();
		deleteline(fp,id);
		}
		System.out.println("Done Thank You");
	}

	public static void deleteline(String fp, String id) throws IOException {
		
		String tempfile="f2.csv";
		File oldfile=new File(fp);
		File newfile=new File(tempfile);
		
		String cid,cname,ctype,city,cfees,cpin;
		try{
			FileWriter fw=new FileWriter(tempfile,true);
			BufferedWriter bw=new BufferedWriter(fw);
			PrintWriter pw=new PrintWriter(bw);
			BufferedReader br = new BufferedReader(new FileReader(fp));
		    String line;
		    while ( (line = br.readLine()) != null ) {
		    	
		    	 String[] values = line.split(",");
		    	
				
				if(!values[0].equals(id))
				{
					System.out.println(values[0]+","+values[1]+","+values[2]+","+values[3]+","+values[4]+","+values[5]);
					
					//pw.println(values[0]+","+values[1]+","+values[2]+","+values[3]+","+values[4]+","+values[5]);
					
					saveRecord(values[0],values[1],values[2],values[3],values[4],values[5],tempfile);
				}
				
				
				
			}
		    pw.flush();
		    pw.close();
		    br.close();
		    bw.close();
		    fw.close();
		    
		    oldfile.delete();
		    File dump=new File(fp);
		    newfile.renameTo(dump);
		       		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				 
	}

	public static int searchCsv(String fp,int searchColumnIndex, String searchString) throws IOException {
	   int c=0;
	    BufferedReader br = new BufferedReader(new FileReader(fp));
	    String line;
	    while ( (line = br.readLine()) != null ) {
	        String[] values = line.split(",");
	        if(values[searchColumnIndex].equalsIgnoreCase((searchString))) {
	           c++;
	            break;
	        }
	        
	    }
	    br.close();
	    return c;
	}
	public static void saveRecord(String collegeid, String collegeName, String courseType, String city, String fees,
			String pinCode, String fp) {
		
		try{
			FileWriter fw=new FileWriter(fp,true);
			BufferedWriter bw=new BufferedWriter(fw);
			PrintWriter pw=new PrintWriter(bw);
			pw.println(collegeid+","+collegeName+","+courseType+","+city+","+fees+","+pinCode);
			pw.flush();
			pw.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
