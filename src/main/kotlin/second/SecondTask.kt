package second

import kotlin.math.min
import kotlin.random.Random

fun main() {
    val listOfAbiturient = mutableListOf<Abiturient>()

    println("Input count of abiturient")
    readln().toIntOrNull()?.let {
        repeat(it) {
            println("Input first name")
            val firstName = readln()
            println("Input second name")
            val secondName = readln()
            println("Input third name")
            val thirdName = readln()
            println("Input address")
            val address = readln()
            println("Input phone number")
            val phoneNumber = try {
                checkPhoneNumberFormat(readln())
            } catch (e: PhoneNumberException) {
                println("Wrong input")
                ""
            }

            listOfAbiturient.add(
                Abiturient(
                    firstName = firstName,
                    secondName = secondName,
                    thirdName = thirdName,
                    address = address,
                    phoneNumber = phoneNumber
                )
            )
        }

        println("All abiturient:")
        println(listOfAbiturient)

        if (it > 0) {
            println("Abiturientes with mark 3:")
            println(listOfAbiturient.filter { abiturient ->
                abiturient.mark.contains(3)
            })

            println("Input average mark:")
            try {
                readln().toInt().let { avg ->
                    if (avg in 2..5) {
                        println("Abiturientes with mark greater than $avg:")
                        println(listOfAbiturient.filter { abiturient ->
                            abiturient.mark.sum() / abiturient.mark.size > avg
                        })
                    } else {
                        throw AverageMarkException()
                    }
                }
            } catch (e: AverageMarkException) {
                println(e.message)
            } catch (e: Exception) {
                println("Something went wrong")
            }

            println("Input n:")
            val n = readln().toIntOrNull() ?: 1
            println("Sorted Abiturientes:")
            listOfAbiturient.apply {
                sortBy { abiturient ->
                    abiturient.mark.sum() / abiturient.mark.size
                }
                reverse()
                for (i in (1..min(n, it))) {
                    println(listOfAbiturient[i])
                }
            }
        }
    }
}

data class Abiturient(
    val id: Int = Random.nextInt(),
    val firstName: String,
    val secondName: String,
    val thirdName: String,
    val address: String,
    val phoneNumber: String,
    val mark: List<Int> = listOf(
        (2..5).random(),
        (2..5).random(),
        (2..5).random(),
        (2..5).random(),
        (2..5).random()
    )
)

fun checkPhoneNumberFormat(value: String): String {
    val symbols = "0123456789"
    val notFormattedValue = value.lowercase()
    if (notFormattedValue.any { it !in symbols } || notFormattedValue.length == 11) {
        throw PhoneNumberException()
    } else {
        return notFormattedValue
    }
}

class PhoneNumberException(override val message: String = "Wrong phone number format") : Exception()

class AverageMarkException(override val message: String = "Wrong average mark value") : Exception()
