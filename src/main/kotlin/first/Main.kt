package org.example.first

fun main() {
    val firstPolynomial = HashMap<Int, Int>()
    val secondPolynomial = HashMap<Int, Int>()
    val range = (-5..5)

    println("Input n")
    val n = readln().toIntOrNull() ?: 3

    repeat(n) {
        firstPolynomial[it] = range.random()
        secondPolynomial[it] = range.random()
    }

    println(firstPolynomial)
    println(secondPolynomial)
    println(firstTask(firstPolynomial, secondPolynomial))
    println(secondTask(firstPolynomial, secondPolynomial))
}

fun firstTask(firstPolynomial: HashMap<Int, Int>, secondPolynomial: HashMap<Int, Int>): HashMap<Int, Int> {
    val result = HashMap<Int, Int>()
    firstPolynomial.forEach {
        result[it.key] = it.value + (secondPolynomial[it.key] ?: 0)
    }
    return result
}

fun secondTask(firstPolynomial: HashMap<Int, Int>, secondPolynomial: HashMap<Int, Int>): HashMap<Int, Int> {
    val result = HashMap<Int, Int>()
    firstPolynomial.forEach { first ->
        secondPolynomial.forEach { second ->
            result[first.key + second.key] = (result[first.key + second.key] ?: 0) + first.value * second.value
        }
    }
    return result
}
