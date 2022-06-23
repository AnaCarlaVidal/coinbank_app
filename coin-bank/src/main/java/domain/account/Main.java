package domain.account;

import domain.customer.Customer;

import java.math.BigDecimal;

public class Main {
    
    public static void main(String[] args) {

        final var joao = Customer.of("123", "João", "123.456.789-00");
        final var agency = Agency.of("123", "Agency");

        final var checking = IAccount.ofChecking( joao, agency, BigDecimal.valueOf(1000));

        checking.withdraw(BigDecimal.valueOf(100));
        TransactionsRepository.add(checking.number(), Transaction.ofWithdraw(BigDecimal.valueOf(100)));

        checking.withdraw(BigDecimal.valueOf(90));
        TransactionsRepository.add(checking.number(), Transaction.ofWithdraw(BigDecimal.valueOf(90)));

        final var maria = Customer.of("123", "Maria", "123.456.789-00");
        final var savings = IAccount.ofSavings(maria, agency);

        savings.deposit(BigDecimal.valueOf(100));
        TransactionsRepository.add(savings.number(), Transaction.ofDeposit(BigDecimal.valueOf(100)));

        savings.deposit(BigDecimal.valueOf(1000));
        TransactionsRepository.add(savings.number(), Transaction.ofDeposit(BigDecimal.valueOf(1000)));

        savings.transfer(checking, BigDecimal.valueOf(100));
        TransactionsRepository.add(savings.number(), Transaction.ofTransfer(checking, BigDecimal.valueOf(100)));

        System.out.println(TransactionsRepository.findAll(checking.number()));

        System.out.println(TransactionsRepository.findAll(savings.number()));

    }
}