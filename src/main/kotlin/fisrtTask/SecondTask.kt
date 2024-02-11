package fisrtTask

fun main() {
    val array = mutableListOf<Matrix>()

    println("Input n")
    readln().toIntOrNull()?.let {
        repeat(it) {
            array.add(Matrix())
        }

        println("Matrix's:")
        array.forEach { println(it) }

        println("Multiplications:")
        array.forEachIndexed { first, _ ->
            array.forEachIndexed { second, _ ->
                println(array[first].multiplication(array[second]))
            }
        }

        println("Matrix with smallest first norm:")
        println(array.map { matrix ->
            Pair(matrix.firstNorm(), matrix)
        }.minBy { item -> item.first }.second)

        println("Matrix with smallest second norm:")
        println(array.map { matrix ->
            Pair(matrix.secondNorm(), matrix)
        }.minBy { item -> item.first }.second)
    }

}

class Matrix(
    val size: Int = SIZE,
    private val elements: MutableList<MutableList<Int>> = MutableList(size) { MutableList(size) { (-10..10).random() } }
) {

    private companion object {
        const val SIZE = 3
    }

    constructor(size: String) : this(size.toIntOrNull() ?: SIZE)

    constructor(elements: MutableList<MutableList<Int>>) : this(elements.size, elements)

    fun getMatrixElements(): List<List<Int>> = elements

    fun setMatrixElement(i: Int, j: Int, value: Int) {
        elements[i][j] = value
    }

    override fun toString() = elements.toString()


    fun sum(matrix: Matrix): Matrix {
        return if (size == matrix.size) {
            val tempMatrix = mutableListOf<MutableList<Int>>()
            for (i in 0..<size) {
                val row = mutableListOf<Int>()
                for (j in 0..<size) {
                    row.add(elements[i][j] + matrix.getMatrixElements()[i][j])
                }
                tempMatrix.add(row)
            }
            Matrix(tempMatrix)
        } else {
            Matrix()
        }
    }

    fun subtraction(matrix: Matrix): Matrix {
        return if (size == matrix.size) {
            val tempMatrix = mutableListOf<MutableList<Int>>()
            for (i in 0..<size) {
                val row = mutableListOf<Int>()
                for (j in 0..<size) {
                    row.add(elements[i][j] - matrix.getMatrixElements()[i][j])
                }
                tempMatrix.add(row)
            }
            Matrix(tempMatrix)
        } else {
            Matrix()
        }
    }

    fun multiplication(matrix: Matrix): Matrix {
        return if (size == matrix.size) {
            val tempMatrix = mutableListOf<MutableList<Int>>()
            for (i in 0..<size) {
                val row = mutableListOf<Int>()
                for (j in 0..<size) {
                    var currentElement = 0
                    for (k in 0..<size) {
                        currentElement += elements[i][k] * matrix.getMatrixElements()[k][j]
                    }
                    row.add(currentElement)
                }
                tempMatrix.add(row)
            }
            Matrix(tempMatrix)
        } else {
            Matrix()
        }
    }

    fun firstNorm(elements: List<List<Int>> = this.elements) = elements.maxOfOrNull {
        it.sum()
    } ?: 0


    fun secondNorm() = firstNorm(transposeMatrix())


    private fun transposeMatrix(): List<List<Int>> {
        val transposedMatrix = MutableList(size) { MutableList(size) { 0 } }

        for (i in 0..<size) {
            for (j in 0..<size) {
                transposedMatrix[j][i] = elements[i][j]
            }
        }

        return transposedMatrix
    }
}