package org.example

fun main() {
    val array = mutableListOf<Int>()
    println("Input N:")
    val n = readln()
    n.toIntOrNull()?.let { size ->
        repeat(size) {
            readln().toIntOrNull()?.let {
                array.add(it)
            }
        }
        if (size > 0) {
            println("Result of first task:")
            firstTask(array)
            println("Result of second task:")
            secondTask(array)
        }
    }
}

fun firstTask(array: List<Int>) =
    array.filter {
        it.toString() == it.toString().reversed()
    }.printList()


fun secondTask(array: List<Int>) =
    array.filterIndexed { index, i ->
        (index > 0 && index < array.size - 1) &&
                (i == ((array[index - 1] + array[index + 1])) / 2)
    }.printList()


fun List<Int>.printList() = forEach { println(it) }