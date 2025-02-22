package com.example.estdelivery.domain

import com.example.estdelivery.accountTransactionsArbitraryBuilder
import com.example.estdelivery.moneyArbitraryBuilder
import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.FreeSpec
import java.time.LocalDateTime

class AccountTransactionsTest : FreeSpec({
    val money = moneyArbitraryBuilder().sample()
    val accountTransactions = AccountTransactions()

    "돈 입금 기록을 추가한다." {
        shouldNotThrowAny {
            accountTransactions.deposit(money, LocalDateTime.now())
        }
    }

    "돈 출금 기록을 추가한다." {
        shouldNotThrowAny {
            accountTransactions.withdraw(money, LocalDateTime.now())
        }
    }

    "잔액을 조회한다." {
        shouldNotThrowAny {
            accountTransactions.balance()
        }
    }
})
