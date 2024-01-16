package study.test.part2

open class BirdParent(var name: String, var wing: Int, var beak: String) {

    fun fly() {
        println("fly")
    }
}

class Lark(name: String, wing: Int, beak: String): BirdParent(name, wing, beak) {

    fun singHitone() {
        println("sing Hitone")
    }
}

class Parrot: BirdParent {

    var language: String = "하이"
    // 부생성자
    constructor(name: String, wing: Int, beak: String, language: String): super(name, wing, beak) {
        this.language = language
    }

    fun speak() {
        println("speak")
    }
}

fun main() {

    val lark = Lark("myLark", 2 , "short")
    val parrot = Parrot("myParrot", 2, "long", "kor")

    println("lark : ${lark.name} , ${lark.beak}, ${lark.wing}")
    println("parrot: ${parrot.name} , ${parrot.beak}, ${parrot.wing}, ${parrot.language}")

    lark.singHitone()
    lark.fly()

    parrot.speak()
    parrot.fly()
}