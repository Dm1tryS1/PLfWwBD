package fourthTask.university

import fourthTask.Human
import fourthTask.university.University.Companion.MAX_MARK
import fourthTask.university.University.Companion.MIN_MARK

data class Student(override val fullName: String, override val gender: Boolean, var testResult: TestResult? = null) :
    Human() {
    fun writeTest() {
        if (testResult == null) {
            println("Write test")
            testResult = TestResult(Test(readln()))
        } else {
            println("Test has been already written")
        }
    }
}

data class TestResult(var test: Test) {
    var mark: Mark? = null
}

data class Mark(private var value: Int) {
    fun setValue(value: Int) {
        this.value = if (value > MAX_MARK) {
            MAX_MARK
        } else if (value < MIN_MARK) {
            MIN_MARK
        } else {
            value
        }
    }

    fun getValue() = value
}

data class Test(val text: String)