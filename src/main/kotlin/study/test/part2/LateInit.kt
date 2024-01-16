package study.test.part2

class Person {
    lateinit var name: String

    fun test() {
        if (!::name.isInitialized) {
            println("not Init")
        } else {
            println("init")
        }
    }
}

fun main() {
    val person = Person()

    person.test()
    person.name = "sss"
    person.test()
}