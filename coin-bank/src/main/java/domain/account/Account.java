package domain.account;

import domain.customer.Customer;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Account {

    private String id;
    private String number;
    private BigDecimal balance;
    private Customer customer;
    private Agency agency;

    private Type type;

    protected Account(String id, BigDecimal balance, Customer customer, Agency agency, Type type) {

        this.id = id;
        this.number = String.format("%09d", (int) (Math.random() * 100_000_000));
        this.balance = balance;
        this.customer = Objects.requireNonNull(customer);
        this.agency = Objects.requireNonNull(agency);
        this.type = type;

    }

    public void deposit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
        this.validate();
    }

    public void withdraw(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
        this.validate();
    }

    public void transfer(Account account, BigDecimal amount) {
        this.withdraw(amount);
        account.deposit(amount);
    }

    public enum Type {
        SAVINGS("Poupança"),
        CHECKING("Corrente");

        private String value;

        Type(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }

    }

    abstract void validate();

    public String id() {
        return id;
    }

    public String number() {
        return number;
    }

    public Customer customer() {
        return customer;
    }

    public Agency agency() {
        return agency;
    }

    public BigDecimal balance() {
        return balance;
    }

    public Type type() {
        return type;
    }

    public abstract String toString();

}
