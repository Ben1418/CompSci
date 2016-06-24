package shapes;

public class TriangularPrism extends Triangle{
	double height, volume;
	
	public TriangularPrism(){
		super();
		height = 1;
		volume = area * height;
	}
	
	public void setHeight(double height){this.height=height;}

}
