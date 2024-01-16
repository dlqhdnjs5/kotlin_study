package study.test

import java.lang.RuntimeException

var global = 10


inline fun error(a:Int, b:Int): Int {
    println("aaaa")
    return a/b
}


fun errorTest() {
    println("111")
    error(3, 0)
    println("222")
}


fun main() {
    errorTest()


    fun localFunc1() {
        println("localFunc1")
    }
    fun sum(x: (Int, Int) -> Int, y: Int) {
      x(y, y)
    }

    sum(fun(x:Int, y:Int):Int = x + y, 10)

    localFunc1()

    global = 15
    val local1 = 15
    println("global $global")
    userFunc()
    println("final global : $global")
}

fun userFunc() {
    global = 20
    val local1 = 20
    println("userFunc -. global: $global local1: $local1")
}