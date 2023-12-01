package day1


import java.io.File

fun solvePart1(input: List<String>): Int {
    var total = 0
    input.forEach {
        var digits = it.filter {
            it.isDigit()
        }
        if (digits.length == 1) {
            digits += digits.first()
        }
        total += (digits.first().toString() + digits.last().toString()).toInt()
        println(digits)
    }
    return total
}

fun main() {
    val input = File("inputs/day1.txt").readText().split("\n")
    println("total: " + solvePart1(input))
}
