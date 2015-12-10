import java.util.Scanner;

public class linelength {
	public static void main(String [] args){
		Scanner kb = new Scanner(System.in);
		int a, b, c, d;
		linemeth obj;
		System.out.println("Points or lengths?");
		if(kb.next().equalsIgnoreCase("points")){
			System.out.println("x1:");
			a = kb.nextInt();
			System.out.println("y1:");
			b= kb.nextInt();
			System.out.println("x2:");
			c = kb.nextInt();
			System.out.println("y2:");
			d = kb.nextInt();
			obj = new linemeth(a, b, c, d);
			System.out.println("Do you want a midpoint(y/n)?");
			if(kb.next().equalsIgnoreCase("y")){
				obj.midp=true;
			}
		}else{
			System.out.println("l1:");
			a = kb.nextInt();
			System.out.println("l2:");
			b = kb.nextInt();
			obj = new linemeth(a, b);
		}
		obj.print();
	}


}
