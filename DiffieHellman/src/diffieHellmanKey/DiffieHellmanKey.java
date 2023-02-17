package diffieHellmanKey;
import java.util.Scanner;

public class DiffieHellmanKey {

	public static void main(String[] args) {
		Verification ver=new Verification();
		SecretKey key=new SecretKey();
		
		Scanner userEnter=new Scanner(System.in);
		System.out.print("(p): ");
		ver.setMod(userEnter.nextInt());
		System.out.print("(L): ");
		ver.setBase(userEnter.nextInt());
	
		ver.verification(ver.getBase(), ver.getMod());
		
		System.out.print("(xA): ");
		key.setXA(userEnter.nextInt());
		System.out.print("(xB): ");
		key.setXB(userEnter.nextInt());
		userEnter.close();
		
		System.out.println("Secret key = "+key.secretKey(ver.getBase(), ver.getMod(), key.getXA(), key.getXB()));
		
	}
}
