/*Client Code.
 * Testing Class Point. 
 * Public class test is made
 * Scanner is imported to get user input.
 * Accessibility: Public 
 */

import java.util.Scanner;
public class Test {
	/*Class method main
	 * 
	 */
	public static void main(String[] args){
	
	/*Taking user input for all three points 
	 * Using scanner to get input
	 * Input is taken as a souble	
	 */
	Scanner input = new Scanner(System.in);								
	System.out.println("Enter x1 value for point");
	
	double input1X = input.nextDouble();
	
	System.out.println("Enter y1 value for point");
	
	double input1Y = input.nextDouble();
	
	System.out.println("Enter x2 value for point");
	
	double input2X = input.nextDouble();
	
	System.out.println("Enter y2 value for point");
	
	double input2Y = input.nextDouble();
	
	System.out.println("Enter x3 value for point");
	
	double input3X = input.nextDouble();
	
	System.out.println("Enter y3 value for point");
	
	double input3Y = input.nextDouble();
	
	//Three point objects are made using user inputs
	
	Point pointA = new Point(input1X, input1Y);
	
	Point pointB = new Point(input2X, input2Y);
	
	Point pointC = new Point(input3X, input3Y);
	
	Point pointD = new Point();
	
	/*Taking input for delta x
	 * input taken as double
	 */
	
	System.out.println("Enter deltaX");
	double deltaX = input.nextDouble();

	/*Taking input for delta y
	 *input taken as double
	 */
	System.out.println("Enter deltaY");
	double deltaY = input.nextDouble();
	
	/*All three points shifted using instance method move
	 * deltaX and deltaY
	 */
	pointA.move(deltaX, deltaY);
	pointB.move(deltaX, deltaY);
	pointC.move(deltaX, deltaY);
	
	//Distance are calculated between two point using instance method distance 
	
	
	double distance1 = pointA.distance(pointD);
	double distance2 = pointB.distance(pointD);
	
	//Distance are calculated between two point using class method distance
	double distance3 = Point.distance(pointC, pointD);

	/*Taking average of all points to create another point object
	 * point object created as a double
	 */
	double pointAvgx = (pointA.getX() + pointB.getX() + pointC.getX())/3;
	double pointAvgy = (pointA.getY() + pointB.getY() + pointC.getY())/3;
	
	Point pointAvg = new Point(pointAvgx, pointAvgy);
	//All print out statement for statistic on each point
	
	System.out.println("The id of point one is " + pointA.pointId());
	System.out.println("The coordinates of point one is (" + pointA.getX() +","+ pointA.getY()+ ")");
	System.out.println("Point One is " + distance1 + "away from the origin");
	
	System.out.println("The id of point two is " + pointB.pointId());
	System.out.println("The coordinates of point two is (" + pointB.getX() +","+ pointB.getY()+ ")");
	System.out.println("Point One is " + distance2 + "away from the origin");
	
	System.out.println("The id of point three is " + pointC.pointId());
	System.out.println("The coordinates of point three is (" + pointC.getX() +","+ pointC.getY()+ ")");
	System.out.println("Point One is " + distance3 + "away from the origin");
	
	System.out.println("The average coordinates is (" + pointAvg.getX() +","+ pointAvg.getY()+ ")");
	System.out.println("The id of averages point  is " + pointAvg.pointId());
	
	System.out.println("The number of actives is " + Point.active());

	//Setting all point to null.

	pointA = null;
	pointB = null;
	pointC = null;
	
	System.gc();
	System.runFinalization();
	//Printing out the active GC
	System.out.println("The number of actives after GC is " + Point.active());
	input.close();
	}	
	
}

