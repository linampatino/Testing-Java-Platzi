package testing;

import static org.junit.Assert.*;

import org.junit.Test;
import org.hamcrest.CoreMatchers;
import discounts.PriceCalculator;


public class PriceCalculatorShould {

	@Test
	public void total_zero_when_there_are_not_prices() {
		PriceCalculator calculator = new PriceCalculator();
		assertThat(calculator.getTotal(), CoreMatchers.is(0.0));
	}

	@Test
	public void total_is_the_sum_of_prices(){
		PriceCalculator calculator = new PriceCalculator();
		calculator.addPrice(10.2);
		calculator.addPrice(15.5);
		calculator.addPrice(11.1);
		
		assertThat(calculator.getTotal(), CoreMatchers.is(36.8));
	}
	
	@Test
	public void apply_discount_to_prices(){
		PriceCalculator calculator = new PriceCalculator();
		
		calculator.addPrice(12.5);
		calculator.addPrice(17.5);
		
		calculator.setDiscount(50);
		
		assertThat(calculator.getTotal(), CoreMatchers.is(15.0));
	}
}
