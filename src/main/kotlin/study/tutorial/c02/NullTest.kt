package study.tutorial.c02

fun main() {
    var str1: String?
    str1 = "Heloo"

    val len = str1?.length ?: -1
    println("str1: $str1, length: $len")
}

