
public class PrimeDriver {
	public static void main(String [] args){
		while(true){
			try{
				PrimeMethods obj = new PrimeMethods();
				obj.input_1();
				obj.operate();
			}catch(NullPointerException ex){
				System.exit(0);
			}
		}
	}

}
