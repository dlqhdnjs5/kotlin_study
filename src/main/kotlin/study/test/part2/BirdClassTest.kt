package study.test.part2

class Bird {
    var name: String
    var wing: Int
    var beak: String

    constructor(name: String, _wing: Int, beak: String) { //부 생성자
        this.name = name
        this.wing = _wing
        this.beak = beak
    }

    constructor(_name: String, _beak: String) {
        this.name = _name
        this.wing = 7
        this.beak = _beak
    }


    /*init {
        println("---------- init start -----------")
        name = name.capitalize() // 첫문자를 대문자로 변경
        println("name : $name, wing: $wing, beak: $beak")
        println("---------- init end --------------")
    }*/

    fun fly() {
        println("fly")
    }

}

fun main() {
    val coco: Bird = Bird("coco", 2, "short")
    val coco2: Bird = Bird("coco2", "long")

    coco.name = "coco"
    coco.fly()
}