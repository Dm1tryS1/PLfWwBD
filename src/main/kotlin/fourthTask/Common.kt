package fourthTask

import kotlin.random.Random

abstract class Human {
    val id = Random.nextInt()
    abstract val fullName: String
    abstract val gender: Boolean
}