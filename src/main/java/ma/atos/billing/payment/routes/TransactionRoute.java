import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TransactionRoute extends RouteBuilder {

    @Override
    public void configure() {

        from("direct:sendTransaction")
                .routeId("transaction-route")
                .log("Sending transaction: ${body}")
                .to("rabbitmq:localhost:5672/INVOICE_QUEUE"
                        + "?queue=INVOICE_QUEUE"
                        + "&autoDelete=false"
                        + "&routingKey=INVOICE_QUEUE");
    }
}