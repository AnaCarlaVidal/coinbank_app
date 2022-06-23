package domain.account;

import domain.customer.Customer;

import java.math.BigDecimal;

public class CheckingAccount extends Account {

    private BigDecimal overdraftLimit;

    private CheckingAccount(String id, BigDecimal balance, Customer customer, Agency agency, Type type, BigDecimal overdraftLimit) {
        super(id, balance, customer, agency, type);
        this.overdraftLimit = overdraftLimit;

        this.validate();
    }

    static CheckingAccount of(Customer customer, Agency agency, BigDecimal overdraftLimit) {
        return new CheckingAccount(null, BigDecimal.ZERO, customer, agency, Type.CHECKING, overdraftLimit);
    }

    static CheckingAccount of(String id, BigDecimal balance, Customer customer, Agency agency, Type type, BigDecimal overdraftLimit) {
        return new CheckingAccount(id, balance, customer, agency, type, overdraftLimit);
    }

    @Override
    void validate() {

        final var limit = this.balance().add(this.overdraftLimit);

        if (limit.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalStateException("insufficient overdraft limit");
        }

    }

    public BigDecimal overdraftLimit() {

        if (this.balance().compareTo(BigDecimal.ZERO) < 0) {
            return this.overdraftLimit.add(this.balance());
        }

        return this.overdraftLimit;
    }

    public String toString() {
        return """
                --------------------------------------------------
                | Cliente: %s
                | Agência: %s
                | Conta: %s
                | Tipo: %s                
                | Saldo atual: R$ %s
                | Limite de crédito: R$ %s
                --------------------------------------------------
                """.formatted(
                this.customer().name(),
                this.agency().number(),
                this.number(),
                this.type().value(),
                this.balance(),
                this.overdraftLimit()
        );

    }
}
