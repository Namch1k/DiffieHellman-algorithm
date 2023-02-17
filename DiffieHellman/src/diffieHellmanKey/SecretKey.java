package diffieHellmanKey;
import java.math.BigInteger;

public class SecretKey {
	private int xA, xB;
	
	public void setXA(int xA) {
		this.xA=xA;
	}
	public int getXA() {
		return xA;
	}
	public void setXB(int xB) {
		this.xB=xB;
	}
	public int getXB() {
		return xB;
	}
	
	private int fakeKey(int base, int mod, int xN) {
		BigInteger bigBase=BigInteger.valueOf(base);
		BigInteger biMod=BigInteger.valueOf(mod);
		BigInteger exp=BigInteger.valueOf(xN);
		BigInteger fakeKey=new BigInteger("0");
		
		fakeKey=bigBase.modPow(exp, biMod);
		
		return fakeKey.intValue();
	}
	public int secretKey(int base, int mod, int xA, int xB) {
		BigInteger bigBase=BigInteger.valueOf(fakeKey(base, mod, xA));
		BigInteger biMod=BigInteger.valueOf(mod);
		BigInteger exp=BigInteger.valueOf(xB);
		BigInteger secretKey1=bigBase.modPow(exp, biMod);
		
		bigBase=BigInteger.valueOf(fakeKey(base, mod, xB));
		exp=BigInteger.valueOf(xA);
		BigInteger secretKey2=bigBase.modPow(exp, biMod);
		
		if(secretKey1.intValue()==secretKey2.intValue())
			return secretKey1.intValue();
		else
			return 0;
	}
}
