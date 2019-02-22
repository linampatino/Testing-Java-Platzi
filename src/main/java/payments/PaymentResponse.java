package payments;

import lombok.Data;

@Data
public class PaymentResponse {
	
	public enum PaymentStatus{
		OK, ERROR
	}
	
	private PaymentStatus status;

	public PaymentResponse(PaymentStatus status) {
		this.status = status;
	}
	
	

}
