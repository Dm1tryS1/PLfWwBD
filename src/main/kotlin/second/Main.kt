package second

fun main() {
    val secondThread = SecondThread()
    secondThread.start()

    repeat(5) {
        Thread.sleep(500)
        println("Right")
    }
}

class SecondThread : Thread() {
    override fun run() {
        repeat(5) {
            sleep(500)
            println("Left")
        }
    }
}