package thirdTask

import thirdTask.Number.Companion.DEFAULT_VALUE
import java.util.*


fun main() {
    println("Input first numerator")
    val firstNumerator = readln().toIntOrNull() ?: DEFAULT_VALUE
    println("Input first denominator")
    val firstDenominator = readln().toIntOrNull() ?: DEFAULT_VALUE
    println("Input second numerator")
    val secondNumerator = readln().toIntOrNull() ?: DEFAULT_VALUE
    println("Input second denominator ")
    val secondDenominator = readln().toIntOrNull() ?: DEFAULT_VALUE

    val firstFraction = Fraction(Number(firstNumerator), Number(firstDenominator))
    val secondFraction = Fraction(Number(secondNumerator), Number(secondDenominator))

    println(firstFraction)
    println(secondFraction)

    println(firstFraction.sum(secondFraction))
    println(firstFraction.sub(secondFraction))
    println(firstFraction.mul(secondFraction))
    println(firstFraction.div(secondFraction))

}

class Fraction(numerator: Number, denominator: Number) {

    val denominator: Number
    val numerator: Number

    init {
        if (denominator == Number(0)) {
            this.denominator = Number(DEFAULT_VALUE)
        } else {
            this.denominator = denominator
        }
        this.numerator = numerator
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Fraction) return false
        return other.numerator == numerator && other.denominator == denominator
    }

    override fun hashCode() = Objects.hash(numerator, denominator)


    override fun toString() = "Fraction[numerator:$numerator, denominator:$denominator]"

    fun sum(fraction: Fraction): Fraction {
        val denominator = fraction.denominator.value * this.denominator.value
        val numerator = fraction.denominator.value * this.numerator.value + this.denominator.value * fraction.numerator.value
        return Fraction(Number(numerator), Number(denominator))
    }

    fun sub(fraction: Fraction): Fraction {
        val denominator = fraction.denominator.value * this.denominator.value
        val numerator = fraction.denominator.value * this.numerator.value - this.denominator.value * fraction.numerator.value
        return Fraction(Number(numerator), Number(denominator))
    }

    fun mul(fraction: Fraction): Fraction {
        val denominator = fraction.denominator.value * this.denominator.value
        val numerator = fraction.numerator.value * this.numerator.value
        return Fraction(Number(numerator), Number(denominator))
    }

    fun div(fraction: Fraction): Fraction {
        val denominator = fraction.numerator.value * this.denominator.value
        val numerator = fraction.denominator.value * this.numerator.value
        return Fraction(Number(numerator), Number(denominator))
    }

}

class Number(val value: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Number) return false
        return other.value == value
    }

    override fun hashCode() = Objects.hash(value)


    override fun toString() = "Number[value:$value]"

    companion object {
        const val DEFAULT_VALUE = 1
    }

}