package study.test


fun main() {


    val num: Int = 1
    var grade: Char = 'F'

    if (num in 0..10) {
        grade = 'F'
    }

    val result: Int = if (num in 0..10)
                    10
                else
                    12

    println("F ${grade!!.toString()} , ${result}")



}