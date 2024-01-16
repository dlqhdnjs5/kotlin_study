package study.test

inline fun shortFunc(a: Int, out: (Int) -> Unit) {
    println("Hello")
    out(a)
    println("good bye")
}

fun main() {
    shortFunc(3)  {
        println("a: $it")
    }
}