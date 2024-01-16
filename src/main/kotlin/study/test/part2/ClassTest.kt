package study.test.part2

class Car {
    val wheel: Int = 4

    fun start() {
        println("Engine start")
    }
}

fun main() {
    val sonata: Car = Car(); // class 이름으로 되어있는 함수가 생성자;

    println(sonata.wheel)
    sonata.start()
}