package study.tutorial.c05

import java.lang.Integer.parseInt

fun main() {
    중괄호_생략()
    ifElse문_간략화()
    ifElse문_간략화_블록과_함께사용()
    범위_연산자()
    when구문()
    인자가_없는_when()
    for_문()
    for_문_하행반복()
    for_문_단계적_증가()
    일반_익명함수()
    람다식_반환 ()
    라벨없는_break() // TODO 추가 필요
    람다식에서의_return()
    예외처리 ()
    예외 ()
}

fun 중괄호_생략() {
    val a = 1
    val b = 2

    if ( a < b )
        println("Hello")
}

fun ifElse문_간략화() {
    val a = 1
    val b = 2
    if (a > b)
        println("hello")
    else
        println("hi")


    // TODO : 코틀린에는 삼항 연산자가 없어서 사용할수 잇음 추가
    if (a > b) println("hello") else println("hi")
}

fun ifElse문_간략화_블록과_함께사용() {
    val a = 1
    val b = 2

    val max = if (a > b) {
        println("hello")
        a
    } else {
        println("hi")
        b
    }

    println(max)
}

fun 범위_연산자() {
    val score = 8

    val level = if (score < 3) {
        "low"
    } else if (score in 4..8) {
        "middle"
    } else {
        "high"
    }

    println(level)
}

fun when구문() {
    val x = 5

    when (x) {
        1 -> println("x == 1")
        2 -> println("x == 2")
        3,4 -> println("x 는 3 or 4 ")
        parseInt("5") -> println("x == 5")
        in 6..8 -> println("x 는 6 과 8 내 속합니다.")
        !in 10..12 -> println("x 는 10 과 12 내 속하지 않습니다.")
        is Int -> println("x 는 Int 형 입니다.")
        else -> {
            println("x 는 1,2 아니면서 3 ~ 6 에 포함되지 않습니다.")
        }
    }

    // return 을 받을수도 있음
    val result = when (x) {
        1 -> true
        else -> false
    }
}


fun 인자가_없는_when() {
    val score = 8

    when {
        score > 9 -> println("A")
        score in 7..8 -> println("B")
        score in 5..7 -> println("D")
        else -> println("F")
    }
}


fun for_문() {
    for (x in 1..6) {
        println(x)
    }

    for (x in 1..6) println(x)
}

fun for_문_하행반복() {
    for (i in 5 downTo 1) print(i) // 54321
    for (i in 5..1) print(i) // 잘못된 사용이며 아무것도 출력되지 않는다. in 사용시 5 -> 1 로 내려가도록 사용하지 않는다.
}

fun for_문_단계적_증가() {
    for (i in 1..5 step 2) print(i) // 1, 3, 5
}

inline fun inlineLamda(a: Int, b: Int, out: (Int, Int) -> Unit) {
    out(a, b)
}

fun 람다식에서의_return() {
    println("시작")

    inlineLamda(10, 20) { a, b ->
        val result = a + b      // 암묵적 라벨 사용
        if (result < 40 ) return@inlineLamda // inlineLamda 는 inline 함수이기때문에 inlineLamda 만 빠져나오는것이 아니라
                                 //  함수 본문(람다식에서의_return())을 빠져나가는 비지역 반환이 일어 나게 됨.
        println("끝")            // result 가 40 보다 작으면 도달하지 못하여 실행되지 못함
    }

    println("위 result가 40 보다 작으면 나는 실행되지 못함")
}

fun 일반_익명함수() {
    println("시작")

    inlineLamda(10, 20, fun (a, b) {
        val result = a + b
        if (result < 40 ) return

        println("끝")
    })

    println("위 result가 40 보다 작으면 나는 실행되지 못함")
}

fun 람다식_반환 () {
    val message = labelFun@{ num: Int ->
        if (num > 10)
            return@labelFun "bigger than 10"
        else
            "less than 10"
    }

    print(message)
}


fun 라벨없는_break() {
    first@ for (i in 1..6) {
        second@ for (x in 1..7) {
            if (x == 6)
                break@first
        }
    }
}

fun 예외처리 () {
    val a = 6
    val b = 0
    val c: Int

    try {
        c = a/b
    } catch (exception: Exception) {
        println(exception)
    } finally {
        println("finally")
    }
}

fun 예외 () {
    val exception = throw IllegalArgumentException(
        "A percentage value must be between 0 and 100")
}
