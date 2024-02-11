package org.example
fun main(args: Array<String>) {
    println("What is your name?")
    Hello(readln())
    println("Params of main function:")
    args.apply {
        reverse()
    }.forEach {
        println(it)
    }
}

class Hello(userName: String) {
    init {
        println("Hello, $userName")
    }
}