package study.test.part2

import kotlin.properties.Delegates

class UserObservable {
    var name: String by Delegates.observable("Noname") {
        property, oldValue, newValue ->  println("${oldValue} -> ${newValue}" )
    }
}

fun main() {
    var user = UserObservable()

    user.name = "sss"
    user.name = "bbb"
}