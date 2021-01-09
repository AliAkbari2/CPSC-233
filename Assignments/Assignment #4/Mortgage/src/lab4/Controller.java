package lab4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * This program is based of TA Edwin's Sample Code
 * Although not entirely the same, I have asked before hand to use his code, he had agree with it.
 * This is the Controller class part of MVC, used to connect my view class and model class
 * This class also has listeners connected to GUI components   
 * Instructor : Leonard Manzara
 * @author Ali Akbari
 */

public class Controller {
	//Initializing  View and Model Objects
	private View MortgageView;
	private Mortgage MortgageModel;
	
	/**
	 * Constructor for my Controller, takes my View and my Model so that I can link the two
	 * with the Controller. With my View, I get/set values from my elements, such as labels,
	 * text fields, combo boxes, radio buttons, etc. I also attach the listeners to my
	 * UI elements. With my Model, I use get/set methods to manipulate my object (Mortgage).
	 * If there are Mortgage-specific methods, these can be added in the Mortgage, otherwise
	 * the logic part of my program should be in here, the Controller. 
	 * @param MortgageView
	 * @param MortgageModel
	 */
	public Controller(View MortgageView, Mortgage MortgageModel){
		// View and Model
		this.MortgageView = MortgageView;
		this.MortgageModel = MortgageModel;
				
		// Attach listeners using methods from the View
		MortgageView.attachWindowListener(new myWindowAdapter());
		MortgageView.attachComboBoxListener(new myComboBoxListener());
		MortgageView.attachRadioButtonListener(new myRadioButtonListener());
		MortgageView.attachButtonListener(new myButtonListener());
	}
	
	// We could implement the WindowListener, but it's simpler to extend WindowAdapter so that
	// we don't have to implement all 7 WindowEvents.
	private class myWindowAdapter extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			// If we close the JFrame window, exit the program.
			System.exit(0);
		}
	}
	
	
	// This is the handler for my PaymentFrequency combo box.
	private class myComboBoxListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// The user selected one of the payment frequency options in my combo box,
			// I should store this value in the model immediately.
			MortgageModel.setPaymentFrequency(MortgageView.getSelectedComboBox());
		}
	}
	
	// This is the handler for my interest compounding frequency radio buttons.
	// NOTE: This handler is attached to EACH of my radio buttons. When the user
	// selects one of the radio buttons, "e" will contain information about the
	// radio button which triggered this event. I can then get the option name
	// (eg. "monthly", "weekly", etc.) and store that to my Model.
	private class myRadioButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			// Store selected interest compounding frequency option into my model.
			MortgageModel.setCompoundingFrequency(e.getActionCommand());
		}
	}
	
	// This is the handler for my Calculate button.
	private class myButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) { 
			// Calculate button was clicked by user
			
			// Get all the user inputs that haven't been stored to my Model already,
			// because I will need them for my results later.
			MortgageModel.setNumberOfPayments(MortgageView.getNumberOfPayments());
			MortgageModel.setTotalPrincipal(MortgageView.getPrincipal());
			MortgageModel.setAnnualInterestRate(MortgageView.getAnnualInterestRate());
			MortgageModel.setInterestFactor(MortgageView.getAnnualInterestRate(), MortgageModel.getCompoundingFrequency(), MortgageModel.getPaymentFrequency());
			MortgageModel.setBlendedAmount(MortgageView.getPrincipal(), MortgageModel.getInterestfactor(), MortgageView.getNumberOfPayments());
			MortgageModel.setTotalInterestAndPrincipal(MortgageModel.getBlendedAmount(), MortgageModel.getNumberOfPayments());
			MortgageModel.setTotalInterest(MortgageModel.getTotalInterestAndPrincipal(), MortgageModel.getTotalPrincipal());
			MortgageModel.setPrincipalInterestRatio(MortgageModel.getTotalInterest(), MortgageModel.getTotalPrincipal());
			MortgageModel.setInterestPerYear(MortgageModel.getTotalInterest(), MortgageModel.getNumberOfPayments());
			MortgageModel.setAverageInterestMonthly(MortgageModel.getTotalInterest(), MortgageModel.getNumberOfPayments());
			MortgageModel.setAmortization(MortgageModel.getNumberOfPayments());
			// Get the results from my model, and display them in my View using setResults().
			// Not all values have to be stored to the Model, just store the useful ones for
			// calculating the results (plus bonus).
			MortgageView.setResults(String.format("<html>You will make %s payments, "
					+ "on a %s basis. "
					+ "Interest is compounded %s." + 
					"<br>Total Principal is: %s" + 
					"<br>Annual Interest Rate is: %s" +
					"<br>Interest Factor is: %s" + 
					"<br>Blended Payment is: %s" +
					"<br>Total interest plus principal is: %s" + 
					"<br>Total interest paid is: %s" +
					"<br>Interest and principal ratio is: %s" + 
					"<br>Interest average per year is: %s" +
					"<br>Interest average monthly is: %s" +
					"<br>The amortization express in years is: %s<html>",
					MortgageModel.getNumberOfPayments(),
					MortgageModel.getPaymentFrequency(), 
					MortgageModel.getCompoundingFrequency(), 
					MortgageModel.getTotalPrincipal(),
					MortgageModel.getAnnualInterestRate(),
					MortgageModel.getInterestfactor(),
					MortgageModel.getBlendedAmount(),
					MortgageModel.getTotalInterestAndPrincipal(),
					MortgageModel.getTotalInterest(),
					MortgageModel.getPrincipalInterestRatio(),
					MortgageModel.getInterestPerYear(),
					MortgageModel.getAverageInterestMonthly(),
					MortgageModel.getAmortization()));
					
		}
	}
	
}
