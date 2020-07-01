package br.com.sistemawebapp.util;

import java.util.Random;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class CryptUtil {
	private BCrypt bCrypt = null;
	private Random random = new Random();
	
	public CryptUtil() {
		bCrypt = new BCrypt();
	}
	
	private String updateCryp(String cryp) {
		String arrayResult[] = cryp.split("");
		String str = "";
		for(int i = 0; i < arrayResult.length; i++) {
			if(arrayResult[i].equals("/")) {
				arrayResult[i] = ""+i;
				str += arrayResult[i];
			}else {
				str += arrayResult[i];
			}
		}
		
		return str;
	}
	
	public String crypId() {
		int ram = random.nextInt();
		
		String val = "";
		String array[] = String.valueOf(ram).split("");
		for(int i = 0; i < 2;i++) {
			if(!array[i].equals("-") && !array[i].equals(".") && !array[i].equals(",")) {
				val += array[i]; 
			}
		} 
		
		if(Integer.parseInt(val) >= 4 && Integer.parseInt(val) <= 31) {
			return updateCryp(bCrypt.gensalt(Integer.parseInt(val)));
		}
		
		return updateCryp(bCrypt.gensalt(25));
	}
	
	public boolean isCryp(String cryp, String parm) {
		return cryp.equals(parm);
	}
}
