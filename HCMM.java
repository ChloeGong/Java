package HCMM17S1;

import java.io.*;
import java.util.*;

public class HCMM {
	public static void main(String[] args) {
		if(args.length==4){
		writefile F = new writefile(args);
		F.readMember();
		F.readInstruction();
		F.saveResult();
		F.saveReport();
		}
	}

}


