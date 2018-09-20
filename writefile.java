package HCMM17S1;

import java.io.*;
import java.util.*;

public class writefile {
	private File readmember;
	private File inputfile;
	private File outputfile;
	private File reportfile;
	private Person person;

	public writefile(String[] s) {// 如何调用？
		readmember = new File(s[0]);
		inputfile = new File(s[1]);
		outputfile = new File(s[2]);
		reportfile=new File(s[3]);
		person = new Person();
	}

	public void readMember() {

		try {

			Scanner scn = new Scanner(readmember);
			String sum = "";
			while (scn.hasNextLine()) {
				String sc = scn.nextLine();
				sum = sum + sc + "\n";
			}
			// System.out.print(sum);
			String[] people = sum.trim().split("[\n]{2,}");// 以空行为分割；"[\n]{2,}"
			for (int a = 0; a < people.length; a++) {
				String p = people[a];// 某一个人的信息；
			     person.addPerson(p);
			}

		} catch (Exception e) {
			System.out.print("Error" + e.getMessage());
		}
	}

	public void saveResult() {
		try {
			PrintWriter out = new PrintWriter(new FileOutputStream(outputfile));
			out.println(person.toString());
			out.close();
		System.out.println("inputs written into result successfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void saveReport() {
		try {
			PrintWriter out = new PrintWriter(new FileOutputStream(reportfile));
			out.println(person.queryToString());
			//System.out.println("query="+"\n"+person.queryToString());
			out.close();
		System.out.println("inputs written into report successfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readInstruction() {
		try {
			Scanner scan = new Scanner(inputfile);//instruction 文件；
			while (scan.hasNextLine()) {
				String instruction = scan.nextLine();// 每一行
				Scanner sc = new Scanner(instruction);
				String keyword, param;
				if (sc.hasNext()) {
					keyword = sc.next();
					if (sc.hasNextLine()) {  
                          param = sc.nextLine();
               			   if (keyword.equalsIgnoreCase("add")) {
               				 String[]temp=param.trim().split(";");
	                          String sum="";//分割param的为不同的属性
	                          for(int j=0;j<temp.length;j++){
	                        	  sum=sum+temp[j]+"\n";}
		                        	  person.addPerson(sum);
						    
	                       }
						 else if (keyword.equalsIgnoreCase("delete")){ 
							 person.removePerson(param);
							
						   }
						
					  else if (keyword.equalsIgnoreCase("sort")){ 
							 person.sortPerson();
							
						   }
						
					  else if (keyword.equalsIgnoreCase("query"));{
						   person.queryPerson(param);
   					       }
						
					}
				else continue;
					sc.close();
				
		     }
				else continue;

			}
			scan.close();
		
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
