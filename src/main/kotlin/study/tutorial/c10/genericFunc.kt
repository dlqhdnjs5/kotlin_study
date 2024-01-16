package study.tutorial.c10

fun <T> find(a: Array<T>, Target: T): Int {
    for (i in a.indices) {
        if (a[i] == Target) return i
    }

    return -1
}

fun main() {
    val arr1: Array<String> = arrayOf("Apple", "Banana", "Cherry", "Durian")
    val arr2: Array<Int> = arrayOf(1, 2, 3, 4)

    println("arr,indices ${arr1.indices}") // indices 는 배열의 유효범위 반환
    println(find<String>(arr1, "Cherry"))
    println(find(arr2, 2)) // 요서 2의 인덱스 찾아내기


    val result = add(2,3, {a, b -> a + b})
    // val result = add(2,3) {a, b -> a + b} 와 같음
    println(result)


    val ss = Calc<Int>()
    ss.plus(2, 3)
}

/*fun <T> add(a:T, b:T): T {
    return a + b // 오류 ! 자료형 결정할수 없음
}*/

fun <T> add(a: T, b: T, op:(T, T) -> T): T {
    return op(a, b)
}


class Calc<T: Number> {
    fun plus(arg1: T, arg2: T): Double {
        return arg1.toDouble() + arg2.toDouble()
    }
}


