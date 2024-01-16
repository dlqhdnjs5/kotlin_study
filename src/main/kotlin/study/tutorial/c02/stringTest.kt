package study.tutorial.c02

fun main() {
    var str1: String = "hello"
    var str2 = "world"
    var str3 = "hello"

    println("str1 == str2 ${str1 === str2}")
    println("str1 == str3 ${str1 === str3}")
}