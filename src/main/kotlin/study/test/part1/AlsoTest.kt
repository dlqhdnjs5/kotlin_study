package study.test.part1

fun main() {
/*

    val person = Person("bowon", "Kotlin")

    val a = person.also {
        it.skills = "Java"
        "Success"
    }



    println("person: $person")
    println("a : $a")

    var c: String = "ccc"
    var d = c.also {
        c = "ddd"
    }
    println("c : $c")
    println("d: $d")

    var b: Int = 1

    var result = b.also {
        b = it + 3
    }

    println("b : $b")
    println("result: $result")
*/

    // also 의 리턴값은 aslo 함수의 매게 변수의 초기값을 리턴한다.



}

data class Person(var name: String,  var skills: String)
