package ma.atos.billing.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BillingPaymentApplication {

	public static void main(String[] args)  {
		SpringApplication.run(BillingPaymentApplication.class, args);
	}

}
