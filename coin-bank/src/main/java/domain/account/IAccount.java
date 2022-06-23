package domain.account;

import domain.account.Account.Type;
import domain.customer.Customer;

import java.math.BigDecimal;

public interface IAccount {

    static Account ofSavings(Customer customer, Agency agency) {
        return SavingsAccount.of(customer, agency);
    }

    static Account ofSavings(String id, BigDecimal balance, Customer customer, Agency agency) {
        return SavingsAccount.of(id, balance, customer, agency, Type.SAVINGS);
    }

    static Account ofChecking(String id, BigDecimal balance, Customer customer, Agency agency, BigDecimal overdraftLimit) {
        return CheckingAccount.of(id, balance, customer, agency, Type.CHECKING, overdraftLimit);
    }

    static Account ofChecking(Customer customer, Agency agency, BigDecimal overdraftLimit) {
        return CheckingAccount.of(customer, agency, overdraftLimit);
    }


}
