package lab4;
/**
 * This program is based of TA Edwin's Sample Code
 * Although not entirely the same, I have asked before hand to use his code, he had agree with it.
 * This is the Mortgage class part of MVC, this class has all the logic behind Mortgages, also has all the calculation
 * This class also has all the data, which the controller can manipulate by using the set and get methods in this class. 
 * Instructor : Leonard Manzara
 * @author Ali Akbari
 */

import static java.lang.Math.pow;

public class Mortgage {
	private int numberOfPayments = 0;
	private int amortization = 0;
	private double totalPrincipal = 0;
	private double annualInterestRate = 0;
	private double interestFactor = 0;
	private double blendedAmount = 0;
	private double TotalInterestAndPrincipal = 0;
	private double TotalInterest= 0;
	private double interestAndPrincpalRatio = 0;
	private double interestPerYear = 0;
	private double interestPerMonth = 0;
	private String interestCompoundingFrequency = "";
	private String paymentFrequency = "";

	/**Mortgage Constructor
	 * Used to initialize all default value for GUI/ variable initialization. 
	 */
	public Mortgage(){
		this.numberOfPayments = 60;
		this.totalPrincipal = 300000;
		this.annualInterestRate = 0.045;
		this.interestCompoundingFrequency = "semi-annually";
		this.paymentFrequency = "Monthly";
	}
	/**
	 * This method sets the number of payments
	 * Changes Variable to argument passed into this method
	 * @param numberOfPaymentsVal, number of payments as integer
	 */
	public void setNumberOfPayments(int numberOfPaymentsVal){
		this.numberOfPayments = numberOfPaymentsVal;
	}
	/**
	 * @return integer, the number of payments 
	 */
	public int getNumberOfPayments(){
		return numberOfPayments;
	}
	/**
	 * This method sets the number of principal
	 * Changes Variable to argument passed into this method
	 * @param TotalPrincipalVal, total principal as double
	 */
	public void setTotalPrincipal(double TotalPrincipalVal){
		this.totalPrincipal = TotalPrincipalVal;
	}
	/**
	 * @return double, the total principal  
	 */
	public double getTotalPrincipal(){
		return totalPrincipal;
	}
	/**
	 * This method sets the number of annual Interest Rate
	 * Changes Variable to argument passed into this method
	 * @param AnnualInterestRateVal, annual interest rate as double
	 */
	public void setAnnualInterestRate(double AnnualInterestRateVal){
		this.annualInterestRate = AnnualInterestRateVal;
	}
	/**
	 * @return double, the annual Interest Rate
	 */
	public double getAnnualInterestRate(){
		return annualInterestRate;
	}
	
	/**This method sets the interest factor
	 * Changes Variable by equation using other variables/ argument passed into this method 
	 * @param annualInterestRate, annual interest rate as double
	 * @param compoundingFrequence, compounding frequency as string 
	 * @param PaymentFrequence, payment frequency as string 
	 */
	public void setInterestFactor(double annualInterestRate, String compoundingFrequence, String PaymentFrequence){
		/*If statements to change string to it's actual integer meaning 
		 * If statements for both Compounding and frequency of payments
		 */
		int compoundingFrequenceVal = 0;
		int PaymentFrequenceVal = 0;
		
		if(compoundingFrequence.equals("semi-annually")){
			compoundingFrequenceVal = 2;
		}
		else if(compoundingFrequence.equals("monthly")){
			compoundingFrequenceVal = 12;
		}
		else if(compoundingFrequence.equals("weekly")){
			compoundingFrequenceVal = 52;
		}
		else if(compoundingFrequence.equals("daily")){
			compoundingFrequenceVal = 365;
		}
		
		if(PaymentFrequence.equals("weekly")){
			PaymentFrequenceVal = 52;
		}
		else if(PaymentFrequence.equals("bi-weekly")){
			PaymentFrequenceVal = 26;
		}
		else if(PaymentFrequence.equals("Monthly")){
			PaymentFrequenceVal = 12;
		}
		double calculation1 = (annualInterestRate/compoundingFrequenceVal) + 1;
		double calculation2 = (compoundingFrequenceVal/PaymentFrequenceVal);
		interestFactor = pow(calculation1, calculation2) - 1;
		
	}
	/**
	 * 
	 * @return double, the interest factor
	 */
	public double getInterestfactor(){
		return  interestFactor;
	}
	/**This method sets the blendedAmount
	 * Changes Variable by equation using other variables/ argument passed into this method 
	 * @param principal, total principal as double
	 * @param interestFactor, interest factor as a double
	 * @param numberOfPayments, Number of payments as double 
	 */
	public void setBlendedAmount(double principal, double interestFactor, int numberOfPayments){
		double calculation1 = (principal * interestFactor);
		double calculation2 = 1 - pow(interestFactor + 1, -numberOfPayments);
		blendedAmount = calculation1/calculation2;
	}
	/**
	 * @return double, the blended amount
	 */
	public double getBlendedAmount(){
		return blendedAmount;
	}

	/**
	 * This method sets the total + principal
	 * Changes Variable by multiplying the two arguments passed into this method
	 * @param blendedPayment, blended payment as a double
	 * @param numberOfPayments, Number of payment as double
	 */
	public void setTotalInterestAndPrincipal(double blendedPayment, double numberOfPayments){
		this.TotalInterestAndPrincipal = blendedPayment * numberOfPayments;
	}
	/**
	 * @return double, the Interest + principal
	 */
	public double getTotalInterestAndPrincipal(){
		return TotalInterestAndPrincipal;
	}
	/**
	 * This method sets the number of Total interest
	 * calculates Variable by multiplying the two arguments passed into this method
	 * @param TotalInterestAndPrincipal, total and principle added as double
	 * @param principal, total principal as a double
	 */
	public void setTotalInterest(double TotalInterestAndPrincipal, double principal){
		this.TotalInterest = TotalInterestAndPrincipal - principal;
		
	}
	/**
	 * @return double, the total interest
	 */
	public double getTotalInterest(){
		return TotalInterest;
	}
	/**This method sets the ratio between principal and interest
	 * calculates Variable by dividing one argument pass into this method by the other 
	 * @param TotalInterest, total interest as double
	 * @param totalPrincpal, total principal as double
	 */
	public void setPrincipalInterestRatio(double TotalInterest, double totalPrincpal){
		this.interestAndPrincpalRatio = TotalInterest/totalPrincpal;
	}
	/**
	 * @return double, the ratio between principal and interest
	 */
	public double getPrincipalInterestRatio(){
		return interestAndPrincpalRatio;
	}
	/**
	 * This method sets the number interest per year
	 * Calculates Variable by dividing one argument passed into the method by the other
	 * @param totalInterest, total interest as a double
	 * @param numberOfPayments, number of payments as integer
	 */
	public void setInterestPerYear(double totalInterest, int numberOfPayments){
		this.interestPerYear = (totalInterest / numberOfPayments) * ( 1/12);
		
	}
	/**
	 * 
	 * @return double, the interest per year
	 */
	public double getInterestPerYear(){
		return interestPerYear;
	}
	/**This method sets the of interest per month
	 * Calculates Variable by dividing one argument passed into the method by the other
	 * @param totalInterest, total interest as a double
	 * @param numberOfPayments, Number of payments made as an integer
	 */
	public void setAverageInterestMonthly(double totalInterest, double numberOfPayments){
		this.interestPerMonth = totalInterest / numberOfPayments;
	}
	/**
	 * @return double the interest per month
	 */
	public double getAverageInterestMonthly(){
		return interestPerMonth;
	}
	/**This method sets the number of Amortization
	 * Calculates Variable by dividing one argument passed into the method by 12
	 * @param numberOfPayments, number of payments  made as a integer
	 */
	public void setAmortization(int numberOfPayments){
		this.amortization = numberOfPayments / 12;
	}
	/**
	 * @return int, the amortization 
	 */
	public int getAmortization(){
		return amortization;
	}
	/// SET/GET statements ///
	
	/**
	 * Get the interest compounding frequency
	 * @return The interest compounding frequency as a String
	 */
	public String getCompoundingFrequency(){
		return interestCompoundingFrequency;
	}
	
	/**
	 * Set the interest compounding frequency
	 * @param compoundingFrequency The interest compounding frequency as a String
	 */
	public void setCompoundingFrequency(String compoundingFrequency){
		this.interestCompoundingFrequency = compoundingFrequency;
	}
	
	/**
	 * Get the payment frequency
	 * @return The payment frequency as a String
	 */
	public String getPaymentFrequency(){
		return paymentFrequency;
	}
	
	/**
	 * Set the payment frequency
	 * @param paymentFrequency The payment frequency as a String
	 */
	public void setPaymentFrequency(String paymentFrequency){
		this.paymentFrequency = paymentFrequency;
	}
			
	
}