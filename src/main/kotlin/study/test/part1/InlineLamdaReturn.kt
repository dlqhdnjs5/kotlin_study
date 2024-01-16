package study.test

fun main() {
    retFunc()
}

inline fun inlineLamda(a: Int, b: Int, out: (Int, Int) -> Unit) {
    out(a, b)
}

fun retFunc() {
    println("Start")
    inlineLamda(3, 3) lit@{
        a, b ->
        val result = a + b
        if (result > 10 ) return@lit
        println("result")
    }
    println("end of Func")

}