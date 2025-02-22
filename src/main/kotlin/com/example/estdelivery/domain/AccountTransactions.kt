package com.example.estdelivery.domain

import java.time.LocalDateTime

class AccountTransactions(
    private var accountTransactions: List<AccountTransaction> = listOf()
) {
    fun deposit(amount: Money, transactionTime: LocalDateTime) {
        accountTransactions = accountTransactions + AccountTransaction(amount, TransactionType.DEPOSIT, transactionTime)
    }

    fun withdraw(amount: Money, transactionTime: LocalDateTime) {
        accountTransactions =
            accountTransactions + AccountTransaction(amount, TransactionType.WITHDRAWAL, transactionTime)
    }

    fun balance() = accountTransactions.sortedBy { it.transactionDateTime }
        .fold(Money.ZERO) { acc, accountTransaction ->
            when (accountTransaction.type) {
                TransactionType.DEPOSIT -> acc + accountTransaction.amount
                TransactionType.WITHDRAWAL -> acc - accountTransaction.amount
            }
        }

    fun showTransactions() = accountTransactions
}
