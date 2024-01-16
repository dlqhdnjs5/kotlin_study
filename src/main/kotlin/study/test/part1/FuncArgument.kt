package study.test

fun sum2(vararg a: Int) {
    for (b: Int in a) {
        println("this is argument : ${b}")
    }
}

fun paramFunc(sum: (Int, Int) -> Int, a: Int, b: Int) : Int {
    return sum(a, b)
}

fun main() {
    val sum1 = {a: Int, b: Int -> a + b}
    val mul1 = {a: Int, b: Int -> a * b}
    val funcfunc = {a: Int, b: Int -> sum1(a, b)}

    val result = sum1(10, 10)
    val result2 = mul1( sum1(10, 5), 10)
    val result3 = funcfunc(2, 3)
    val result4 = paramFunc({a, b -> a + b}, 3, 4)

    println("result: $result, result2: $result2, result3: $result3, result4: $result4")
}