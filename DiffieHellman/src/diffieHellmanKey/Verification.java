package diffieHellmanKey;
import java.math.BigInteger;

public class Verification {
	private int base, mod; 
	
	public void setBase(int base) {
		this.base=base;
	}
	public int getBase() {
		return base;
	}
	public void setMod(int mod) {
		this.mod=mod;
	}
	public int getMod() {
		return mod;
	}
	
	private boolean checkOnPrime(int mod) {
		if(mod<=1)
			return false;
		for(int i=2; i<mod; i++) {
			if(mod%i==0)
				return false;
		}
		return true;
	}
	
	private int eulerFun(int mod) {
		int result=mod;
		for(int i=2; i*i<=mod; i++) {
			if(mod%i==0) {
				while(mod%i==0) {
					mod/=i;
					result-=result/i;
				}
			}
		}
		if(mod>1)
			result-=result/mod;
		return result;
	}
	
	private boolean checkOriginal(int base, int eulerMod, int mod) {
		int currentMod=eulerMod;
		boolean complete=false;
		
		BigInteger bigBase=BigInteger.valueOf(base);
		BigInteger biMod=BigInteger.valueOf(mod);
		BigInteger exp=new BigInteger("0");
		BigInteger result=new BigInteger("0");
		
		while(complete!=true) {
			complete=true;
			for(int i=2; i<currentMod; i++) {
				if(currentMod%i==0) {
					currentMod/=i;
					exp=BigInteger.valueOf(eulerMod/i);
					result=bigBase.modPow(exp, biMod);
				}
				if(result.intValue()==1) {
					return false;
				}
				complete=false;
			}
		}
		return true;
	}
	
	public void verification(int base, int mod) {
		if(checkOnPrime(mod)==false) {
			System.out.print("Incorrect");
			System.exit(0);
		}
		if(checkOriginal(base, eulerFun(mod), mod)==false) {
			System.out.print("Incorrect");
			System.exit(0);
		}
		else {
			System.out.println("Correct");
		}
	}
}