package HCMM17S1;

import java.lang.reflect.Array;
import java.util.*;

public class Person {
	private ArrayList<member> person;
	public StringBuilder queryPerson;//= new StringBuilder();
	public Person() {
		person = new ArrayList<member>();
		queryPerson=new StringBuilder();
	}

	public void addPerson(String p) {
		String name = "";
		String mobile = "";
		
		member information = new member(p);
		if (information.isValidToAdd()){ 
			boolean exist = true;
				for(member m : person){
					if(m.getName().trim().equalsIgnoreCase(information.getName().trim()) && m.getMobile().trim().equals(information.getMobile().trim())){
						if(information.getBirthday()!= null){
							m.setBirthday(information.getBirthday().toString());
						}
						if(information.getFee()!= null){
							m.setFee(information.getFee());//m.setFee(feevalid fee)
						}
						if(information.getPass()!= null){
							m.setPass(information.getPass());
							
						}
						if(information.getEmail()!= null){
							m.setEmail(information.getEmail());
							
						}
						if(information.getAddress()!= null){
							m.setAddress(information.getAddress());
							
						}
						exist=false;
					}					
					}	
				if (exist == true){
					person.add(information);
				}
				
			}
		}
			
	public void removePerson(String p) {
		String[]temp = p.trim().split(";");
		String name = temp[0].trim();
		String mobile = temp[1].trim();
			for (int i = 0; i < person.size(); i++){
				if (person.get(i).getName().trim().equalsIgnoreCase(name) && person.get(i).getMobile().trim().equals(mobile)) {
					person.remove(i);
				}
				else continue;
			}
		}
	


	public void sortPerson() {
		ArrayList<member>list=person;
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				String name1 = list.get(i).getName();
				String mobile1 = list.get(i).getMobile();
				String name2 = list.get(j).getName();
				String mobile2 = list.get(j).getMobile();
				String tempName1 = name1.replaceAll("\\s", "");
				String tempName2 = name2.replaceAll("\\s", "");
				if (tempName1.compareTo(tempName2) > 0) {
					member temp = new member();
					temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				} else if (tempName1.compareTo(tempName2) == 0) {
					if (Integer.parseInt(mobile1) > Integer.parseInt(mobile2)) {
						member temp = new member();
						temp = list.get(i);
						list.set(i, list.get(j));
						list.set(j, temp);
					}
				}
			}
		}
	}
	public void sort(ArrayList<member> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				String name1 = list.get(i).getName();
				String mobile1 = list.get(i).getMobile();
				String name2 = list.get(j).getName();
				String mobile2 = list.get(j).getMobile();
				String tempName1 = name1.replaceAll("\\s", "");
				String tempName2 = name2.replaceAll("\\s", "");
				if (tempName1.compareTo(tempName2) > 0) {
					member temp = new member();
					temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				} else if (tempName1.compareTo(tempName2) == 0) {
					if (Integer.parseInt(mobile1) > Integer.parseInt(mobile2)) {
						member temp = new member();
						temp = list.get(i);
						list.set(i, list.get(j));
						list.set(j, temp);
					}
				}
			}
		}
	}
	public void queryPerson(String p){////query 从这里开始
		 ArrayList<member> queryPass;
		 queryPass=new ArrayList<member>();
		 p=p.trim();
		 if(p.trim().equalsIgnoreCase("pass bronze"))	{
			 int i=0;
			 double total=0.0;
			 double Fee=0.0;
			 String fee=null;
			 while(i<person.size()){
				 if(person.get(i).getPass()!=null&&person.get(i).getPass().trim().equalsIgnoreCase("bronze")){
					 if(person.get(i).getFee()!=null)
					 fee=person.get(i).getFee().toString();//feevalid
					 String[]temp=fee.trim().split("\\$");
					 Fee=Double.parseDouble(temp[temp.length-1]);//
					 //System.out.println("Fee="+Fee);
					 total=total+Fee;
					 queryPass.add(person.get(i));
					 }
				 i++;
				 }
			 if(queryPass.size()>1){
				ArrayList<member>list=queryPass;
				 sort(queryPass);
			 }
			 StringBuilder sb=new StringBuilder();
			 sb.append("----"+"query "+p+"----"+"\n");
			 for(member m: queryPass){
				 sb.append(m.toString()+"\n");
			 }
			 String F= String.format("Total Fee:$%.2f\n", total);
			 sb.append(F+"-------------------------"+"\n"+"\n"+"\n");
			 queryPerson.append(sb.toString());
			 }
		 
		 else if(p.trim().equalsIgnoreCase("pass silver"))	{
			 int i=0;
			 double total=0.0;
			 double Fee=0.0;
			 String fee=null;
			 while(i<person.size()){
				 if(person.get(i).getPass()!=null&&person.get(i).getPass().trim().equalsIgnoreCase("silver")){
					 if(person.get(i).getFee()!=null)
					 fee=person.get(i).getFee().toString();//feevalid
					 String[]temp=fee.trim().split("\\$");
					 Fee=Double.parseDouble(temp[temp.length-1]);//
					 //System.out.println("Fee="+Fee);
					 total=total+Fee;
					 queryPass.add(person.get(i));
					 }
				 i++;
				 }
			 if(queryPass.size()>1){
				ArrayList<member>list=queryPass;
				 sort(queryPass);
			 }
			 StringBuilder sb=new StringBuilder();
			 sb.append("----"+"query "+p+"----"+"\n");
			 for(member m: queryPass){
				 sb.append(m.toString()+"\n");
			 }
			 String F= String.format("Total Fee:$%.2f\n", total);
			 sb.append(F+"-------------------------"+"\n"+"\n"+"\n");
			 queryPerson.append(sb.toString());
			 }
			 
		  else if(p.trim().equalsIgnoreCase("pass gold"))	{
			 int i=0;
			 double total=0.0;
			 double Fee=0.0;
			 String fee=null;
			 while(i<person.size()){
				 if(person.get(i).getPass()!=null&&person.get(i).getPass().trim().equalsIgnoreCase("gold")){
					 if(person.get(i).getFee()!=null)
					 fee=person.get(i).getFee().toString();//feevalid
					 String[]temp=fee.trim().split("\\$");
					 Fee=Double.parseDouble(temp[temp.length-1]);//
					 //System.out.println("Fee="+Fee);
					 total=total+Fee;
					 queryPass.add(person.get(i));
					 }
				 i++;
				 }
			 if(queryPass.size()>1){
				ArrayList<member>list=queryPass;
				 sort(queryPass);
			 }
			 StringBuilder sb=new StringBuilder();
			 sb.append("----"+"query "+p+"----"+"\n");
			 for(member m: queryPass){
				 sb.append(m.toString()+"\n");
			 }
			 String F= String.format("Total Fee:$%.2f\n", total);
			 sb.append(F+"-------------------------"+"\n"+"\n"+"\n");
			 queryPerson.append(sb.toString());
			 }
		 else if(p.equalsIgnoreCase("age fee"))	{
			 String birthday="";
			 String year="";
			String fee;
			double a=0.0,b=0.0,c=0.0,d=0.0,e=0.0;
	       for(int i = 0;i<person.size();i++){
		    double Fee=0;int age=0;
			 if(person.get(i).getFee()!=null){
				 fee=person.get(i).getFee().toString();
				String Fe= fee.toString();
				 String[]temp=fee.trim().split("\\$");
				 Fee=Double.parseDouble(temp[temp.length-1]);
	               if(person.get(i).getBirthday()!=null){
			        birthday=person.get(i).getBirthday().toString();
			        String[]birth=birthday.trim().split("\\D");
			        if(birth.length==3){ 
			    	 year=birth[2];
			      age=2017-Integer.parseInt(year);
			      if(age<=8) a=a+Fee;
			      else if(age>8&&age<=18) b=b+Fee;
			      else if(age>18&&age<=65) c=c+Fee;
			      else if(age>65) d=d+Fee;
			      
			             }
			          }
	               else if(person.get(i).getBirthday()==null&&person.get(i).getFee()!=null)	e=e+Fee;
			       }
			    
			 //System.out.print("Fee:"+Fee);
	 }
	 StringBuilder sb=new StringBuilder();
	 sb.append("----"+"query "+p+"----"+"\n");
     String A= String.format("(0,8]:$%.2f\n", a);
     String B= String.format("(8,18]:$%.2f\n", b);
     String C= String.format("(18,65]:$%.2f\n", c);
     String D= String.format("(65,-):$%.2f\n", d);
     String E= String.format("Unknown:$%.2f\n", e);
     sb.append("Total Club Member size: "+person.size()+"\n");
     sb.append("Age based fee income distribution"+"\n");
     sb.append(""+A);
     sb.append(""+B);
     sb.append(""+C);
     sb.append(""+D);
     sb.append(""+E);
	 sb.append("---------------------");
	queryPerson.append(sb.toString());
    } 
}	 
	public String queryToString() {

		return queryPerson.toString();
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (member information : person) {
			sb.append(information.toString());
			sb.append("\n\n");
		}
		return sb.toString();
	}

	public ArrayList<member> getPerson() {
		return person;
	}

	

	public void setPerson(ArrayList<member> person) {
		this.person = person;
	}
}
