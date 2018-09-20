package HCMM17S1;

import java.util.*;
import java.text.*;
import java.util.*;

public class member {
	private String information;
	private String name;
	private datevalid birthday;
	private String mobile;
	private String pass;
	private feevalid fee;
	private String address;
	private String postcode;
	private String email;

	public member() {
		name = null;
		birthday = null;
		mobile = null;
		pass = null;
		fee = null;
		address = null;
		postcode = null;
		email = null;
	}

	public member(String Info) {
		Scanner information = new Scanner(Info);
		while (information.hasNextLine()) {
			String member = information.nextLine();
			String[] temp = member.trim().split("\\s");
			if (temp[0].equalsIgnoreCase("name")) {
				String nm = "";
				for (int b = 1; b < temp.length; b++) {
					nm = nm + temp[b] + " ";
					name = nm;
				}
			} else if (temp[0].equalsIgnoreCase("birthday"))
				birthday = new datevalid(temp[1]);
			else if (temp[0].equalsIgnoreCase("mobile"))
				mobile = temp[1];
			else if (temp[0].equalsIgnoreCase("pass"))
				pass = temp[1];
			else if (temp[0].equalsIgnoreCase("fee"))
				fee = new feevalid(temp[1]);
			else if (temp[0].equalsIgnoreCase("email"))
				email = temp[1];
			else if (temp[0].equalsIgnoreCase("address")) {
				String add = "";
				for (int a = 1; a < temp.length; a++) {
					add = add + temp[a] + " ";
				}
				address = add;
			} else {
				String addd = "";
				for (int c = 0; c < temp.length; c++) {
					addd = addd + temp[c].trim() + " ";
				}
				address += addd;

			}
		}
	}



	private boolean validName() {
		if (name != null && (name.matches("^[a-zA-Z_\\s+a-zA-Z_ ]+$")
				|| name.matches("^[a-zA-Z_\\s+a-zA-Z_\\s+a-zA-Z_]+$"))) {
			getName();
			return true;
		} else
			return false;
	}

	private boolean validBirthday() {
		return birthday.isValid();

	}

	private boolean validMobile() {
		if (mobile != null && mobile.matches("^\\d{8}")) {
			getMobile();
			return true;
		}

		else
			return false;
	}

	private boolean validPass() {
		if (pass != null && ((pass.equalsIgnoreCase("gold")) || (pass.equalsIgnoreCase("silver"))
				|| (pass.equalsIgnoreCase("bronze")))) {
			getPass();
			return true;
		} else
			return false;
	}

	private boolean validFee() {
		return fee.isValid();

	}

	public boolean validAddress() {
		String Regexadd = "^[0-9]{4}$";
		String[] addr = address.trim().split("\\s+");
		postcode = addr[addr.length - 1];
		if (postcode != null && postcode.matches(Regexadd)) {
			return true;
		} else
			return false;
	}

	public boolean validEmail() {
		String Regexem = "^[A-Za-z0-9][\\w\\-\\.]{3,12}@([\\w\\-]+\\.)+[\\w]{2,3}$";
		if (email.matches(Regexem)) {
			getEmail();

			return true;
		} else
			return false;
	}
	public String getName() {
		return name;
	}

	public datevalid getBirthday() {
		return birthday;
	}

	public String getMobile() {
		return mobile;

	}

	public feevalid getFee() {
		return fee;
	}

	public String getPass() {

		return pass;

	}

	public String getAddress() {
		return address;

	}

	public String getEmail() {

		return email; // String.format("email: %s\n", email);

	}

	public void setName(String n) {
		name = n.trim();
	}
	public void setMobile(String m) {
		m = m.trim();
		mobile = m;
	}

	public void setPass(String p) {
		p = p.trim();
		pass = p;
	}

	public void setFee(feevalid f) {
		 fee=f;
		  
		
	}
	public void setBirthday(String b) {
		datevalid date = new datevalid(b);
		 birthday = date;
	}

	public void setEmail(String e) {
		email = e.trim();
	}

	public void setAddress(String a) {
		address = a.trim();
	}

	public String ValidAddname() {
		if (validName() == true) {
			return "name" + "\t" + name + "\n";
		} else
			return "";
	}

	public String ValidAddmobile() {
		if (validMobile() == true) {
			return "mobile" + "\t" + mobile + "\n";
		} else
			return "";
	}

	public String ValidAddbirth() {
		if (birthday != null && birthday.isValid() == true) {
			return "birthday" + " " + birthday.toString() + "\n";
		} else
			return "";
	}

	public String ValidAddpass() {
		if (pass != null && validPass() == true) {
			return "pass" + "\t" + pass + "\n";
		} else
			return "";
	}

	public String ValidAddfee() {
		if (fee != null && fee.isValid() == true) {
			return fee + "";
		} else
			return "";
	}

	public String ValidAddadd() {
		if (address != null && validAddress() == true) {
			return "address" + " " + address + "\n";
		} else
			return "";
	}

	public String ValidAddemail() {
		if (email != null && validEmail() == true) {
			return "email" + "\t" + email + "\n";
		} else
			return "";
	}

	public String toString() {
		return ValidAddname() + ValidAddbirth() + ValidAddmobile() + ValidAddpass() + ValidAddfee()
				+ ValidAddadd() + ValidAddemail();

	}

	public boolean isValidToAdd() {
		return validName() && validMobile();


	}


}

