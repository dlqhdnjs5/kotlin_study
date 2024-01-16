package study.test

fun normalVar(vararg a: Int) {
    for (num in a) {
        println("this is ${num + 1}")
    }
}

fun func1(a: Int, b: Int = 1): Unit {
    println("sdfsfa $a , $b")
}

fun fff(a: Int, b:Int) = a + b

fun highFunc(sum: (Int, Int) -> Int, a: Int, b:Int ): Int {
    return sum(a, b)
}

fun highFunc2(a: Int, b:Int, sum: (Int, Int) -> Int, sum2: (Int, Int) -> Int): Int {
    return sum(a, b)
}


fun avgFunc(initial: Float = 0f, vararg numbers: Float): Double {
    var result = 0f
    for (num in numbers) {
        result += num
    }
    println("result: $result, numbers.size: ${numbers.size}")
    val avg = result/numbers.size
            return avg.toDouble() + initial.toDouble()
}

fun main() {
    val result = avgFunc(5f, 100f, 90f, 80f)  // 첫번째 인자: 초기값, 이후 인자는 가변인자
    println("avg result: $result")
}

