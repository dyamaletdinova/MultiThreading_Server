/**
 * 
 */
package model;

/**
 * @author Diana Yamaletdinova
 *
 * Aug 17, 2017
 */
public class Interest {
	
	private double principal; // The value of the investment.
	private double rate;// The annual interest rate.
	private double interest;// Interest earned in one year.
	/**
	 * @param principal
	 * @param rate
	 * @param interest
	 */
	public Interest(double principal, double rate) {
		this.principal = principal;
		this.rate = rate;
	}
	
	public Interest(){}
	
/*
	public double getPrincipal() {
		return principal;
	}

	public void setPrincipal(double principal) {
		this.principal = principal;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}



	public void setInterest(double interest) {
		this.interest = interest;
	}*/
	public double getInterest() {
		return interest;
	}
	/* Do the computations. */
	// Compute value of investment after one year, with interest.
	//rate is provided by the client
    public double calvInvestmentValue (){
    	this.interest = this.principal * this.rate;
    	return this.principal + this.interest;
    }      
}
