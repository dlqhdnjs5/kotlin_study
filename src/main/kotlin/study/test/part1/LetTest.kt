package study.test


fun main() {

    var a = 1
    val b = 2



    val result = a.let { it + b }

    print("reslut: $result")
    print("b: $b")
    print("a: $a")
}