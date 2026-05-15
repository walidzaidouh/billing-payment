package ma.atos.billing.payment.enums;

import java.util.Arrays;

public enum PaymentType {

    CASH("Cash"),
    CHECK("Check"),
    TRANSFER("Bank Transfer");

    private final String label;

    PaymentType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static PaymentType fromValue(String value) {
        return Arrays.stream(values())
                .filter(p -> p.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid PaymentType: " + value));
    }
}
