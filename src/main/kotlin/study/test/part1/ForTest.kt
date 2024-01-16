package study.test

class Comp {
    companion object {
        val aa = aa()


        fun aa() : String {
           return "aaa"
        }
    }


}

fun main() {

    println(Comp.aa())


    var total: Int = 0

    for (num in 1..100 step 2) {
        total += num
    }

    for (num in 100 downTo 1 step 2) {
        print(num)
    }

    println("total : $total")


    var aa = 1

    while (aa == 0) {
        println("aa : $aa")
        aa++
    }
}