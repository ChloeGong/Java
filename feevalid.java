package HCMM17S1;

public class feevalid {
	private double fee;
	public feevalid(String s){
	s = s.trim();
	if (!s.startsWith("$")){
		fee=-1;
	}else
		try {
			fee = Double.parseDouble(s.trim().substring(1));
			
		} catch (Exception e) {
			fee=-1;
		}
	}

public boolean isValid(){
	return fee>=0;
}
public String toString(){
	if(isValid()){
return String.format("fee  $%.2f\n", fee);
}
	else return null;
}
}