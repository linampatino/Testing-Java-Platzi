package testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import payments.PaymentGateway;
import payments.PaymentProcessor;
import payments.PaymentResponse;

public class PaymentProcessorTest {
	
	private PaymentGateway mockPaymentGateway;
	private PaymentProcessor paymentProcessor;
	
	@Before //Esta anotación hace que se ejecute este método antes de cada test
	public void setup() {
		//Se crea el mock(objeto simulado) de la interface PaymentGateway
		this.mockPaymentGateway = Mockito.mock(PaymentGateway.class);
		this.paymentProcessor = new PaymentProcessor(mockPaymentGateway);
	}
	
	@Test
	public void payment_is_correct() {
		// ---- Preparación de la prueba ----
		//Aquí se define el comportamiento que va a tener el mock cuando se llama
		//el método requestPayment. Mockito.any lo que indica es que no importa 
		//lo que llegue por parámetro la respuesta siempre será la misma
		Mockito.when(this.mockPaymentGateway.requestPayment(Mockito.any()))
			.thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));
		
		PaymentProcessor paymentProcessor = new PaymentProcessor(mockPaymentGateway);
		
		//Ejecución del médoto y Comprobación del resultado
		assertTrue(this.paymentProcessor.makePayment(1000));
	}
	
	@Test
	public void payment_is_wrong() {
		// ---- Preparación de la prueba ----
		
		
		//Aquí se define el comportamiento que va a tener el mock cuando se llama
		//el método requestPayment. Mockito.any lo que indica es que no importa 
		//lo que llegue por parámetro la respuesta siempre será la misma
		Mockito.when(this.mockPaymentGateway.requestPayment(Mockito.any()))
			.thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));
		
		
		//Ejecución del médoto y Comprobación del resultado
		assertFalse(this.paymentProcessor.makePayment(1000));
	}

}
