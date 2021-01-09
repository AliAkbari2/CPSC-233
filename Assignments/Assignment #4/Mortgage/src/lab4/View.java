package lab4;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;

/**
 * 
 * 
 * This program is based of TA Edwin's Sample Code
 * Although not entirely the same, I have asked before hand to use his code, he had agree with it.
 * This is the View class part of MVC, this class all the UI, the graphical interface with UI logic 
 * This class also extends JFrame to create a window, and all of my
 * layouts and elements are defined here. 
 * Instructor : Leonard Manzara
 * @author Ali Akbari
 */

public class View extends JFrame {
	// All of the UI elements are defined here. You can make subclasses for groups of elements
	// such as a JPanel with multiple labels/buttons if you want, but it's not required.
	
	//// Number of Payments (text field example) ////
	private JLabel lblNumberOfPayments = new JLabel("Number of payments:");
	private JTextField txtNumberOfPayments = new JTextField("60", 10);
	//Principal label and textFields
	private JLabel lblPrincipal = new JLabel("Total Principal:");
	private JTextField txtPrincipal = new JTextField("300000", 10);
	//Annual Interest Rate label and text field
	private JLabel lblAnnualInterestRate = new JLabel("Interest Rate:");
	private JTextField txtAnnualInterestRate = new JTextField("0.045", 10);
	
	//// Payment Frequency (combo box example) ////
	private JLabel lblPaymentFrequency = new JLabel("Frequency of payments:");
	String[] paymentFrequencyStrings = {"weekly", "bi-weekly", "monthly"};
	private JComboBox<String> cbPaymentFrequency = new JComboBox<String>(paymentFrequencyStrings);
	
	//// Interest Compounding Frequency (radio buttons example) ///
	private JLabel lblCompoundFrequency = new JLabel("Compounding frequency:");
	private ButtonGroup grpCompoundFrequency = new ButtonGroup();
	private JRadioButton rbCompoundFrequencyDaily = new JRadioButton("daily");
	private JRadioButton rbCompoundFrequencyWeekly = new JRadioButton("weekly");
	private JRadioButton rbCompoundFrequencyMonthly = new JRadioButton("monthly");
	private JRadioButton rbCompoundFrequencySemiAnnual = new JRadioButton("semi-annually", true);
	
	//// Calculate/Results (button example) ////
	private JButton btnCalculate = new JButton("Calculate");
	private JLabel lblResults = new JLabel("Results will go here after clicking Calculate.");

	public View() {
		// call the super() constructor to create a JFrame
		super();
		// set the JFrame/window properties
		// note the grid layout; 4 rows, 1 column, 20 padding
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(800, 400));
		this.setLayout(new BorderLayout(15,15));
		this.setTitle("Mortgage Calculator");
		
		// Our JFrame grid is going to contain 4 JPanels
		JPanel textFieldPanel = new JPanel();
		JPanel comboBoxPanel = new JPanel();
		JPanel radioPanel = new JPanel();
		JPanel resultPanel = new JPanel();
		
		// Here we set the layouts for the four JPanels
		textFieldPanel.setLayout(new GridLayout(3, 1)); // 0 row, 1 col
		comboBoxPanel.setLayout(new GridLayout(1, 1));	// 1 row, 2 col
		radioPanel.setLayout(new GridLayout(5, 1)); 	// 5 row, 1 col
		resultPanel.setLayout(new BorderLayout(1,10));		// border layout, we use NORTH and CENTER (see below)
		
		// Add all our radio buttons to a group, so that only one option can be selected
		grpCompoundFrequency.add(rbCompoundFrequencyDaily);
		grpCompoundFrequency.add(rbCompoundFrequencyWeekly);
		grpCompoundFrequency.add(rbCompoundFrequencyMonthly);
		grpCompoundFrequency.add(rbCompoundFrequencySemiAnnual);
		
		// Make option 2 (Monthly payments) the default option
		cbPaymentFrequency.setSelectedIndex(2);

		// Add all our elements to the JPanels (order DOES matter for the grid layouts)
		textFieldPanel.add(lblNumberOfPayments);
		textFieldPanel.add(txtNumberOfPayments);
		textFieldPanel.add(lblPrincipal);
		textFieldPanel.add(txtPrincipal);
		textFieldPanel.add(lblAnnualInterestRate);
		textFieldPanel.add(txtAnnualInterestRate);
		comboBoxPanel.add(lblPaymentFrequency);
		comboBoxPanel.add(cbPaymentFrequency);
		radioPanel.add(lblCompoundFrequency);
		radioPanel.add(rbCompoundFrequencyDaily);
		radioPanel.add(rbCompoundFrequencyWeekly);
		radioPanel.add(rbCompoundFrequencyMonthly);
		radioPanel.add(rbCompoundFrequencySemiAnnual);
		resultPanel.add(btnCalculate, BorderLayout.NORTH);
		resultPanel.add(lblResults, BorderLayout.CENTER);
	
		
		this.add(textFieldPanel, BorderLayout.NORTH);
		this.add(comboBoxPanel, BorderLayout.CENTER);
		this.add(radioPanel, BorderLayout.EAST);
		this.add(resultPanel, BorderLayout.SOUTH);
	}

	/**
	 * Method for my Controller to attach a listener to the JFrame window
	 * @param myWindowAdapter The event handler for my window.
	 */
	public void attachWindowListener(WindowAdapter myWindowAdapter){
		this.addWindowListener(myWindowAdapter);
	}
	
	/**
	 * Method for my Controller to attach a listener to the combo box
	 * @param myCBHandler The event handler for my combo box.
	 */
	public void attachComboBoxListener(ActionListener myCBHandler){
		cbPaymentFrequency.addActionListener(myCBHandler);
	}
	
	/**
	 * Method for my Controller to attach a listener to EACH of my radio buttons
	 * @param myRadioHandler The event handler for each of my radio buttons.
	 */
	public void attachRadioButtonListener(ActionListener myRadioHandler){
		// This way, any time the user chooses any of these radio buttons, my event handler
		// in the Controller will get the selected option and store it to my Model.
		rbCompoundFrequencyDaily.addActionListener(myRadioHandler);
		rbCompoundFrequencyWeekly.addActionListener(myRadioHandler);
		rbCompoundFrequencyMonthly.addActionListener(myRadioHandler);
		rbCompoundFrequencySemiAnnual.addActionListener(myRadioHandler);
	}
	
	/**
	 * Method for my Controller to attach a listener to my Calculate button
	 * @param myButtonHandler The event handler for my Calculate button.
	 */
	public void attachButtonListener(ActionListener myButtonHandler){
		btnCalculate.addActionListener(myButtonHandler);
	}
	
	/**
	 * Method for my Controller to get the number of payments from the text field.
	 * For the radio buttons, the selected option is passed through "e" in my
	 * listener. Since I don't have a listener for my text field, I need a way
	 * to manually grab the value.
	 * @return The number of payments entered by the user, parsed as an integer.
	 */
	public int getNumberOfPayments(){
		return Integer.parseInt(this.txtNumberOfPayments.getText());
	}
	/**
	 * get method for principal
	 * @return double, text input for principal
	 */
	public double getPrincipal(){
		return Double.parseDouble(this.txtPrincipal.getText());
	}
	/**
	 * get method annual interest rate
	 * @return double, text input annual interest rate
	 */
	public double getAnnualInterestRate(){
		return Double.parseDouble(this.txtAnnualInterestRate.getText());
	}
	/**
	 * Method for my Controller to get the selected option in my combo box. Although
	 * I have a listener for my combo box, the event that gets passed to my listener
	 * only tells me that the option was changed. I need a way to actually get the
	 * option selected.
	 * @return The selected payment frequency in my combo box.
	 */
	public String getSelectedComboBox(){
		return this.cbPaymentFrequency.getSelectedItem().toString();
	}
	
	/**
	 * I need a way for my Controller to display results in the View.
	 * @param results The String I want to display as my results.
	 */
	public void setResults(String results){
		this.lblResults.setText(results);
	}
}