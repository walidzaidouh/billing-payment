package ma.atos.billing.payment.config;



import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Log4j2
@Configuration
public class Config {


    @Value("${spring.datasource.username:}")
    private String usernameVault;

    public void test(){
    System.out.println("Test Vault " + usernameVault);
    }
}
