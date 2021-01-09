/**Class Type: concrete subclass class extends shape
 * Class name: Rectangle
 * Instructor : Manzara
 * Ta: Edwin Chan
 * @author Ali
 */
public class Rectangle extends Shape {
	public static double length;
	public static double width;
	public static double originX;
	public static double originY;
	public static double circumference;
	public static double area;
	/**Constructor Rectangle is made 
	 * parameters sent to initialize attributes of rectangle 
	 * @param lengthVal
	 * @param widthVal
	 * @param xVal
	 * @param yVal
	 */
	public Rectangle(double lengthVal, double widthVal, double xVal, double yVal){
		super(xVal, yVal);
		length = lengthVal;
		width = widthVal;
	}
	/**Constructor Rectangle is made
	 * This constructor initializes attribute to o
	 */
	public Rectangle(){
		super();
		length = 0.0;
		width = 0.0;
	}
	/**Method setSizelength is made
	 * return type void
	 * this method is use for setting the value of length of rectangle object
	 * @param lengthVal
	 */
	public void setSizelength(double lengthVal){
		length = lengthVal;
	}
	/**Method setSizewidth is mad
	 * return type void
	 * this method is use for setting the value of width of rectangle object
	 * @param widthVal
	 */
	public void setSizewidth(double widthVal){
		width = widthVal;
	}
	/**Method setSizeboth is made
	 * return type void
	 * this method is use for setting the values of length and width of rectangle object
	 * @param lengthVal
	 * @param widthVal
	 */
	public void setSizeboth(double lengthVal, double widthVal){
		length =lengthVal;
		width = widthVal;
	}
	/**Method getSizelength is made
	 * return type double/ value of length
	 * @returns double 
	 */
	public double getSizelength(){
		return length;
	}
	/**Method getSizewidth is made
	 * return type double/ value of width
	 * @return
	 */
	public double getSizewidth(){
		return width;
	}
	
	/**Method area is made
	 * This method overrides the abstract method area in parent class
	 * return type double/ value of area
	 */
	@Override
	public double area() {
		double area = length * width;
		return area;
	}
	/**Method circumference is made
	 * This method overrides the abstract method circumference in parent class
	 * return type doubleé value of circumference
	 */
	@Override
	public double circumference() {
		double circumference = (2 * length) + (2 * width);
		return circumference;
	}
	/**Method toString it made
	 * use to print attributes of objects
	 * return type string 
	 */
	public String toString(){
		return super.toString() + " Lenght= " + getSizelength() + " Width " + getSizewidth() + " primeter of rectangle is = " + circumference() + " Area of rectangle is = " + area();
		}
}