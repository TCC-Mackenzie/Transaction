package tcc.bank.transaction.service.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TransactionType {
    DEPOSITY(0, "Depósito"),
    PIX(1, "PIX"),
    TED(2, "TED"),
    DOC(3, "TED"),
    REVERSAL(4, "Estorno");

    @JsonValue
    int id;
    String description;

    TransactionType(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
