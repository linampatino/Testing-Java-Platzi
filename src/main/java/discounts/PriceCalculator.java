package discounts;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {
	
	private List<Double> prices = new ArrayList<>();
	private double discount = 0;

	public double getTotal() {
		double result = 0;
		
		for (Double price : prices) {
			result += price; 
		}
		return result * ((100 - this.discount)/100);
	}

	public void addPrice(double d) {
		prices.add(d);
	}

	public void setDiscount(double i) {
		this.discount = i;
	}

}
