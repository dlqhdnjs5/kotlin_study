package study.test

fun main() {
    //val multi = { a: Int, b: Int -> a * b}

    val multi: (Int, Int) -> Int = { a: Int, b: Int ->
        println("this is result")
        a * b
    }

    val returnUtit: (Int , Int) -> Unit = { a: Int, b: Int -> println("return Unit")}
    val returnUtit2: (Int , Int) -> Unit = { a, b -> println("return Unit")}
    val returnUnit3: () -> Unit = {println("this is empty")}

    val sum = { a:Int, b: Int ->
        println("this is sum")
        a + b
    }
    val sum2: (Int, Int) -> Int = {a, b -> a + b}
    val sum3: (Int, Int) -> Int = {a: Int, b: Int -> a + b}


    print(multi(2, 3))
    returnUtit(3, 3)
    returnUtit2(4, 3)
    returnUnit3()


    val nestedLamda: () -> () -> Unit = { { println("nestedLamda") } }
    nestedLamda()
}