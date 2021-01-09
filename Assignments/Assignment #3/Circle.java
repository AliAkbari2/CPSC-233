/** Math is imported from default package
 * This is used to calculations in further code
 */

import static java.lang.Math.pow;
/**Class Type: concrete subclass class extends shape
 * Class name: Circle
 * Instructor : Manzara
 * Ta: Edwin Chan
 * @author Ali
 */
public class Circle extends Shape {
	public static double radius;
	public static double originX;
	public static double originY;
	public static double circumference;
	public static double area;
	/**Constructor Circle is made
	 * 	This constructor is used to initialize attributes of circle object
	 * @param radiusVal
	 * @param xVal
	 * @param yVal
	 */
	public Circle(double radiusVal, double xVal, double yVal){
		super(xVal, yVal);
		radius = radiusVal;
	}
	/**Constructor Circle is made
	 * 	This constructor is used to initialize attributes of circle object to 0.0
	 * 
	 */
	public Circle(){
		this(0.0, 0.0, 0.0);
	}
	/**Method setRadius is made
	 * Used to set value for radius of circle object
	 * return type void
	 * @param radiusVal
	 */
	public void setRadius(double radiusVal){
		radius = radiusVal;
	}
	/**Method getRadius is made
	 * Used to get value of circle object radius
	 * @return double
	 */
	public double getRadius(){
		return radius;
	}
	
	/**Method area is made 
	 * This method overrides abstract method area in parent class 
	 * returns a double/ value for area
	 */
	@Override
	public double area() {
		double area;
		area = pow(radius,2) * (Math.PI);
		return area;
	}
	
	/**Method circumference is made 
	 * This method overrides abstract method circumference in parent class 
	 * returns a double/ value for circumference
	 */
	@Override
	public double circumference() {
		double circumference;
		circumference = (2*radius) * (Math.PI);
		return circumference;
	}
	/**Method toString it made
	 * use to print attributes of objects
	 * return type string 
	 */
	public String toString(){
		return super.toString() + " Radius = " + getRadius() + " circumference of circle is = " + circumference() + " Area of circle is = " + area(); 

	}
}