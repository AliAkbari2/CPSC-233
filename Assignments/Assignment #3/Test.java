
/** Scanner is imported from default package
 * This is used to take user input in further code
 */
import java.util.Scanner;
import java.util.ArrayList;
/**Class Type: final class Test
 * Class name: Circle
 * Instructor : Manzara
 * Ta: Edwin Chan
 * @author Ali
 */
public final class Test {

	/**Main method
	 * @param args
	 */
	public static void main(String[] args) {
		boolean doWhilechecker = true; // This checker is made for the do while loop, to end the loop
		ArrayList<Shape> shapeArray = new ArrayList<Shape>();//Arraylist made to store shape objects 
		
		//This do while runs and keeps asking user for input
		do{
			//variable is assign to the size of array
			int lengthOfarray = shapeArray.size();
			//Scanner is made to take user input 
			Scanner input = new Scanner(System.in);
			//User list of options
			System.out.println("Please choose an option (1-9):" 
			+	"\n1 - Create a shape."
			+	"\n2 - Set the origin of a shape."
			+	"\n3 - Set the dimensions for a shape."
			+	"\n4 - Display the state of a shape."
			+	"\n5 - Move a shape."
			+	"\n6 - Find the distance between two shapes."
			+	"\n7 - Remove a shape."
			+	"\n8 - List the state of all shapes."
			+	"\n9 - Quit.");
		
			//UserPickofList is initialized to what user pick from list
			int UserPickofList = input.nextInt();
			
			//If UserPickofList is equal to 1 follow this if statement 
			if (UserPickofList == 1){
				//This choice from the list make shape object, user picks if they want circle or rectangle created				
				System.out.println("Enter 1 to create a circle or 2 to create a rectangle");
				int input2 = input.nextInt();
				//checker made for do while
				boolean checker1 = true;
				do{
					//If user picks circle to be created
					if(input2 == 1){
						Circle circle1 = new Circle();
						System.out.println("Created Circle");
						shapeArray.add(circle1); // shape stored into the arraylist
						checker1 = false;//To exit out of do while loop
					}
					//If user picks rectangle to be created
					else if(input2 == 2){
						Rectangle rectangle1 = new Rectangle();
						System.out.println("Created Rectangle");
						shapeArray.add(rectangle1);// shape stored into the arraylist
						checker1 = false;//To exit out of do while loop
					}else{
						System.out.println("Invalid choice");//if user enters wrong index
						checker1 = false;//To exit out of do while loop
					}

				}while(checker1);
			}
			/*If user pick #2 from the list do the following
			 * This option lets the user to pick a shape and change it's origin point
			 */
			if (UserPickofList == 2){
				
				System.out.println("Which shape would you like to set the origin? Enter an index of Arraylist.");
				int input3 = input.nextInt();
				
				if((input3 - 1 >= 0)&(input3 -1  <= shapeArray.size()-1)){
					System.out.println("Enter the x value for the origin of the shape");
					double input3x = input.nextDouble();
					System.out.println("Enter the y value for the origin of the shape");
					double input3y = input.nextDouble();
				
					System.out.println("Set the origin of the shape to (" + input3x+ " ," + input3y + ")");
					Shape shape1 = shapeArray.get(input3 - 1);	
					shape1.setOrigin(input3x, input3y);
				}
				else{
					System.out.println("Invalid index, try again");//if user enters wrong index
				}

			}
			/*If user picks #3 from list do the following
			 * This option lets the user change the dimensions of object
			 */
			if (UserPickofList == 3){
				System.out.println("Which shape would you like to set the dimensions of? Enter an index of Arraylist.");
				//User is asked which object they want from the arraylist to change dimensions
				int input4 = input.nextInt();
				
				if(0 <= input4 & input4 <= lengthOfarray){
					
					Shape shapeType = shapeArray.get(input4 - 1);//Using user input to take out objects stored in arraylist to change dimensions of
					
					if (shapeType instanceof Circle){//checks if object is Circle
					
					System.out.println("Enter the value for the radius of the Circle");
					
					double input4x = input.nextDouble();
					
					System.out.println("Set the radius of the Circle to (" + input4x + " )");
					Circle shapeCircle = (Circle) shapeArray.get(input4 - 1);	
					shapeCircle.setRadius(input4x);//using setRadiusmethod from circle class
					}
					
					if (shapeType instanceof Rectangle ){//checks if object is rectangle
						
						Rectangle shapeRectangle = (Rectangle) shapeArray.get(input4 -1);	
						
						System.out.println("Enter the value for the length of the Rectangle");
						
						double input4l = input.nextDouble();
						
						System.out.println("Set the length of the Rectangle to (" + input4l + ")");
						shapeRectangle.setSizelength(input4l);//using setSizelength method from rectangle class
									
						
						System.out.println("Enter the value for the width of the Rectangle");
						
						double input4w = input.nextDouble();
						
						System.out.println("Set the width of the Rectangle to (" + input4w + ")");
						shapeRectangle.setSizewidth(input4w);//using setSizewidth method from rectangle class
					
					}
			

				}else{
					System.out.println("Invalid index, try again");//if user enters wrong index
					}
			}
			/*If user pick #4 from the list do the following
			 * This option print a single object state and attributes
			 */
			if (UserPickofList == 4){
				
				
				System.out.println("There are " + lengthOfarray + " Shapes choose one to display current state"); 
				
				int input5 = input.nextInt();
				if(0 <= input5 &input5 <= lengthOfarray){
					Shape shapeType = shapeArray.get(input5 -1); 
				
					if(shapeType instanceof Circle ){//checks if object is circle
						System.out.println("Type: Circle\t " + shapeType.toString());//prints the current state and attributes
					}
				
					if(shapeType instanceof Rectangle ){//checks if object is rectangle
						System.out.println("Type: Rectanlge\t " + shapeType.toString());//prints the current state and attributes
					}
				}else{
					System.out.println("Invalid index, try again");//if user enters wrong index
					}			
			}
			/*If user pick # 5 from the list do the following
			 * This option moves origin points of shape
			 * user is asked for deltax and deltay 
			 */
			if (UserPickofList == 5){
				if (lengthOfarray == 0){
					System.out.println("There are no shapes to choose to move make some shapes");
				}else{
					System.out.println("There are " + lengthOfarray + " Shapes choose one to move");
					int input6 = input.nextInt();
					Shape shapeType = shapeArray.get(input6 - 1);//Using array to get the shape the user wants to move
				
					if(shapeType instanceof Circle ){
					
						System.out.println("How much do you want to move by for x?");
						double input6cx = input.nextDouble();
						double xVal = Circle.originX;
						xVal = xVal + input6cx;
						System.out.println("Delta x is " + xVal );
						
					
						
						System.out.println("How much do you want to move by for y?");
						double input6cy = input.nextDouble();
						double yVal = Circle.originY;
						yVal = yVal + input6cy;
					
						System.out.println("Delta y is " + yVal );
					
						shapeType.move(input6cx, input6cy);//move method used from parent class
					
						System.out.println("Origin is moved to (" + xVal +"," +yVal+ ")" );//print the new origin point values
					}
					
					if(shapeType instanceof Rectangle ){
						
						System.out.println("How much do you want to move by for x?");
						double input6rx = input.nextDouble();
						double xVal = Rectangle.originX;
						xVal = xVal + input6rx;
						System.out.println("Delta x is " + xVal );
						
					
						
						System.out.println("How much do you want to move by for y?");
						double input6ry = input.nextDouble();
						double yVal = Rectangle.originY;
						yVal = yVal + input6ry;
					
						System.out.println("Delta y is " + yVal );
					
						shapeType.move(input6rx, input6ry);//move method used from parent class
					
						System.out.println("Origin is moved to (" + xVal +"," +yVal+ ")" );//print the new origin point values
					}
				
				}
				
			}
			/*If user picks #6 from the list do the following 
			 * This option calculates the distance between two shapes 
			 */
			if (UserPickofList == 6){
				if (lengthOfarray == 0){
					System.out.println("There are no shapes to choose to move make some shapes");
				}else{
				
					System.out.println("There are" + lengthOfarray + " Shapes choose two to find the distance between each of them");
		
					System.out.println("Choose the first shape");
					int input7 = input.nextInt();
				
					if((input7 >= 1) & (input7 <= lengthOfarray)){
				
						System.out.println("Choose the second shape");
						int input7b = input.nextInt();
					
						if((input7b >= 1) & (input7b <= lengthOfarray)){
							double distance = shapeArray.get(input7 - 1).distance((shapeArray.get(input7 - 1)).getOrigin());//Use distance method from parent class
							System.out.println("The Distance between the two shapes are " + distance);//Print the distance to the console
						}
					}	
				}	
				
				
				
			
	
			}
			/*If user picks # 7 from the list do the following 
			 * This option removes array elements
			 * The elements index is users choice
			 */
			if (UserPickofList == 7){
				System.out.println("There are " + lengthOfarray + " Shapes which one would you like to delete?");
				int input8 = input.nextInt();
				
				if((input8 >= 1) & (input8 <= lengthOfarray)){
					shapeArray.remove(input8 - 1);
				}
				int lengthofArray1 = shapeArray.size();
				System.out.println("There are " + lengthofArray1 + " shapes left");
	
			}

			
			/*If user pick # 8 from the list do the following
			 *This option print all circle and rectangle objects and their attributes 
			 */
			if(UserPickofList == 8){
				if (lengthOfarray != 0){ 
					for (int i = 0; i <= lengthOfarray - 1; i++){
						Shape shapeType = shapeArray.get(i);
						
						if (shapeType instanceof Circle){
							System.out.println("Type: Circle\t " + shapeArray.get(i).toString());
						}
					
						if(shapeType instanceof Rectangle ){
							System.out.println("Type: Rectanlge\t " + shapeArray.get(i).toString());
						}
					}
				}
				else{
					System.out.println("There are no shapes in the array, create some.");
			
				}
			}
			
				
	

			// I user picks #9 from list do the following
			//This option exits out of do while loop, and program stops running
			if (UserPickofList == 9){
				doWhilechecker = false;//checker is used to exit out of loop
				System.out.println("Program closed.");
				return;//return is used just in case user want to exit for first option
			}
			
			
				
		}while(doWhilechecker = true);//while expression for do while loop
		
		
	
	}
}	
	
	
		
	
		

		