package lab4;

public class Test {
	public static void main(String args[]){
		// Create my MVC components. View and Model should be created first, so they
		// can be passed into my Controller constructor. The Controller can then
		// interact with the View and Model using the public methods in View/Model.
		// Make sure your properties are private in View/Model, and you are using
		// proper get/set methods.
		View MortgageView = new View();
		Mortgage MortgageModel = new Mortgage();
		Controller myController = new Controller(MortgageView, MortgageModel);
		
		//set the JFrame window to visible.
		MortgageView.setVisible(true);
	}
}
