package study.test


fun main() {
    val num = 3
    val str = num.strPlus("Kotlin")
    val str2 = num strPlus "Kotlin"
    println(str)

}

infix fun Int.strPlus(x: String): String {
    return "$x version $this"
}
