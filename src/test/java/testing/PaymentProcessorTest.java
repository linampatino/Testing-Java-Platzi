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
	
	@Before //Esta anotaci�n hace que se ejecute este m�todo antes de cada test
	public void setup() {
		//Se crea el mock(objeto simulado) de la interface PaymentGateway
		this.mockPaymentGateway = Mockito.mock(PaymentGateway.class);
		this.paymentProcessor = new PaymentProcessor(mockPaymentGateway);
	}
	
	@Test
	public void payment_is_correct() {
		// ---- Preparaci�n de la prueba ----
		//Aqu� se define el comportamiento que va a tener el mock cuando se llama
		//el m�todo requestPayment. Mockito.any lo que indica es que no importa 
		//lo que llegue por par�metro la respuesta siempre ser� la misma
		Mockito.when(this.mockPaymentGateway.requestPayment(Mockito.any()))
			.thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));
		
		PaymentProcessor paymentProcessor = new PaymentProcessor(mockPaymentGateway);
		
		//Ejecuci�n del m�doto y Comprobaci�n del resultado
		assertTrue(this.paymentProcessor.makePayment(1000));
	}
	
	@Test
	public void payment_is_wrong() {
		// ---- Preparaci�n de la prueba ----
		
		
		//Aqu� se define el comportamiento que va a tener el mock cuando se llama
		//el m�todo requestPayment. Mockito.any lo que indica es que no importa 
		//lo que llegue por par�metro la respuesta siempre ser� la misma
		Mockito.when(this.mockPaymentGateway.requestPayment(Mockito.any()))
			.thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));
		
		
		//Ejecuci�n del m�doto y Comprobaci�n del resultado
		assertFalse(this.paymentProcessor.makePayment(1000));
	}

}
