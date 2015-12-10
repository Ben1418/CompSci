
public class linemeth {
	double distance;
	double my;
	double mx;
	boolean midp = false;
	

	public linemeth(int a, int b, int c, int d){
		distance = 1.0*(Math.sqrt(Math.pow((a-c), 2)+Math.pow((b-d), 2)));
	}
	public linemeth(int a, int b){
		distance = Math.sqrt(Math.pow(a, 2)+Math.pow(b, 2));
	}
	public void midpoint(int a, int b, int c, int d){
		mx = a + c/2.0;
		my = b + d / 2.0;
	}
	public void print(){
		System.out.println("The distance is " + distance);
		if(midp){
			System.out.println("The midpoint is (" + mx + ", " + my + ")");
		}
	}
	

}
