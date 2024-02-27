package org.example.first

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.random.Random

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val bank = Bank(mutableListOf(Account()))

    runBlocking {
        List(10) {
            bank.accounts[0].let {
                val value = (-100..100).random()
                println("Current balance: ${it.balance}, transaction: $value")
                bank.makeTransaction(it.id, value)
            }
        }.forEach { it.await() }
    }
}

class Bank(val accounts: MutableList<Account>) {

    suspend fun makeTransaction(id: Int, value: Int) = CoroutineScope(Dispatchers.Default).async<Unit> {
        delay((0..5).random() * 1000L)
        accounts.find { it.id == id }?.addBalance(value)
    }
}

data class Account(val id: Int = Random.nextInt(), var balance: Int = 0) {
    private val mutex = Mutex()

    suspend fun addBalance(value: Int) {
        mutex.withLock {
            if (balance + value > 0) {
                balance += value
                println("Balance: $balance, transaction $value")
            } else {
                println("Balance Error. Balance: $balance, transaction $value")
            }
        }
    }
}