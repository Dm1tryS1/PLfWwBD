package org.example.fisrtTask

import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val array = mutableListOf<Vector>()
    val range = (-100..100)

    println("Input n")
    readln().toIntOrNull()?.let {
        repeat(it) {
            array.add(
                Vector(
                    Pair(range.random(), range.random()),
                    Pair(range.random(), range.random()),
                    Pair(range.random(), range.random()),
                )
            )
        }


        if (it > 2) {
            val complementarity = mutableListOf<List<Vector>>()
            for (i in 0..array.size - 3) {
                for (j in i + 1..array.size - 2) {
                    for (k in j + 1..<array.size) {
                        if (array[i].сheckComplementarity(array[j], array[k])) {
                            complementarity.add(listOf(array[i], array[j], array[k]))
                        }
                    }

                }
            }

            complementarity.forEachIndexed { i, item ->
                println("${i + 1} complementarity")
                println(item.map { vector -> vector.toString() })
            }
        }
    }
}


class Vector(private val x: Pair<Int, Int>, private val y: Pair<Int, Int>, private val z: Pair<Int, Int>) {

    fun checkOrt(vector: Vector) =
        (x.first + vector.x.first) + (x.second + vector.x.second) + (y.first + vector.y.first) + (y.second + vector.y.second) + (z.first + vector.z.first) + (z.second + vector.z.second) > 0

    fun checkIntersection(vector: Vector) = intersection(
        x.first,
        vector.x.first,
        y.first,
        vector.y.first,
        z.first,
        vector.z.first,
        x.second,
        vector.x.second,
        y.second,
        vector.y.second,
        z.second,
        vector.z.second
    )

    fun сheckComplementarity(secondVector: Vector, thirdVector: Vector): Boolean {
        val matrix = listOf(
            coordinatesInList(this), coordinatesInList(secondVector), coordinatesInList(thirdVector)
        )

        return matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1]) + (-1) * matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0]) + matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]) == 0
    }

    fun equalsOfVector(vector: Vector): Boolean = length(vector) == length(this) && checkDirection(vector)


    private fun intersection(
        x11: Int,
        x12: Int,
        y11: Int,
        y12: Int,
        z11: Int,
        z12: Int,
        x21: Int,
        x22: Int,
        y21: Int,
        y22: Int,
        z21: Int,
        z22: Int
    ) = (veсtorMulti(x22 - x21, y22 - y21, y11 - y21, z11 - z21) * veсtorMulti(
        x22 - x21, y22 - y21, y12 - y21, z12 - z21
    ) < 0 && veсtorMulti(x12 - x11, y21 - y11, y21 - y11, z21 - z11) * veсtorMulti(
        x12 - x11, y21 - y11, y22 - y21, z22 - z11
    ) < 0)


    private fun veсtorMulti(ax: Int, ay: Int, bx: Int, by: Int) = ax * by - bx * ay


    private fun length(vector: Vector) = sqrt(
        (vector.x.second - vector.x.first).toDouble().pow(2) + (vector.y.second - vector.y.first).toDouble()
            .pow(2) + (vector.z.second - vector.z.first).toDouble().pow(2)
    )

    private fun checkDirection(vector: Vector) =
        (vector.x.second - vector.x.first) * (x.second - x.first) > 0 && (vector.y.second - vector.y.first) * (y.second - y.first) > 0 && (vector.z.second - vector.z.first) * (z.second - z.first) > 0

    private fun coordinatesInList(vector: Vector) = listOf(
        (vector.x.second - vector.x.first), (vector.y.second - vector.y.first), (vector.z.second - vector.z.first)
    )

    override fun toString() = "$x, $y, $z"

}
