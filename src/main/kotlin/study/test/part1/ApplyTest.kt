package study.test

fun main() {
    data class Person(var name: String, var skills : String)
    var person = Person("Kildong", "Kotlin")

    // 여기서 this는 person 객체를 가리킴
    person.apply { this.skills = "Swift" }
    println(person)

    val retrunObj = person.apply {
        name = "Sean" // ① this는 생략할 수 있음
        skills = "Java" // this 없이 객체의 멤버에 여러 번 접근
    }
    println(person)
    println(retrunObj)
}