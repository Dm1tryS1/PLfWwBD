package secondTask

import secondTask.Patient.Companion.LEFT_BORDER
import secondTask.Patient.Companion.RIGHT_BORDER
import kotlin.random.Random

fun main() {
    val listOfPatient = mutableListOf<Patient>()
    val listOfDiagnosis = listOf(
        Diagnosis(name = "cold"),
        Diagnosis(name = "flu"),
        Diagnosis(name = "strep throat"),
        Diagnosis(name = "measles"),
        Diagnosis(name = "chicken pox"),
        Diagnosis(name = "mumps"),
    )

    println("Input count of patient")
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
            val phoneNumber = readln()

            listOfPatient.add(
                Patient(
                    firstName = firstName,
                    secondName = secondName,
                    thirdName = thirdName,
                    address = address,
                    phoneNumber = phoneNumber,
                    diagnosis = listOfDiagnosis.random()
                )
            )
        }

        println("All patients:")
        println(listOfPatient)

        if (it > 0) {
            println("Input diagnosis name")
            val diagnosis = readln()
            println("Patients:")
            println(listOfPatient.filter { patient ->
                patient.diagnosis.name == diagnosis
            })
            println("Input left border")
            val leftBorder = readln().toIntOrNull() ?: LEFT_BORDER
            println("Input right border")
            val rightBorder = readln().toIntOrNull() ?: RIGHT_BORDER
            println("Patients:")
            println(listOfPatient.filter { patient ->
                patient.numberMedic in (leftBorder..rightBorder)
            })
        }
    }
}

data class Patient(
    val id: Int = Random.nextInt(),
    val firstName: String,
    val secondName: String,
    val thirdName: String,
    val address: String,
    val phoneNumber: String,
    val numberMedic: Int = (LEFT_BORDER..RIGHT_BORDER).random(),
    val diagnosis: Diagnosis
) {
    companion object {
        const val LEFT_BORDER = -1000
        const val RIGHT_BORDER = 1000
    }
}

data class Diagnosis(
    val id: Int = Random.nextInt(),
    val name: String
)
