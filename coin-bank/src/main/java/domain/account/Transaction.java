package domain.account;

import java.math.BigDecimal;
import java.time.Instant;

public class Transaction {

    private String id;
    private Instant createdAt;
    private String description;
    private OperationType type;

    private Transaction(String id, Instant createdAt, String description, OperationType type) {
        this.id = id;
        this.createdAt = createdAt;
        this.description = description;
        this.type = type;
    }

    public static Transaction ofWithdraw(BigDecimal amount) {
        final var now = Instant.now();
        final var description = String.format("Foi retirado R$ %.2f em %s", amount, now);

        return new Transaction(null, now, description, OperationType.WITHDRAWAL);
    }

    public static Transaction ofDeposit(BigDecimal amount) {
        final var now = Instant.now();
        final var description = String.format("Foi depositado R$ %.2f em %s", amount, now);

        return new Transaction(null, now, description, OperationType.DEPOSIT);
    }

    public static Transaction ofTransfer(Account account, BigDecimal amount) {
        final var now = Instant.now();
        final var description = String.format("Foi transferido R$ %.2f para a conta %s em %s", amount, account.number(), now);

        return new Transaction(null, now, description, OperationType.TRANSFER);
    }


    public enum OperationType {

        WITHDRAWAL("Saque"),
        DEPOSIT("Depósito"),
        TRANSFER("Transferência");

        private String value;

        OperationType(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }

    }

    public String id() {
        return id;
    }

    public Instant createdAt() {
        return createdAt;
    }

    public String description() {
        return description;
    }

    public OperationType type() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("%s", description);
    }

}
