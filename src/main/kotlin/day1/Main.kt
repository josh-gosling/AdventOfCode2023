package day1


import java.io.File


fun solvePart2(digits: String): String {
    var previousText = ""
    var replacedAll = false
    var text = digits
    val wordToDigit = mapOf(
        "one" to "o1e",
        "two" to "t2o",
        "three" to "t3e",
        "four" to "f4r",
        "five" to "f5e",
        "six" to "s6x",
        "seven" to "s7n",
        "eight" to "e8t",
        "nine" to "n9e"
    )
    val pattern = wordToDigit.keys.joinToString("|")
    while (!replacedAll) {
        text = text.replace(pattern.toRegex()) { wordToDigit[it.value]!! }
        if (text == previousText) {
            replacedAll = true
        }
        previousText = text
    }
    return text
}

fun solvePart1(input: List<String>): Int {
    var total = 0
    input.forEach {
        var first = ""
        var last = ""
        var firstFound = false
        val digits = solvePart2(it)
        digits.forEach {
            if (!firstFound && it.isDigit()) {
                first = it.toString()
                firstFound = true
            }
            if (it.isDigit()) {
                last = it.toString()
            }
        }
        val toAdd = (first + last).toInt()
        total += toAdd
        println("$it : $toAdd")

    }
    return total
}

fun main() {
    val input = File("inputs/day1.txt").readText().replace("\r", "").split("\n")
    println("total: " + solvePart1(input))
}
