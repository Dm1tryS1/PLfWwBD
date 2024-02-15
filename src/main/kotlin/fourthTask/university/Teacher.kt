package fourthTask.university

import fourthTask.Human

data class Teacher(override val fullName: String, override val gender: Boolean) : Human() {
    fun checkTest(student: Student) {
        student.testResult?.let {
            println("Set mark")
            it.mark = Mark(readln().toIntOrNull() ?: 0)
            println("Student ${student.fullName} has score: ${it.mark}")
        } ?: println("Student did not write test")
    }
}