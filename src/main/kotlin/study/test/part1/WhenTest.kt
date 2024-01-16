package study.test

fun main() {
    val score: Int = 33
    val string: String = "gg"

   when (score) {
       in 0..10 -> println(" 10 아래")
       in 11..20 -> println(" 20 아래")
       in 21..30 -> println(" 30 아래")
       else -> println("good")
   }

    when (string) {
        "gg" -> println("what")
        "aa" -> println("asdf")
    }


}