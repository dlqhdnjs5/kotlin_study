package study.tutorial.c08

import kotlin.properties.Delegates

fun main() {

    /*val user = User(1, "sean", 30)

    val name = user.name // user.name 은 내부적으로 .getName()에 접근 하게됨
    user.age = 41 // 이럴경우 내부적으로 setter 에 접근하게 된다.

    println("name : ${user.name}") // user.name 의 경우 내부적으로 getter() 에 접근하게 된다.*/


/*    val bowon = Person()
    bowon.test() // 초기화 안됨 출력
    bowon.name = "bowon"
    bowon.test() // 초기화됨 출력*/


   /* val test = LazyTest()
    test.flow()*/

    /*var isPersonInstantiated: Boolean = false  // ① 초기화 확인 용도

    val person : Person2 by lazy { // ② lazy를 사용한 person 객체의 지연 초기화
        isPersonInstantiated = true
        Person2("Kim", 23) // ③ 이 부분이 Lazy 객체로 반환 됨
    }
    val personDelegate = lazy { Person2("Hong", 40) }  // ④ 위임 변수를 사용한 초기화

    println("person Init: $isPersonInstantiated")
    println("personDelegate Init: ${personDelegate.isInitialized()}")
    println("personDelegate Init2: ${personDelegate.isInitialized()}")

    println("person.name = ${person.name}")  // ⑤ 이 시점에서 초기화
    println("personDelegate.value.name = ${personDelegate.value.name}")  // ⑥ 이 시점에서 초기화

    println("person Init: $isPersonInstantiated")
    println("personDelegate Init: ${personDelegate.isInitialized()}")*/


    /*val myDamas = CarModel("Damas", VanImple("100 마력"))
    val mySports = CarModel("sports", SportImple("350 마력"))

    myDamas.carInfo()
    mySports.carInfo()*/

    val user3 = User3()
    user3.name = "bowon"
    user3.name = "bowon2"

    var max: Int by Delegates.vetoable(0) { // 초기값 0
        prop, old, new ->
        new > old // 조건에 맞지 않으면 거부권 행사
    }

    println(max) // 0
    max = 10
    println(max) // 10

    //여기서 부터는 기존값이 새값 보다 크므로 false, 따라서 5를 재할당 하지 않는다.
    max = 5
    println(max) // 10
}

interface Car {
    fun go(): String
}

class VanImple(val power: String): Car {
    override fun go(): String {
       return "는 짐을 적재하며 $power 마력을 가집니다"
    }
}

class SportImple(val power: String): Car {
    override fun go(): String {
        return "는 경주용에 사용되며 $power 마력을 가집니다"
    }
}

class CarModel(val model:String, impl:Car): Car by impl {
    fun carInfo() {
        println("$model ${go()}")
    }
}

class CarModel2(val model:String, val impl:Car): Car {
    fun carInfo() {
        println("$model ${impl.go()}")
    }

    override fun go(): String {
        return ""
    }
}



class User(_id: Int, _name: String, _age: Int) {

    val id: Int = _id
        get() = field

    var name: String = _name
        get() = field
        set(value) {
            field = value
        }

    var age: Int = _age
        get() = field
        set(value) {
            field = value
        }
}

class User2(val _id: Int, var _name: String, var _age: Int)


open class First {
    open val x: Int = 0
        get() {
            println("first X")
            return field
        }

    val y: Int = 0 //open 키워드가 없어서 final 프로퍼티이다.
}

class Second: First() {
    override val x: Int = 1
        get()  {
            println("Second x")
            return field + 3
        }

    // override val y: Int = 0 // 오버라이딩이 블가능 하다.
}

class Person {
    lateinit var name: String

    fun test() {
        if (!::name.isInitialized) { // isInitialized는 프로퍼티 초기화 여부를 판단.
            println("초기화 안됨")
        } else {
            println("초기화 됨")
        }
    }
}

class Person2(var name: String, var age: Int)


class LazyTest {
    init {
        println("init block") // ②
    }

    val subject by lazy {
        println("lazy initialized") // ⑥ 반환값만 반환하고 초기화 된상태에서는 반한값 외에 함수 실행 안함
        "Kotlin Programming" // ⑦ lazy 반환값
    }
    fun flow() {
        println("not initialized") //  ④
        println("subject one: $subject") // ⑤ 최초 초기화 시점!
        println("subject two: $subject") // ⑧ 이미 초기화된 값 사용
    }
}


class User3 {
    var name: String by Delegates.observable("NONAME") {
        prop, old, new -> // 람다식 매개변수로 프로퍼티, 기존값, 새로운값
        println("$old -> $new")
    }
}


