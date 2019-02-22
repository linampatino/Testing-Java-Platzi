package payments;

import payments.PaymentResponse.PaymentStatus;

public class PaymentProcessor {
	
	private PaymentGateway paymentGateway;
	
	public PaymentProcessor(PaymentGateway paymentGateway) {
		this.paymentGateway = paymentGateway;
	}

	public boolean makePayment(double amount) {
		PaymentResponse response = this.paymentGateway.requestPayment(new PaymentRequest(amount));
		
		if(response.getStatus() == PaymentStatus.OK)
			return true;
		else
			return false;
	}
}
