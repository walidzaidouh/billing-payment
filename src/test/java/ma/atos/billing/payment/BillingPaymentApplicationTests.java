package ma.atos.billing.payment;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class BillingPaymentApplicationTests {

	@Test
	void contextLoads() {
	}

}
