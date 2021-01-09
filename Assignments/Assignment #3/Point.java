
/**Author: Ali Akbari
 * Assignment 2
 * Instructors : Leonard Manzara
 * Ta: Edwin Chan
 * Program is used to represent points on a Cartesian coordinate system.
 *Importing math as it's used in later calculations
 */
import static java.lang.Math.*;

/**Class point is made.
 * Accessibility: Public 
 */
public class Point {

	/**Initializing class variables
	 * Accessibility: private 
	 */
	
	private static int actives = 0;
	private static int idIncrement = 1;

	/**Initializing instances variables
	 * Accessibility: Public 
	 */
	public double xVal, yVal;
	private int iD = 0;
	
	/**Class method active is made
	 * Accessibility: Public 
	 * @returns active as int
	 */
	public static int active(){
		return actives;
	}
	/**Class method static is made.
	 * Accessibility: Public 
	 * @param pointOne
	 * @param pointTwo
	 * @returns distance as a double
	 */
	public static double distance(Point pointOne, Point pointTwo){
		
	double distance = pointOne.distance(pointTwo);
	
	
	double changeInx = (pointOne.getX()) - (pointTwo.getX());
	double changeIny = (pointOne.getY()) - (pointTwo.getY());
	
	distance = pow(pow(changeInx,2) + pow(changeIny,2), 0.5);
		
	return distance;
	}
	/**Constructor Point is made.
	 * Accessibility: Public 
	 * @param x
	 * @param y
	 * Accessibility: Public 
	 */
	public Point(double x, double y){
	xVal = x;
	yVal = y;
	iD = idIncrement;
	actives ++;
	idIncrement++;
	}
	/**Constructor Point is made.
	 * Takes no parameters
	 * Uses above constructor to set values to (0.0,0.0) 
	 * Accessibility: Public 
	 */
	public Point(){
		this(0.0, 0.0);
	}
	/**Instance Method id made.
	 *Nothing is returned
	 * @param xSet
	 * @param ySet
	 * Accessibility: Public 
	 */
	public void setXy(double xSet, double ySet){
	xVal = xSet;
	yVal = ySet;
	}
	/**Instance method setX is made
	 * Accessibility: Public 
	 * @param xSet
	 */
	public void setX(double xSet){
	xVal = xSet;
	}
	/**Instance method setY is made.
	 * Accessibility: Public 
	 * @param ySet
	 */
	public void setY(double ySet){
	yVal = ySet;
	}
	/**Instance method getX is made.
	 * Accessibility: Public 
	 * @returns double xVal.
	 */
	public double getX(){
	return xVal;
	}
	/**Instance method getY is made.
	 * Accessibility: Public 
	 * @returns double yVal
	 */
	public double getY(){
	return yVal;
	}
	/**Instance  method move is made.
	 * Accessibility: Public 
	 * @param deltaX
	 * @param deltaY
	 */
	public void move(double deltaX, double deltaY){
	xVal = xVal + deltaX;
	yVal = yVal + deltaY;
	}
	/**Instance distance is made.
	 * Calculates the distance between two points
	 * Accessibility: Public 
	 * @param pointA
	 * @returns double distance
	 */
	public double distance(Point pointA){
	double changeInx = xVal - (pointA.getX());
	double changeIny = yVal - (pointA.getY());		
	double distance = pow(pow(changeInx,2) + pow(changeIny,2), 0.5);	
	return distance;
	}
	/**Instance method pointId is made.
	 * Accessibility: Public 
	 * @returns int iD
	 */
	public int pointId(){
	return iD;
	}

	/**Instance method finalize is made.
	 * Accessibility: protected
	 * decrements actives	
	 */
	protected void finalize() throws Throwable{
		super.finalize();
		actives--;
	}	
}