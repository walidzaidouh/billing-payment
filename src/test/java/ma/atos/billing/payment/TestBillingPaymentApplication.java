package ma.atos.billing.payment;

import org.springframework.boot.SpringApplication;

public class TestBillingPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.from(BillingPaymentApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
