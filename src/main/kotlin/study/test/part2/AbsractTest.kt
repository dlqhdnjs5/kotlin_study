package study.test.part2

abstract class Vehicle(val name: String, val color: String, val weight: Int) {


    // 추상 프로퍼티 - 하위 클래스에서 오버라이딩
    abstract val maxSpeed: Int

    var year: String = "2008"

    abstract fun start()

    abstract fun stop()

    fun displaySpec() {
        println("name: ${name}, color: ${color}, weight: $weight")
    }
}

class Car2(name: String, color: String, weight: Int, override val maxSpeed: Int) : Vehicle(name, color, weight) {
    override fun start() {
        println("car start")
    }

    override fun stop() {
        println("car stop")
    }
}

class Motorbike(name: String, color: String, weight: Int, override val maxSpeed: Int) : Vehicle(name, color, weight) {
    override fun start() {
        println("bike start")
    }

    override fun stop() {
        println("bike stop")
    }
}

fun main() {
    var car = Car2("matiz", "red", 1000, 100)
    var motorbike = Motorbike("matiz", "red", 1000, 100)

    car.year = "2002"

    car.displaySpec()
    car.start()

    motorbike.displaySpec()
    motorbike.start()
}