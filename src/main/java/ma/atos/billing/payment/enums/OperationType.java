package ma.atos.billing.payment.enums;

import java.util.Arrays;

public enum OperationType {

    CREDIT("Credit"),
    DEBIT("Debit");

    private final String label;

    OperationType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static OperationType fromValue(String value) {
        return Arrays.stream(values())
                .filter(op -> op.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid OperationType: " + value));
    }
}