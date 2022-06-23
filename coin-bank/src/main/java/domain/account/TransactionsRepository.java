package domain.account;

import domain.account.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionsRepository {

    private static Map<String, List<Transaction>> transactions = new HashMap<>();

    public static void add(String accountId, Transaction transaction) {
        transactions.computeIfAbsent(accountId, k -> new ArrayList<>()).add(transaction);
    }

    public static List<Transaction> findAll(String accountId) {
        return transactions.getOrDefault(accountId, new ArrayList<>());
    }

}
