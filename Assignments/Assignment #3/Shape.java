/**Class Type: abstract parent class
 * Class name: Shape
 * Instructor : Manzara
 * Ta: Edwin Chan
 * @author Ali
 */
 public abstract class Shape{
	 /*
	  * new point object originPoint is made
	  */
	 static Point originPoint = new Point();
	 /**
	  * Constructor for shape class is made 
	  * Initializes the origin x and y values
	  * @param x
	  * @param y
	  */
	public Shape(double x, double y){
		 originPoint = new Point(x,y); 		
	}
	/**Second constructor for shape class is made 
	 * Used to intialize the x and y values to 0.0
	 */
	public Shape(){
		this(0.0, 0.0);
	}
	/**
	 * setOrigin method is made so that changing 
	 * @param xVal
	 * @param yVal
	 * retruns nothing
	 */
	public void setOrigin(double xVal, double yVal){
		originPoint.setXy(xVal, yVal);
	}
	/**method getOrigin is made
	 * @returns Point reference 
	 */
	public Point getOrigin(){
		return originPoint;
	}
	/**method move is made
	 * takes parameters and moves origin point by adding parameters x and y 
	 * @param deltaX
	 * @param deltaY
	 */
	public void move(double deltaX, double deltaY){
		originPoint.move(deltaX, deltaY);
	}
	/**method distance is made
	 * calculates the distance between two shapes 
	 * @param a
	 * @returns a double
	 */
	public double distance(Point a){
		return originPoint.distance(a);
	}
	/**abstract class area
	 * this class is changed by subclasses
	 * @return
	 */
	public abstract double area();
	/**abstract class area
	 * this class is changed by subclasses
	 * @return
	 */
	public abstract double circumference();
	/**toString method is made 
	 * returns a string
	 */
	public String toString(){
		return "The X value is " + originPoint.getX() + " The Y value is " + originPoint.getY();
	}
	
 }
	 
	 
	 
	 
	 
	 
	 
	 