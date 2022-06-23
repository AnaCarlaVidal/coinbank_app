package domain.account;

import domain.customer.Customer;

import java.math.BigDecimal;

public class SavingsAccount extends Account {

    private SavingsAccount(String id, BigDecimal balance, Customer customer, Agency agency, Type type) {
        super(id, balance, customer, agency, type);
        this.validate();
    }

    static SavingsAccount of(Customer customer, Agency agency) {
        return new SavingsAccount(null, BigDecimal.ZERO, customer, agency, Type.SAVINGS);
    }

    static SavingsAccount of(String id, BigDecimal balance, Customer customer, Agency agency, Type type) {
        return new SavingsAccount(id, balance, customer, agency, type);
    }

    @Override
    void validate() {

        if (this.balance().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalStateException("Balance cannot be negative");
        }

    }

    public String toString() {
        return """
                --------------------------------------------------
                | Cliente: %s
                | Agência: %s
                | Conta: %s
                | Tipo: %s                
                | Saldo atual: R$ %s
                --------------------------------------------------
                """.formatted(
                this.customer().name(),
                this.agency().number(),
                this.number(),
                this.type().value(),
                this.balance()
        );
    }

}
