import java.util.Scanner;

public class Base2to10 {
	public static void main(String [] args){
		Scanner kb = new Scanner(System.in);
		System.out.println("How many bits");
		int bits = kb.nextInt();
		System.out.println("What base number?");
		int base = kb.nextInt();
		System.out.println("Enter a(n) " + bits + " bit base-" + base + " number");
		String num = kb.next();
		boolean neg = false;
		if(num.charAt(0)=='-'){
			neg = true;
			num = num.substring(1, num.length());
		}
		if(num.length() != bits){
			System.out.println("Thats the wrong number of bits!");
			System.exit(0);
		}
		
		int [] nums = new int[bits];
		for(int i = 0; i < bits; i++){
			nums[i] = Integer.parseInt("" + num.charAt(i));
			if(nums[i] > base-1){
				System.out.println("Nonexistant number");
				System.exit(0);
			}
		}
		
		int b10counter = 0;
		for(int i = 0; i < bits; i++){
			b10counter += nums[bits-i-1]*Math.pow(base, i);
		}
		if(neg == true){
			b10counter *= -1;
		}
		System.out.println("" + b10counter);
	}

}
